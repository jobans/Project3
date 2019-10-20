package com.spring.pro;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.eclipse.jdt.internal.compiler.ast.ModuleDeclaration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.service.AdminService;
import com.spring.service.UserService;
import com.spring.vo.UserVO;

@Controller
@RequestMapping("/admin/*")
public class AdminController {

	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@Inject
	private AdminService asvc;
	
	@Inject
	private UserService usvc;
	
	// 사용자 리스트 보기
	@RequestMapping(value="/u_list", method=RequestMethod.POST)
	public void admin_u_list(Model model) throws Exception{
		
		model.addAttribute("u_list", asvc.userList());
		
	}
	
	// 사업자 리스트 보기
	@RequestMapping(value="/o_list", method=RequestMethod.POST)
	public void admin_o_list(Model model) throws Exception{
		
		model.addAttribute("o_list", asvc.ownerList());
		
	}
	
	// 업체 리스트 전체 보기
	@RequestMapping(value="/c_list", method=RequestMethod.POST)
	public void admin_c_list(Model model) throws Exception{
		
		model.addAttribute("c_list", asvc.comList());
		
	}
	
	
}
