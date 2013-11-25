package com.insigma.guobo.tbk.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CheckImagValue extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//获取用户输入的验证码
		String value1 = request.getParameter("value");
		value1 = URLDecoder.decode(value1,"utf-8");
		//获取生成的验证码
		String value2 = (String) request.getSession().getAttribute("validataImag");
		//判断是否相等
		if(value2.equals(value1)){
			//相等
			response.getWriter().write("1");
		}else{
			//bu相等
			response.getWriter().write("0");
		}
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
