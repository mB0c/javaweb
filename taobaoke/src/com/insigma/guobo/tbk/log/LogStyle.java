package com.insigma.guobo.tbk.log;

import org.apache.log4j.Logger;

public class LogStyle {
	private static final String DEBUG = "debug";
	private static final String INFO = "info";
	private static final String WARN = "warn";
	private static final String ERROR = "error";
	private static final String FATAL = "fatal";
	/**
	 * 打印service层的日志信息
	 * @param clazz  所在的类
	 * @param message  要打印的信息
	 * @param level  日志级别
	 */
	public static void serviceLog(Class clazz, String message, String level){
		Logger logger = Logger.getLogger(clazz);
		if(DEBUG.equals(level)){
			logger.debug("  service层  "+message);
		}else if(INFO.equals(level)){
			logger.info("  service层  " + message);
		}else if(WARN.equals(level)){
			logger.warn("  service层  " + message);
		}else if(ERROR.equals(level)){
			logger.error("  service层  " + message);
		}else if(FATAL.equals(level)){
			logger.fatal("  service层  " + message);
		}
	}
	
	/**
	 * 打印da信息o层的日志
	 * @param clazz  所属的类
	 * @param message  索要打印的信息
	 * @param level   日志级别
	 */
	public static void daoLog(Class clazz, String message, String level){
		Logger logger = Logger.getLogger(clazz);
		if(DEBUG.equals(level)){
			logger.debug("dao层  "+message);
		}else if(INFO.equals(level)){
			logger.info("dao层  " + message);
		}else if(WARN.equals(level)){
			logger.warn("dao层  " + message);
		}else if(ERROR.equals(level)){
			logger.error("dao层  " + message);
		}else if(FATAL.equals(level)){
			logger.fatal("dao层  " + message);
		}
	}
	/**
	 * 打印任务调用时的日志信息
	 * @param clazz   当前日志是哪一个类中
	 * @param message  日志消息
	 * @param level    日志级别
	 */
	public static void taskLog(Class clazz, String message, String level){
		Logger logger = Logger.getLogger(clazz);
		if(DEBUG.equals(level)){
			logger.debug("任务层  "+message);
		}else if(INFO.equals(level)){
			logger.info("任务层  " + message);
		}else if(WARN.equals(level)){
			logger.warn("任务层  " + message);
		}else if(ERROR.equals(level)){
			logger.error("任务层  " + message);
		}else if(FATAL.equals(level)){
			logger.fatal("任务层  " + message);
		}
	}
	

}
