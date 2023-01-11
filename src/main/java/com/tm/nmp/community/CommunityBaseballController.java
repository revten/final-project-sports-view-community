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
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String withGoListGo(HttpServletRequest req) {
		acDAO.loginCheck(req);

		req.setAttribute("contentPage", "community/baseball/.jsp");

		return "index";
	}
	
	
}
