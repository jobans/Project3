package com.spring.vo;

import java.util.Date;

public class OreviewVO {
	//오너리뷰 VO
	
	private int orno;
	private int rno;
 	private String oid;
	private String orcontents;
	private Date ordate;
	private Date orredate;
	
	public OreviewVO() {
		super();
	}

	public OreviewVO(int orno, int rno, String oid, String orcontents, Date ordate, Date orredate) {
		super();
		this.orno = orno;
		this.rno = rno;
		this.oid = oid;
		this.orcontents = orcontents;
		this.ordate = ordate;
		this.orredate = orredate;
	}

	public int getOrno() {
		return orno;
	}

	public void setOrno(int orno) {
		this.orno = orno;
	}

	public int getRno() {
		return rno;
	}

	public void setRno(int rno) {
		this.rno = rno;
	}

	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	public String getOrcontents() {
		return orcontents;
	}

	public void setOrcontents(String orcontents) {
		this.orcontents = orcontents;
	}

	public Date getOrdate() {
		return ordate;
	}

	public void setOrdate(Date ordate) {
		this.ordate = ordate;
	}

	public Date getOrredate() {
		return orredate;
	}

	public void setOrredate(Date orredate) {
		this.orredate = orredate;
	}
	
	
}
