package com.tm.nmp.community;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tm.nmp.account.AccountDAO;

@Controller
public class CommunitySoccerController {

	@Autowired
	private AccountDAO acDAO;
	
	@Autowired
	private CM_SC_DAO scDAO;
	
	@RequestMapping(value = "soccerBoardDetail.go", method = RequestMethod.GET)
	public String withGoListGo(HttpServletRequest req, CM_SC_TITLE sc) {
		acDAO.loginCheck(req);
		scDAO.getSoccerDetail(req,sc);
		req.setAttribute("contentPage", "community/soccer/soccerBoardDetail.jsp");

		return "index";
	}
	@RequestMapping(value = "soccerDelete.do", method = RequestMethod.GET)
	public String soccerDeleteDo(HttpServletRequest req, CM_SC_TITLE sc) {
		acDAO.loginCheck(req);
		scDAO.deleteSoccer(req,sc);
		scDAO.getSoccerBoard(req, sc);
		req.setAttribute("contentPage", "community/soccer/soccerBoard.jsp");
		return "index";
	}
	
	@RequestMapping(value = "soccerUpdate.go", method = RequestMethod.GET)
	public String soccerUpdateGo(HttpServletRequest req, CM_SC_TITLE sc) {
		acDAO.loginCheck(req);
		scDAO.getSoccerDetail(req, sc);
		req.setAttribute("contentPage", "community/soccer/soccerBoardUpdate.jsp");
		return "index";
	}
	@RequestMapping(value = "soccerUpdate.do", method = RequestMethod.GET)
	public String soccerUpdateDo(HttpServletRequest req, CM_SC_TITLE sc) {
		acDAO.loginCheck(req);
		scDAO.updateSoccer(req, sc);
		scDAO.getSoccerBoard(req, sc);
		req.setAttribute("contentPage", "community/soccer/soccerBoard.jsp");
		return "index";
	}
	
	@RequestMapping(value = "soccerInsert.go", method = RequestMethod.GET)
	public String soccerInsertgo(HttpServletRequest req, CM_SC_TITLE sc) {
		acDAO.loginCheck(req);
		req.setAttribute("contentPage", "community/soccer/soccerBoardInsert.jsp");
		return "index";
	}
	
	@RequestMapping(value = "soccerInsert.do", method = RequestMethod.POST)
	public String soccerInsertDo(HttpServletRequest req, CM_SC_TITLE sc) {
		acDAO.loginCheck(req);
		scDAO.insertSoccerBoard(req, sc);
		scDAO.getSoccerBoard(req, sc);
		req.setAttribute("contentPage", "community/soccer/soccerBoard.jsp");
		return "index";
	}
	
	
	
}
