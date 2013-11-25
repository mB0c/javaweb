package com.insigma.guobo.tbk.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.insigma.guobo.tbk.services.GetUsersServiceImpl;

public class UsersOptServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		//获取参数
		String type = request.getParameter("type");
		String ids = request.getParameter("ids");
		if("user".equals(type)){  //用户操作
			//定义返回的消息
			String message = "0";
			boolean isSuccess = false;
			
			//校验ids是否为空的
			if(null == ids || "".equals(ids)){
				response.getWriter().write(message);
				return;
			}
			//提取用户的id
			String[] id = ids.split(";");
			//把字符串型的id  转为  int类型的
			int[] idInts = new int[id.length];
			for (int i = 0;i < id.length ;i++) {
				idInts[i] = Integer.parseInt(id[i]);
			}
			//删除数据库中的数据
			isSuccess = new GetUsersServiceImpl().delUsers(idInts);
			if(isSuccess){
				message = "1";
			}
			
			//返回消息
			response.getWriter().write(message);
			
		}
		
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
