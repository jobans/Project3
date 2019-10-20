package com.spring.dao;

import java.util.List;

import com.spring.vo.AD_NoticeVO;
import com.spring.vo.ComVO;
import com.spring.vo.OwnerVO;
import com.spring.vo.UserVO;

public interface AdminDAO {

	//관리자 기능
	
		// 사용자 전체조회
		public List<UserVO> UserList();
		
		// 사업자 전체조회
		public List<OwnerVO> OwnerList();
		
		// 업체 전체 조회
		public List<ComVO> ComList();
		
		
		//공지사항 조회수 증가
		public void ad_no_Hits(int an_no);
		
		//공지사항 등록
		public void ad_no_Write(AD_NoticeVO avo);
		
		// 공지사항 조회
		public AD_NoticeVO ad_no_Select(int an_no);
		
		//공지사항 수정
		public void ad_no_Update(AD_NoticeVO avo);
		
		//공지사항 삭제
		public void ad_no_Delete(int an_no);
		
		//공지사항 전체 리스트
		public List<AD_NoticeVO> ad_no_List();
		
		
}
