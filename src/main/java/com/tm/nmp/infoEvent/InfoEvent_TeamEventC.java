package com.tm.nmp.infoEvent;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tm.nmp.account.AccountDAO;

@Controller
public class InfoEvent_TeamEventC {

	@Autowired
	private AccountDAO aDAO;
	
	@Autowired
	private InfoEventDAO iDAO;
	
	@RequestMapping(value = "/team.event.detail.go", method = RequestMethod.GET)
	public String teamEventDetailGo(HttpServletRequest req, TeamEventDTO te) {
		aDAO.loginCheck(req);
		iDAO.getteamEvent(req, te);
		
		req.setAttribute("contentPage", "infoEvent/teamEvent/teamEventDetail.jsp");
		return "index";
	}
}
