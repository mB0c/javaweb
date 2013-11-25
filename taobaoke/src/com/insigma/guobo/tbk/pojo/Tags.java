package com.insigma.guobo.tbk.pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * Tags entity. @author MyEclipse Persistence Tools
 */

public class Tags implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private Set goodsTagses = new HashSet(0);

	// Constructors

	/** default constructor */
	public Tags() {
	}

	/** minimal constructor */
	public Tags(String name) {
		this.name = name;
	}

	/** full constructor */
	public Tags(String name, Set goodsTagses) {
		this.name = name;
		this.goodsTagses = goodsTagses;
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

	public Set getGoodsTagses() {
		return this.goodsTagses;
	}

	public void setGoodsTagses(Set goodsTagses) {
		this.goodsTagses = goodsTagses;
	}

}