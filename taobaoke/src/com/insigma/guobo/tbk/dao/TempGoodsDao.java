package com.insigma.guobo.tbk.dao;

import java.util.List;

import com.insigma.guobo.tbk.pojo.TempGoods;

public interface TempGoodsDao {
	
	/**
	 * 判断tempgoods表中是否有 传入的id 的数据
	 * @param id  要验证的id
	 * @return  true 有  false 没有
	 */
	public boolean isExitTg(String id);
	/**
	 * 向数据库中插入TempGoods
	 * @param tg  要插入的对象
	 */
	public void addTg(TempGoods tg);
	
	/**
	 * 获取数据库中指定页数的商品信息
	 * @param pageNo   页数
	 * @param pageNum  每页的条数
	 * @return   结果以列表的形式返回
	 */
	public List<TempGoods> getTempGoods(int pageNo,int pageNum);
}
