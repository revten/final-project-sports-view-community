package com.tm.nmp.admin;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tm.nmp.account.AccountDAO;

@Controller
public class AdminC {
	
	@Autowired
	private AccountDAO acDAO;
	
	@Autowired
	private AnswerDAO asDAO;
	
	@RequestMapping(value = "/admin.answerBoard.go", method = RequestMethod.GET)
	public String adminAnswerBoardGo(HttpServletRequest req) {
		acDAO.loginCheck(req);
		
		asDAO.getAnswerAll(req, 1);
		req.setAttribute("contentPage", "admin/answerBoard.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/ans.page.change", method = RequestMethod.GET)
	public String answerPageChange(HttpServletRequest req) {
		int p = Integer.parseInt(req.getParameter("p"));
		asDAO.getAnswerAll(req, p);
		acDAO.loginCheck(req);
		req.setAttribute("contentPage", "admin/answerBoard.jsp");
		return "index";
	}
	
	

}
