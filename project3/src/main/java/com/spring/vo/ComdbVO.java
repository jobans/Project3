package com.spring.vo;

public class ComdbVO {
	//기업DB VO
	
	private String bnum;
	private String c_num;
	private String c_name;
	private String c_newadd;
	private String c_add;
	private String c_class;
	private String c_phone;
	
	public ComdbVO() {
		super();
	}

	public ComdbVO(String bnum, String c_num, String c_name, String c_newadd, String c_add, String c_class, String c_phone) {
		super();
		this.bnum = bnum;
		this.c_num = c_num;
		this.c_name = c_name;
		this.c_newadd = c_newadd;
		this.c_add = c_add;
		this.c_class = c_class;
		this.c_phone = c_phone;
	}

	public String getBnum() {
		return bnum;
	}

	public void setBnum(String bnum) {
		this.bnum = bnum;
	}

	public String getC_num() {
		return c_num;
	}

	public void setC_num(String c_num) {
		this.c_num = c_num;
	}

	public String getC_name() {
		return c_name;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

	public String getC_newadd() {
		return c_newadd;
	}

	public void setC_newadd(String c_newadd) {
		this.c_newadd = c_newadd;
	}

	public String getC_add() {
		return c_add;
	}

	public void setC_add(String c_add) {
		this.c_add = c_add;
	}

	public String getC_class() {
		return c_class;
	}

	public void setC_class(String c_class) {
		this.c_class = c_class;
	}

	public String getC_phone() {
		return c_phone;
	}

	public void setC_phone(String c_phone) {
		this.c_phone = c_phone;
	}

	
	
}
