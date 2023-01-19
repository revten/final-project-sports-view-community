package com.tm.nmp;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tm.nmp.account.AC_US_DAO;
import com.tm.nmp.admin.AnswerDAO;
import com.tm.nmp.community.CM_SC_DAO;
import com.tm.nmp.community.CM_SC_TITLE;
import com.tm.nmp.community.CM_WG_DAO;
import com.tm.nmp.community.CM_WG_TITLE;
import com.tm.nmp.games.GamesAnalyzeDAO;
import com.tm.nmp.games.TotoDAO;
import com.tm.nmp.infoEvent.InfoEventDAO;
import com.tm.nmp.mypage.AskDAO;
import com.tm.nmp.mypage.MyPostDAO;

@Controller
public class HomeController {


	@Autowired
	private AC_US_DAO acDAO;

	@Autowired
	private GamesAnalyzeDAO gaDAO;
	
	@Autowired
	private InfoEventDAO ieDAO;
	
	@Autowired
	private TotoDAO ttDAO;
	
	@Autowired
	private MyPostDAO mpDAO;
	
	@Autowired
	private AskDAO askDAO;

	@Autowired
	private CM_SC_DAO scDAO;
	
	@Autowired
	private AnswerDAO asDAO;

	@Autowired
	private CM_WG_DAO wgDAO;
	
	
	private boolean firstReq;

	public HomeController() {
		firstReq = true;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpServletRequest req) {

		if (firstReq) {
			gaDAO.calcAllPostCount();
			ttDAO.calcAllPostCount();
			ieDAO.calcAllPostCount();
			mpDAO.calcAllPostCount();
			askDAO.calcAllPostCount();
			asDAO.calcAllPostCount();
			scDAO.calcAllPostCount();
			firstReq = false;
		}
		

		acDAO.loginCheck(req);
		req.setAttribute("contentPage", "home.jsp");
		return "index";
	}

	@RequestMapping(value = "/index.go", method = RequestMethod.GET)
	public String indexGo(HttpServletRequest req) {
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
		acDAO.loginCheck(req);
		req.setAttribute("contentPage", "stadium/stadiumMain.jsp");
		return "index";
	}

	@RequestMapping(value = "/news.main.go", method = RequestMethod.GET)
	public String newsMainGo(HttpServletRequest req) {
		acDAO.loginCheck(req);
		req.setAttribute("contentPage", "infoEvent/news/newsMain.jsp");
		req.setAttribute("newsPage", "everyNews.jsp");
		return "index";
	}

	@RequestMapping(value = "/community.main.go", method = RequestMethod.GET)
	public String communityMainGo(HttpServletRequest req, CM_SC_TITLE sc, CM_WG_TITLE wg) {
		acDAO.loginCheck(req);
		scDAO.getSoccerBoard(req, 1);
		wgDAO.showWithGoList(req, wg);
		req.setAttribute("contentPage", "community/communityMain.jsp");
		return "index";
	}

	@RequestMapping(value = "/infoEvent.main.go", method = RequestMethod.GET)
	public String infoEventMainGo(HttpServletRequest req) {
		acDAO.loginCheck(req);
		req.setAttribute("contentPage", "infoEvent/infoEventMain.jsp");
		req.setAttribute("newsPage", "news/everyNews.jsp");
		return "index";
	}

	@RequestMapping(value = "/games.main.go", method = RequestMethod.GET)
	public String gamesMainGo(HttpServletRequest req) {
		acDAO.loginCheck(req);
		req.setAttribute("contentPage", "games/gamesMain.jsp");
		return "index";
	}

	@RequestMapping(value = "/myPage.main.go", method = RequestMethod.GET)
	public String myPageMainGo(HttpServletRequest req) {
		acDAO.loginCheck(req);
		req.setAttribute("contentPage", "myPage/myPageMain.jsp");
		return "index";
	}

	@RequestMapping(value = "/admin.main.go", method = RequestMethod.GET)
	public String adminMainGo(HttpServletRequest req) {
		acDAO.loginCheck(req);
		req.setAttribute("contentPage", "admin/admin.jsp");
		return "index";
	}

}
