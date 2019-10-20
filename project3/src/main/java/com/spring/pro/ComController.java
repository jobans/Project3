	package com.spring.pro;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.service.ComService;
import com.spring.service.ComdbService;
import com.spring.service.NoticeService;
import com.spring.service.ReviewService;
import com.spring.up.UploadFileUtils;
import com.spring.vo.ComVO;
import com.spring.vo.ComdbVO;
import com.spring.vo.NoticeVO;
import com.spring.vo.OwnerVO;
import com.spring.vo.ReviewVO;

@Controller
@RequestMapping("/comreg/*")
public class ComController {
	
	private static final Logger logger = LoggerFactory.getLogger(ComController.class);

	@Inject
	private ComService csvc;
	
	
	@Inject
	private ComdbService cdbsvc;
	
	@Inject
	private ReviewService rsvc;
	
	@Resource(name = "uploadPath")
	private String uploadPath;
	// 1. 업체등록 요청
	
	@RequestMapping(value = "/regreq", method=RequestMethod.GET)
	public void regreqGET(HttpSession session, Model model) throws Exception{
		logger.info("regreqGET start....");
	}

	// 2. 업체등록 요청 후 승인 처리
	@RequestMapping(value = "/regreq", method=RequestMethod.POST)
	public String regreq(@RequestParam("bnum") String bnum, 
			HttpSession session, 
			Model model, 
			RedirectAttributes reAttr ) {
		
		ComdbVO cdbvo = cdbsvc.searchCdb(bnum);
		OwnerVO ovo = (OwnerVO)session.getAttribute("owner");
		
		if ( cdbvo != null ){ // 모범음식점 번호가 db에 있다면
	       
			csvc.admissionCom(bnum);// 승인 상태 1로 변경하여 업체 등록 활성화
			session.setAttribute("bnum", bnum);
			
	        reAttr.addFlashAttribute("result","Reqsuccess");
	        
	        return "redirect:/comreg/register";
	        
	    }else { // 업체 등록 실패한 경우
	    	reAttr.addFlashAttribute("result","Reqfail");
	    }
		
		
		
		
        return "redirect:/comreg/regreq"; 
	}
		
		
	
	// 3. 업체 등록 화면 호출
	@RequestMapping(value = "/register", method=RequestMethod.GET)
	public void regCom(HttpSession session, Model model) throws Exception{
		logger.info("regCom start...");
		
		OwnerVO ovo = (OwnerVO)session.getAttribute("owner");
		//String bnum = (String)session.getAttribute("bnum");
		
		String o_id = ovo.getO_id();
		String bnum = ovo.getBnum();	
		System.out.println(bnum);
		System.out.println(o_id);
		
		model.addAttribute("o_id", o_id);
		model.addAttribute("bnum", bnum);
		
		ComVO cvo = csvc.readCom(ovo.getO_id());
		ComdbVO cdbvo = cdbsvc.searchCdb(bnum);
		model.addAttribute("c_name", cdbvo.getC_name());
		//model.addAttribute("c_score", cvo.getC_score());
			        
	}
	
