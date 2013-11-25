package com.insigma.guobo.tbk.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IsSuccessServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setHeader("content-type", "text/html;charset=utf-8");
		//获取标志message
		String message = (String)request.getAttribute("message");
		if("1".equals(message)){
			System.out.println("----------------成功-------------------");
			//激活成功
			response.setHeader("refresh", "3;url='/taobaoke/jsp/user/login.jsp'");
			response.getWriter().write("激活成功！！！");
			response.getWriter().write("在3秒后 跳到登录页面<a href='/taobaoke/jsp/user/login.jsp'>   等不急了 </a>");
		}else{
			System.out.println("----------------失败-------------------");
			//激活失败
			response.setHeader("refresh", "3;url='/taobaoke/jsp/user/index.jsp'");
			response.getWriter().write("激活失败！！！");
			response.getWriter().write("在3秒后 跳到首页    点<a href='/taobaoke/jsp/user/index.jsp'>   等不急了   </a>");
		}

	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
