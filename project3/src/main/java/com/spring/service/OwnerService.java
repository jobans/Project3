package com.spring.service;

import javax.servlet.http.HttpServletRequest;

import com.spring.vo.OwnerVO;
import com.spring.vo.UserVO;

public interface OwnerService {

//회원가입
	public void insertOwner(OwnerVO ovo);
	
	// 아이디 중복 확인
	public OwnerVO idCheck(String o_id);
	
	// email 중복 확인
	public OwnerVO emailCheck(String o_email);
	
	// email 난수 생성 
	public String init();
	
	// email 인증키 생성
	public String getKey(boolean lowerCheck, int size);
	
	// email 인증키 입력
    public void createokey(OwnerVO ovo1);   
	
	// email 인증키 발송
	public void mailSendWithOwnerKey(OwnerVO uvo, HttpServletRequest req);
	
	// email 인증키 확인
	public void keyconfirm(String o_id, String o_key);
	
	
// 로그인
	public OwnerVO loginowner(String o_id, String o_pw);

	// 아이디 찾기	
	public OwnerVO findowner(String o_name, String bnum);
	
	// 비번 찾기
	public OwnerVO findpw(String o_id, String o_email);
	
	// 비번 email 발송
	public void mailSendFindpw(OwnerVO ovo);
		
		
//개인정보 조회
	public OwnerVO readOwner(String o_id);
	
//개인정보 수정
	public void modifyOwner(OwnerVO ovo);
	
// 계정정지 = grade 수정
    public void grade_stop(String o_id);
    
// 계정 재활성화 = grade 수정
    public void grade_reactivated(String o_id); 	
	
// 회원탈퇴
	public void removeOwner(String o_id);
}
