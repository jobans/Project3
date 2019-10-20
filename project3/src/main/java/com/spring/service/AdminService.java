package com.spring.service;

import java.util.List;

import com.spring.vo.AD_NoticeVO;
import com.spring.vo.ComVO;
import com.spring.vo.OwnerVO;
import com.spring.vo.UserVO;

public interface AdminService {

	
	//사용자 전체조회 - 성공
	public List<UserVO> userList();
	
	// 사업자 전체조회
	public List<OwnerVO> ownerList();
	
	// 업체 전체 조회
	public List<ComVO> comList();
	
	
	//공지사항 조회수 증가
	public void ad_no_hits(int an_no);
	
	//공지사항 등록
	public void ad_no_write(AD_NoticeVO avo);
	
	// 공지사항 조회
	public AD_NoticeVO ad_no_select(int an_no);
	
	//공지사항 수정
	public void ad_no_update(AD_NoticeVO avo);
	
	//공지사항 삭제
	public void ad_no_delete(int an_no);
	
	// 공지사항 리스트
	public List<AD_NoticeVO> ad_no_list();
}
