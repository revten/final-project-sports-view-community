package com.tm.nmp.games;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tm.nmp.TokenMaker;
import com.tm.nmp.account.AC_US_DAO;

@Controller
public class GamesController {

	@Autowired
	private AC_US_DAO acDAO;
	
	@Autowired
	private TotoDAO ttDAO;

	@Autowired
	private GamesAnalyzeDAO gaDAO;

	@RequestMapping(value = "/games.analyzeBoard.go", method = RequestMethod.GET)
	public String gamesAnalystBoard(HttpServletRequest req) {
		TokenMaker.make(req);
		SiteOption.clearSearch(req);
		acDAO.loginCheck(req);
		gaDAO.getAllPost(req, 1);
		req.setAttribute("contentPage", "games/analyzeBoard/analyzeBoard.jsp");
		return "index";
	}

	@RequestMapping(value = "/games.page.change", method = RequestMethod.GET)
	public String gamesPageChange(HttpServletRequest req) {
		TokenMaker.make(req);
		int p = Integer.parseInt(req.getParameter("p"));
		gaDAO.getAllPost(req, p);
		acDAO.loginCheck(req);
		req.setAttribute("contentPage", "games/analyzeBoard/analyzeBoard.jsp");
		return "index";
	}

	@RequestMapping(value = "/games.analyzeBoard.getDetail", method = RequestMethod.GET)
	public String gamesAnalystBoardGetDetail(HttpServletRequest req, GamesAnalyzeBoard gp) {
		TokenMaker.make(req);
		acDAO.loginCheck(req);
		gaDAO.getPost(req, gp);
		req.setAttribute("contentPage", "games/analyzeBoard/analyzeBoardDetail.jsp");
		return "index";
	}

	@RequestMapping(value = "/games.analyzeBoard.write", method = RequestMethod.POST)
	public String gamesAnalystBoardWrite(HttpServletRequest req, GamesAnalyzeBoard gp) {
		TokenMaker.make(req);
		// 글등록하는 순간 parameter token = 328
		if (acDAO.loginCheck(req)) {
			gaDAO.writePost(req, gp);
		}

		req.setAttribute("contentPage", "games/analyzeBoard/analyzeBoard.jsp");
		return "index";
	}

	@RequestMapping(value = "/games.analyzeBoard.delete", method = RequestMethod.GET)
	public String gamesAnalystBoardDelete(HttpServletRequest req, GamesAnalyzeBoard gp) {
		TokenMaker.make(req);
		SiteOption.clearSearch(req);
		if (acDAO.loginCheck(req)) {
			gaDAO.deletePost(req, gp);
		}

		req.setAttribute("contentPage", "games/analyzeBoard/analyzeBoard.jsp");
		return "index";
	}

	@RequestMapping(value = "/games.analyzeBoard.update", method = RequestMethod.POST)
	public String gamesAnalystBoardUpdate(HttpServletRequest req, GamesAnalyzeBoard gp) {
		TokenMaker.make(req);
		int p = Integer.parseInt(req.getParameter("p"));
		if (acDAO.loginCheck(req)) {
			gaDAO.deletePost(req, gp);
		}
		gaDAO.getAllPost(req, p);
		req.setAttribute("contentPage", "games/analyzeBoard/analyzeBoard.jsp");
		return "index";
	}

	@RequestMapping(value = "/games.analyzeBoard.search", method = RequestMethod.GET)
	public String gamesAnalyzeBoardSearch(HttpServletRequest req, GamesSelector gSel) {
		TokenMaker.make(req);
//		int p = Integer.parseInt(req.getParameter("p"));
		acDAO.loginCheck(req);
		gaDAO.searchPost(req, gSel);
		gaDAO.getAllPost(req, 1);
		req.setAttribute("contentPage", "games/analyzeBoard/analyzeBoard.jsp");
		return "index";
	}

	@RequestMapping(value = "/games.totoBoard.go", method = RequestMethod.GET)
	public String gamesTotoBoardGo(HttpServletRequest req) {
		SiteOption.clearSearch(req);
		acDAO.loginCheck(req);
		ttDAO.getTotoAll(req, 1);
		req.setAttribute("contentPage", "games/totoBoard.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/toto.page.change", method = RequestMethod.GET)
	public String totoPageChange(HttpServletRequest req) {
		TokenMaker.make(req);
		int p = Integer.parseInt(req.getParameter("p"));
		ttDAO.getTotoAll(req, p);
		acDAO.loginCheck(req);
		req.setAttribute("contentPage", "games/totoBoard.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/games.toto.search", method = RequestMethod.GET)
	public String gamesTotoSearch(HttpServletRequest req, TotoSelector ttSel) {
		acDAO.loginCheck(req);
		ttDAO.searchToto(req, ttSel);
		ttDAO.getTotoAll(req, 1);
		req.setAttribute("contentPage", "games/totoBoard.jsp");
		return "index";
	}
	
	
}
