package com.insigma.guobo.tbk.services;

public interface GoodsService {

	/**
	 * 获取商品名 数组  通过模糊查询
	 * @param name  关键字
	 * @return   返回数组
	 */
	public abstract String[] getGoodsByLikeName(String name);

}