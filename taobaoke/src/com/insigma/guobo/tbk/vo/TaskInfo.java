package com.insigma.guobo.tbk.vo;

import java.util.Date;

/**
 * 在TaskServlet 中根据taskConf的时间配置封装该任务启动的时间或者延迟多长时间启动
 * @author gb
 *
 */
public class TaskInfo {

	private Date runTime;
	private boolean flag;
	private long yanChiTime;

	public long getYanChiTime() {
		return yanChiTime;
	}
	public void setYanChiTime(long yanChiTime) {
		this.yanChiTime = yanChiTime;
	}
	public Date getRunTime() {
		return runTime;
	}
	public void setRunTime(Date runTime) {
		this.runTime = runTime;
	}
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	
	
}
