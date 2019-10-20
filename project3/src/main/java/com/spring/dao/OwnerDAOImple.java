package com.spring.dao;

import java.util.HashMap;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import com.spring.vo.OwnerVO;

@Repository
public class OwnerDAOImple implements OwnerDAO {
	
	@Inject
	private SqlSession ss;
	
// 1. 회원가입	
	
	// 개인정보 등록
	@Override
	public void signupOwner(OwnerVO ovo) {
		ss.insert("signupOwner", ovo);

	}
	
	// 아이디 중복
	@Override
	public OwnerVO checkId(String o_id) {
		// TODO Auto-generated method stub
		return ss.selectOne("com.spring.dao.OwnerDAO.checkId", o_id);
	}

	// email 중복
	@Override
	public OwnerVO checkEmail(String o_email) {
		// TODO Auto-generated method stub
		return ss.selectOne("com.spring.dao.OwnerDAO.checkEmail", o_email);
	}

	// 인증키 입력
	@Override
	public void createOKey(String o_id, String o_key) {
		// uvo1 = (uid, ukey)
		HashMap map = new HashMap();
        map.put("o_id", o_id);
        map.put("o_key", o_key);
     
		ss.update("createO_key", map);	
		
	}

	// 인증코드 확인
	@Override
	public void keyConfirm(String o_id, String o_key) {
		HashMap map = new HashMap();
        map.put("o_id", o_id);
        map.put("o_key", o_key);
		ss.update("keyConfirm", map);	
	}

	// 인증후 계정 활성화
	@Override
	public void ownerAuth(OwnerVO ovo) {
		// TODO Auto-generated method stub
		 ss.update("ownerAuth", ovo);
	}



// 2.  로그인

	@Override
	public OwnerVO loginOwner(String o_id, String o_pw) {
		HashMap map = new HashMap();
        map.put("o_id", o_id);
        map.put("o_pw", o_pw);
		
		return ss.selectOne("loginOwner", map);
	}

// 3. 아이디, 비번 찾기
	// 아이디찾기
	@Override
	public OwnerVO findOwner(String o_name, String bnum) {
		HashMap map = new HashMap();
        map.put("o_name", o_name);
        map.put("bnum", bnum);
		
		return ss.selectOne("findOwner", map);
	}
	
	// 비번 찾기
	@Override
	public OwnerVO findPw(String o_id, String o_email) {
		HashMap map = new HashMap();
        map.put("o_id", o_id);
        map.put("o_email", o_email);
        
		return ss.selectOne("com.spring.dao.OwnerDAO.findPw", map);
	}



// 4. 개인정보 조회
	@Override
	public OwnerVO selectOwner(String o_id) {
		// TODO Auto-generated method stub
		return ss.selectOne("selectOwner", o_id);
	}

// 5. 개인정보 수정	
	@Override
	public void updateOwner(OwnerVO ovo) {
		ss.update("updateOwner", ovo);

	}
	
// 관리자에 의한 계정 정지
	@Override
	public void grade_Stop(String o_id) {
		// TODO Auto-generated method stub
		ss.update("key_Stop", o_id);
	}

// 관리자에 의한 계정 재활성화
	@Override
	public void grade_Reactivated(String o_id) {
		// TODO Auto-generated method stub
		ss.update("key_Reactivated", o_id);
	}	

// 6. 탈퇴
	@Override
	public void deleteOwner(String o_id) {
		ss.delete("deleteOwner", o_id);

	}

}
