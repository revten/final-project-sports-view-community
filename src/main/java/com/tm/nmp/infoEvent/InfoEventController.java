package com.tm.nmp.infoEvent;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tm.nmp.account.AC_US_DAO;

@Controller
public class InfoEventController {

	
	@Autowired
	private AC_US_DAO aDAO;
	
	@Autowired
	private InfoEventDAO iDAO;
	
	
	@RequestMapping(value = "/club.event.main.go", method = RequestMethod.GET)
	public String clubEventMainGo(HttpServletRequest req, ClubEventDTO te) {
		aDAO.loginCheck(req);
		iDAO.getClubEventAll(req, 1);
		req.setAttribute("contentPage", "infoEvent/clubEvent/clubEvent.jsp");
		return "index";
	}
	
	
	@RequestMapping(value = "/sports.info.main.go", method = RequestMethod.GET)
	public String sportsInfoMainGo(HttpServletRequest req) {
		aDAO.loginCheck(req);
		req.setAttribute("contentPage", "infoEvent/sportsInfo/sportsInfo.jsp");
		return "index";
	}
	
}
