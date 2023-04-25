package com.tm.nmp.admin;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tm.nmp.account.accountDAO;
import com.tm.nmp.board.BoardDAO;

@Controller
public class AdminController {

	@Autowired
	private accountDAO acDAO;

	@Autowired
	private BoardDAO brDAO;

	@RequestMapping(value = "/admin.go", method = RequestMethod.GET)
	public String adminGo(HttpServletRequest req) {
//		acDAO.wathingPage(req);
//		acDAO.loginCheck(req);
		return "/admin/admin";
	}

	@RequestMapping(value = "/admin.member.go", method = RequestMethod.GET)
	public String adminMemberGo(HttpServletRequest req) {
//		acDAO.wathingPage(req);
//		acDAO.loginCheck(req);
		return "/admin/adminMember";
	}

	@RequestMapping(value = "/admin.board.go", method = RequestMethod.GET)
	public String adminBoardGo(HttpServletRequest req) {
//		acDAO.wathingPage(req);
//		acDAO.loginCheck(req);
		return "/admin/adminBoard";
	}

	@RequestMapping(value = "/admin.club.go", method = RequestMethod.GET)
	public String adminClubGo(HttpServletRequest req) {
//		acDAO.wathingPage(req);
//		acDAO.loginCheck(req);
		return "/admin/adminClub";
	}

}