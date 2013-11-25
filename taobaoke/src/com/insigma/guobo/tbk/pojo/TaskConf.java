package com.insigma.guobo.tbk.pojo;

/**
 * TaskConf entity. @author MyEclipse Persistence Tools
 */

public class TaskConf implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String startTime;
	private String endTime;
	private String cid;
	private Double minRate;
	private Integer minNum;
	private Integer maxNum;
	private Double minValue;
	private String status;
	private String keyword;

	// Constructors

	/** default constructor */
	public TaskConf() {
	}

	/** minimal constructor */
	public TaskConf(String name, String startTime, String endTime, String status) {
		this.name = name;
		this.startTime = startTime;
		this.endTime = endTime;
		this.status = status;
	}

	/** full constructor */
	public TaskConf(String name, String startTime, String endTime, String cid,
			Double minRate, Integer minNum, Integer maxNum, Double minValue,
			String status, String keyword) {
		this.name = name;
		this.startTime = startTime;
		this.endTime = endTime;
		this.cid = cid;
		this.minRate = minRate;
		this.minNum = minNum;
		this.maxNum = maxNum;
		this.minValue = minValue;
		this.status = status;
		this.keyword = keyword;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStartTime() {
		return this.startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return this.endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getCid() {
		return this.cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public Double getMinRate() {
		return this.minRate;
	}

	public void setMinRate(Double minRate) {
		this.minRate = minRate;
	}

	public Integer getMinNum() {
		return this.minNum;
	}

	public void setMinNum(Integer minNum) {
		this.minNum = minNum;
	}

	public Integer getMaxNum() {
		return this.maxNum;
	}

	public void setMaxNum(Integer maxNum) {
		this.maxNum = maxNum;
	}

	public Double getMinValue() {
		return this.minValue;
	}

	public void setMinValue(Double minValue) {
		this.minValue = minValue;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getKeyword() {
		return this.keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

}