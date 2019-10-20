package com.spring.vo;

public class ComVO {
	//기업정보 VO
	
	private String bnum;
	private String o_id;
	private double c_score;
	private String c_price;
	private String c_time;
	private String c_last;
	private String c_menu;
	private String c_parking;
	private String c_keyword;
	private int c_hits;
	private String c_contents;
	private int c_admission; // 초기상태는 0, 관리자 승인이 되면 1, 등록 활성화
	private String c_name;
	private String c_newadd;
	private String c_photo;
	
	private ComdbVO cdbvo;// comdb 테이블 조인
	
	public ComVO() {
		super();
	}

	public ComVO(String bnum, String o_id, double c_score, String c_price, String c_time, String c_last, String c_menu,
			String c_parking, String c_keyword, int c_hits, String c_contents, int c_admission, String c_name,
			String c_newadd, String c_photo, ComdbVO cdbvo) {
		super();
		this.bnum = bnum;
		this.o_id = o_id;
		this.c_score = c_score;
		this.c_price = c_price;
		this.c_time = c_time;
		this.c_last = c_last;
		this.c_menu = c_menu;
		this.c_parking = c_parking;
		this.c_keyword = c_keyword;
		this.c_hits = c_hits;
		this.c_contents = c_contents;
		this.c_admission = c_admission;
		this.c_name = c_name;
		this.c_newadd = c_newadd;
		this.c_photo = c_photo;
		this.cdbvo = cdbvo;
	}


	public String getBnum() {
		return bnum;
	}

	public void setBnum(String bnum) {
		this.bnum = bnum;
	}

	public String getO_id() {
		return o_id;
	}

	public void setO_id(String o_id) {
		this.o_id = o_id;
	}

	public double getC_score() {
		return c_score;
	}

	public void setC_score(double c_score) {
		this.c_score = c_score;
	}

	public String getC_price() {
		return c_price;
	}

	public void setC_price(String c_price) {
		this.c_price = c_price;
	}

	public String getC_time() {
		return c_time;
	}

	public void setC_time(String c_time) {
		this.c_time = c_time;
	}

	public String getC_last() {
		return c_last;
	}

	public void setC_last(String c_last) {
		this.c_last = c_last;
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

	public int getC_hits() {
		return c_hits;
	}

	public void setC_hits(int c_hits) {
		this.c_hits = c_hits;
	}

	public String getC_contents() {
		return c_contents;
	}

	public void setC_contents(String c_contents) {
		this.c_contents = c_contents;
	}

	public int getC_admission() {
		return c_admission;
	}

	public void setC_admission(int c_admission) {
		this.c_admission = c_admission;
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

	public ComdbVO getCdbvo() {
		return cdbvo;
	}

	public void setCdbvo(ComdbVO cdbvo) {
		this.cdbvo = cdbvo;
	}

	public String getC_photo() {
		return c_photo;
	}

	public void setC_photo(String c_photo) {
		this.c_photo = c_photo;
	}
	
	
}
