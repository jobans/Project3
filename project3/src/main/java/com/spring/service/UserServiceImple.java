package com.spring.service;

import java.util.Random;

import javax.inject.Inject;
import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dao.EmailDAO;
import com.spring.dao.EmailSender;
import com.spring.dao.UserDAO;
import com.spring.vo.UserVO;

@Service
public class UserServiceImple implements UserService{

	@Inject // DAO 주입
	private UserDAO udao;
	
	EmailDAO edao = new EmailDAO();
  	
  	EmailSender emailSenderf = new EmailSender();
 
  	
	private boolean lowerCheck;
	private int size;
	String u_key;


// 1. 회원가입 관련 	
	// 개인정보 입력
	@Override
	public void insertUser(UserVO uvo) {		
		udao.signupUser(uvo);		
	}
	
	// 아이디 중복 확인
	@Override
	public UserVO idCheck(String u_id) {
		// TODO Auto-generated method stub
		return udao.checkId(u_id);
	}
	
	// email 중복확인
	@Override
	public UserVO emailCheck(String u_email) {
		// TODO Auto-generated method stub
		return udao.checkEmail(u_email);
	}
	
	// email 난수  생성
	@Override
	public String init() {
		Random ran = new Random();
		StringBuffer sb = new StringBuffer();
		int num = 0;

		do {
			num = ran.nextInt(75) + 48;
			if ((num >= 48 && num <= 57) || (num >= 65 && num <= 90) || (num >= 97 && num <= 122)) {
				sb.append((char) num);
			} else {
				continue;
			}

		} while (sb.length() < size);
		if (lowerCheck) {
			return sb.toString().toLowerCase();
		}
		return sb.toString();
	}


	// email 인증키 생성
	@Override
	public String getKey(boolean lowerCheck, int size) {
		this.lowerCheck = lowerCheck;
		this.size = size;
		return init();
	}
	

	// email 인증키 발송
	@Override
	public void mailSendWithUserKey(UserVO uvo, HttpServletRequest req) {
		
		u_key = getKey(false, 20);
        String u_id = uvo.getU_id();
        String u_email = uvo.getU_email();
        
        try {
            edao.setReceiver(u_email);
            edao.setSubject(u_id+"님의 회원가입을 위한 인증메일입니다.");
            edao.setContent("<h2>" + u_id + " 님 안녕하세요 ~  soldesk 입니다!</h2><br><br>" 
    				+ "<h3>" + u_id + "님 </h3>"
    				+ "<p><h4> 인증하기 버튼을 클릭하면 회원가입이 완료됩니다"
    				+ "<a href'http://localhost:8080" 
    				+ req.getContextPath() + "/usersignup/keyConfirm?u_id="+u_id+"&u_key="+u_key+"'>인증하기</a><h4></p><br>"
            		+ "<h6> 혹시 잘못 전달된 메일이라면 이 이메일을 무시하셔도 됩니다 </h6>)");
            emailSenderf.SendEmail(edao);	 
            
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	// email 인증키 입력
	@Override
	public void createU_key(UserVO uvo) {
		String u_id = uvo.getU_id();
		udao.createu_key(u_id, u_key);		
	}
	
	
	// email 인증키 확인
	public  void keyconfirm(String u_id, String u_key) {
		udao.keyConfirm(u_id, u_key);		
	}
	
	

	
//2. 로그인 관련
	// 로그인
	@Override
	public UserVO loginuser(String u_id, String u_pw, int grade) {
		// TODO Auto-generated method stub
		return udao.loginUser(u_id, u_pw, grade);
	}
	
	// 아이디 찾기
	@Override
	public UserVO finduser(String u_name, String u_dob) {
		// TODO Auto-generated method stub
		return udao.findUser(u_name, u_dob);
	}
	
	// 비번 찾기
	@Override
	public UserVO findpw(String u_id, String u_email) {		
		return udao.findPw(u_id, u_email);
	}
	
	// 비번 email 발송
	@Override
	public void mailSendFindpw(UserVO uvo) {
		String id=uvo.getU_id();
        String email=uvo.getU_email();
        String pw=uvo.getU_pw(); 
        
        //System.out.println(pw);
                     
        try {
        	 edao.setReceiver(email);
             edao.setSubject(id+"님 비밀번호 찾기 메일입니다.");
             edao.setContent(id + " 님의 비밀번호는 "+pw+" 입니다.");
			 emailSenderf.SendEmail(edao);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	
//3. 개인정보 조회
	@Override
	public UserVO readUser(String u_id) {		
		return udao.selectUser(u_id);
	}
	
	
//4. 개인정보 수정
	@Override
	public void modifyUser(UserVO uvo) {
		udao.updateUser(uvo);		
	}

	
	// 계정정지 - grade 수정
	@Override
	public void grade_stop(String u_id) {
		udao.grade_Stop(u_id);
		
	}
	
	// 계정 재활성화 - grade 수정
	@Override
	public void grade_reactivated(String u_id) {
		udao.grade_Reactivated(u_id);
		
	}

	
//5. 회원탈퇴
	@Override
	public void removeUser(String u_id) {
		udao.deleteUser(u_id);
	}


	

	

	

	
	

	

}
