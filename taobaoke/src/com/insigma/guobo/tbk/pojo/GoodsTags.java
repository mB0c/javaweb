package com.insigma.guobo.tbk.pojo;

/**
 * GoodsTags entity. @author MyEclipse Persistence Tools
 */

public class GoodsTags implements java.io.Serializable {

	// Fields

	private Integer id;
	private Goods goods;
	private Tags tags;

	// Constructors

	/** default constructor */
	public GoodsTags() {
	}

	/** full constructor */
	public GoodsTags(Goods goods, Tags tags) {
		this.goods = goods;
		this.tags = tags;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Goods getGoods() {
		return this.goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public Tags getTags() {
		return this.tags;
	}

	public void setTags(Tags tags) {
		this.tags = tags;
	}

}