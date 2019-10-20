package com.spring.service;

import java.util.Random;

import javax.inject.Inject;
import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.spring.dao.EmailDAO;
import com.spring.dao.EmailSender;
import com.spring.dao.OwnerDAO;
import com.spring.vo.OwnerVO;
@Service
public class OwnerServiceImple implements OwnerService {

	@Inject
	private OwnerDAO odao;
	
	
/*	
	@Inject // Email 주입
	private Email edao;
	
	@Inject // EmailSender 주입
    private EmailSender emailSenderf;
*/	
	EmailDAO edao = new EmailDAO();
  	
  	EmailSender emailSenderf = new EmailSender();
      
	
	private boolean lowerCheck;
	private int size;
	String o_key;

	
	// 회원가입
	@Override
	public void insertOwner(OwnerVO ovo) {
		odao.signupOwner(ovo);
	}
	
	// 아이디 중복
	@Override
	public OwnerVO idCheck(String o_id) {
		// TODO Auto-generated method stub
		return odao.checkId(o_id);
	}
	

	// email 중복
	@Override
	public OwnerVO emailCheck(String o_email) {
		// TODO Auto-generated method stub
		return odao.checkEmail(o_email);
	}

	// email 난수 생성
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
	public void mailSendWithOwnerKey(OwnerVO ovo, HttpServletRequest req) {
		o_key = getKey(false, 20);
        String o_id = ovo.getO_id();
        String o_email = ovo.getO_email();
        
      
        try {
            edao.setReceiver(o_email);
            edao.setSubject(o_id+"님의 회원가입을 위한 인증메일입니다.");
            edao.setContent("<h2>" + o_id + " 님 안녕하세요 ~  soldesk 입니다!</h2><br><br>" 
    				+ "<h3>" + o_id + "님 </h3>"
    				+ "<p><h4> 인증하기 버튼을 클릭하면 회원가입이 완료됩니다"
    				+ "<a href'http://localhost:8080" 
    				+ req.getContextPath() + "/usersignup/keyConfirm?uid="+o_id+"&ukey="+o_key+"'>인증하기</a><h4></p><br>"
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
	public void createokey(OwnerVO ovo1) {
		String o_id = ovo1.getO_id();
		odao.createOKey(o_id, o_key);	
	}

	// email 인증키 확인
	@Override
	public void keyconfirm(String o_id, String o_key) {
		odao.keyConfirm(o_id, o_key);		
	}

	
	// 로그인	
	@Override
	public OwnerVO loginowner(String o_id, String o_pw) {
		// TODO Auto-generated method stub
		return odao.loginOwner(o_id, o_pw);
	}

	// 아이디찾기
	@Override
	public OwnerVO findowner(String o_name, String bnum) {
		// TODO Auto-generated method stub
		return odao.findOwner(o_name, bnum);
	}

	// 비번 찾기
	@Override
	public OwnerVO findpw(String o_id, String o_email) {
		// TODO Auto-generated method stub
		return odao.findPw(o_id, o_email);
	}

	// 비번 email 발송
	@Override
	public void mailSendFindpw(OwnerVO ovo) {
		
		String id=ovo.getO_id();
        String email=ovo.getO_email();
        String pw=ovo.getO_pw(); 
        
       // System.out.println(pw);
                     
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
	

	// 개인정보 조회
	@Override
	public OwnerVO readOwner(String o_id) {
		// TODO Auto-generated method stub
		return odao.selectOwner(o_id);
	}

	// 개인정보 수정
	@Override
	public void modifyOwner(OwnerVO ovo) {
		odao.updateOwner(ovo);

	}
	
	// 관리자에 의한 계정 정지
	@Override
	public void grade_stop(String o_id) {
		// TODO Auto-generated method stub
		odao.grade_Stop(o_id);
	}

	// 관리자에 의ㅏ한 계정 재활성화
	@Override
	public void grade_reactivated(String o_id) {
		// TODO Auto-generated method stub
		odao.grade_Reactivated(o_id);
	}


	// 회원탈퇴
	@Override
	public void removeOwner(String o_id) {
		odao.deleteOwner(o_id);

	}




}
