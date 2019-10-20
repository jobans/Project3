package com.spring.service;

import javax.servlet.http.HttpServletRequest;
import com.spring.vo.UserVO;

public interface UserService {
	
//회원가입
	public void insertUser(UserVO uvo);
	
	// 아이디 중복 확인
	public UserVO idCheck(String u_id);
	
	// email 중복 확인
	public UserVO emailCheck(String u_email);
	
	// email 난수 생성 
	public String init();
	
	// email 인증키 생성
	public String getKey(boolean lowerCheck, int size);
	
	// email 인증키 입력
    public void createU_key(UserVO uvo1);   
	
	// email 인증키 발송
	public void mailSendWithUserKey(UserVO uvo, HttpServletRequest req);
	
	// email 인증키 확인
	public void keyconfirm(String u_id, String u_key);
	

	
// 로그인
	public UserVO loginuser(String u_id, String u_pw, int grade);
	
	// 아이디 찾기	
	public UserVO finduser(String u_name, String u_dob);
	
	// 비번 찾기
	public UserVO findpw(String u_id, String u_email);
	
	// 비번 email 발송
	public void mailSendFindpw(UserVO uvo);
		
	
//개인정보 조회
	public UserVO readUser(String u_id);
	
//개인정보 수정
	public void modifyUser(UserVO uvo);
	
// 계정정지 = grade 수정
    public void grade_stop(String u_id);
    
// 계정 재활성화 = grade 수정
    public void grade_reactivated(String u_id); 
    	
	
// 회원탈퇴
	public void removeUser(String u_id);

}
