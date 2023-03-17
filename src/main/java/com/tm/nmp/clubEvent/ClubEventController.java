package com.tm.nmp.clubEvent;

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
public class ClubEventController {
	@Autowired
	private AC_US_DAO acDAO;

	@Autowired
	private BoardDAO brDAO;

	@RequestMapping(value = "clubEvent.board.go", method = RequestMethod.GET)
	public String clubEventBoardGO(HttpServletRequest req, PostVO p) {
		acDAO.loginCheck(req);
		brDAO.getAllPost(req, 1, p);

		req.setAttribute("contentPage", "clubEvent/clubEventBoard.jsp");
		return "index";
	}

	@RequestMapping(value = "clubEvent.detail.go", method = RequestMethod.GET)
	public String clubEventDetail(HttpServletRequest req, PostVO p) {
		BoardOption.clearSearch(req);
		acDAO.wathingPage(req);
		acDAO.loginCheck(req);
		brDAO.getPost(req, p);
		req.setAttribute("contentPage", "clubEvent/clubEventDetail.jsp");
		return "index";
	}

	@RequestMapping(value = "clubEvent.reg.go", method = RequestMethod.GET)
	public String clubEventRegGo(HttpServletRequest req, PostVO p) {
		acDAO.wathingPage(req);
		if (acDAO.loginCheck(req)) {
			req.setAttribute("contentPage", "clubEvent/clubEventReg.jsp");
		} else {
			req.setAttribute("contentPage", "account/loginPage.jsp");
		}
		return "index";
	}

	@RequestMapping(value = "clubEvent.reg.do", method = RequestMethod.POST)
	public String clubEventRegDo(HttpServletRequest req, PostVO p) {

		acDAO.loginCheck(req);
		brDAO.regPost(req, p);
		brDAO.getAllPost(req, 1, p);
		req.setAttribute("contentPage", "clubEvent/clubEventBoard.jsp");
		return "index";
	}

	@RequestMapping(value = "clubEvent.update.go", method = RequestMethod.GET)
	public String clubEventUpdateGo(HttpServletRequest req, PostVO p) {
		acDAO.wathingPage(req);
		acDAO.loginCheck(req);
		brDAO.getPost(req, p);
		req.setAttribute("contentPage", "clubEvent/clubEventUpdate.jsp");
		return "index";
	}

	@RequestMapping(value = "clubEvent.update.do", method = RequestMethod.POST)
	public String clubEventUpdateDo(HttpServletRequest req, PostVO p) {
		TokenMaker.make(req);
		if (acDAO.loginCheck(req)) {
			brDAO.updatePost(req, p);
		}
		brDAO.getAllPost(req, 1, p);
		req.setAttribute("contentPage", "clubEvent/clubEventBoard.jsp");
		return "index";
	}

	@RequestMapping(value = "clubEvent.delete.do", method = RequestMethod.GET)
	public String clubEventDeleteDo(HttpServletRequest req, PostVO p) {
		BoardOption.clearSearch(req);
		if (acDAO.loginCheck(req)) {
			brDAO.deletePost(req, p);
		}
		brDAO.getAllPost(req, 1, p);
		req.setAttribute("contentPage", "clubEvent/clubEventBoard.jsp");
		return "index";
	}

	@RequestMapping(value = "/clubEvent.page.change", method = RequestMethod.GET)
	public String clubEventPageChange(HttpServletRequest req, PostVO p) {
		acDAO.wathingPage(req);
		acDAO.loginCheck(req);
		int pg = Integer.parseInt(req.getParameter("pg"));
		brDAO.getAllPost(req, pg, p);
		req.setAttribute("contentPage", "clubEvent/clubEventBoard.jsp");
		return "index";
	}

	@RequestMapping(value = "/clubEvent.search.do", method = RequestMethod.GET)
	public String clubEventSearchDo(HttpServletRequest req, BoardSelector bSel, PostVO p) {
		acDAO.loginCheck(req);
		brDAO.searchPost(req, bSel);
		brDAO.getAllPost(req, 1, p);
		req.setAttribute("contentPage", "clubEvent/clubEventBoard.jsp");
		return "index";
	}

	@RequestMapping(value = "clubEventReply.reg.do", method = RequestMethod.GET)
	public String clubEventReplyRegDo(HttpServletRequest req, ReplyVO rp, PostVO p) {
		TokenMaker.make(req);
		if (acDAO.loginCheck(req)) {
			brDAO.regReply(req, rp);
		}
		brDAO.getPost(req, p);
		req.setAttribute("contentPage", "clubEvent/clubEventDetail.jsp");
		return "index";
	}

	@RequestMapping(value = "clubEventReply.delete.do", method = RequestMethod.GET)
	public String clubEventReplyDelete(HttpServletRequest req, ReplyVO rp, PostVO p) {
		TokenMaker.make(req);
		if (acDAO.loginCheck(req)) {
			brDAO.deleteReply(req, rp);
		}
		brDAO.getPost(req, p);
		req.setAttribute("contentPage", "clubEvent/clubEventDetail.jsp");
		return "index";
	}

	@RequestMapping(value = "clubEventReply.update.do", method = RequestMethod.GET)
	public String clubEventReplyUpdate(HttpServletRequest req, ReplyVO rp, PostVO p) {
		TokenMaker.make(req);
		if (acDAO.loginCheck(req)) {
			brDAO.updateReply(req, rp);
		}
		brDAO.getPost(req, p);
		req.setAttribute("contentPage", "clubEvent/clubEventDetail.jsp");
		return "index";
	}
}
