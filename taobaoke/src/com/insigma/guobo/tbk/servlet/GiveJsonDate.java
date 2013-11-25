package com.insigma.guobo.tbk.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONSerializer;
import net.sf.json.JsonConfig;

import com.insigma.guobo.tbk.pojo.Users;
import com.insigma.guobo.tbk.services.GetUsersService;
import com.insigma.guobo.tbk.services.GetUsersServiceImpl;
import com.insigma.guobo.tbk.vo.JsonTest;

public class GiveJsonDate extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setCharacterEncoding("utf-8");
		//返回json数据

		
		GetUsersService getUsers = new GetUsersServiceImpl();
		List<Users> list = getUsers.getAllUsers();
		//获取数据库中的数据
		if(null != list ){
			JsonConfig jconf = new JsonConfig();
			
			jconf.setExcludes(new String[]{"commentses"});
			String ja = JSONSerializer.toJSON(list, jconf).toString();
			//JSONArray ja = JSONArray.fromObject(list);
			
			response.getWriter().write(ja);
			return;
		}
		response.getWriter().write("");
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
