package com.spring.vo;

import java.util.Date;

public class NoticeVO {
	
	//공지사항 VO
	
	private int n_no;
	private String bnum;// db 수정
	private String n_subject;
	private int n_hits;
	private String n_contents;
	private Date n_date;
	
	public NoticeVO() {
		super();
	}

	public NoticeVO(int n_no, String bnum, String n_subject, int n_hits, String n_contents, Date n_date) {
		super();
		this.n_no = n_no;
		this.bnum = bnum;
		this.n_subject = n_subject;
		this.n_hits = n_hits;
		this.n_contents = n_contents;
		this.n_date = n_date;
	}

	public int getN_no() {
		return n_no;
	}

	public void setN_no(int n_no) {
		this.n_no = n_no;
	}

	public String getBnum() {
		return bnum;
	}

	public void setBnum(String bnum) {
		this.bnum = bnum;
	}

	public String getN_subject() {
		return n_subject;
	}

	public void setN_subject(String n_subject) {
		this.n_subject = n_subject;
	}

	public int getN_hits() {
		return n_hits;
	}

	public void setN_hits(int n_hits) {
		this.n_hits = n_hits;
	}

	public String getN_contents() {
		return n_contents;
	}

	public void setN_contents(String n_contents) {
		this.n_contents = n_contents;
	}

	public Date getN_date() {
		return n_date;
	}

	public void setN_date(Date n_date) {
		this.n_date = n_date;
	}

	
	
	
}
