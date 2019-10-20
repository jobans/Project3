package com.spring.pro;

import java.io.File;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.catalina.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.service.AdminService;
import com.spring.service.BookingService;
import com.spring.service.ComService;
import com.spring.service.ComdbService;
import com.spring.service.OwnerService;
import com.spring.service.ReplyService;
import com.spring.service.ReviewService;
import com.spring.service.UserService;
import com.spring.up.UploadFileUtils;
import com.spring.vo.AD_NoticeVO;
import com.spring.vo.BookingVO;
import com.spring.vo.ComVO;
import com.spring.vo.ComdbVO;
import com.spring.vo.OwnerVO;
import com.spring.vo.ReplyVO;
import com.spring.vo.ReviewVO;
import com.spring.vo.UserVO;


@Controller
@RequestMapping("/usersignup/*")
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Inject // service 주입
	private UserService usvc;
	
	@Inject
	private ComService csvc;
	
	@Inject
	private ComdbService cdbsvc;
	
	@Inject
	private ReviewService rsvc;
	
	@Inject
	private BookingService bsvc;
	
	@Inject
	private AdminService asvc;
	
	@Inject
	private OwnerService osvc;
	
	@Inject
	private ReplyService r_rsvc;
	
	
// 1. 회원가입

	// 회원가입 페이지 (register.jsp) 호출 - get 방식 (signup page)
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public void signupGET(UserVO uvo, Model model) throws Exception {
		logger.info("signupGET start...");
		
	}
	
	// 아이디 중복확인
	@ResponseBody // ajax 사용
	@RequestMapping(value="/idcheck", method=RequestMethod.POST)
	public int idcheck(HttpServletRequest req) throws Exception{
		
		logger.info("idcheck start");
		
		String u_id = req.getParameter("u_id");
		UserVO uvo = usvc.idCheck(u_id);
		
		int result = 0; // 사용불가
		
		if(uvo == null) {
			
			result = 1;// 사용 가능
		}
		
		return result;
	}
	
	// 비밀번호 유효성평가
	@ResponseBody // ajax 사용
	@RequestMapping(value="/pwCheck", method=RequestMethod.POST)
	public boolean PwCheck(@RequestParam("u_pw") String u_pw) {	
		logger.info("PwCheck");	
		
		boolean check = false;	
		
		String pw_chk = "^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[$@$!%*?&`~'\"+=])[A-Za-z[0-9]$@$!%*?&`~'\"+=]{6,18}$"; 
		Pattern pattern_symbol = Pattern.compile(pw_chk);	
		Matcher matcher_symbol = pattern_symbol.matcher(u_pw);
		
		if(matcher_symbol.find()) {	
			check = true; 
		}	
		return check; 
	}
	
	// email 유효성 검사
	@ResponseBody // ajax 사용
	@RequestMapping(value="/emailcheck", method=RequestMethod.POST)
	public boolean emailcheck(@RequestParam("u_email") String u_email) {	
		logger.info("emailcheck start");	
		
		boolean check = false;	
		
		String email_chk = "^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$";
		
		Pattern pattern_symbol = Pattern.compile(email_chk);	
		Matcher matcher_symbol = pattern_symbol.matcher(u_email);
		 
		if(matcher_symbol.find()) {	
			check = true; 
		}	
		return check; 
	}
		
	
	// email 중복 확인
	@ResponseBody // ajax 사용
	@RequestMapping(value="/emailducheck", method=RequestMethod.POST)
	public int emailducheck(HttpServletRequest req) throws Exception{
		
		logger.info("emailducheck start");
		
		String u_email = req.getParameter("u_email");
		UserVO uvo = usvc.emailCheck(u_email);
		
		int result = 0; // 사용불가
		
		if(uvo == null) {
			
			result = 1;// 사용가능
		}
		
		return result;
	}
	

	// 회원가입 처리 (register.jsp) - post 방식
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String signupPOST(UserVO uvo, HttpServletRequest req, RedirectAttributes reAttr) throws Exception {
		
		logger.info("signupPOST start...");
		logger.info(uvo.toString());
		
		
/*		
		// 입력 비밀번호
		System.out.println("입력 pw : " + uvo.getu_pw());
		
		// 비밀번호 암호화 (sha 256)
		String encryPw = PwSha256.encrypt(uvo.getu_pw());
		
		uvo.setu_pw(encryPw);
		
		// 암호화된 pw 확인
		System.out.println("암호화된 pw : " + uvo.getu_pw());
*/		
		// db 입력
		usvc.insertUser(uvo);		
		
		// email 인증키 생성 및 발송
		//usvc.mailSendWithUserKey(uvo, req);
		//usvc.createU_key(uvo);
		
		reAttr.addFlashAttribute("result","Inputsuccess");	
		
		return "redirect:/common/main"; 
	}
		
	// email 인증키 확인
	@RequestMapping(value="/keyConfirm", method=RequestMethod.GET)
	public String keyConfirm(@RequestParam("u_id") String u_id, @RequestParam("u_key") String u_key,  RedirectAttributes reAttr) {
		
		usvc.keyconfirm(u_id, u_key);
		// 결과 알림
		reAttr.addFlashAttribute("result","Regsuccess");		
		return "/usersignup/login";
	}

	
