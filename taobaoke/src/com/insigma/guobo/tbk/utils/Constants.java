package com.insigma.guobo.tbk.utils;

import javax.persistence.Entity;

@Entity
public class Constants {
	//用户角色
	public static final String USER_ROLE_NORMAL = "1";
	public static final String USER_ROLE_ADMIN = "0";
	//用户激活状态
	public static final String USER_ACTIVE_NO = "0";
	public static final String USER_ACTIVE_YES = "1";
	//任务状态
	public static final String TEMP_GOODS_STATUS_NOT_COMMIT="0";
	public static final String TEMP_GOODS_STATUS_COMMIT="1";
	public static final String TEMP_GOODS_diuqi="2";
	
	//jsp 首页展示的商品图片 每次加载获取的张数
	public static final int JSP_PAGENUM = 20;
}
