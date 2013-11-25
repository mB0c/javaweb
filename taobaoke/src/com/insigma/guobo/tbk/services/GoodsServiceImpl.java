package com.insigma.guobo.tbk.services;

import com.insigma.guobo.tbk.dao.GoodsDao;
import com.insigma.guobo.tbk.dao.GoodsDaoImpl;

public class GoodsServiceImpl implements GoodsService {

	GoodsDao goodDAO = new GoodsDaoImpl();
	
	/* (non-Javadoc)
	 * @see com.insigma.guobo.tbk.services.GoodsService#getGoodsByLikeName(java.lang.String)
	 */
	public String[] getGoodsByLikeName(String name){
		
		String[] goodNames;
		goodNames = goodDAO.getGoodsNames(name);
		
		return goodNames;
	}
}
