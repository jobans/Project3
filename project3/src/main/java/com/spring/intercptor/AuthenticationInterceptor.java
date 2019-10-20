package com.spring.intercptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthenticationInterceptor extends HandlerInterceptorAdapter{
	// AuthenticationInterceptor는 특정 경로 접근 시(게시물 입력, 수정, 삭제, myaccount 요청시) 사용자의 로그인 여부 체크
	
	private static final Logger logger = LoggerFactory.getLogger(AuthenticationInterceptor.class);
	
	
	// 페이지 요청 정보 저장
	private void saveDestination(HttpServletRequest request) {
		String uri = request.getRequestURI();
		String query = request.getQueryString();
		
		if (query == null || query.equals("null")) {
			query = "";
		} else {
			query = "?" + query;
		}
		
		if (request.getMethod().equals("GET")) {
			logger.info("destination : " + (uri + query));
			request.getSession().setAttribute("destination", uri + query);
		}
	}

	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// preHandle()는 참, 거짓에 따라 컨트롤러 요청 uri로 가느냐 안가느냐 결정
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("user");
		
		// 
		if (obj == null) {// 로그인 안된 경우
		logger.info("current user is not logged");
		
		response.sendRedirect("/usersignup/login");// 로그인페이지로 이동
		
		return false;// 컨트롤러 요청하지 않도록 false 반환
		}
		
		
		return true;// 참인 경우 컨트롤러 수행
	}
	
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// postHandle()은 httpSession에 컨트롤러 수행하여 저장한 user를 저장하고, 화면이 보여지기 직전에 수행
		HttpSession session = request.getSession(); // session 객체 호출 
		Object obj = session.getAttribute("user");
		
		if (obj != null) {
			logger.info("new login success");
			super.postHandle(request, response, handler, modelAndView);
			
		}
	}
	
	

		
	
}
