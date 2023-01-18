package com.tm.nmp.admin;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tm.nmp.account.AC_US_DAO;

@Controller
public class AdminC {
	
	@Autowired
	private AC_US_DAO acDAO;
	
	@Autowired
	private AnswerDAO asDAO;
	
	@RequestMapping(value = "/admin.answerBoard.go", method = RequestMethod.GET)
	public String adminAnswerBoardGo(HttpServletRequest req) {
		acDAO.loginCheck(req);
		
		asDAO.getAnswerAll(req);
		req.setAttribute("contentPage", "admin/answerBoard.jsp");
		return "index";
	}
	
	

}
