package com.spring.intercptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter{

	private static final Logger logger = LoggerFactory.getLogger(AuthenticationInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// preHandle()는 참, 거짓에 따라 컨트롤러 요청 uri로 가느냐 안가느냐 결정
		HttpSession session = request.getSession();// session  객체 호출
		Object obj = session.getAttribute("user");// 로그인 된 사용자 정보 객체를(모델명) obj에 담음
		
		// 
		if (obj == null) {// 객체에 정보가 없다면
		logger.info("clear login data before");
		
		response.sendRedirect("/usersignup/login");// login page 이동
		
		return false;// 컨트롤러 요청하지 않도록 false 값 반환
		}
			
		return true;// 객체에 정보가 있다면 true 리턴하여 컨트롤러 수행
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
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		super.afterCompletion(request, response, handler, ex);
	}
	
}
