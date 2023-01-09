package com.tm.nmp.infoEvent;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tm.nmp.account.AccountDAO;
import com.tm.nmp.news.NewsDAO;

@Controller
public class infoEventController {

	
	@Autowired
	private AccountDAO aDAO;
	
	@Autowired
	private NewsDAO nDAO;
	
	@RequestMapping(value = "/team.event.main.go", method = RequestMethod.GET)
	public String teamEventMainGo(HttpServletRequest req) {
		aDAO.loginCheck(req);
		req.setAttribute("contentPage", "infoEvent/teamEvent.jsp");
		return "index";
	}
	@RequestMapping(value = "/sports.info.main.go", method = RequestMethod.GET)
	public String sportsInfoMainGo(HttpServletRequest req) {
		aDAO.loginCheck(req);
		req.setAttribute("contentPage", "infoEvent/sportsInfo.jsp");
		return "index";
	}
	
}
