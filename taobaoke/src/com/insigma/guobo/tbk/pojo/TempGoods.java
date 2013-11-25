package com.insigma.guobo.tbk.pojo;

/**
 * TempGoods entity. @author MyEclipse Persistence Tools
 */

public class TempGoods implements java.io.Serializable {

	// Fields

	private Integer id;
	private TaobaoCategory taobaoCategory;
	private String picUrl;
	private String taobaoId;
	private String name;
	private Double price;
	private String url;
	private Double commissionRate;
	private Integer commissionNum;
	private Double commissionVolumn;
	private String content;
	private String status;
	private Integer volum;

	// Constructors

	/** default constructor */
	public TempGoods() {
	}

	/** minimal constructor */
	public TempGoods(String taobaoId, String name, Double price, String url,
			Double commissionRate, Integer commissionNum, String status) {
		this.taobaoId = taobaoId;
		this.name = name;
		this.price = price;
		this.url = url;
		this.commissionRate = commissionRate;
		this.commissionNum = commissionNum;
		this.status = status;
	}

	/** full constructor */
	public TempGoods(TaobaoCategory taobaoCategory, String picUrl,
			String taobaoId, String name, Double price, String url,
			Double commissionRate, Integer commissionNum,
			Double commissionVolumn, String content, String status,
			Integer volum) {
		this.taobaoCategory = taobaoCategory;
		this.picUrl = picUrl;
		this.taobaoId = taobaoId;
		this.name = name;
		this.price = price;
		this.url = url;
		this.commissionRate = commissionRate;
		this.commissionNum = commissionNum;
		this.commissionVolumn = commissionVolumn;
		this.content = content;
		this.status = status;
		this.volum = volum;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TaobaoCategory getTaobaoCategory() {
		return this.taobaoCategory;
	}

	public void setTaobaoCategory(TaobaoCategory taobaoCategory) {
		this.taobaoCategory = taobaoCategory;
	}

	public String getPicUrl() {
		return this.picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public String getTaobaoId() {
		return this.taobaoId;
	}

	public void setTaobaoId(String taobaoId) {
		this.taobaoId = taobaoId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Double getCommissionRate() {
		return this.commissionRate;
	}

	public void setCommissionRate(Double commissionRate) {
		this.commissionRate = commissionRate;
	}

	public Integer getCommissionNum() {
		return this.commissionNum;
	}

	public void setCommissionNum(Integer commissionNum) {
		this.commissionNum = commissionNum;
	}

	public Double getCommissionVolumn() {
		return this.commissionVolumn;
	}

	public void setCommissionVolumn(Double commissionVolumn) {
		this.commissionVolumn = commissionVolumn;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getVolum() {
		return this.volum;
	}

	public void setVolum(Integer volum) {
		this.volum = volum;
	}

}