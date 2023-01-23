package com.tm.nmp.community;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tm.nmp.TokenMaker;
import com.tm.nmp.account.AC_US_DAO;
import com.tm.nmp.board.BoardOption;
import com.tm.nmp.board.BoardSelector;
import com.tm.nmp.board.FreeDAO;
import com.tm.nmp.board.PostVO;
import com.tm.nmp.board.ReplyVO;

@Controller
public class FreeBasketballController {

	@Autowired
	private AC_US_DAO acDAO;

	@Autowired
	private FreeDAO frDAO;

	@RequestMapping(value = "basketball.detail.go", method = RequestMethod.GET)
	public String basketballDetail(HttpServletRequest req, PostVO p) {
		BoardOption.clearSearch(req);
		acDAO.loginCheck(req);
		frDAO.getPost(req, p);

		req.setAttribute("contentPage", "community/basketball/basketballDetail.jsp");
		return "index";
	}

	@RequestMapping(value = "basketball.reg.go", method = RequestMethod.GET)
	public String basketballRegGo(HttpServletRequest req, PostVO p) {
		acDAO.loginCheck(req);
		req.setAttribute("contentPage", "community/basketball/basketballReg.jsp");
		return "index";
	}

	@RequestMapping(value = "basketball.reg.do", method = RequestMethod.POST)
	public String basketballRegDo(HttpServletRequest req, PostVO p) {
		acDAO.loginCheck(req);
		frDAO.regPost(req, p);

		frDAO.getAllPost(req, 1, 23);

		req.setAttribute("contentPage", "community/basketball/basketballBoard.jsp");
		return "index";
	}

	@RequestMapping(value = "basketball.update.go", method = RequestMethod.GET)
	public String basketballUpdateGo(HttpServletRequest req, PostVO p) {
		acDAO.loginCheck(req);
		frDAO.getPost(req, p);

		req.setAttribute("contentPage", "community/basketball/basketballUpdate.jsp");
		return "index";
	}

	@RequestMapping(value = "basketball.update.do", method = RequestMethod.POST)
	public String basketballUpdateDo(HttpServletRequest req, PostVO p) {
		if (acDAO.loginCheck(req)) {
			frDAO.updatePost(req, p);
		}
		frDAO.getAllPost(req, 1, 23);

		req.setAttribute("contentPage", "community/basketball/basketballBoard.jsp");
		return "index";
	}

	@RequestMapping(value = "basketball.delete.do", method = RequestMethod.GET)
	public String basketballDeleteDo(HttpServletRequest req, PostVO p) {
		BoardOption.clearSearch(req);
		if (acDAO.loginCheck(req)) {
			frDAO.deletePost(req, p);
		}
		frDAO.getAllPost(req, 1, 23);

		req.setAttribute("contentPage", "community/basketball/basketballBoard.jsp");
		return "index";
	}

	@RequestMapping(value = "/basketball.page.change", method = RequestMethod.GET)
	public String basketballPageChange(HttpServletRequest req) {
		TokenMaker.make(req);
		int pg = Integer.parseInt(req.getParameter("pg"));
		frDAO.getAllPost(req, pg, 23);
		acDAO.loginCheck(req);

		req.setAttribute("contentPage", "community/basketball/basketballBoard.jsp");
		return "index";
	}

	@RequestMapping(value = "/basketball.search.do", method = RequestMethod.GET)
	public String basketballSearchDo(HttpServletRequest req, BoardSelector bSel) {
		acDAO.loginCheck(req);
		frDAO.searchPost(req, bSel);
		frDAO.getAllPost(req, 1, 23);

		req.setAttribute("contentPage", "community/basketball/basketballBoard.jsp");
		return "index";
	}

	@RequestMapping(value = "basketballReply.reg.do", method = RequestMethod.GET)
	public String basketballReplyRegDo(HttpServletRequest req, ReplyVO rp, PostVO p) {
		if (acDAO.loginCheck(req)) {
			frDAO.regReply(req, rp);
		}
		frDAO.getPost(req, p);
		req.setAttribute("contentPage", "community/basketball/basketballDeatail.jsp");
		return "index";
	}

	@RequestMapping(value = "basketballReply.dalete.do", method = RequestMethod.GET)
	public String basketballReplyDelete(HttpServletRequest req, ReplyVO rp, PostVO p) {
		if (acDAO.loginCheck(req)) {
			frDAO.deleteReply(req, rp);
		}
		frDAO.getPost(req, p);
		req.setAttribute("contentPage", "community/basketball/basketballDeatail.jsp");
		return "index";
	}

	@RequestMapping(value = "basketballReply.update.do", method = RequestMethod.GET)
	public String basketballReplyUpdate(HttpServletRequest req, ReplyVO rp, PostVO p) {
		if (acDAO.loginCheck(req)) {
			frDAO.updateReply(req, rp);
		}
		frDAO.getPost(req, p);
		req.setAttribute("contentPage", "community/basketball/basketballDeatail.jsp");
		return "index";
	}

}
