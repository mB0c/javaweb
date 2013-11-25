package com.insigma.guobo.tbk.services;

import java.util.ArrayList;
import java.util.List;

import com.insigma.guobo.tbk.dao.CommentsDao;
import com.insigma.guobo.tbk.dao.CommentsDaoImpl;
import com.insigma.guobo.tbk.vo.CommentsVo;

public class CommentsServiceImpl implements CommentsService {
	
	private CommentsDao commentDAO = new CommentsDaoImpl();

	public List<CommentsVo> listCommennt(String userName,String goodName,String time1,String time2){
		List<CommentsVo> list = new ArrayList<CommentsVo>();
		list = commentDAO.getList(userName, goodName, time1,time2);
		
		return list;
	}

	public boolean delCommentById(String cId) {
		// 
		int cid = Integer.parseInt(cId);
		
		boolean flag = false;
		flag = commentDAO.delCommentById(cid);
		return flag;
	}


	
	
}
