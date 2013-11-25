package com.insigma.guobo.tbk.dao;

import java.util.List;

import com.insigma.guobo.tbk.pojo.TaskConf;

public interface TaskConfDao {

	/**
	 * 从数据库中获取任务列表
	 * @return  任务列表  或者 为null
	 */
	public abstract List<TaskConf> getAllTaskConf();

	/**
	 * dao层 向数据库添加 一条任务
	 * @param tc 所要添加的任务对象
	 */
	public abstract void addTaskConf(TaskConf tc);

}