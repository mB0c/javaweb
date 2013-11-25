package com.insigma.guobo.tbk.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import com.insigma.guobo.tbk.pojo.TaskConf;
import com.insigma.guobo.tbk.services.taskservice.TaskOptServiceImpl;

public class GetTaskConfServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setCharacterEncoding("utf-8");
		//进行任务的查询  返回json数据 进行表格填充
		List<TaskConf> list = new ArrayList<TaskConf>();
		
		//到service dao 层获取数据
		list = new TaskOptServiceImpl().getTaskConf();
		
		//转换为json数据写回给jsp页面
		JSONArray ja = JSONArray.fromObject(list);
		
		response.getWriter().write(ja.toString());
		
		
		
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
