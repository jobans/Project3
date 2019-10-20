package com.spring.dao;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spring.vo.ComVO;
import com.spring.vo.SearchVO;
import com.spring.vo.UserVO;

@Repository //저장소 역활 지정 -> 스프링에인식하기 위하여
public class UserDAOImple implements UserDAO{

	@Inject // DB 연결(Mybatis) 주입
	private SqlSession ss;
	
// 1. 회원가입 
	// 사용자 개인정보 등록
	@Override
	public void signupUser(UserVO uvo) {
		ss.insert("signupUser",uvo);
	}
	
	// 아이디 중복 확인
	@Override
	public UserVO checkId(String u_id) {
		// TODO Auto-generated method stub
		return ss.selectOne("com.spring.dao.UserDAO.checkId", u_id);
	}
	
		
	// email 중복 확인
	@Override
	public UserVO checkEmail(String u_email) {
		return ss.selectOne("com.spring.dao.UserDAO.checkEmail", u_email);
	}

	// email 인증키 입력
	@Override
	public void createu_key(String u_id, String u_key) {
		// uvo1 = (u_id, u_key)
		HashMap map = new HashMap();
        map.put("u_id", u_id);
        map.put("u_key", u_key);
     
		ss.update("createu_key", map);		
	}

	// 이메일 인증 코드 확인
	@Override
	public void keyConfirm(String u_id, String u_key) {
		HashMap map = new HashMap();
        map.put("u_id", u_id);
        map.put("u_key", u_key);
		ss.update("keyConfirm", map);
	}

	
	// 인증후 계정 활성화
	@Override
	public void userAuth(UserVO uvo) {
		System.out.println("인증하나요??");
        
        ss.update("userAuth", uvo);		
	}

	
// 2. 로그인
	@Override
	public UserVO loginUser(String u_id, String u_pw, int grade) {
		HashMap map = new HashMap();
        map.put("u_id", u_id);
        map.put("u_pw", u_pw);
        map.put("grade", grade);
		
		return ss.selectOne("loginUser", map);
	}
	
// 3. 아이디, 비밀번호 찾기
	
	// id 찾기
	@Override
	public UserVO findUser(String u_name, String u_dob) {
		
		HashMap map = new HashMap();
        map.put("u_name", u_name);
        map.put("u_dob", u_dob);
		
		return ss.selectOne("findUser", map);
	}
	
	// pw 찾기
	@Override
	public UserVO findPw(String u_id, String u_email) {
		HashMap map = new HashMap();
        map.put("u_id", u_id);
        map.put("u_email", u_email);
        
		return ss.selectOne("com.spring.dao.UserDAO.findPw", map);
	}
	
	
// 3. 개인정보 조회
	@Override
	public UserVO selectUser(String u_id) {
		
		return ss.selectOne("selectUser", u_id);
	}

	// 개인정보 수정
	@Override
	public void updateUser(UserVO uvo) {
		
		ss.update("updateUser", uvo);
		
	}



	// 계정정지 = grade 수정
	@Override
	public void grade_Stop(String u_id) {
		
		ss.update("grade_Stop", u_id);
		
	}
	
	// 계정 활성화 = grade 수정
	@Override
	public void grade_Reactivated(String u_id) {
		
		ss.update("grade_Reactivated", u_id);
		
	}

	
	// 4. 회원탈퇴
	@Override
	public void deleteUser(String u_id) {
		ss.delete("deleteUser", u_id);
		
	}


	
	
	



	



	

	



}
