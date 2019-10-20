package com.spring.vo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UserVO {
	
	//user 유저
	private String u_id;
	private String u_pw;
	private String u_name;
	private String u_phone;
	private String u_email;
	private String u_add;
	private Date u_date;
	private Date u_dob;
	private int u_sex;
	private String u_key;// 인증키 추가
	private int grade;

	
	public UserVO() {
		super();
	}
	

	public UserVO(String u_id, String u_pw, String u_name, String u_phone, String u_email, String u_add, Date u_date,
			Date u_dob, int u_sex, String u_key, int grade) {
		super();
		this.u_id = u_id;
		this.u_pw = u_pw;
		this.u_name = u_name;
		this.u_phone = u_phone;
		this.u_email = u_email;
		this.u_add = u_add;
		this.u_date = u_date;
		this.u_dob = u_dob;
		this.u_sex = u_sex;
		this.u_key = u_key;
		this.grade = grade;
	}





	public String getU_id() {
		return u_id;
	}





	public void setU_id(String u_id) {
		this.u_id = u_id;
	}





	public String getU_pw() {
		return u_pw;
	}





	public void setU_pw(String u_pw) {
		this.u_pw = u_pw;
	}





	public String getU_name() {
		return u_name;
	}





	public void setU_name(String u_name) {
		this.u_name = u_name;
	}





	public String getU_phone() {
		return u_phone;
	}





	public void setU_phone(String u_phone) {
		this.u_phone = u_phone;
	}





	public String getU_email() {
		return u_email;
	}





	public void setU_email(String u_email) {
		this.u_email = u_email;
	}





	public String getU_add() {
		return u_add;
	}





	public void setU_add(String u_add) {
		this.u_add = u_add;
	}





	public Date getU_date() {
		return u_date;
	}





	public void setU_date(Date u_date) {
		this.u_date = u_date;
	}





	public int getU_sex() {
		return u_sex;
	}





	public void setU_sex(int u_sex) {
		this.u_sex = u_sex;
	}





	public String getU_key() {
		return u_key;
	}





	public void setU_key(String u_key) {
		this.u_key = u_key;
	}





	public int getGrade() {
		return grade;
	}





	public void setGrade(int grade) {
		this.grade = grade;
	}



	



	public Date getU_dob() {
		return u_dob;
	}




	public void setU_dob(String u_dob) throws ParseException {
		
		String str = u_dob;

		SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");

		Date to = transFormat.parse(str);

		this.u_dob = to;
	}
	

	
	
}
