package com.spring.service;

import java.util.List;

import com.spring.vo.ReviewVO;
import com.spring.vo.PageCriteria;

public interface ReviewService {

	// 1. 리뷰 등록
		public void regreview(ReviewVO rvo);

	// 2. 리뷰 조회
		public ReviewVO selectreview(int r_no);
		
		
	// 3. 리뷰 수정
		public void updatereview(ReviewVO rvo);
		
	// 4. 리뷰 삭제
		public void deletereview(int r_no);
		
		public void autoScore(String bnum);
	// 
		public int countreview(String bnum);
		

	// 5. 업체별 리뷰 리스트
		public List<ReviewVO> Reviewlist(String bnum);
		
	// 6. 사용자별 리뷰 리스트
		public List<ReviewVO> Review_Ulist(String u_id);
		
		public List<ReviewVO> listpage(int page) throws Exception;// 페이징처리하는 메소드
		
		public List<ReviewVO> listcriteria(PageCriteria page) throws Exception;
		
		public int countdata(PageCriteria pCri) throws Exception;// 토탈 데이터 얻어오는 메소드?

}
