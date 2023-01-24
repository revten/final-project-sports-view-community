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
			brDAO.calcAllPostCount(11); // 직관함께 게시판 withGo
			brDAO.calcAllPostCount(12);	// 직관후기 게시판 review
			brDAO.calcAllPostCount(21); // 야구 게시판 baseball
			brDAO.calcAllPostCount(22);	// 축구 게시판 soccer
			brDAO.calcAllPostCount(23); // 농구 게시판 basketball
			brDAO.calcAllPostCount(24); // 배구 게시판 volleyball
			brDAO.calcAllPostCount(31); // 구단이벤트 게시판 clubEvent
			brDAO.calcAllPostCount(41); // 분석 게시판 analyze
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

	@RequestMapping(value = "/stadium.main.go", method = RequestMethod.GET)
	public String stadiumMainGo(HttpServletRequest req) {
		acDAO.wathingPage(req);
		acDAO.loginCheck(req);
		req.setAttribute("contentPage", "stadium/stadiumMain.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/watch.main.go", method = RequestMethod.GET)
	public String watchMainGo(HttpServletRequest req) {
		acDAO.wathingPage(req);
		acDAO.loginCheck(req);
		/*
		 * scDAO.getSoccerBoard(req, 1); wgDAO.showWithGoList(req, wg);
		 */
		req.setAttribute("contentPage", "watch/watchMain.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/fan.main.go", method = RequestMethod.GET)
	public String fanMainGo(HttpServletRequest req) {
		acDAO.wathingPage(req);
		acDAO.loginCheck(req);

		req.setAttribute("contentPage", "fan/fanMain.jsp");
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
