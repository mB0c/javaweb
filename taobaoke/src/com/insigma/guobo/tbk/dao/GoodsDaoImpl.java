package com.insigma.guobo.tbk.dao;

import java.util.List;

import org.hibernate.Session;

import com.insigma.guobo.tbk.pojo.Goods;
import com.insigma.guobo.tbk.pojo.HibernateSessionFactory;

public class GoodsDaoImpl implements GoodsDao {
	
	/* (non-Javadoc)
	 * @see com.insigma.guobo.tbk.dao.GoodsDao#getGoodsNames(java.lang.String)
	 */
	public String[] getGoodsNames(String name){
		
		Session s = HibernateSessionFactory.getSession();
		List<Goods> list = s.createQuery("from Goods where name like '%" + name +"%'").list();
		String[] goodsNames = {""};
		if(null != list && list.size() != 0){
			goodsNames = new String[list.size()];
			for(int i = 0;i<list.size();i++){
				goodsNames[i] = list.get(i).getName();
			}
		}
		
		return goodsNames;
	}
	
}
