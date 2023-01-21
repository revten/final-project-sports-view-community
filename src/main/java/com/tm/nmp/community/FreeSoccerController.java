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
public class FreeSoccerController {

	@Autowired
	private AC_US_DAO acDAO;
		
	@Autowired
	private FreeDAO frDAO;
	
	@RequestMapping(value = "soccer.detail.go", method = RequestMethod.GET)
	public String soccerDetail(HttpServletRequest req, PostVO p) {
		BoardOption.clearSearch(req);
		acDAO.loginCheck(req);
		frDAO.getPost(req, p);

		req.setAttribute("contentPage", "community/soccer/soccerDetail.jsp");
		return "index";
	}
	
	@RequestMapping(value = "soccer.reg.go", method = RequestMethod.GET)
	public String soccerRegGo(HttpServletRequest req, PostVO p) {
		acDAO.loginCheck(req);
		req.setAttribute("contentPage", "community/soccer/soccerReg.jsp");
		return "index";
	}

	@RequestMapping(value = "soccer.reg.do", method = RequestMethod.POST)
	public String soccerRegDo(HttpServletRequest req, PostVO p) {
		acDAO.loginCheck(req);
		frDAO.regPost(req, p);
		
		frDAO.getAllPost(req, 1, 22);

		req.setAttribute("contentPage", "community/soccer/soccerBoard.jsp");
		return "index";
	}

	@RequestMapping(value = "soccer.update.go", method = RequestMethod.GET)
	public String soccerUpdateGo(HttpServletRequest req, PostVO p) {
		acDAO.loginCheck(req);
		frDAO.getPost(req, p);

		req.setAttribute("contentPage", "community/soccer/soccerUpdate.jsp");
		return "index";
	}

	@RequestMapping(value = "soccer.update.do", method = RequestMethod.POST)
	public String soccerUpdateDo(HttpServletRequest req, PostVO p) {
		if (acDAO.loginCheck(req)) {
			frDAO.updatePost(req, p);
		}
		frDAO.getAllPost(req, 1, 22);

		req.setAttribute("contentPage", "community/soccer/soccerBoard.jsp");
		return "index";
	}
	
	@RequestMapping(value = "soccer.delete.do", method = RequestMethod.GET)
	public String soccerDeleteDo(HttpServletRequest req, PostVO p) {
		BoardOption.clearSearch(req);
		if (acDAO.loginCheck(req)) {
			frDAO.deletePost(req, p);
		}
		frDAO.getAllPost(req, 1, 22);

		req.setAttribute("contentPage", "community/soccer/soccerBoard.jsp");
		return "index";
	}

	@RequestMapping(value = "/soccer.page.change", method = RequestMethod.GET)
	public String soccerPageChange(HttpServletRequest req) {
		TokenMaker.make(req);
		int pg = Integer.parseInt(req.getParameter("pg"));
		frDAO.getAllPost(req, pg, 22);
		acDAO.loginCheck(req);

		req.setAttribute("contentPage", "community/soccer/soccerBoard.jsp");
		return "index";
	}

	@RequestMapping(value = "/soccer.search.do", method = RequestMethod.GET)
	public String soccerSearchDo(HttpServletRequest req, BoardSelector bSel) {
		acDAO.loginCheck(req);
		frDAO.searchPost(req, bSel);
		frDAO.getAllPost(req, 1, 22);

		req.setAttribute("contentPage", "community/soccer/soccerBoard.jsp");
		return "index";
	}
	
	@RequestMapping(value = "soccerReply.reg.do", method = RequestMethod.GET)
	public String soccerReplyRegDo(HttpServletRequest req, ReplyVO rp, PostVO p) {
		if (acDAO.loginCheck(req)) {
			frDAO.regReply(req, rp);
		}
		frDAO.getPost(req, p);
		req.setAttribute("contentPage", "community/soccer/soccerDeatail.jsp");
		return "index";
	}
	
	@RequestMapping(value = "soccerReply.dalete.do", method = RequestMethod.GET)
	public String soccerReplyDelete(HttpServletRequest req, ReplyVO rp, PostVO p) {
		if (acDAO.loginCheck(req)) {
			frDAO.deleteReply(req, rp);
		}
		frDAO.getPost(req, p);
		req.setAttribute("contentPage", "community/soccer/soccerDeatail.jsp");
		return "index";
	}
	
	@RequestMapping(value = "soccerReply.update.do", method = RequestMethod.GET)
	public String soccerReplyUpdate(HttpServletRequest req, ReplyVO rp, PostVO p) {
		if (acDAO.loginCheck(req)) {
			frDAO.updateReply(req, rp);
		}
		frDAO.getPost(req, p);
		req.setAttribute("contentPage", "community/soccer/soccerDeatail.jsp");
		return "index";
	}
	

}
