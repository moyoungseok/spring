package com.reonsoft.example.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthInterceptor extends HandlerInterceptorAdapter{
	
		private static final Logger logger = LoggerFactory.getLogger(AuthInterceptor.class);

		//현재 로그인 상태 여부를 확인하고 컨트롤러를 호출할 것인지 아닌지를 결정 <특정 경로에 접근할 경우 현재 사용자의 로그인 여부를 체크한다>
		@Override
		public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
				throws Exception {
			HttpSession httpSession = request.getSession();
			
			if(httpSession.getAttribute("login")==null) {
				logger.info("current user is not logged");
				response.sendRedirect("/login"); //로그인하지 않은 사용자라면 로그인 페이지로 리다이렉트
				return false;
			}
			return true;
		}
		
		
}
