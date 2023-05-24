package com.tm.nmp.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

import com.tm.nmp.account.AccountDTO;

public class AdminInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		HttpSession session = request.getSession();

		AccountDTO ac = (AccountDTO) session.getAttribute("Account");
		
		if(ac == null ||  ac.getId() != "admin") { // 관리자 계정이 아닐 경우
			
			response.sendRedirect("/index"); // 메인페이지로 리다이렉트
			
			return false;
			
		}

		return true; // 관리자 계정 로그인인 경우
	}
}