// 2. 로그인	

	// 로그인 처리
	@RequestMapping(value="/u_login", method=RequestMethod.POST)
	public String uloginPOST(@RequestParam("u_id") String u_id, 
			@RequestParam("u_pw") String u_pw, 
			@RequestParam("grade") int grade,
			HttpSession session, RedirectAttributes reAttr) throws Exception {
		
		logger.info("login start...");
		logger.info("id : " + u_id);
		
		 if (session.getAttribute("user") != null ){
	        // 기존에 login이란 세션 값이 존재한다면
	        session.removeAttribute("user"); // 기존값을 제거해 준다.
	     }
		 
		// 비밀번호 암호화
			// String encryPw = PwSha256.encrypt(u_pw);
		         	         
	    // 로그인이 성공하면 OwnerVO(ovo) 객체를 반환함.
		UserVO uvo = usvc.loginuser(u_id, u_pw, grade);
	         
	    if ( uvo != null ){ // 로그인 성공
	    	System.out.println(uvo.getU_email());
	        session.setAttribute("user", uvo); // 세션에 login인이란 이름으로 OwnerVO 객체를 저장.
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
	public String idfindPOST(@RequestParam("u_name") String u_name, @RequestParam("u_dob") String u_dob, HttpSession session, RedirectAttributes reAttr) throws Exception {
		
		logger.info("login start...");
		
		UserVO uvo = usvc.finduser(u_name, u_dob);	
		
		reAttr.addFlashAttribute("id", uvo.getU_id());
		
		return "redirect:/common/find";
		 
 	}
 	
 	
 	// 비밀번호 찾기 처리
  	@RequestMapping(value="/pwfind", method=RequestMethod.POST)
 	public String pwfindPOST(@RequestParam("u_id") String u_id, @RequestParam("u_email") String u_email, RedirectAttributes reAttr) throws Exception {
 		
 		logger.info("pw find start...");
 		
 		UserVO uvo = usvc.findpw(u_id, u_email);
 		
 		// email 비밀번호 발송	
 		if(uvo !=null) {
 			
 			usvc.mailSendFindpw(uvo);
 			
            reAttr.addFlashAttribute("result","Pwsendsuccess");
            
            return "redirect:/common/login";
        }else {

        	reAttr.addFlashAttribute("result","PwFail");
        	return "redirect:/common/find";
        }      
 
  	}
  	 
    
	
// 3. myaccount에서 개인정보 조회      
	@RequestMapping(value="/myaccount", method=RequestMethod.GET)
	public String myaccountGET(HttpSession session, Model model) throws Exception{
		
		UserVO uvos = (UserVO)session.getAttribute("user"); //session에 있는 정보를 받아온다
		String u_id = uvos.getU_id();

		//List<ReviewVO> rvo = rsvc.Review_Ulist(u_id);
		
		model.addAttribute("r_list", rsvc.Review_Ulist(u_id));

		//model.addAttribute("c_name",cdbsvc.searchCdb(rvo.getBnum()));
		
        if(u_id == null) {
            return "/common/main";
        } else {
        
	        model.addAttribute("uvo", usvc.readUser(u_id));
	        
			return "/usersignup/myaccount";
		}	
        
	}
	
	
// 4. modify에서 개인정보 수정하기
	// 수정 조회
	@RequestMapping(value="/modify", method=RequestMethod.GET)
	public String modifyGET(HttpSession session, Model model) throws Exception {
		logger.info("modifyGET start...");
		
		UserVO uvos = (UserVO)session.getAttribute("user"); //session에 있는 정보를 받아온다
		String u_id = uvos.getU_id();
		
        if(uvos == null) {
            return "/common/login";
            
        } else {
        
        	model.addAttribute("uvo", usvc.readUser(u_id));
	        
	        return "/usersignup/modify";
        }
     
		
	}
	
	
	// 수정처리
	@RequestMapping(value="/modify", method=RequestMethod.POST)
	public String modifyPOST(UserVO uvo, HttpSession session, RedirectAttributes reAttr) throws Exception {// RedirectAttributes : 한번만 전송
		
		logger.info("modifyPOST start...");
		
		usvc.modifyUser(uvo);	
		reAttr.addFlashAttribute("result", "Modisuccess");
		
		return "redirect:/usersignup/myaccount";
	}
	// 예약 수정 호출
		@RequestMapping(value="/b_modify", method=RequestMethod.GET)
		public void b_modifyGET(@RequestParam("b_no") int b_no, Model model) throws Exception {
			logger.info("modifyGET start...");
			
			BookingVO bvo = bsvc.selectbooking(b_no);
			System.out.println(bvo.getB_no());
			System.out.println(bvo.getB_date());
			model.addAttribute("bvo", bvo);
			
			ComdbVO cdbvo = cdbsvc.searchCdb(bvo.getBnum());
			model.addAttribute("c_name", cdbvo.getC_name());
			
		}
		
		
		// 예약 수정 처리
		@RequestMapping(value="/b_modify", method=RequestMethod.POST)
		public String b_modifyPOST(BookingVO bvo, RedirectAttributes reAttr) throws Exception {// RedirectAttributes : 한번만 전송
			
			logger.info("modifyPOST start...");
			
			bsvc.updatebooking(bvo);
			reAttr.addFlashAttribute("result", "b_Modisuccess");
			
			return "redirect:/usersignup/myaccount";
		}	
	


		
		// 사용자 리뷰 작성 화면 호출
		@RequestMapping(value="/rev_write", method=RequestMethod.GET)
		public void re_writeGET(HttpSession session, Model model){
			
			UserVO uvos = (UserVO)session.getAttribute("user");
			String u_id = uvos.getU_id();
			
			String bnum = (String)session.getAttribute("bnum");
			
			ComdbVO cdbvo = cdbsvc.searchCdb(bnum);
			
			
			model.addAttribute("u_id", u_id);				
			model.addAttribute("bnum", bnum);			
			model.addAttribute("c_name", cdbvo.getC_name());
			
		}
		
		
		// 사용자 리뷰 처리
		@RequestMapping(value="/rev_write", method=RequestMethod.POST)
		public String re_writePOST(ReviewVO rvo, HttpSession session, Model model){
			rsvc.regreview(rvo);
			
			String bnum = rvo.getBnum();
				
			ComdbVO cdbvo = cdbsvc.searchCdb(bnum);
			model.addAttribute("cdbvo", cdbvo);
			
			model.addAttribute("countreview", rsvc.countreview(bnum));
			
			ComVO cvo = csvc.readCom(bnum);
			model.addAttribute("cvo", cvo);
			model.addAttribute("rlist", rsvc.Reviewlist(bnum));	
				
			rsvc.autoScore(bnum);	
			return "/common/r_site";			
			
		}
		
		// 사용자 리뷰 수정 화면
		@RequestMapping(value="/rev_modify", method=RequestMethod.GET)
		public void modifyGET(HttpSession session, @RequestParam("r_no")int r_no, Model model) throws Exception{
			UserVO uvos = (UserVO)session.getAttribute("user");
			String u_id = uvos.getU_id();
			
			ReviewVO rvo = rsvc.selectreview(r_no);
			
			model.addAttribute("rvo", rvo);			
	
		}
		
		
		// 8. 사용자 리뷰 수정 처리
		@RequestMapping(value="/rev_modify", method=RequestMethod.POST)
		public String modifyCom(ReviewVO rvo  , HttpSession session, RedirectAttributes reAttr, Model model) throws Exception{
			
			rsvc.updatereview(rvo);
				
			String bnum = rvo.getBnum();
			
			String a = "direct:/common/r_site?bnum=";
			rsvc.autoScore(bnum);
			reAttr.addFlashAttribute("result", "r_Modisuccess");
			
			return "redirect:/common/r_site?bnum="+bnum;
		       	
		}	
		
		
		// 9. 사용자 리뷰 삭제
		@RequestMapping(value = "/rev_delete", method = RequestMethod.GET )
		public String delreview(int r_no, ReviewVO rvo,HttpSession session)throws Exception {
			rsvc.deletereview(r_no);
			rsvc.autoScore((String) session.getAttribute("bnum"));
			String bnum = (String) session.getAttribute("bnum");
			return "redirect:/common/r_site?bnum="+bnum;
		}
		
		// 리뷰 상세보기 호출 (댓글리스트, 댓글창 포함)
		@RequestMapping(value="/rev_select", method=RequestMethod.GET)
		public void rev_selectGET(HttpSession session, @RequestParam("r_no")int r_no, Model model) throws Exception{
			
			ReviewVO rvo = rsvc.selectreview(r_no);
			
			model.addAttribute("rvo", rvo);	
			
			List<ReplyVO> re_list = r_rsvc.replyList(r_no);
			
			model.addAttribute("re_list", re_list);
						
		}
		

		// 댓글 등록 처리	  
		@RequestMapping(value="/rep_write", method=RequestMethod.POST)
		public String rep_write(@RequestParam("r_no") Integer r_no,
								@RequestParam("re_r_contents") String re_r_contents,
								HttpSession session, RedirectAttributes reAttr, Model model) {

			OwnerVO ovos = (OwnerVO) session.getAttribute("owner");
			String o_id = ovos.getO_id();
					
			ReplyVO r_rvo = new ReplyVO();		
			r_rvo.setO_id(o_id);
			r_rvo.setR_no(r_no);
			r_rvo.setRe_r_contents(re_r_contents);
			ReviewVO rvo = rsvc.selectreview(r_no);
			String bnum =   rvo.getBnum();
			try {
				
				r_rsvc.inputReply(r_rvo);
				
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
			reAttr.addFlashAttribute("result", "rep_regsuccess");
			
		
			return "redirect:/common/r_site?bnum=" +bnum;
		}
		// 관리자 공지사항 작성 호출
		@RequestMapping(value="/a_n_write", method=RequestMethod.GET)
		public void a_n_write1() {
					
		}
		
		
		// 관리자 공지사항 작성 처리
		@RequestMapping(value="/a_n_write", method=RequestMethod.POST)
		public String a_n_writePOST(AD_NoticeVO avo, HttpSession session, RedirectAttributes reAttr) {
			
			asvc.ad_no_write(avo);	
			
			return "redirect:/usersignup/myaccount";
		}
		
		// 공지사항 한 건 당 조회 (조회수 증가 포함)
		@RequestMapping(value="/a_n_select", method=RequestMethod.GET)
		public void a_n_select(@RequestParam("an_no") Integer an_no, HttpSession session, Model model) {
			
			UserVO uvo = (UserVO)session.getAttribute("user");
			
			if(uvo != null) {
				asvc.ad_no_hits(an_no);	
			}
			
			AD_NoticeVO avo = asvc.ad_no_select(an_no);
			
			model.addAttribute("avo", avo);	
			
		}
		
		
		// 관리자 공지사항 수정 호출
		@RequestMapping(value="/a_n_modify", method=RequestMethod.GET)
		public void a_n_modify(@RequestParam("an_no") Integer an_no, Model model) {
			
			AD_NoticeVO avo = asvc.ad_no_select(an_no);
			
			model.addAttribute("avo", avo);
			
		}
		
		// 관리자 공지사항 수정 처리
		@RequestMapping(value="/a_n_modify", method=RequestMethod.POST)
		public String a_n_modifyPOST(AD_NoticeVO avo, HttpSession session, RedirectAttributes reAttr) {
			
			asvc.ad_no_update(avo);
			
			reAttr.addFlashAttribute("result", "a_n_Modisuccess");
			
			return "redirect:/usersignup/myaccount";
		}
		
		// main(버튼)에 관리자 공지사항 호출
		@RequestMapping(value="/a_n_list", method=RequestMethod.GET)
		public void a_n_list(Model model) {
			
			model.addAttribute("ad_no_list", asvc.ad_no_list());
			
		}
		
		
		// 관리자 공지사항 삭제
		@RequestMapping(value="/a_n_delete", method=RequestMethod.GET)
		public String a_n_delete(@RequestParam("an_no") Integer an_no, HttpSession session, RedirectAttributes reAttr, Model model) throws Exception{
			
			asvc.ad_no_delete(an_no);
			
			reAttr.addFlashAttribute("result", "a_n_Delsuccess");
			
			return "redirect:/usersignup/myaccount";
			
		}
		
		
		// 관리자 사용자 회원 정지 
		@RequestMapping(value="/u_stop", method=RequestMethod.GET)
		public String admin_u_stop(@RequestParam("u_id") String u_id, RedirectAttributes reAttr) throws Exception{
			
			usvc.grade_stop(u_id);
			
			return "redirect:/usersignup/myaccount";
			
		}
		
		// 관리자 사용자 회원 계정 재활성화
		@RequestMapping(value="/u_reactivated", method=RequestMethod.GET)
		public String admin_u_reactivated(@RequestParam("u_id") String u_id, RedirectAttributes reAttr) throws Exception{
			
			usvc.grade_reactivated(u_id);
			
			return "redirect:/usersignup/myaccount";
			
		}
		
		// 관리자 사용자 회원 삭제
		@RequestMapping(value="/u_delete", method=RequestMethod.GET)
		public String admin_u_delete(@RequestParam("u_id") String u_id, RedirectAttributes reAttr) throws Exception{
			
			usvc.removeUser(u_id);
			
			return "redirect:/usersignup/myaccount";
			
		}
		
		
		// 관리자 사업자 회원 정지 
		@RequestMapping(value="/o_stop", method=RequestMethod.GET)
		public String admin_o_stop(@RequestParam("o_id") String o_id, RedirectAttributes reAttr) throws Exception{
			
			osvc.grade_stop(o_id);
			
			return "redirect:/usersignup/myaccount";
			
		}
		
		// 관리자 사업자 회원 계정 재활성화
		@RequestMapping(value="/o_reactivated", method=RequestMethod.GET)
		public String admin_o_reactivated(@RequestParam("o_id") String o_id, RedirectAttributes reAttr) throws Exception{
			
			osvc.grade_reactivated(o_id);
			
			return "redirect:/usersignup/myaccount";
			
		}
		
		// 관리자 사업자 회원 삭제
		@RequestMapping(value="/o_delete", method=RequestMethod.GET)
		public String admin_o_delete(@RequestParam("o_id") String o_id, RedirectAttributes reAttr) throws Exception{
			
			osvc.removeOwner(o_id);
			
			return "redirect:/usersignup/myaccount";
			
		}

	
// 5. 회원탈퇴
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public String delete(HttpSession session, RedirectAttributes reAttr) throws Exception{
	
		UserVO uvos = (UserVO)session.getAttribute("user"); //session에 있는 정보를 받아온다
		
	    if(uvos == null) {
	        return "/usersignup/login";
	    }
	    
	    usvc.removeUser(uvos.getU_id());
	   	reAttr.addFlashAttribute("result", "Delsuccess");		
	    
		return "/usersignup/main";	
	
	}
}
