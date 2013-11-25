package com.insigma.guobo.tbk.pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * TaobaoCategory entity. @author MyEclipse Persistence Tools
 */

public class TaobaoCategory implements java.io.Serializable {

	// Fields

	private Integer cid;
	private String cname;
	private Integer PCid;
	private Set tempGoodses = new HashSet(0);

	// Constructors

	/** default constructor */
	public TaobaoCategory() {
	}

	/** minimal constructor */
	public TaobaoCategory(String cname, Integer PCid) {
		this.cname = cname;
		this.PCid = PCid;
	}

	/** full constructor */
	public TaobaoCategory(String cname, Integer PCid, Set tempGoodses) {
		this.cname = cname;
		this.PCid = PCid;
		this.tempGoodses = tempGoodses;
	}

	// Property accessors

	public Integer getCid() {
		return this.cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public String getCname() {
		return this.cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public Integer getPCid() {
		return this.PCid;
	}

	public void setPCid(Integer PCid) {
		this.PCid = PCid;
	}

	public Set getTempGoodses() {
		return this.tempGoodses;
	}

	public void setTempGoodses(Set tempGoodses) {
		this.tempGoodses = tempGoodses;
	}

}