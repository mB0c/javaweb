package com.insigma.guobo.tbk.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.insigma.guobo.tbk.pojo.HibernateSessionFactory;
import com.insigma.guobo.tbk.pojo.TempGoods;

public class TempGoodsDaoImpl implements TempGoodsDao {

	public boolean isExitTg(String taobaoId) {
		
		boolean isSuccess = false;
		Session s = HibernateSessionFactory.getSession();
		
		Criteria c =   s.createCriteria(TempGoods.class);
		c.add(Restrictions.eq("taobaoId", taobaoId));
		if(c.list().size() != 0){  //说明数据库中存在这条
			isSuccess = true;
		}
		s.clear();
		HibernateSessionFactory.closeSession();
		return isSuccess;
	}

	public void addTg(TempGoods tg) {
		Session s = HibernateSessionFactory.getSession();
		s.beginTransaction();
		s.save(tg);
		s.getTransaction().commit();
		s.clear();
		HibernateSessionFactory.closeSession();		
	}

	public List<TempGoods> getTempGoods(int pageNo, int pageNum) {
		Session s = HibernateSessionFactory.getSession();
		Query q = s.createQuery("from TempGoods");
		q.setFirstResult((pageNo-1) * pageNum);
		q.setMaxResults(pageNum);
		List<TempGoods> list = q.list();
		s.flush();
		HibernateSessionFactory.closeSession();
		return list;
	}

}
