package com.spring.vo;

import java.util.Date;

public class AD_NoticeVO {

	private int an_no;
	private String an_subject;
	private int an_hits;
	private String an_contents;
	private Date an_date;
	
	
	public AD_NoticeVO(int an_no, String an_subject, int an_hits, String an_contents, Date an_date) {
		super();
		this.an_no = an_no;
		this.an_subject = an_subject;
		this.an_hits = an_hits;
		this.an_contents = an_contents;
		this.an_date = an_date;
	}


	public int getAn_no() {
		return an_no;
	}


	public void setAn_no(int an_no) {
		this.an_no = an_no;
	}


	public String getAn_subject() {
		return an_subject;
	}


	public void setAn_subject(String an_subject) {
		this.an_subject = an_subject;
	}


	public int getAn_hits() {
		return an_hits;
	}


	public void setAn_hits(int an_hits) {
		this.an_hits = an_hits;
	}


	public String getAn_contents() {
		return an_contents;
	}


	public void setAn_contents(String an_contents) {
		this.an_contents = an_contents;
	}


	public Date getAn_date() {
		return an_date;
	}


	public void setAn_date(Date an_date) {
		this.an_date = an_date;
	}
	
	
	
	
}
