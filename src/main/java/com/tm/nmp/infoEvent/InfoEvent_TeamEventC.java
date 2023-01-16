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
	
	@RequestMapping(value = "/teamEvent.update.go", method = RequestMethod.GET)
	public String teamEventUpdateGo(HttpServletRequest req, TeamEventDTO te) {
		aDAO.loginCheck(req);
		iDAO.getteamEvent(req, te);
		
		req.setAttribute("contentPage", "infoEvent/teamEvent/teamEventUpdate.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/teamEvent.update.do", method = RequestMethod.GET)
	public String teamEventUpdateDo(HttpServletRequest req, TeamEventDTO te) {
		aDAO.loginCheck(req);
		iDAO.updateTeamEvent(req,te);
		iDAO.getteamEvent(req, te);
		
		req.setAttribute("contentPage", "infoEvent/teamEvent/teamEventDetail.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/teamEvent.delete.do", method = RequestMethod.GET)
	public String teamEventDeleteDo(HttpServletRequest req, TeamEventDTO te) {
		aDAO.loginCheck(req);
		iDAO.deleteTeamEvent(req, te);
		iDAO.getteamEventAll(req, 1);
		
		req.setAttribute("contentPage", "infoEvent/teamEvent/teamEvent.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/teamEvent.insert.go", method = RequestMethod.GET)
	public String teamEventInsertGo(HttpServletRequest req) {
		aDAO.loginCheck(req);
		
		req.setAttribute("contentPage", "infoEvent/teamEvent/teamEventReg.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/teamEvent.insert.do", method = RequestMethod.POST)
	public String teamEventInsertDo(HttpServletRequest req, TeamEventDTO te) {
		aDAO.loginCheck(req);
		iDAO.insertTeamEvent(req, te);
		iDAO.getteamEventAll(req, 1);
		
		req.setAttribute("contentPage", "infoEvent/teamEvent/teamEvent.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/teamEvent.search.do", method = RequestMethod.GET)
	public String teamEventSearchDo(HttpServletRequest req, TeamEventDTO te) {
		aDAO.loginCheck(req);
		iDAO.getteamEventSearch(req, te);
		
		req.setAttribute("contentPage", "infoEvent/teamEvent/teamEventSearch.jsp");
		return "index";
	}
}
