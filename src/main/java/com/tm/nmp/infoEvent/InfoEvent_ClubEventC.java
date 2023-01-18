package com.tm.nmp.infoEvent;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tm.nmp.account.AccountDAO;

@Controller
public class InfoEvent_ClubEventC {

	@Autowired
	private AccountDAO aDAO;
	
	@Autowired
	private InfoEventDAO iDAO;
	
	@RequestMapping(value = "/club.event.detail.go", method = RequestMethod.GET)
	public String clubEventDetailGo(HttpServletRequest req, ClubEventDTO te) {
		aDAO.loginCheck(req);
		iDAO.getClubEvent(req, te);
		
		req.setAttribute("contentPage", "infoEvent/clubEvent/clubEventDetail.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/clubEvent.update.go", method = RequestMethod.GET)
	public String clubEventUpdateGo(HttpServletRequest req, ClubEventDTO te) {
		aDAO.loginCheck(req);
		iDAO.getClubEvent(req, te);
		
		req.setAttribute("contentPage", "infoEvent/clubEvent/clubEventUpdate.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/clubEvent.update.do", method = RequestMethod.GET)
	public String clubEventUpdateDo(HttpServletRequest req, ClubEventDTO te) {
		aDAO.loginCheck(req);
		iDAO.updateClubEvent(req,te);
		iDAO.getClubEvent(req, te);
		
		req.setAttribute("contentPage", "infoEvent/clubEvent/clubEventDetail.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/clubEvent.delete.do", method = RequestMethod.GET)
	public String clubEventDeleteDo(HttpServletRequest req, ClubEventDTO te) {
		aDAO.loginCheck(req);
		iDAO.deleteClubEvent(req, te);
		iDAO.getClubEventAll(req, 1);
		
		req.setAttribute("contentPage", "infoEvent/clubEvent/clubEvent.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/clubEvent.insert.go", method = RequestMethod.GET)
	public String clubEventInsertGo(HttpServletRequest req) {
		aDAO.loginCheck(req);
		
		req.setAttribute("contentPage", "infoEvent/clubEvent/clubEventReg.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/clubEvent.insert.do", method = RequestMethod.POST)
	public String clubEventInsertDo(HttpServletRequest req, ClubEventDTO te) {
		aDAO.loginCheck(req);
		iDAO.insertClubEvent(req, te);
		iDAO.getClubEventAll(req, 1);
		
		req.setAttribute("contentPage", "infoEvent/clubEvent/clubEvent.jsp");
		return "index";
	}
	
}
