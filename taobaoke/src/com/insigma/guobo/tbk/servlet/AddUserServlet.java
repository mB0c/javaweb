package com.insigma.guobo.tbk.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import com.insigma.guobo.tbk.exception.SendEmailException;
import com.insigma.guobo.tbk.exception.UserExistException;
import com.insigma.guobo.tbk.pojo.Users;
import com.insigma.guobo.tbk.services.RegisterService;
import com.insigma.guobo.tbk.services.RegisterServiceImpl;
import com.insigma.guobo.tbk.utils.Constants;
import com.insigma.guobo.tbk.utils.PwdMd5Util;

public class AddUserServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		
		//获取type值
		String type = request.getParameter("type");
		if("addItem".equals(type)){
			addSaveUser(request, response);
		}else if("editItem".equals(type)){
			editSaveUser(request, response);
		}
//		
		

	}


	private void editSaveUser(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		//获取新增用户的信息
		String nick = request.getParameter("nick");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String role = request.getParameter("role");
		String id = request.getParameter("id");
		String activeCode = request.getParameter("activeCode");
		String status = request.getParameter("status");
		String pwdIsChanged = request.getParameter("pwdIsChanged");
		
		//判断密码是否被修改  如果修改了 则从新加密    此时还没加密 所以不做  TODO
//		if("1".equals(pwdIsChanged)){
//			password = 加密过程
//		}

		//调用service层进行注册
		Users user = new Users();
		user.setActiveCode(activeCode);
		user.setEmail(email);
		user.setNick(nick);
		user.setPassword(password);
		user.setStatus(status);
		user.setRole(null == role || "".equals(role) ? Integer.parseInt(Constants.USER_ROLE_NORMAL) : Integer.parseInt(role));
		user.setId(Integer.parseInt(id));
		user.setPassword(password);
		
		//进行修改业务
		String message = "修改成功！";
		boolean isSuccess = false;
		RegisterService service = new RegisterServiceImpl();

		isSuccess = service.updateUser(user);
		if(!isSuccess){
			message = "用户修改失败";
		}

		
		//返回注册信息给jsp
		
		response.getWriter().write(message);
		
	}


	private void addSaveUser(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		//获取新增用户的信息
		String nick = request.getParameter("nick");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String role = request.getParameter("role");
		
		String activeCode = PwdMd5Util.md52Code(email + password);
		String status = Constants.USER_ACTIVE_NO;
		//调用service层进行注册
		Users user = new Users();
		user.setActiveCode(activeCode);
		user.setEmail(email);
		user.setNick(nick);
		user.setPassword(password);
		user.setStatus(status);
		user.setRole(null == role || "".equals(role) ? Integer.parseInt(Constants.USER_ROLE_NORMAL) : Integer.parseInt(role));
		
		//进行注册业务
		String message = "用户注册成功！";
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
		
		//返回注册信息给jsp
		
		response.getWriter().write(message);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
