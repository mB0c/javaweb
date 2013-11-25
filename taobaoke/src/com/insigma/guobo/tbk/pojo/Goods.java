package com.insigma.guobo.tbk.pojo;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Goods entity. @author MyEclipse Persistence Tools
 */

public class Goods implements java.io.Serializable {

	// Fields

	private Integer id;
	private Category category;
	private String taobaoId;
	private String name;
	private Double price;
	private String url;
	private String pic;
	private Integer favorite;
	private String content;
	private Timestamp time;
	private Set goodsTagses = new HashSet(0);
	private Set commentses = new HashSet(0);

	// Constructors

	/** default constructor */
	public Goods() {
	}

	/** minimal constructor */
	public Goods(Integer id, Category category, String taobaoId, String name,
			Double price, String url, String pic, Integer favorite) {
		this.id = id;
		this.category = category;
		this.taobaoId = taobaoId;
		this.name = name;
		this.price = price;
		this.url = url;
		this.pic = pic;
		this.favorite = favorite;
	}

	/** full constructor */
	public Goods(Integer id, Category category, String taobaoId, String name,
			Double price, String url, String pic, Integer favorite,
			String content, Timestamp time, Set goodsTagses, Set commentses) {
		this.id = id;
		this.category = category;
		this.taobaoId = taobaoId;
		this.name = name;
		this.price = price;
		this.url = url;
		this.pic = pic;
		this.favorite = favorite;
		this.content = content;
		this.time = time;
		this.goodsTagses = goodsTagses;
		this.commentses = commentses;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
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

	public String getPic() {
		return this.pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public Integer getFavorite() {
		return this.favorite;
	}

	public void setFavorite(Integer favorite) {
		this.favorite = favorite;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getTime() {
		return this.time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	public Set getGoodsTagses() {
		return this.goodsTagses;
	}

	public void setGoodsTagses(Set goodsTagses) {
		this.goodsTagses = goodsTagses;
	}

	public Set getCommentses() {
		return this.commentses;
	}

	public void setCommentses(Set commentses) {
		this.commentses = commentses;
	}

}