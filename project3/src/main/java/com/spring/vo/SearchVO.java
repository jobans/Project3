package com.spring.vo;

public class SearchVO {

	private String keyword;// 검색 keyword
	
	private String bnum;
	
	private String c_name;
	
	private String c_newadd;
	
	private String c_add;
	
	private String c_menu;
	
	private String c_parking;
	
	private String c_keyword;
	
	private String c_contents;
	
	
	
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "FindCtriteria : " + "[keyword=" + keyword + "]";
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
	public String getC_menu() {
		return c_menu;
	}
	public void setC_menu(String c_menu) {
		this.c_menu = c_menu;
	}
	public String getC_parking() {
		return c_parking;
	}
	public void setC_parking(String c_parking) {
		this.c_parking = c_parking;
	}
	public String getC_keyword() {
		return c_keyword;
	}
	public void setC_keyword(String c_keyword) {
		this.c_keyword = c_keyword;
	}
	public String getC_contents() {
		return c_contents;
	}
	public void setC_contents(String c_contents) {
		this.c_contents = c_contents;
	}
	
	
}