	// 4. 업체 등록 처리
	@RequestMapping(value = "/register", method=RequestMethod.POST)
	public String regComPOST(ComVO cvo, HttpSession session, Model model, RedirectAttributes reAttr,
			MultipartFile file) throws Exception {
		
		logger.info("regComPOST start...");
		logger.info(cvo.toString());
		
		
		
		reAttr.addFlashAttribute("result", "Regsuccess");
		
		session.removeAttribute("bnum"); //
		
		String imgUploadPath = uploadPath + File.separator + "imgUpload";
		String ymdPath = UploadFileUtils.calcPath(imgUploadPath);
		String fileName = null;
		
		if(file != null) {
		 fileName =  UploadFileUtils.fileUpload(imgUploadPath, file.getOriginalFilename(), file.getBytes(), ymdPath); 
		} else {
		 fileName = uploadPath + File.separator + "images" + File.separator + "none.png";
		}
		
		String a = File.separator + "imgUpload" + ymdPath + File.separator + fileName;
		System.out.println(a);
		cvo.setC_photo(File.separator + "imgUpload" + ymdPath + File.separator + fileName);
		csvc.insertCom(cvo);
		//vo.setGdsThumbImg(File.separator + "imgUpload" + ymdPath + File.separator + "s" + File.separator + "s_" + fileName);
		
		
		
		
		return "redirect:/ownersignup/myaccount";
	}
	
	
	// 5. 사업자별 업체 리스트
	@RequestMapping(value="/mycomList", method=RequestMethod.GET)
	public void mycomList(HttpSession session, Model model) throws Exception{
		
		OwnerVO ovos = (OwnerVO)session.getAttribute("owner"); //session에 있는 정보를 받아온다
		String o_id = ovos.getO_id();

		model.addAttribute("clist", csvc.comlist(o_id));
		
		System.out.println(ovos.getO_id());
	}
	
	
	// 6. 각 업체 상세 보기
	@RequestMapping(value="/comaccount", method=RequestMethod.GET)
	public void readCom(@RequestParam("bnum") String bnum,  HttpSession session, Model model) throws Exception{

		model.addAttribute("com", csvc.readCom(bnum));
		ComdbVO cdbvo = cdbsvc.searchCdb(bnum);
		model.addAttribute("c_name", cdbvo.getC_name());
        
	}
	
	
	// 7. 각 업체 정보 수정 호출
	@RequestMapping(value="/modify", method=RequestMethod.GET)
	public void modifyGET(@RequestParam("bnum") String bnum, HttpSession session, Model model) throws Exception{
		
		session.setAttribute("bnum", bnum);

		ComVO cvo = csvc.readCom(bnum);
		model.addAttribute("com", cvo);
		ComdbVO cdbvo = cdbsvc.searchCdb(bnum);
		model.addAttribute("c_name", cdbvo.getC_name());
		
	}
	
	// 8. 각 업체 정보 수정 처리
	@RequestMapping(value="/modify", method=RequestMethod.POST)
	public String modifyCom(HttpSession session, RedirectAttributes reAttr,
	
			@RequestParam("c_price") String c_price,
			@RequestParam("c_time") String c_time,
			@RequestParam("c_last") String c_last,
			@RequestParam("c_menu") String c_menu,
			@RequestParam("c_parking") String c_parking,
			@RequestParam("c_keyword") String c_keyword,
			@RequestParam("c_contents") String c_contents
			) throws Exception{
		
		ComVO cvo = new ComVO();
		cvo.setBnum((String)session.getAttribute("bnum"));
		cvo.setO_id((String)session.getAttribute("o_id"));
		cvo.setC_price(c_price);
		cvo.setC_time(c_time);
		cvo.setC_last(c_last);
		cvo.setC_menu(c_menu);
		cvo.setC_parking(c_parking);
		cvo.setC_keyword(c_keyword);
		cvo.setC_contents(c_contents);
		
		System.out.println(cvo.getBnum());
		System.out.println(cvo.getC_price());
			
		csvc.modifyCom(cvo);
		
		reAttr.addFlashAttribute("result", "Modisuccess");
		
		return "redirect:/comreg/mycomList";
	       	
	}
	
	
	// 각 업체별 통계 처리
	@RequestMapping(value="/statistic", method=RequestMethod.GET)
	public void statistic(@RequestParam("bnum") String bnum, HttpSession session, Model model){
		model.addAttribute("bnum", bnum);	
		
	}
	
	

	
	// 9. 업체 삭제
	@RequestMapping(value = "/deletecom", method=RequestMethod.GET)
	public String delete(@RequestParam("bnum") String bnum, HttpSession session, RedirectAttributes reAttr) throws Exception{
		
		csvc.removeCom(bnum);
		
	   	reAttr.addFlashAttribute("result", "Delcomsuccess");		
	    
		return "/ownersignup/myaccount";	
		
	}
	
		
	
}
