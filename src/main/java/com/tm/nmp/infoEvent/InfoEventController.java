package com.tm.nmp.infoEvent;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tm.nmp.account.AccountDAO;

@Controller
public class InfoEventController {

	
	@Autowired
	private AccountDAO aDAO;
	
	@Autowired
	private InfoEventDAO iDAO;
	
	
	@RequestMapping(value = "/team.event.main.go", method = RequestMethod.GET)
	public String teamEventMainGo(HttpServletRequest req, TeamEventDTO te) {
		aDAO.loginCheck(req);
		iDAO.getteamEventAll(req, te);
		
		req.setAttribute("contentPage", "infoEvent/teamEvent/teamEvent.jsp");
		return "index";
	}
	
	
	@RequestMapping(value = "/sports.info.main.go", method = RequestMethod.GET)
	public String sportsInfoMainGo(HttpServletRequest req) {
		aDAO.loginCheck(req);
		req.setAttribute("contentPage", "infoEvent/sportsInfo/sportsInfo.jsp");
		return "index";
	}
	
}
