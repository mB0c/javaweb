package com.insigma.guobo.tbk.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.insigma.guobo.tbk.log.LogStyle;
import com.insigma.guobo.tbk.pojo.TaskConf;
import com.insigma.guobo.tbk.services.taskservice.TaskOptServiceImpl;
import com.insigma.guobo.tbk.task.GetGoodsTask;
import com.insigma.guobo.tbk.vo.TaskInfo;

public class TaskServlet extends HttpServlet {

	private Map<String, GetGoodsTask> taskMap = new HashMap<String, GetGoodsTask>();
	private Timer timer = new Timer();
	

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//进行  管理员的任务操作 的 工作           /taobaoke/src/com/insigma/guobo/tbk/servlet/TaskServlet.java
		//获取  type  的类型
		String type = request.getParameter("type");
		if("stop".equals(type)){
			//停止任务操作
			//获取  要操作的  任务名称是数组
			String name = request.getParameter("name");
			String[] names = null; 
			if(null != name && !"".equals(name)){
				names = name.split(";");
			}
			String message = "";
			for (String taskName : names) {  //注意这里的是ajax传过来的参数  有乱码 需在前边编码（2次） 在此解码一次
				taskName = URLDecoder.decode(taskName, "utf-8");
				System.out.println(taskName);
				if(!taskMap.get(taskName).cancel()){
					//如果任务停止失败 则记录下来
					message += taskName + ",";
				}else{
					//TODO  要从数据库中删除数据
					LogStyle.taskLog(TaskServlet.class, taskName + "已经被停止！！！", "warn");
				}
			}
			if(!"".equals(message)){  //如果存在失败的则 封装为 。。。。失败
				message = message.substring(0, message.lastIndexOf(',')) + "执行失败，请检查！";
			}
			response.getWriter().write(message);
			
			
		}else if("edit".equals(type)){
			//编任务操作
			
			
		}else if("add".equals(type)){
			String message = "";
			//定制任务操作
			//获取任务配置信息  封装
			TaskConf tc = new TaskConf();
			tc.setName(URLDecoder.decode(request.getParameter("name"), "utf-8"));
			tc.setCid(request.getParameter("cid"));
			tc.setEndTime(request.getParameter("endTime"));
			tc.setStartTime(request.getParameter("startTime"));
			tc.setMinNum(Integer.parseInt(request.getParameter("minNum")));
			tc.setMaxNum(Integer.parseInt(request.getParameter("maxNum")));
			tc.setStatus("1");
			tc.setMinRate(Double.parseDouble(request.getParameter("minRate")));
			tc.setKeyword(URLDecoder.decode(request.getParameter("keyword"), "utf-8"));
			
			//先把任务加到列表中
			GetGoodsTask ggt = new GetGoodsTask(tc);
			//分析任务配置  进行定制
			//获取开始任务的时间
			TaskInfo ti = this.getRunTime(tc);
			try{
				timer.scheduleAtFixedRate(ggt, ti.getRunTime(), ti.getYanChiTime()); //
				taskMap.put(tc.getName(), ggt);
				
				LogStyle.taskLog(TaskServlet.class, tc.getName() + "  任务已定制！", "warn");
				
				//如果任务启动成功  则存放到数据库
				new TaskOptServiceImpl().addTaskConf(tc);  //需要判断是否添加成功  
				message = "任务添加成功！";
			}catch(Exception e){
				message = "任务添加失败！";
			}
			message = URLEncoder.encode(message, "utf-8");
			response.getWriter().write(message);
		}
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}


	public void init() throws ServletException {
		//定时启动
		//获取数据库中的   taskconf  
		List<TaskConf> list = new ArrayList<TaskConf>();
		list = new TaskOptServiceImpl().getTaskConf();
		if(null == list){
			LogStyle.taskLog(TaskServlet.class, "当前未定制任务", "warn");
			return;
		}
		//定制任务  要考虑第一次是特殊的   第二天就按正常的来了  如果web项目只开一次  那么这个servlet只运行一次
		
		for (TaskConf taskConf : list) {
			if("1".equals(taskConf.getStatus())){
				//创建timertask
				GetGoodsTask ggt = new GetGoodsTask(taskConf);
				//分析任务配置  进行定制
				//获取开始任务的时间
				TaskInfo ti = this.getRunTime(taskConf);
				
				timer.scheduleAtFixedRate(ggt, ti.getRunTime(), ti.getYanChiTime()); //
				taskMap.put(taskConf.getName(), ggt);
				
				LogStyle.taskLog(TaskServlet.class, taskConf.getName() + "  任务已定制！", "warn");
			}
			
		}
		
	}

	private TaskInfo getRunTime(TaskConf tc) {
		
		TaskInfo ti = new TaskInfo();
		//数据库中的时间格式：09:09
		//提取任务开始时间 和 任务结束时间
		String startTimeHH = tc.getStartTime().substring(0, tc.getStartTime().indexOf(':'));
		String startTimeMM= tc.getStartTime().substring(tc.getStartTime().indexOf(':')+1);
		String endTimeHH = tc.getEndTime().substring(0, tc.getStartTime().indexOf(':'));
		String endTimeMM = tc.getEndTime().substring(tc.getStartTime().indexOf(':')+1);
		
		//获取当前的时间
		Calendar currCAL = Calendar.getInstance();
		long currTime = currCAL.getTimeInMillis();  // 当前的时间
		
		//获取年 月 日
//		int year = currCAL.get(Calendar.YEAR);
//		int month = currCAL.get(Calendar.MONTH);
//		int day = currCAL.get(Calendar.DAY_OF_MONTH);
		
		//获取任务开始时间的毫秒值
		currCAL.set(Calendar.HOUR_OF_DAY, Integer.parseInt(startTimeHH));
		currCAL.set(Calendar.MINUTE, Integer.parseInt(startTimeMM));
		long startTime = currCAL.getTimeInMillis();
		
		//获取任务结束时的毫秒值
		currCAL.set(Calendar.HOUR_OF_DAY, Integer.parseInt(endTimeHH));
		currCAL.set(Calendar.MINUTE, Integer.parseInt(endTimeMM));
		long endTime = currCAL.getTimeInMillis();
		
		if(startTime < currTime){
			//当前时间   在   开始时间    之前
			ti.setRunTime(new Date(startTime));
			ti.setYanChiTime(24 * 3600 * 1000);
			
			System.out.println(tc.getName() + "   " + Calendar.getInstance().getTimeInMillis());
			
		}else if(endTime < currTime){
			//当前时间在  结束时间之后
			ti.setRunTime(new Date(currTime - endTime + 60 * 1000));//24 * 3600 * 1000 TODO
			ti.setYanChiTime(24 * 3600 * 1000);
			
			System.out.println(tc.getName() + "   " + Calendar.getInstance().getTimeInMillis());
			
		}else{
			//当前时间在   任务时间内
			ti.setRunTime(new Date(currTime));
			ti.setYanChiTime(currTime - startTime + 24 * 3600 * 1000);// 第一次正常了  第二次会怎么样  考虑 用 new Timer().scheduleAtFixedRate(task, delay, period)
			
			System.out.println(tc.getName() + "   " + Calendar.getInstance().getTimeInMillis());
			
		}
		
		return ti;
	}

}
