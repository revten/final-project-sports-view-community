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
public class FreeVolleyballController {
	
	@Autowired
	private AC_US_DAO acDAO;
		
	@Autowired
	private FreeDAO frDAO;
	
	@RequestMapping(value = "volleyball.detail.go", method = RequestMethod.GET)
	public String volleyballDetail(HttpServletRequest req, PostVO p) {
		BoardOption.clearSearch(req);
		acDAO.loginCheck(req);
		frDAO.getPost(req, p);

		req.setAttribute("contentPage", "community/volleyball/volleyballDetail.jsp");
		return "index";
	}
	
	@RequestMapping(value = "volleyball.reg.go", method = RequestMethod.GET)
	public String volleyballRegGo(HttpServletRequest req, PostVO p) {
		acDAO.loginCheck(req);
		req.setAttribute("contentPage", "community/volleyball/volleyballReg.jsp");
		return "index";
	}

	@RequestMapping(value = "volleyball.reg.do", method = RequestMethod.POST)
	public String volleyballRegDo(HttpServletRequest req, PostVO p) {
		acDAO.loginCheck(req);
		frDAO.regPost(req, p);
		frDAO.getAllPost(req, 1, 24);
		req.setAttribute("contentPage", "community/volleyball/volleyballBoard.jsp");
		return "index";
	}

	@RequestMapping(value = "volleyball.update.go", method = RequestMethod.GET)
	public String volleyballUpdateGo(HttpServletRequest req, PostVO p) {
		acDAO.loginCheck(req);
		frDAO.getPost(req, p);

		req.setAttribute("contentPage", "community/volleyball/volleyballUpdate.jsp");
		return "index";
	}

	@RequestMapping(value = "volleyball.update.do", method = RequestMethod.POST)
	public String volleyballUpdateDo(HttpServletRequest req, PostVO p) {
		if (acDAO.loginCheck(req)) {
			frDAO.updatePost(req, p);
		}
		frDAO.getAllPost(req, 1, 24);

		req.setAttribute("contentPage", "community/volleyball/volleyballBoard.jsp");
		return "index";
	}
	
	@RequestMapping(value = "volleyball.delete.do", method = RequestMethod.GET)
	public String volleyballDeleteDo(HttpServletRequest req, PostVO p) {
		BoardOption.clearSearch(req);
		if (acDAO.loginCheck(req)) {
			frDAO.deletePost(req, p);
		}
		frDAO.getAllPost(req, 1, 24);

		req.setAttribute("contentPage", "community/volleyball/volleyballBoard.jsp");
		return "index";
	}

	@RequestMapping(value = "/volleyball.page.change", method = RequestMethod.GET)
	public String volleyballPageChange(HttpServletRequest req) {
		TokenMaker.make(req);
		int pg = Integer.parseInt(req.getParameter("pg"));
		frDAO.getAllPost(req, pg, 24);
		acDAO.loginCheck(req);

		req.setAttribute("contentPage", "community/volleyball/volleyballBoard.jsp");
		return "index";
	}

	@RequestMapping(value = "/volleyball.search.do", method = RequestMethod.GET)
	public String volleyballSearchDo(HttpServletRequest req, BoardSelector bSel) {
		acDAO.loginCheck(req);
		frDAO.searchPost(req, bSel);
		frDAO.getAllPost(req, 1, 24);

		req.setAttribute("contentPage", "community/volleyball/volleyballBoard.jsp");
		return "index";
	}
	
	@RequestMapping(value = "volleyballReply.reg.do", method = RequestMethod.GET)
	public String volleyballReplyRegDo(HttpServletRequest req, ReplyVO rp, PostVO p) {
		if (acDAO.loginCheck(req)) {
			frDAO.regReply(req, rp);
		}
		frDAO.getPost(req, p);
		req.setAttribute("contentPage", "community/volleyball/volleyballDeatail.jsp");
		return "index";
	}
	
	@RequestMapping(value = "volleyballReply.dalete.do", method = RequestMethod.GET)
	public String volleyballReplyDelete(HttpServletRequest req, ReplyVO rp, PostVO p) {
		if (acDAO.loginCheck(req)) {
			frDAO.deleteReply(req, rp);
		}
		frDAO.getPost(req, p);
		req.setAttribute("contentPage", "community/volleyball/volleyballDeatail.jsp");
		return "index";
	}
	
	@RequestMapping(value = "volleyballReply.update.do", method = RequestMethod.GET)
	public String volleyballReplyUpdate(HttpServletRequest req, ReplyVO rp, PostVO p) {
		if (acDAO.loginCheck(req)) {
			frDAO.updateReply(req, rp);
		}
		frDAO.getPost(req, p);
		req.setAttribute("contentPage", "community/volleyball/volleyballDeatail.jsp");
		return "index";
	}

}
