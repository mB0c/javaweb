package com.insigma.guobo.tbk.pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * Users entity. @author MyEclipse Persistence Tools
 */

public class Users implements java.io.Serializable {

	// Fields

	private Integer id;
	private String nick;
	private String email;
	private String password;
	private String activeCode;
	private Integer role;
	private String status;
	private Set commentses = new HashSet(0);

	// Constructors

	/** default constructor */
	public Users() {
	}

	/** minimal constructor */
	public Users(String nick, String email, String password, String activeCode,
			Integer role, String status) {
		this.nick = nick;
		this.email = email;
		this.password = password;
		this.activeCode = activeCode;
		this.role = role;
		this.status = status;
	}

	/** full constructor */
	public Users(String nick, String email, String password, String activeCode,
			Integer role, String status, Set commentses) {
		this.nick = nick;
		this.email = email;
		this.password = password;
		this.activeCode = activeCode;
		this.role = role;
		this.status = status;
		this.commentses = commentses;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNick() {
		return this.nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getActiveCode() {
		return this.activeCode;
	}

	public void setActiveCode(String activeCode) {
		this.activeCode = activeCode;
	}

	public Integer getRole() {
		return this.role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Set getCommentses() {
		return this.commentses;
	}

	public void setCommentses(Set commentses) {
		this.commentses = commentses;
	}

}