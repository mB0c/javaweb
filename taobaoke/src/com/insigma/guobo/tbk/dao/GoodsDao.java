package com.insigma.guobo.tbk.dao;

public interface GoodsDao {

	/**
	 * 根据关键字 模糊查询 获取商品名
	 * @param name  关键字 商品名
	 * @return   数组
	 */
	public abstract String[] getGoodsNames(String name);

}