package com.spring.dao;

import java.util.List;
import com.spring.vo.NoticeVO;
import com.spring.vo.PageCriteria;


public interface NoticeDAO {

	// 1. 공지사항 등록
		public void regNotice(NoticeVO nvo);

	// 2. 공지사항 조회
		public NoticeVO selectNotice(int n_no);
		
		// 조회수
		public void noticeviewCnt(int n_no);

	// 3. 공지사항 수정
		public void updateNotice(NoticeVO nvo);
		
	// 4. 공지사항 삭제
		public void deleteNotice(int n_no);
		
	// 5. 업체별 공지사항 리스트
		public List<NoticeVO> NoticeList(String bnum);
		
	// 6. 공지사항 전체리스트	
		public List<NoticeVO> NoticeAllList();
		
		public List<NoticeVO> listPage(int page) throws Exception;// 페이징처리하는 메소드
		
		public List<NoticeVO> listCriteria(PageCriteria page) throws Exception;
		
		public int countData(PageCriteria pCri) throws Exception;// 토탈 데이터 얻어오는 메소드?
		
		
}
