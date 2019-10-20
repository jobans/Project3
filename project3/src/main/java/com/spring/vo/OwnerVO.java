package com.spring.vo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class OwnerVO {
	//오너 VO	
	private String o_id;
	private String bnum;
	private String o_pw;
	private String o_name;
	private String o_email;
	private Date o_date;
	private String o_phone;
	private String o_key;// 인증키 추가
	
	public OwnerVO() {
		super();
	}

	public OwnerVO(String o_id, String bnum, String o_pw, String o_name, String o_email, Date o_date, String o_phone,
			String o_key) {
		super();
		this.o_id = o_id;
		this.bnum = bnum;
		this.o_pw = o_pw;
		this.o_name = o_name;
		this.o_email = o_email;
		this.o_date = o_date;
		this.o_phone = o_phone;
		this.o_key = o_key;
	}

	public String getO_id() {
		return o_id;
	}

	public void setO_id(String o_id) {
		this.o_id = o_id;
	}

	public String getBnum() {
		return bnum;
	}

	public void setBnum(String bnum) {
		this.bnum = bnum;
	}

	public String getO_pw() {
		return o_pw;
	}

	public void setO_pw(String o_pw) {
		this.o_pw = o_pw;
	}

	public String getO_name() {
		return o_name;
	}

	public void setO_name(String o_name) {
		this.o_name = o_name;
	}

	public String getO_email() {
		return o_email;
	}

	public void setO_email(String o_email) {
		this.o_email = o_email;
	}

	public Date getO_date() {
		return o_date;
	}

	public void setO_date(Date o_date) {
		
		SimpleDateFormat dt = new SimpleDateFormat("yyyyy-mm-dd"); 
		
		this.o_date = o_date;
	}

	public String getO_phone() {
		return o_phone;
	}

	public void setO_phone(String o_phone) {
		this.o_phone = o_phone;
	}

	public String getO_key() {
		return o_key;
	}

	public void setO_key(String o_key) {
		this.o_key = o_key;
	}



	
}
