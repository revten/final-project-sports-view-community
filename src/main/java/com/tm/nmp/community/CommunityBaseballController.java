package com.tm.nmp.community;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tm.nmp.account.AccountDAO;

@Controller
public class CommunityBaseballController {

	@Autowired
	private AccountDAO acDAO;
	
	@Autowired
	private CM_BS_DAO bsDAO;
	
	@RequestMapping(value = "baseballBoard.go", method = RequestMethod.GET)
	public String baseballBoardGo(HttpServletRequest req, CM_BS_TITLE bs) {
		acDAO.loginCheck(req);
		bsDAO.getAllBaseball(req,bs);
		req.setAttribute("contentPage", "community/baseball/baseballBoard.jsp");

		return "index";
	}
}
