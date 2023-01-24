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
public class VolleyballController {

	@Autowired
	private AC_US_DAO acDAO;

	@Autowired
	private BoardDAO brDAO;

	@RequestMapping(value = "volleyball.board.go", method = RequestMethod.GET)
	public String volleyballBoardGO(HttpServletRequest req) {
		TokenMaker.make(req);
		acDAO.loginCheck(req);
		brDAO.getAllPost(req, 1, 24);

		req.setAttribute("contentPage", "fan/volleyball/volleyballBoard.jsp");
		return "index";
	}

	@RequestMapping(value = "volleyball.detail.go", method = RequestMethod.GET)
	public String volleyballDetail(HttpServletRequest req, PostVO p) {
		TokenMaker.make(req);
		BoardOption.clearSearch(req);
		acDAO.wathingPage(req);
		acDAO.loginCheck(req);
		brDAO.getPost(req, p);
		req.setAttribute("contentPage", "fan/volleyball/volleyballDetail.jsp");
		return "index";
	}

	@RequestMapping(value = "volleyball.reg.go", method = RequestMethod.GET)
	public String volleyballRegGo(HttpServletRequest req, PostVO p) {
		TokenMaker.make(req);
		acDAO.wathingPage(req);
		if (acDAO.loginCheck(req)) {
			req.setAttribute("contentPage", "fan/volleyball/volleyballReg.jsp");
		} else {
			req.setAttribute("contentPage", "account/loginPage.jsp");
		}
		return "index";
	}

	@RequestMapping(value = "volleyball.reg.do", method = RequestMethod.POST)
	public String volleyballRegDo(HttpServletRequest req, PostVO p) {
		TokenMaker.make(req);
		acDAO.loginCheck(req);
		brDAO.regPost(req, p);
		brDAO.getAllPost(req, 1, 24);
		req.setAttribute("contentPage", "fan/volleyball/volleyballBoard.jsp");
		return "index";
	}

	@RequestMapping(value = "volleyball.update.go", method = RequestMethod.GET)
	public String volleyballUpdateGo(HttpServletRequest req, PostVO p) {
		TokenMaker.make(req);
		acDAO.wathingPage(req);
		acDAO.loginCheck(req);
		brDAO.getPost(req, p);
		req.setAttribute("contentPage", "fan/volleyball/volleyballUpdate.jsp");
		return "index";
	}

	@RequestMapping(value = "volleyball.update.do", method = RequestMethod.POST)
	public String volleyballUpdateDo(HttpServletRequest req, PostVO p) {
		TokenMaker.make(req);
		if (acDAO.loginCheck(req)) {
			brDAO.updatePost(req, p);
		}
		brDAO.getAllPost(req, 1, 24);
		req.setAttribute("contentPage", "fan/volleyball/volleyballBoard.jsp");
		return "index";
	}

	@RequestMapping(value = "volleyball.delete.do", method = RequestMethod.GET)
	public String volleyballDeleteDo(HttpServletRequest req, PostVO p) {
		TokenMaker.make(req);
		BoardOption.clearSearch(req);
		if (acDAO.loginCheck(req)) {
			brDAO.deletePost(req, p);
		}
		brDAO.getAllPost(req, 1, 24);
		req.setAttribute("contentPage", "fan/volleyball/volleyballBoard.jsp");
		return "index";
	}

	@RequestMapping(value = "/volleyball.page.change", method = RequestMethod.GET)
	public String volleyballPageChange(HttpServletRequest req) {
		TokenMaker.make(req);
		acDAO.wathingPage(req);
		acDAO.loginCheck(req);
		int pg = Integer.parseInt(req.getParameter("pg"));
		brDAO.getAllPost(req, pg, 24);
		req.setAttribute("contentPage", "fan/volleyball/volleyballBoard.jsp");
		return "index";
	}

	@RequestMapping(value = "/volleyball.search.do", method = RequestMethod.GET)
	public String volleyballSearchDo(HttpServletRequest req, BoardSelector bSel) {
		acDAO.loginCheck(req);
		brDAO.searchPost(req, bSel);
		brDAO.getAllPost(req, 1, 24);
		req.setAttribute("contentPage", "fan/volleyball/volleyballBoard.jsp");
		return "index";
	}

	@RequestMapping(value = "volleyballReply.reg.do", method = RequestMethod.GET)
	public String volleyballReplyRegDo(HttpServletRequest req, ReplyVO rp, PostVO p) {
		TokenMaker.make(req);
		if (acDAO.loginCheck(req)) {
			brDAO.regReply(req, rp);
		}
		brDAO.getPost(req, p);
		req.setAttribute("contentPage", "fan/volleyball/volleyballDetail.jsp");
		return "index";
	}

	@RequestMapping(value = "volleyballReply.delete.do", method = RequestMethod.GET)
	public String volleyballReplyDelete(HttpServletRequest req, ReplyVO rp, PostVO p) {
		TokenMaker.make(req);
		if (acDAO.loginCheck(req)) {
			brDAO.deleteReply(req, rp);
		}
		brDAO.getPost(req, p);
		req.setAttribute("contentPage", "fan/volleyball/volleyballDetail.jsp");
		return "index";
	}

	@RequestMapping(value = "volleyballReply.update.do", method = RequestMethod.GET)
	public String volleyballReplyUpdate(HttpServletRequest req, ReplyVO rp, PostVO p) {
		TokenMaker.make(req);
		if (acDAO.loginCheck(req)) {
			brDAO.updateReply(req, rp);
		}
		brDAO.getPost(req, p);
		req.setAttribute("contentPage", "fan/volleyball/volleyballDetail.jsp");
		return "index";
	}
}
