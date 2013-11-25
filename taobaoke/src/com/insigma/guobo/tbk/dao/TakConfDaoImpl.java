package com.insigma.guobo.tbk.dao;

import java.util.List;

import org.hibernate.Session;

import com.insigma.guobo.tbk.pojo.HibernateSessionFactory;
import com.insigma.guobo.tbk.pojo.TaskConf;

public class TakConfDaoImpl implements TaskConfDao {
	

	public List<TaskConf> getAllTaskConf(){
		
		Session s = HibernateSessionFactory.getSession();
		@SuppressWarnings("unchecked")
		List<TaskConf> list = s.createQuery("from TaskConf").list();
		s.clear();
		HibernateSessionFactory.closeSession();
		return list;
	}

	public void addTaskConf(TaskConf tc) {
		try{
		Session s = HibernateSessionFactory.getSession();
		s.save(tc);
//		s.flush();
//		s.clear();
		HibernateSessionFactory.closeSession();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
