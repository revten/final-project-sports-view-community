package com.tm.nmp.admin;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tm.nmp.account.AC_US_DAO;
import com.tm.nmp.board.BoardDAO;

@Controller
public class AdminController {

	@Autowired
	private AC_US_DAO acDAO;

	@Autowired
	private BoardDAO brDAO;
	
	@RequestMapping(value = "/admin.main.go", method = RequestMethod.GET)
	public String adminMainGo(HttpServletRequest req) {
		acDAO.wathingPage(req);
		acDAO.loginCheck(req);
		req.setAttribute("contentPage", "admin/admin.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/admin.member.go", method = RequestMethod.GET)
	public String adminMemberGo(HttpServletRequest req) {
		acDAO.wathingPage(req);
		acDAO.loginCheck(req);
		req.setAttribute("contentPage", "admin/adminMember.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/admin.board.go", method = RequestMethod.GET)
	public String adminBoardGo(HttpServletRequest req) {
		acDAO.wathingPage(req);
		acDAO.loginCheck(req);
		req.setAttribute("contentPage", "admin/adminBoard.jsp");
		return "index";
	}
	
}