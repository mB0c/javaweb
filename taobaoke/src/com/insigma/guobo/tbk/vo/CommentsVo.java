package com.insigma.guobo.tbk.vo;

import java.text.DateFormat;
import java.util.Date;

import com.insigma.guobo.tbk.utils.DataParse;




public class CommentsVo {
	private int cId;
	private int userId;  //用户id
	private Integer goodId; // 商品id
	private String userName;  //用户名
	private String goodName;  //商品名
	private String time;     //评论时间
	private String content;  //评论内容
	private Integer goodLevel;   //好评
	private Integer midLevel;  //中评
	private Integer badLevel;  //差评
	private Integer total;   //总评数
	private Double goodRate;  //好评率
	private Double badRate; //差评率
	
	public CommentsVo(){}//
	
	public CommentsVo(int cId,String userName,String goodName,String content,Date time,String level){
		this.cId = cId;
		this.userName = userName;
		this.goodName = goodName;
		this.content = content;
		this.time = DataParse.getString(time);
		if("1".equals(level)){
			this.badLevel = 1;
		}else if("2".equals(level)){
			this.midLevel = 1;
		}else if("3".equals(level)){
			this.goodLevel = 1;
		}
		
	}
	
	
	

	public int getcId() {
		return cId;
	}

	public void setcId(int cId) {
		this.cId = cId;
	}

	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getGoodId() {
		return goodId;
	}
	public void setGoodId(Integer goodId) {
		this.goodId = goodId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getGoodName() {
		return goodName;
	}
	public void setGoodName(String goodName) {
		this.goodName = goodName;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public Integer getGoodLevel() {
		return goodLevel;
	}
	public void setGoodLevel(Integer goodLevel) {
		this.goodLevel = goodLevel;
	}
	public Integer getMidLevel() {
		return midLevel;
	}
	public void setMidLevel(Integer midLevel) {
		this.midLevel = midLevel;
	}
	public Integer getBadLevel() {
		return badLevel;
	}
	public void setBadLevel(Integer badLevel) {
		this.badLevel = badLevel;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public Double getGoodRate() {
		return goodRate;
	}
	public void setGoodRate(Double goodRate) {
		this.goodRate = goodRate;
	}
	public Double getBadRate() {
		return badRate;
	}
	public void setBadRate(Double badRate) {
		this.badRate = badRate;
	}

}
