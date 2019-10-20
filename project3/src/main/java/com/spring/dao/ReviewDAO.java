package com.spring.dao;

import java.util.List;

import com.spring.vo.ReviewVO;
import com.spring.vo.PageCriteria;

public interface ReviewDAO {

	// 1. 리뷰 등록
		public void regReview(ReviewVO rvo);

	// 2. 리뷰 조회
		public ReviewVO selectReview(int r_no);


		
	// 3. 리뷰 수정
		public void updateReview(ReviewVO rvo);
		
	// 4. 리뷰 삭제
		public void deleteReview(int r_no);
		
	// 5. 업체별 리뷰 count (게시글 수)
		public int countReview(String bnum); 
	
	// 평점
		public void autoScore(String bnum);
	
		
	// 5. 업체별 리뷰 리스트
		public List<ReviewVO> ReviewList(String bnum);
		
	// 6. 사용자별 리뷰 리스트
		public List<ReviewVO> Review_uList(String u_id);
		
		public List<ReviewVO> listPage(int page) throws Exception;// 페이징처리하는 메소드
		
		public List<ReviewVO> listCriteria(PageCriteria page) throws Exception;
		
		public int countData(PageCriteria pCri) throws Exception;// 토탈 데이터 얻어오는 메소드?
			
			
}
