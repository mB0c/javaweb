package com.insigma.guobo.tbk.services.taskservice;

import java.util.List;

import com.insigma.guobo.tbk.dao.TempGoodsDao;
import com.insigma.guobo.tbk.dao.TempGoodsDaoImpl;
import com.insigma.guobo.tbk.pojo.TempGoods;

public class AddTempGoodsServiceImpl implements AddTempGoodsService {
	TempGoodsDao tmpGodsDAO = new TempGoodsDaoImpl();
	public void addTempGood(List<TempGoods> list) {
		
		for (TempGoods tg : list) {
			Long id = Long.parseLong(tg.getTaobaoId());
			//先判断是否有这条数据
			if(!tmpGodsDAO.isExitTg(tg.getTaobaoId())){  //如果不存在  进行插入操作
				
				tmpGodsDAO.addTg(tg);  //插入
				
			}
		}
		
	}
	public List<TempGoods> getTempGoods(int pageNo, int pageNum) {
		List<TempGoods> list = tmpGodsDAO.getTempGoods(pageNo,pageNum);
		return list;
	}

}
