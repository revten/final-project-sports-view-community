package com.tm.nmp.mypage;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tm.nmp.account.AC_US_DAO;

@Controller
public class AskC {
	
	@Autowired
	private AC_US_DAO acDAO;
	
	@Autowired
	private AskDAO askDAO;
	
	@RequestMapping(value = "/myPage.ask.detail.go", method = RequestMethod.GET)
	public String myPageServiceGo(HttpServletRequest req, AskDTO ask) {

		acDAO.loginCheck(req);
		
		askDAO.getAsk(req, ask);
		req.setAttribute("contentPage", "myPage/myPageServiceDetail.jsp");
		return "index";
		
	}
	
	@RequestMapping(value = "/ask.update.go", method = RequestMethod.GET)
	public String askUpdateGo(HttpServletRequest req,  AskDTO ask) {
		
		acDAO.loginCheck(req);
		
		askDAO.getAsk(req, ask);
		req.setAttribute("contentPage", "myPage/myPageServiceUpdate.jsp");
		return "index";
	}
	
	@RequestMapping(value = "ask.update.do", method = RequestMethod.GET)
	public String askUpdateDo(HttpServletRequest req, AskDTO ask) {
		
		acDAO.loginCheck(req);
		askDAO.updateAsk(req, ask);
		askDAO.getAsk(req, ask);
		req.setAttribute("contentPage", "myPage/myPageServiceDetail.jsp");
		return "index";
	}

	@RequestMapping(value = "ask.delete.do", method = RequestMethod.GET)
	public String myPostDeleteDo(HttpServletRequest req, AskDTO ask) {
		
		acDAO.loginCheck(req);
		askDAO.deleteAsk(req, ask);
		askDAO.getAskAll(req);
		req.setAttribute("contentPage", "myPage/myPageService.jsp");
		return "index";
	}
	
	
	@RequestMapping(value = "/ask.insert.go", method = RequestMethod.GET)
	public String askInsertGo(HttpServletRequest req) {
		acDAO.loginCheck(req);
		
		req.setAttribute("contentPage", "myPage/myPageServiceReg.jsp");
		return "index";
	}
	
	@RequestMapping(value = "ask.insert.do", method = RequestMethod.POST)
	public String myPostInserteDo(HttpServletRequest req, AskDTO ask) {
		
		acDAO.loginCheck(req);
		askDAO.insertAsk(req, ask);
		askDAO.getAskAll(req);
		req.setAttribute("contentPage", "myPage/myPageService.jsp");
		return "index";
	}
}
