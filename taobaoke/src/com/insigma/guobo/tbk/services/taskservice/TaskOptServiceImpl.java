package com.insigma.guobo.tbk.services.taskservice;

import java.util.List;

import org.hibernate.Session;

import com.insigma.guobo.tbk.dao.TakConfDaoImpl;
import com.insigma.guobo.tbk.dao.TaskConfDao;
import com.insigma.guobo.tbk.pojo.HibernateSessionFactory;
import com.insigma.guobo.tbk.pojo.TaskConf;

public class TaskOptServiceImpl implements TaskOptService {

	TaskConfDao tcDAO = new TakConfDaoImpl();
	public List<TaskConf> getTaskConf() {
		
		List<TaskConf> list = tcDAO.getAllTaskConf();
		
		
		return list;
	}
	public void addTaskConf(TaskConf tc) {
		
		tcDAO.addTaskConf(tc);
		
		
	}

}
