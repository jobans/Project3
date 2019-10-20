package com.spring.vo;

public class PageCriteria {

	private int page;// 현재 페이지 번호
	private int numPerPage;// 보여지는 페이지당 글 개수
	
	public PageCriteria() {
		this.page = 1;
		this.numPerPage = 10;	
	}
	
	

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		if(page<=0) {
			this.page = 1;
			return;
		}
		
		this.page = page;
	}

	public int getNumPerPage() {
		return numPerPage;
	}

	public void setNumPerPage(int numPerPage) {
		if(numPerPage <= 0 || numPerPage > 50) {
			this.numPerPage = 10; // 재초기화
			return;
		}
		
		this.numPerPage = numPerPage;
	}
	
	// 페이지 구분 설정
	public int getStartPage() {
		return (this.page -1) * numPerPage;
	}
	
	public String toString() {
		return "PageCriteria [page="+this.page+", numPerPage="+ this.numPerPage+"]";
	}
	
	
	
	
}
