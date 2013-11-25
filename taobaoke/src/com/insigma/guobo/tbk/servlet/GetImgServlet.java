package com.insigma.guobo.tbk.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import com.insigma.guobo.tbk.pojo.TempGoods;
import com.insigma.guobo.tbk.services.taskservice.AddTempGoodsServiceImpl;
import com.insigma.guobo.tbk.utils.Constants;

public class GetImgServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		//获取参数 要获取的是第几页的数据   获取的条数 自己设置
		String page = request.getParameter("pageNo");
		int pageNo = (null != page && !"".equals(page)) ? Integer.parseInt(page) : 1;
		int pageNum = Constants.JSP_PAGENUM;
		//dkk
		//调用service层获取数据   先从tempgoods 表中取值
		List<TempGoods> list = new AddTempGoodsServiceImpl().getTempGoods(pageNo,pageNum);
		
		//判断是否为空
		if(null != list && list.size() != 0){
			JSONArray ja = JSONArray.fromObject(list);
			response.getWriter().write(ja.toString());
			return;
		}
		//如果为空的话则返回  ""
		response.getWriter().write("");
		
		
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
