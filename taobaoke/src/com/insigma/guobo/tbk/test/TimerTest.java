package com.insigma.guobo.tbk.test;

import java.util.Date;
import java.util.Timer;

public class TimerTest {

	public static void main(String[] args) {
		CounterTask tt = new CounterTask();
		Timer tmer = new Timer();
		tmer.schedule(tt, new Date());   //当timertask执行完后 线程不会结束
		
		//tmer.schedule(tt, 2000); //运行到这里后 延迟2秒执行
		
		//tmer.schedule(tt, new Date(), 5000);//在当前时间启动  然后  每隔5秒启动一次  实际上tt运行的是10秒 结果是：没什么效果啊
		//tmer.scheduleAtFixedRate(tt, new Date(), 5000);//在当前时间启动  然后  每隔5秒启动一次
		
	}
}
