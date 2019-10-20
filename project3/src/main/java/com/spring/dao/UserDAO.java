package com.spring.dao;


import com.spring.vo.UserVO;

public interface UserDAO {
	
// 1. 회원가입
	// 개인정보 등록
	public void signupUser(UserVO uvo);

	// 아이디 중복 확인
	public UserVO checkId(String u_id);
	
	// email 중복 확인   
    public UserVO checkEmail(String u_email);
 
    // email 인증키 입력
    public void createu_key(String u_id, String u_key);
    
    //이메일 인증 코드 확인
    public void keyConfirm(String u_id, String u_key);
 
    //인증 후 계정 활성화
    public void userAuth(UserVO uvo);
      
	
// 2. 로그인
	public UserVO loginUser(String u_id, String u_pw, int grade);
	
// 3. 아이디, 비번 찾기	
	// 아이디 찾기
	public UserVO findUser(String u_name, String u_dob);
	
	// 비번 찾기
	public UserVO findPw(String u_id, String u_email);
	
	
// 4. 개인정보 조회
	public UserVO selectUser(String u_id);
	
// 5. 개인정보 수정
	public void updateUser(UserVO uvo);

    
// 계정정지 = grade 수정
    public void grade_Stop(String u_id);
    
// 계정 재활성화 = grade 수정
    public void grade_Reactivated(String u_id);    
   
	
// 6. 회원탈퇴
	public void deleteUser(String u_id);

	
	
}
