package com.insigma.guobo.tbk.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.persistence.Entity;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.insigma.guobo.tbk.exception.SendEmailException;
import com.insigma.guobo.tbk.exception.UserExistException;
import com.insigma.guobo.tbk.pojo.Users;
import com.insigma.guobo.tbk.services.RegisterService;
import com.insigma.guobo.tbk.services.RegisterServiceImpl;
import com.insigma.guobo.tbk.utils.PwdMd5Util;

@Entity
public class RegisterServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//实现注册业务
		//创建返回信息
		String message = "注册成功！！！";
		//获取页面上的值  封装起来   使用beanutils封装数据
		Map<String, String[]> map = request.getParameterMap();
		Users user = new Users();
		try {
			//把提取到的数据封装到user中去
			BeanUtils.populate(user, map);//map集合中的数据填充bean对象
			
			//再封装一些其他信息   
			user.setActiveCode(PwdMd5Util.md52Code(user.getEmail() + user.getPassword()));
			user.setRole(1);
			user.setStatus("0");
					
		} catch (Exception e) {
			e.printStackTrace();
			message = "注册失败！！！";
			request.setAttribute("registerMessage", message);
			request.getRequestDispatcher("/jsp/user/register.jsp").forward(request, response);
			return;
		}
		//进行注册业务
		boolean isSuccess = false;
		RegisterService service = new RegisterServiceImpl();
		try {
			isSuccess = service.isRegister(user);
			if(!isSuccess){
				message = "用户注册失败";
			}
		} catch (UserExistException e) {
			e.printStackTrace(); //用户已经存在
			isSuccess = false;
			message = e.getMessage();
		} catch (SendEmailException e) {
			e.printStackTrace();
			isSuccess = false;
			message = e.getMessage();//邮件发送失败
		}
		
		//向客户端反馈信息  
		request.setAttribute("registerMessage", message);
		request.getRequestDispatcher("/jsp/user/register.jsp").forward(request, response);
		return;
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
