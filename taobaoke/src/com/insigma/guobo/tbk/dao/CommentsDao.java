package com.insigma.guobo.tbk.dao;

import java.util.List;

import com.insigma.guobo.tbk.vo.CommentsVo;

public interface CommentsDao {
	/**
	 * 根据条件 查询结果
	 * @param userName  用户名
	 * @param goodName  商品名
	 * @param time      评论时间
	 * @return       返回查询结果
	 */
	public List<CommentsVo> getList(String userName,String goodName,String time1,String time2);

	/**
	 * 根据评论id删除评论
	 * @param cId   要删除的评论id 
	 * @return  返回真假   真  成功   假  失败
	 */
	public boolean delCommentById(int cId);

}
