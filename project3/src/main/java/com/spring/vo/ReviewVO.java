package com.spring.vo;

import java.util.Date;

public class ReviewVO {
	//리뷰 VO
	
	private int r_no;
	private String u_id;
	private String bnum;
	private String r_name;
	private String r_contents;
	private Date r_date;
	private Date r_redate;
	private int r_score;// 별점
	private String c_name;
	
	
	public ReviewVO() {
		super();
	}


	public ReviewVO(int r_no, String u_id, String bnum, String r_name, String r_contents, Date r_date, Date r_redate,
			int r_score ,String c_name) {
		super();
		this.r_no = r_no;
		this.u_id = u_id;
		this.bnum = bnum;
		this.r_name = r_name;
		this.r_contents = r_contents;
		this.r_date = r_date;
		this.r_redate = r_redate;
		this.r_score = r_score;
		this.c_name = c_name;
	}





	public int getR_no() {
		return r_no;
	}

	public void setR_no(int r_no) {
		this.r_no = r_no;
	}

	public String getU_id() {
		return u_id;
	}

	public void setU_id(String u_id) {
		this.u_id = u_id;
	}

	public String getBnum() {
		return bnum;
	}

	public void setBnum(String bnum) {
		this.bnum = bnum;
	}

	public String getR_name() {
		return r_name;
	}

	public void setR_name(String r_name) {
		this.r_name = r_name;
	}

	public String getR_contents() {
		return r_contents;
	}

	public void setR_contents(String r_contents) {
		this.r_contents = r_contents;
	}

	public Date getR_date() {
		return r_date;
	}

	public void setR_date(Date r_date) {
		this.r_date = r_date;
	}

	public Date getR_redate() {
		return r_redate;
	}

	public void setR_redate(Date r_redate) {
		this.r_redate = r_redate;
	}

	public int getR_score() {
		return r_score;
	}

	public void setR_score(int r_score) {
		this.r_score = r_score;
	}


	public String getC_name() {
		return c_name;
	}


	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

	
	
	
}
