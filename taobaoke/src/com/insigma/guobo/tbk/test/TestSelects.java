package com.insigma.guobo.tbk.test;

import java.util.List;

import com.insigma.guobo.tbk.dao.CommentsDaoImpl;
import com.insigma.guobo.tbk.vo.CommentsVo;

public class TestSelects {
	
	public static void main(String[] args) {
		CommentsDaoImpl cd = new CommentsDaoImpl();
		List<CommentsVo> list = cd.getList("nick4", "", "", "");
	}
}
