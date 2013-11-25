package com.insigma.guobo.tbk.services.taskservice;

import java.util.List;

import com.insigma.guobo.tbk.pojo.TaskConf;

public interface TaskOptService {

	/**
	 * 获取数据库中的 任务列表
	 * @return  返回任务列表  没有则返回null
	 */
	public List<TaskConf> getTaskConf();
	
	/**
	 * 向数据库中添加一条任务记录
	 * @param tc  要添加的任务 对象
	 */
	public void addTaskConf(TaskConf tc);
}
