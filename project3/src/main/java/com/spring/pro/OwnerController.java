package com.spring.pro;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.spring.service.ComService;
import com.spring.service.ComdbService;
import com.spring.service.OwnerService;
import com.spring.vo.ComVO;
import com.spring.vo.ComdbVO;
import com.spring.vo.OwnerVO;
import com.spring.vo.OwnerVO;
import com.spring.vo.OwnerVO;

@Controller
@RequestMapping("/ownersignup/*")
public class OwnerController {
	
	private static final Logger logger = LoggerFactory.getLogger(OwnerController.class);

	@Inject
	private OwnerService osvc;
	
	@Inject
	private ComService csvc;
	
	@Inject
	private ComdbService cdbsvc;

	
	
	// 1. 회원가입
	
		// 회원가입 페이지 (register.jsp) 호출 - get 방식 (signup page)
		@RequestMapping(value = "/register", method = RequestMethod.GET)
		public void signupGET( OwnerVO ovo, Model model) throws Exception {
			
			
		}
		
		
		// 아이디 중복확인
		@ResponseBody // ajax 사용
		@RequestMapping(value = "/idcheck", method=RequestMethod.POST)
		public int idcheck(HttpServletRequest req) throws Exception{
			
			logger.info("idcheck start");
			
			String o_id = req.getParameter("o_id");
			OwnerVO ovo = osvc.idCheck(o_id);
			
			int result = 0; // 사용불가
			
			if(ovo == null) {
				
				result = 1;// 사용가능
			}
			
			return result;
		}

		// 모범음식점 번호 유효성 및 중복 검사
		@ResponseBody // ajax 사용
		@RequestMapping(value = "/bnumcheck", method=RequestMethod.POST)
		public int bnumcheck(HttpServletRequest req) throws Exception{
			
			logger.info("bnumcheck start");
			
			String bnum = req.getParameter("bnum");
			ComdbVO cdbvo = cdbsvc.searchCdb(bnum);
			
			ComVO cvo = csvc.readCom(bnum);
			
			int result = 0; 
			
			if(cdbvo != null && cvo == null) {			
				result = 1;// 사용가능
			} else if (cdbvo == null) {
				result = 0; // 없는 번호
			} else if (cvo != null) {
				result = 2; // 중복
			}
			
			return result;
				}
		
		// 비밀번호 유효성평가
		@ResponseBody // ajax 사용
		@RequestMapping(value = "/pwCheck", method = RequestMethod.POST)
		public boolean PwCheck(@RequestParam("o_pw") String o_pw) {	
			logger.info("PwCheck");	
			
			boolean check = false;	
			String pw_chk = "^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[$@$!%*?&`~'\"+=])[A-Za-z[0-9]$@$!%*?&`~'\"+=]{6,18}$"; 
			Pattern pattern_symbol = Pattern.compile(pw_chk);	
			Matcher matcher_symbol = pattern_symbol.matcher(o_pw);
			
			if(matcher_symbol.find()) {	
				check = true; 
			}	
			return check; 
		}
		
		// email 유효성 검사
		@ResponseBody // ajax 사용
		@RequestMapping(value = "/emailcheck", method=RequestMethod.POST)
		public boolean emailcheck(@RequestParam("o_email") String o_email) {	
			logger.info("emailcheck start");	
			
			boolean check = false;	
			
			String email_chk = "^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$";
				
			Pattern pattern_symbol = Pattern.compile(email_chk);	
			Matcher matcher_symbol = pattern_symbol.matcher(o_email);
			
			if(matcher_symbol.find()) {	
				check = true; 
			}	
			return check; 
		}
			
		
		// email 중복 확인
		@ResponseBody // ajax 사용
		@RequestMapping(value = "/emailducheck", method=RequestMethod.POST)
		public int emailducheck(HttpServletRequest req) throws Exception{
			
			logger.info("emailducheck start");
			
			
			String o_email = req.getParameter("o_email");
			System.out.println(o_email);
			OwnerVO ovo = osvc.emailCheck(o_email);
			
			int result = 0; // 사용불가
			
			if(ovo == null) {
				
				result = 1;// 사용가능
			}
			
			return result;
		}
		

		
		// register.jsp - post 방식 (입력 데이터 처리)
		@RequestMapping(value="/register", method = RequestMethod.POST)
		public String signupPOST(OwnerVO ovo, HttpServletRequest req, RedirectAttributes reAttr) throws Exception {
			//로그 기록
			logger.info("signupPOST start...");
			logger.info(ovo.toString());

			
			// 회원가입
			osvc.insertOwner(ovo);	
			
			// 인증키 생성 및 발송 후 DB 입력
		/*
		 * osvc.mailSendWithOwnerKey(ovo, req); osvc.createokey(ovo);
		 */
			
			reAttr.addFlashAttribute("result","Inputsuccess");
				
			return "redirect:/common/main"; 
			
		}
		
			
		// email 인증키 확인후 o_key "y"로 수정
		@RequestMapping(value="/keyConfirm", method=RequestMethod.GET)
		public String keyConfirm(@RequestParam("o_id") String o_id, @RequestParam("o_key") String o_key,  RedirectAttributes reAttr) {
			
			osvc.keyconfirm(o_id, o_key);
			// 결과 알림
			reAttr.addFlashAttribute("result","Regsuccess");	
			
			return "/ownersignup/login";			
		}
		
		
	// 2. 로그인	
	
