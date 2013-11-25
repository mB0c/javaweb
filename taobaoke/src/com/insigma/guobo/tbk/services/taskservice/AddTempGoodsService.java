package com.insigma.guobo.tbk.services.taskservice;

import java.util.List;

import com.insigma.guobo.tbk.pojo.TempGoods;

public interface AddTempGoodsService {

	/**
	 * 把通过任务获取的临时商品放到数据库
	 * @param list   临时商品列表
	 */
	public void addTempGood(List<TempGoods> list); 
	/**
	 * 获取数据库中指定的商品信息
	 * @param pageNo   页数
	 * @param pageNum  每页多少条
	 * @return  结果以列表形式返回
	 */
	public List<TempGoods> getTempGoods(int pageNo,int pageNum);
}
