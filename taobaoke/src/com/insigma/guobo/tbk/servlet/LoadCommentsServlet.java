package com.insigma.guobo.tbk.servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import com.insigma.guobo.tbk.services.CommentsServiceImpl;
import com.insigma.guobo.tbk.vo.CommentsVo;

public class LoadCommentsServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		//对评论操作
		
		String type = request.getParameter("type");
		if("load".equals(type)){
			loadAllComments(request,response);
			
		}else if("del".equals(type)){
			delComments(request,response);
			
		}else if("search".equals(type)){
			searchComments(request,response);
		}
		
		
	}


	private void searchComments(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// 获取传过来的数据
		String nick = request.getParameter("nick");
		nick = URLDecoder.decode(nick, "utf-8");
		String goodName = request.getParameter("goodName");
		goodName = URLDecoder.decode(goodName, "utf-8");
		String time1 = request.getParameter("time1");
		String time2 = request.getParameter("time2");
		//System.out.println(goodName);
		
		List<CommentsVo> list = new CommentsServiceImpl().listCommennt(nick, goodName, time1, time2);
		
		if(null != list){
			JSONArray ja = JSONArray.fromObject(list);
			response.getWriter().write(ja.toString());
			return;
		}else{
			list.add(new CommentsVo());
			JSONArray ja = JSONArray.fromObject(list);
			response.getWriter().write(ja.toString());
		}
		
		
	}


	private void delComments(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		//获取 要删除的评论 id  cId
		String cId = request.getParameter("cId");
		if(null == cId || "".equals(cId)){
			response.getWriter().write("2");  //在前台提示 没选中东西
			return;
		}
		
		boolean flag = new CommentsServiceImpl().delCommentById(cId);
		if(flag){  //为真  怎提示删除成功
			response.getWriter().write("1");
		}else{
			response.getWriter().write("0");
		}
		
	}


	private void loadAllComments(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		
		//获取评论信息
		List<CommentsVo> list = new CommentsServiceImpl().listCommennt("", "", "", "");
		//返回给jsp
		if(null != list && list.size() != 0){
			JSONArray ja = JSONArray.fromObject(list);
			response.getWriter().write(ja.toString());
			return;
		}else{
			response.getWriter().write("");
		}
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
