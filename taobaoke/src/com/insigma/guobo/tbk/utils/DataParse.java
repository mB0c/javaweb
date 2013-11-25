package com.insigma.guobo.tbk.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataParse {
	
	public static String getString(Date time){
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time1 = sdf.format(time);
		return time1;
	}
	
	public static Date getDate(String time) throws ParseException{
		
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		d = sdf.parse(time);
		return d;
	}
	
}