		// 로그인 처리
		@RequestMapping(value="/o_login", method=RequestMethod.POST)
		public String loginPOST(@RequestParam("o_id") String o_id, @RequestParam("o_pw") String o_pw, HttpSession session, RedirectAttributes reAttr) throws Exception {
			
			logger.info("login start...");
			logger.info("id : " + o_id);
			
			 if (session.getAttribute("owner") != null ){
		        // 기존에 login이란 세션 값이 존재한다면
		        session.removeAttribute("owner"); // 기존값을 제거해 준다.
		     }
		         
		    // 로그인이 성공하면 OwnerVO(ovo) 객체를 반환함.
			OwnerVO ovo = osvc.loginowner(o_id, o_pw);
		         
		    if ( ovo != null ){ // 로그인 성공
		        session.setAttribute("owner", ovo); // 세션에 login인이란 이름으로 OwnerVO 객체를 저장.
		    	reAttr.addFlashAttribute("result","LoginSeccess");
		        return "redirect:/common/main"; // 로그인 성공시 게시글 목록페이지로 바로 이동하도록 하고
		    }else { // 로그인에 실패한 경우
		    	reAttr.addFlashAttribute("result","LoginFail");
		        return "redirect:/common/login"; // 로그인 폼으로 다시 가도록 함
		    }
		          
		}
		

	 // 3. 아이디, 비밀번호 찾기
	 	// 아이디 찾기 처리
	 	@RequestMapping(value="/idfind", method=RequestMethod.POST)
		public String idfindPOST(@RequestParam("o_name") String o_name, @RequestParam("bnum") String bnum, HttpSession session, RedirectAttributes reAttr) throws Exception {
			
			logger.info("login start...");
			
			OwnerVO ovo = osvc.findowner(o_name, bnum);		
			reAttr.addFlashAttribute("id", ovo.getO_id());
			
			return "redirect:/common/find";
			 
	 	}
	 	
	 	
	 	// 비밀번호 찾기 처리
	  	@RequestMapping(value="/pwfind", method=RequestMethod.POST)
	 	public String pwfindPOST(@RequestParam("o_id") String o_id, @RequestParam("o_email") String o_email, RedirectAttributes reAttr) throws Exception {
	 		
	 		logger.info("pw find start...");
	 		
	 		OwnerVO ovo = osvc.findpw(o_id, o_email);
	 		
	 		// email 비밀번호 발송	
	 		if(ovo !=null) {
	 			
	 			osvc.mailSendFindpw(ovo);
	 			
	            reAttr.addFlashAttribute("result","Pwsendsuccess");
	            
	            return "redirect:/common/login";
	            
	        }else {	        	
	        	reAttr.addFlashAttribute("result","PwFail");
	        	return "redirect:/common/find";
	        }      
	 
	  	}
	  	 
	    
	    
		
	// 4. myaccount에서 개인정보 조회      
		@RequestMapping(value="/myaccount", method = RequestMethod.GET)
		public String selectOwner(HttpSession session, Model model) throws Exception{
			// 개인정보 보기
			OwnerVO ovos = (OwnerVO)session.getAttribute("owner"); //session에 있는 정보를 받아온다
			String o_id = ovos.getO_id();
				
			//System.out.println(o_id);
		
			if(o_id == null) {
				return "/common/login"; 
			} else {
			  
			model.addAttribute("ovo", osvc.readOwner(o_id));
			  
			 return "/ownersignup/myaccount";
			}
		 
		}

		

	// 4.개인정보 수정하기 
		// 수정 조회
		@RequestMapping(value = "/modify", method = RequestMethod.GET)
		public String modifyGET(HttpSession session, Model model) throws Exception {
			
			logger.info("modifyGET start...");

			OwnerVO ovos = (OwnerVO)session.getAttribute("owner"); //session에 있는 정보를 받아온다
			//System.out.println(ovos.getO_id());
			
	        if(ovos == null) {
	            return "/common/login";
	        } else {
	        	model.addAttribute(osvc.readOwner(ovos.getO_id()));
		        
		        return "/ownersignup/modify";
	        }
	           
		}
		
		
		// 개인정보 수정처리
		@RequestMapping(value = "/modify", method=RequestMethod.POST)
		public String modifyPOST(OwnerVO ovo, RedirectAttributes reAttr) throws Exception {// RedirectAttributes : 한번만 전송
			
			logger.info("modifyPOST start...");
		
			osvc.modifyOwner(ovo);	
			reAttr.addFlashAttribute("result", "Modisuccess");
			
			return "redirect:/ownersignup/myaccount";
		}
		
		
	// 5. 회원탈퇴
		@RequestMapping(value = "/delete", method=RequestMethod.GET)
		public String delete(HttpSession session, RedirectAttributes reAttr) throws Exception{
		
			OwnerVO ovos = (OwnerVO)session.getAttribute("owner"); //session에 있는 정보를 받아온다
			
		    if(ovos == null) {
		        return "/ownersignup/login";
		    }
		    
		    osvc.removeOwner(ovos.getO_id());
		   	reAttr.addFlashAttribute("result", "Delsuccess");		
		    
			return "/ownersignup/main";	
		
		}
			
	
}
