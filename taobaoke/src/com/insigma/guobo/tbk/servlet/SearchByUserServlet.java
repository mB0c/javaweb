package com.insigma.guobo.tbk.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import net.sf.json.util.CycleDetectionStrategy;

import com.insigma.guobo.tbk.services.GetUsersService;
import com.insigma.guobo.tbk.services.GetUsersServiceImpl;
import com.insigma.guobo.tbk.services.GoodsService;
import com.insigma.guobo.tbk.services.GoodsServiceImpl;

public class SearchByUserServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		String sort = request.getParameter("sort");
		if("1".equals(sort)){
			searchByUser(request, response);
		}
		else {
			searchByProName(request, response);
		}
		
		

	}


	private void searchByProName(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		//异步获得商品输入框的内容
		String name = request.getParameter("name");
		GoodsService goodsServiceInterface = new GoodsServiceImpl();
		String[] names = goodsServiceInterface.getGoodsByLikeName(name);
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
		JSONArray ja = JSONArray.fromObject(names,jsonConfig);
		out.println(ja.toString());
		out.flush();
		out.close();
		
	}


	private void searchByUser(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		//异步获得用户输入框的内容
		String name = request.getParameter("name");
		GetUsersService loginServiceInterface = new GetUsersServiceImpl();
		String[] names = loginServiceInterface.getLikeNames(name);
		JSONArray ja = JSONArray.fromObject(names);
		out.println(ja);
		out.flush();
		out.close();
		
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
