package com.tm.nmp;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tm.nmp.account.AC_US_DAO;
import com.tm.nmp.board.BoardDAO;

@Controller
public class HomeController {

	@Autowired
	private AC_US_DAO acDAO;

	@Autowired
	private BoardDAO brDAO;

	private boolean firstReq;

	public HomeController() {
		firstReq = true;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpServletRequest req) {

		if (firstReq) {
			brDAO.calcAllPostCount();
			firstReq = false;
		}

		acDAO.wathingPage(req);
		acDAO.loginCheck(req);
		req.setAttribute("contentPage", "home.jsp");
		return "index";
	}

	@RequestMapping(value = "/index.go", method = RequestMethod.GET)
	public String indexGo(HttpServletRequest req) {
		acDAO.wathingPage(req);
		return home(req);
	}

	@RequestMapping(value = "/account.login.go", method = RequestMethod.GET)
	public String accountLoginGo(HttpServletRequest req) {
		acDAO.loginCheck(req);
		req.setAttribute("contentPage", "account/loginPage.jsp");
		return "index";
	}

	@RequestMapping(value = "/newsEvent.main.go", method = RequestMethod.GET)
	public String newsEventMainGo(HttpServletRequest req) {
		acDAO.wathingPage(req);
		acDAO.loginCheck(req);
		req.setAttribute("contentPage", "newsEvent/newsEventMain.jsp");
		req.setAttribute("newsPage", "everyNews.jsp");
		return "index";
	}

	@RequestMapping(value = "/myPage.main.go", method = RequestMethod.GET)
	public String myPageMainGo(HttpServletRequest req) {
		acDAO.wathingPage(req);
		acDAO.loginCheck(req);
		req.setAttribute("contentPage", "myPage/myPageMain.jsp");
		return "index";
	}
}
