package com.spring.dao;

import com.spring.vo.OwnerVO;

public interface OwnerDAO {

// 1. 회원가입 관련
	
	// 개인정보 등록
	public void signupOwner(OwnerVO ovo);
	
	// 아이디 중복 확인
	public OwnerVO checkId(String o_id);
	
	// email 중복 확인   
    public OwnerVO checkEmail(String o_email);
 
    // email 인증키 입력
    public void createOKey(String o_id, String o_key);
    
    //이메일 인증 코드 확인
    public void keyConfirm(String o_id, String o_key);
    
    //인증 후 계정 활성화
    public void ownerAuth(OwnerVO ovo);
	      
	
// 2. 로그인
	public OwnerVO loginOwner(String o_id, String o_pw);
	
// 3. 아이디, 비번 찾기	
	// 아이디 찾기
	public OwnerVO findOwner(String o_name, String bnum);
	
	// 비번 찾기
	public OwnerVO findPw(String o_id, String o_email);
		
		
// 4. 개인정보 조회
	public OwnerVO selectOwner(String o_id);
	
// 5. 개인정보 수정
	public void updateOwner(OwnerVO ovo);
	
	
// 계정정지 = grade 수정
    public void grade_Stop(String o_id);
    
// 계정 재활성화 = grade 수정
    public void grade_Reactivated(String o_id);    
   
	
// 6. 회원탈퇴
	public void deleteOwner(String o_id);

	
}
