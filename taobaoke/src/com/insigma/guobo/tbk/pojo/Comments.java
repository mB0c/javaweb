package com.insigma.guobo.tbk.pojo;

import java.sql.Timestamp;

/**
 * Comments entity. @author MyEclipse Persistence Tools
 */

public class Comments implements java.io.Serializable {

	// Fields

	private Integer id;
	private Users users;
	private Goods goods;
	private String content;
	private Timestamp time;
	private String level;

	// Constructors

	/** default constructor */
	public Comments() {
	}

	/** minimal constructor */
	public Comments(Users users, Goods goods, Timestamp time, String level) {
		this.users = users;
		this.goods = goods;
		this.time = time;
		this.level = level;
	}

	/** full constructor */
	public Comments(Users users, Goods goods, String content, Timestamp time,
			String level) {
		this.users = users;
		this.goods = goods;
		this.content = content;
		this.time = time;
		this.level = level;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public Goods getGoods() {
		return this.goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
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

	public String getLevel() {
		return this.level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

}