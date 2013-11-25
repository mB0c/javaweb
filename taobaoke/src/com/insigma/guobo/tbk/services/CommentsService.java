package com.insigma.guobo.tbk.services;

import java.util.List;

import com.insigma.guobo.tbk.vo.CommentsVo;

public interface CommentsService {

	/**
	 *根据条件 查询出具体的评论结果
	 * @param userName  用户名称
	 * @param goodName   商品名称
	 * @param time    评论时间
	 * @return    返回结果列表
	 */
	public abstract List<CommentsVo> listCommennt(String userName,
			String goodName, String time,String time2);

	/**
	 * 根据评论id删除评论
	 * @param cId  评论的id
	 * @return  真  成功   假  失败
	 */
	public boolean delCommentById(String cId);
}