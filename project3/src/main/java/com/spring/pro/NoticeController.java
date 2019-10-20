package com.spring.pro;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.service.ComService;
import com.spring.service.ComdbService;
import com.spring.service.NoticeService;
import com.spring.vo.ComVO;
import com.spring.vo.ComdbVO;
import com.spring.vo.NoticeVO;

@Controller
@RequestMapping("/comreg/*")
public class NoticeController {
	private static final Logger logger = LoggerFactory.getLogger(NoticeController.class);

	@Inject
	private NoticeService nsvc;
	
	@Inject
	private ComService csvc;
	
	@Inject
	private ComdbService cdbsvc;
	
		// 1. 공지사항 등록화면 호출
		@RequestMapping(value="/no_write", method=RequestMethod.GET)
		public void no_writeGET(HttpSession session, @RequestParam("bnum")String bnum, Model model) throws Exception{
					
			session.setAttribute("bnum", bnum);
			
			ComVO cvo = csvc.readCom(bnum);
			ComdbVO cdbvo = cdbsvc.searchCdb(cvo.getBnum());
			
			model.addAttribute("c_name", cdbvo.getC_name());
			
		}
		
		// 2. 공지사항 등록 처리
		@RequestMapping(value="/no_write", method=RequestMethod.POST)
		public String no_writePOST(HttpSession session,				
				@RequestParam("n_subject") String n_subject,
				@RequestParam("n_contents") String n_contents
				//@RequestParam("bnum")String bnum
				) throws Exception{
		
			NoticeVO nvo = new NoticeVO();
			nvo.setBnum((String)session.getAttribute("bnum"));
			//nvo.setBnum(bnum);
			nvo.setN_subject(n_subject);
			nvo.setN_contents(n_contents);
			
			nsvc.regnotice(nvo);
			
			return "redirect:/comreg/noticelist";
		}	
		
		// 3. 공지사항 리스트 화면
		@RequestMapping(value="/noticelist", method=RequestMethod.GET)
		public void noticelistGET(
				@RequestParam("bnum") String bnum,
				HttpSession session, Model model) throws Exception{
			
			//String bnum =(String)session.getAttribute("bnum");
		
		
			model.addAttribute("bnum", bnum);
			model.addAttribute("nlist", nsvc.Noticelist(bnum));
			
			ComVO cvo = csvc.readCom(bnum);
			ComdbVO cdbvo = cdbsvc.searchCdb(bnum);
			System.out.println(bnum);
			model.addAttribute("c_name", cdbvo.getC_name());
			
			
		
		}
		
		// 7. 공지사항 수정 호출
		@RequestMapping(value="/no_modify", method=RequestMethod.GET)
		public void modifyGET(HttpSession session, @RequestParam("n_no")int n_no , Model model) throws Exception{
			NoticeVO nvo = nsvc.selectnotice(n_no);
			
			ComdbVO cdbvo = cdbsvc.searchCdb(nvo.getBnum());
			model.addAttribute("c_name", cdbvo.getC_name());
			model.addAttribute("nvo",nvo);
		}
		
		
		// 8. 공지사항 수정 처리
		@RequestMapping(value="/no_modify", method=RequestMethod.POST)
		public String modifyCom(NoticeVO nvo  , HttpSession session, RedirectAttributes reAttr, Model model) throws Exception{
			
			nsvc.updatenotice(nvo);
			
			reAttr.addFlashAttribute("result", "Modisuccess");
			
			return "redirect:/comreg/noticelist";
		       	
		}
		

		// 9. 공지사항 삭제
		@RequestMapping(value = "/no_delete", method=RequestMethod.GET)
		public String delete(@RequestParam("n_no") int n_no, HttpSession session, RedirectAttributes reAttr) throws Exception{
			
			nsvc.deletenotice(n_no);
			
		   	reAttr.addFlashAttribute("result", "Delcomsuccess");		
		    
			return "redirect:/comreg/noticelist";	
			
		}
		
		
		
		

	
		
			
		
	  
	
}
