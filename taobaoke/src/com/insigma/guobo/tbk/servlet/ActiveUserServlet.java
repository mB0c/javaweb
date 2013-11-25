package com.insigma.guobo.tbk.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.insigma.guobo.tbk.pojo.Users;
import com.insigma.guobo.tbk.services.ActiveUserService;
import com.insigma.guobo.tbk.services.ActiveUserServiceImpl;

public class ActiveUserServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//设置标志位
		String message = "0";
		//创建激活类实例
		ActiveUserService aus = new ActiveUserServiceImpl();
		//获取链接带过来的code
		String activeCode = request.getParameter("activeCode");
		activeCode = URLDecoder.decode(activeCode, "utf-8");
		System.out.println(activeCode + "-------------------------");
		//根据code的唯一性  查找该user  并返回user对象 
		Users user = aus.activeUser(activeCode);
		System.out.println(user.getActiveCode() + ">>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		//判断是否激活成功
		if(null != user){
			message = "1";
			request.setAttribute("message", message);
			//用户激活成功 跳转到激活成功页面
			request.getRequestDispatcher("/servlet/IsSuccessServlet").forward(request, response);
			return;
		}else{
			request.setAttribute("message", message);
			//激活失败  则跳转到失败页面
			request.getRequestDispatcher("/servlet/IsSuccessServlet").forward(request, response);
		}

		

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
