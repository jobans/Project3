package com.spring.service;

import java.util.List;

import com.spring.vo.NoticeVO;
import com.spring.vo.PageCriteria;

public interface NoticeService {
	
	// 1. 공지사항 등록
		public void regnotice(NoticeVO nvo);

	// 2. 공지사항 조회
		public NoticeVO selectnotice(int n_no);
		
		// 조회수
		public void noticeviewcnt(int n_no);


	// 3. 공지사항 수정
		public void updatenotice(NoticeVO nvo);
		
	// 4. 공지사항 삭제
		public void deletenotice(int n_no);
		
	// 5. 공지사항 리스트
		public List<NoticeVO> Noticelist(String bnum);
		
		public List<NoticeVO> NoticeAlllist();
		
		public List<NoticeVO> listpage(int page) throws Exception;// 페이징처리하는 메소드
		
		public List<NoticeVO> listcriteria(PageCriteria page) throws Exception;
		
		public int countdata(PageCriteria pCri) throws Exception;// 토탈 데이터 얻어오는 메소드?

}
