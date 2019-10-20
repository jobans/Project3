package com.spring.vo;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class BookingVO {
	//예약 VO
	
	private int b_no;
	private String u_id;
	private String bnum;
	private String c_name;
	private int b_per;
	private Date b_date;
	private String b_app;
	
	
	public BookingVO() {
		super();
	}
		

	public BookingVO(int b_no, String u_id, String bnum, String c_name, int b_per, Date b_date,
			String b_app) {
		super();
		this.b_no = b_no;
		this.u_id = u_id;
		this.bnum = bnum;
		this.c_name = c_name;
		this.b_per = b_per;
		this.b_date = b_date;
		this.b_app = b_app;
	}


	public int getB_no() {
		return b_no;
	}


	public void setB_no(int b_no) {
		this.b_no = b_no;
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


	public String getC_name() {
		return c_name;
	}


	public void setC_name(String c_name) {
		this.c_name = c_name;
	}


	public int getB_per() {
		return b_per;
	}


	public void setB_per(int b_per) {
		this.b_per = b_per;
	}


	public Date getB_date() {
		return b_date;
	}	


	public void setB_date(String b_date) throws ParseException {
		String str = b_date;

		SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");

		Date to = transFormat.parse(str);
		
		this.b_date =to;
	}


	public String getB_app() {
		return b_app;
	}


	public void setB_app(String b_app) {
		this.b_app = b_app;
	}


	
	
}
