	package com.spring.pro;

import javax.inject.Inject;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.service.BookingService;
import com.spring.service.ComService;
import com.spring.service.ComdbService;
import com.spring.service.CommonService;
import com.spring.service.ReplyService;
import com.spring.service.ReviewService;
import com.spring.service.UserService;
import com.spring.vo.BookingVO;
import com.spring.vo.ComVO;
import com.spring.vo.ComdbVO;
import com.spring.vo.OwnerVO;
import com.spring.vo.SearchVO;
import com.spring.vo.UserVO;

@Controller
@RequestMapping("/common/*")
public class CommonController {

	private static final Logger logger = LoggerFactory.getLogger(CommonController.class);

	@Inject // service 주입
	private CommonService comsvc;
	
	@Inject
	private ComService csvc;
	
	@Inject
	private ComdbService cdbsvc;
	
	@Inject
	private ReviewService rsvc;
	
	@Inject
	private BookingService bsvc;
	
	@Autowired
	private JavaMailSender mailSender;
	
	@Inject
	private ReplyService r_rsvc;
	
// 1. main 페이지  
	// main 호출
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public void mainGet(Model model) throws Exception{
		
		model.addAttribute("top_list", csvc.top6_list());
		
		// 업체명 모델에 넣기
	}
	

	// 로그인 페이지 호출
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public void loginGet(Model model) throws Exception{
		logger.info("loginGET start...");
		
	}
	
	// id, pw 찾기 호출
	@RequestMapping(value = "/find", method = RequestMethod.GET)
	public void findGet(Model model) throws Exception{
		logger.info("loginGET start...");
		
	}
	
	
	// 각 업체 사이트 관련
	// 업체 사이트 이동
		@RequestMapping(value="/r_site", method=RequestMethod.GET)
		public void r_site(@RequestParam("bnum") String bnum, HttpSession session, Model model) throws Exception{
			//조회수  증가
			csvc.comviewcnt(bnum);
			
			
			// 업체 사진 파일 모델 저장
			
			session.setAttribute("bnum", bnum);
						
			ComdbVO cdbvo = cdbsvc.searchCdb(bnum);
			model.addAttribute("cdbvo", cdbvo);
			
			
			model.addAttribute("countreview", rsvc.countreview(bnum));
			
			ComVO cvo = csvc.readCom(bnum);
			
			
			
			
			model.addAttribute("cvo", cvo);
				
			model.addAttribute("r", r_rsvc.reallList());
			
			model.addAttribute("rlist", rsvc.Reviewlist(bnum));
		
			
			// 이용자 사진 파일 모델 저장
		}
		// 5. 각 업체 사이트에서  예약하기 호출
			@RequestMapping(value="/booking", method=RequestMethod.GET)	
			public void booking(@ModelAttribute("bnum") String bnum, HttpSession session, Model model) throws Exception{
				
				ComdbVO cdbvo = cdbsvc.searchCdb(bnum);
				model.addAttribute("c_name", cdbvo.getC_name());	
			}	
			
		// 6. 예약처리
			@RequestMapping(value="/booking", method=RequestMethod.POST)
			public String bookingPOST(BookingVO bvo, HttpSession session, RedirectAttributes reAttr,HttpServletRequest request)throws Exception {
				bsvc.regbooking(bvo);
				String bnum = bvo.getBnum();
				
				reAttr.addFlashAttribute("result","BookingSuccess");
				
				OwnerVO ovo = bsvc.bookingOwnerMail(bnum);
				
		
				//예약확인메일보내기
				String setfrom = "whqkstjr625@gmail.com";        //관리자 메일 or 이용자 메일?
			    String tomail  = ovo.getO_email();     // 받는 사람 이메일
			    String title   = bvo.getB_date()+"예약";      // 제목
			    String content = bvo.getB_date() +" 에 " + bvo.getB_per() + " 명 예약";    // 내용
			   
			    try {
			      MimeMessage message = mailSender.createMimeMessage();
			      MimeMessageHelper messageHelper 
			                        = new MimeMessageHelper(message, true, "UTF-8");
			 
			      messageHelper.setFrom(setfrom);  // 보내는사람 생략하거나 하면 정상작동을 안함
			      messageHelper.setTo(tomail);     // 받는사람 이메일
			      messageHelper.setSubject(title); // 메일제목은 생략이 가능하다
			      messageHelper.setText(content);  // 메일 내용
			      
			     
			      mailSender.send(message);
			    } catch(Exception e){
			      System.out.println(e);
			    }
				return "redirect:/common/r_site?bnum="+bnum;
			}
			
			
			
		// 5. 검색 결과
		@RequestMapping(value="/search", method=RequestMethod.GET)	
		public void search(@ModelAttribute("keyword") String keyword, Model model) throws Exception{
			
			model.addAttribute("s_list", csvc.listFind(keyword));
			//model.addAttribute("s_count", csvc.findCountData(keyword));
	
		}
		
			
		// 6. 검색한 자료 중 선택 상세보기
		@RequestMapping(value = "/r_site")
		public void readPage(
				@RequestParam("bnum")String bnum,
				@ModelAttribute("svo") SearchVO svo,
				Model model
				) throws Exception {
			
			ComdbVO cdbvo = cdbsvc.searchCdb(bnum);
			model.addAttribute("cdbvo", cdbvo);
			rsvc.autoScore(bnum);
			model.addAttribute("countreview", rsvc.countreview(bnum));
			
			ComVO cvo = csvc.readCom(bnum);
			model.addAttribute("cvo", cvo);
			
			model.addAttribute("rlist", rsvc.Reviewlist(bnum));
		
		}			
	
	// 로그 아웃
    @RequestMapping(value="/logout")
    public String logout(HttpSession session, RedirectAttributes reAttr) {
        session.invalidate(); // 세션 전체를 날려버림
        //session.removeAttribute("login"); // 하나씩 하려면 이렇게 해도 됨.
        
        reAttr.addFlashAttribute("result","Logoutsuccess");

        return "redirect:/common/main"; // 로그아웃 후 main 이동
    }

	
}
