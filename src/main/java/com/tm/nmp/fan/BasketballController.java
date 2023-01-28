package com.tm.nmp.fan;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tm.nmp.TokenMaker;
import com.tm.nmp.account.AC_US_DAO;
import com.tm.nmp.account.AccountDTO;
import com.tm.nmp.board.BoardDAO;
import com.tm.nmp.board.BoardOption;
import com.tm.nmp.board.BoardSelector;
import com.tm.nmp.board.PostVO;
import com.tm.nmp.board.ReplyVO;

@Controller
public class BasketballController {

	@Autowired
	private AC_US_DAO acDAO;

	@Autowired
	private BoardDAO brDAO;

	@RequestMapping(value = "basketball.board.go", method = RequestMethod.GET)
	public String basketballBoardGO(HttpServletRequest req) {
		TokenMaker.make(req);
		acDAO.loginCheck(req);
		brDAO.getAllPost(req, 1, 23);

		req.setAttribute("contentPage", "fan/basketball/basketballBoard.jsp");
		return "index";
	}

	@RequestMapping(value = "basketball.detail.go", method = RequestMethod.GET)
	public String basketballDetail(HttpServletRequest req, HttpServletResponse res, PostVO p) {
		TokenMaker.make(req);
		BoardOption.clearSearch(req);
		acDAO.wathingPage(req);
		acDAO.loginCheck(req);
		AccountDTO a = (AccountDTO) req.getSession().getAttribute("loginAccount");
		if (!(req.getParameter("post_member").equals(a.getMember_id()))) {
			brDAO.postCountUpdate(req, res, p);
		}
		brDAO.getPost(req, p);
		req.setAttribute("contentPage", "fan/basketball/basketballDetail.jsp");
		return "index";
	}

	@RequestMapping(value = "basketball.reg.go", method = RequestMethod.GET)
	public String basketballRegGo(HttpServletRequest req, PostVO p) {
		TokenMaker.make(req);
		acDAO.wathingPage(req);
		if (acDAO.loginCheck(req)) {
			req.setAttribute("contentPage", "fan/basketball/basketballReg.jsp");
		} else {
			req.setAttribute("contentPage", "account/loginPage.jsp");
		}
		return "index";
	}

	@RequestMapping(value = "basketball.reg.do", method = RequestMethod.POST)
	public String basketballRegDo(HttpServletRequest req, PostVO p) {
		TokenMaker.make(req);
		acDAO.loginCheck(req);
		brDAO.regPost(req, p);
		brDAO.getAllPost(req, 1, 23);
		req.setAttribute("contentPage", "fan/basketball/basketballBoard.jsp");
		return "index";
	}

	@RequestMapping(value = "basketball.update.go", method = RequestMethod.GET)
	public String basketballUpdateGo(HttpServletRequest req, PostVO p) {
		TokenMaker.make(req);
		acDAO.wathingPage(req);
		acDAO.loginCheck(req);
		brDAO.getPost(req, p);
		req.setAttribute("contentPage", "fan/basketball/basketballUpdate.jsp");
		return "index";
	}

	@RequestMapping(value = "basketball.update.do", method = RequestMethod.POST)
	public String basketballUpdateDo(HttpServletRequest req, PostVO p) {
		TokenMaker.make(req);
		if (acDAO.loginCheck(req)) {
			brDAO.updatePost(req, p);
		}
		brDAO.getAllPost(req, 1, 23);
		req.setAttribute("contentPage", "fan/basketball/basketballBoard.jsp");
		return "index";
	}

	@RequestMapping(value = "basketball.delete.do", method = RequestMethod.GET)
	public String basketballDeleteDo(HttpServletRequest req, PostVO p) {
		TokenMaker.make(req);
		BoardOption.clearSearch(req);
		if (acDAO.loginCheck(req)) {
			brDAO.deletePost(req, p);
		}
		brDAO.getAllPost(req, 1, 23);
		req.setAttribute("contentPage", "fan/basketball/basketballBoard.jsp");
		return "index";
	}

	@RequestMapping(value = "/basketball.page.change", method = RequestMethod.GET)
	public String basketballPageChange(HttpServletRequest req) {
		TokenMaker.make(req);
		acDAO.wathingPage(req);
		acDAO.loginCheck(req);
		int pg = Integer.parseInt(req.getParameter("pg"));
		brDAO.getAllPost(req, pg, 23);
		req.setAttribute("contentPage", "fan/basketball/basketballBoard.jsp");
		return "index";
	}

	@RequestMapping(value = "/basketball.search.do", method = RequestMethod.GET)
	public String basketballSearchDo(HttpServletRequest req, BoardSelector bSel) {
		acDAO.loginCheck(req);
		brDAO.searchPost(req, bSel);
		brDAO.getAllPost(req, 1, 23);
		req.setAttribute("contentPage", "fan/basketball/basketballBoard.jsp");
		return "index";
	}

	@RequestMapping(value = "basketballReply.reg.do", method = RequestMethod.GET)
	public String basketballReplyRegDo(HttpServletRequest req, ReplyVO rp, PostVO p) {
		TokenMaker.make(req);
		if (acDAO.loginCheck(req)) {
			brDAO.regReply(req, rp);
		}
		brDAO.getPost(req, p);
		req.setAttribute("contentPage", "fan/basketball/basketballDetail.jsp");
		return "index";
	}

	@RequestMapping(value = "basketballReply.delete.do", method = RequestMethod.GET)
	public String basketballReplyDelete(HttpServletRequest req, ReplyVO rp, PostVO p) {
		TokenMaker.make(req);
		if (acDAO.loginCheck(req)) {
			brDAO.deleteReply(req, rp);
		}
		brDAO.getPost(req, p);
		req.setAttribute("contentPage", "fan/basketball/basketballDetail.jsp");
		return "index";
	}

	@RequestMapping(value = "basketballReply.update.do", method = RequestMethod.GET)
	public String basketballReplyUpdate(HttpServletRequest req, ReplyVO rp, PostVO p) {
		TokenMaker.make(req);
		if (acDAO.loginCheck(req)) {
			brDAO.updateReply(req, rp);
		}
		brDAO.getPost(req, p);
		req.setAttribute("contentPage", "fan/basketball/basketballDetail.jsp");
		return "index";
	}

}
