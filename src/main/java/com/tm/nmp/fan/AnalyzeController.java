package com.tm.nmp.fan;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tm.nmp.TokenMaker;
import com.tm.nmp.account.AC_US_DAO;
import com.tm.nmp.board.BoardDAO;
import com.tm.nmp.board.BoardOption;
import com.tm.nmp.board.BoardSelector;
import com.tm.nmp.board.PostVO;
import com.tm.nmp.board.ReplyVO;

@Controller
public class AnalyzeController {

	@Autowired
	private AC_US_DAO acDAO;

	@Autowired
	private BoardDAO brDAO;
	
	@RequestMapping(value = "analyze.board.go", method = RequestMethod.GET)
	public String analyzeBoardGO(HttpServletRequest req) {
		TokenMaker.make(req);
		acDAO.loginCheck(req);
		brDAO.getAllPost(req, 1, 41);
		
		req.setAttribute("contentPage", "fan/analyze/analyzeBoard.jsp");
		return "index";
	}
	
	@RequestMapping(value = "analyze.detail.go", method = RequestMethod.GET)
	public String analyzeDetail(HttpServletRequest req, PostVO p) {
		TokenMaker.make(req);
		BoardOption.clearSearch(req);
		acDAO.wathingPage(req);
		acDAO.loginCheck(req);
		brDAO.getPost(req, p);
		req.setAttribute("contentPage", "fan/analyze/analyzeDetail.jsp");
		return "index";
	}

	@RequestMapping(value = "analyze.reg.go", method = RequestMethod.GET)
	public String analyzeRegGo(HttpServletRequest req, PostVO p) {
		TokenMaker.make(req);
		acDAO.wathingPage(req);
		if (acDAO.loginCheck(req)) {
			req.setAttribute("contentPage", "fan/analyze/analyzeReg.jsp");
		} else {
			req.setAttribute("contentPage", "account/loginPage.jsp");
		}
		return "index";
	}

	@RequestMapping(value = "analyze.reg.do", method = RequestMethod.POST)
	public String analyzeRegDo(HttpServletRequest req, PostVO p) {
		TokenMaker.make(req);
		acDAO.loginCheck(req);
		brDAO.regPost(req, p);
		brDAO.getAllPost(req, 1, 41);
		req.setAttribute("contentPage", "fan/analyze/analyzeBoard.jsp");
		return "index";
	}

	@RequestMapping(value = "analyze.update.go", method = RequestMethod.GET)
	public String analyzeUpdateGo(HttpServletRequest req, PostVO p) {
		TokenMaker.make(req);
		acDAO.wathingPage(req);
		acDAO.loginCheck(req);
		brDAO.getPost(req, p);
		req.setAttribute("contentPage", "fan/analyze/analyzeUpdate.jsp");
		return "index";
	}

	@RequestMapping(value = "analyze.update.do", method = RequestMethod.POST)
	public String analyzeUpdateDo(HttpServletRequest req, PostVO p) {
		TokenMaker.make(req);
		if (acDAO.loginCheck(req)) {
			brDAO.updatePost(req, p);
		}
		brDAO.getAllPost(req, 1, 41);
		req.setAttribute("contentPage", "fan/analyze/analyzeBoard.jsp");
		return "index";
	}

	@RequestMapping(value = "analyze.delete.do", method = RequestMethod.GET)
	public String analyzeDeleteDo(HttpServletRequest req, PostVO p) {
		TokenMaker.make(req);
		BoardOption.clearSearch(req);
		if (acDAO.loginCheck(req)) {
			brDAO.deletePost(req, p);
		}
		brDAO.getAllPost(req, 1, 41);
		req.setAttribute("contentPage", "fan/analyze/analyzeBoard.jsp");
		return "index";
	}

	@RequestMapping(value = "/analyze.page.change", method = RequestMethod.GET)
	public String analyzePageChange(HttpServletRequest req) {
		TokenMaker.make(req);
		acDAO.wathingPage(req);
		acDAO.loginCheck(req);
		int pg = Integer.parseInt(req.getParameter("pg"));
		brDAO.getAllPost(req, pg, 41);
		req.setAttribute("contentPage", "fan/analyze/analyzeBoard.jsp");
		return "index";
	}

	@RequestMapping(value = "/analyze.search.do", method = RequestMethod.GET)
	public String analyzeSearchDo(HttpServletRequest req, BoardSelector bSel) {
		acDAO.loginCheck(req);
		brDAO.searchPost(req, bSel);
		brDAO.getAllPost(req, 1, 41);
		req.setAttribute("contentPage", "fan/analyze/analyzeBoard.jsp");
		return "index";
	}

	@RequestMapping(value = "analyzeReply.reg.do", method = RequestMethod.GET)
	public String analyzeReplyRegDo(HttpServletRequest req, ReplyVO rp, PostVO p) {
		TokenMaker.make(req);
		if (acDAO.loginCheck(req)) {
			brDAO.regReply(req, rp);
		}
		brDAO.getPost(req, p);
		req.setAttribute("contentPage", "fan/analyze/analyzeDetail.jsp");
		return "index";
	}

	@RequestMapping(value = "analyzeReply.delete.do", method = RequestMethod.GET)
	public String analyzeReplyDelete(HttpServletRequest req, ReplyVO rp, PostVO p) {
		TokenMaker.make(req);
		if (acDAO.loginCheck(req)) {
			brDAO.deleteReply(req, rp);
		}
		brDAO.getPost(req, p);
		req.setAttribute("contentPage", "fan/analyze/analyzeDetail.jsp");
		return "index";
	}

	@RequestMapping(value = "analyzeReply.update.do", method = RequestMethod.GET)
	public String analyzeReplyUpdate(HttpServletRequest req, ReplyVO rp, PostVO p) {
		TokenMaker.make(req);
		if (acDAO.loginCheck(req)) {
			brDAO.updateReply(req, rp);
		}
		brDAO.getPost(req, p);
		req.setAttribute("contentPage", "fan/analyze/analyzeDetail.jsp");
		return "index";
	}

}