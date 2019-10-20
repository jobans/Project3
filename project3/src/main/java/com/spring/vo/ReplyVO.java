package com.spring.vo;

import java.util.Date;

import com.sun.jmx.snmp.Timestamp;

public class ReplyVO {

	private Integer re_r_no;
	private Integer r_no;
	private String re_r_contents;
	private String o_id;
	private Date regdate;
	private Date updateDate;
	
	
	public ReplyVO() {
		// TODO Auto-generated constructor stub
	}
	
	public ReplyVO(Integer re_r_no, Integer r_no, String re_r_contents, String o_id, Date regdate,
			Date updateDate) {
		super();
		this.re_r_no = re_r_no;
		this.r_no = r_no;
		this.re_r_contents = re_r_contents;
		this.o_id = o_id;
		this.regdate = regdate;
		this.updateDate = updateDate;
	}


	public Integer getRe_r_no() {
		return re_r_no;
	}


	public void setRe_r_no(Integer re_r_no) {
		this.re_r_no = re_r_no;
	}


	public Integer getR_no() {
		return r_no;
	}


	public void setR_no(Integer r_no) {
		this.r_no = r_no;
	}


	public String getRe_r_contents() {
		return re_r_contents;
	}


	public void setRe_r_contents(String re_r_contents) {
		this.re_r_contents = re_r_contents;
	}


	public String getO_id() {
		return o_id;
	}


	public void setO_id(String o_id) {
		this.o_id = o_id;
	}


	public Date getRegdate() {
		return regdate;
	}


	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}


	public Date getUpdateDate() {
		return updateDate;
	}


	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	
	
	
	
	
	
	
}
