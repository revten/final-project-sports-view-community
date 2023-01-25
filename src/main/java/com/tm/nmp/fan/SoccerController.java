package com.tm.nmp.fan;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tm.nmp.TokenMaker;
import com.tm.nmp.account.AC_US_DAO;
import com.tm.nmp.board.BoardDAO;
import com.tm.nmp.board.BoardOption;
import com.tm.nmp.board.BoardSelector;
import com.tm.nmp.board.PostVO;
import com.tm.nmp.board.Reccomand;
import com.tm.nmp.board.ReplyVO;
import com.tm.nmp.point.PlusPointVO;
import com.tm.nmp.point.PointDAO;
import com.tm.nmp.point.PointVO;

@Controller
public class SoccerController {

	@Autowired
	private AC_US_DAO acDAO;

	@Autowired
	private BoardDAO brDAO;
	
	@Autowired
	private PointDAO pDAO;
	
	@RequestMapping(value = "soccer.board.go", method = RequestMethod.GET)
	public String soccerBoardGO(HttpServletRequest req) {
		TokenMaker.make(req);
		acDAO.loginCheck(req);
		brDAO.getAllPost(req, 1, 22);
		
		req.setAttribute("contentPage", "fan/soccer/soccerBoard.jsp");
		return "index";
	}
	
	@RequestMapping(value = "soccer.detail.go", method = RequestMethod.GET)
	public String soccerDetail(HttpServletRequest req, PostVO p) {
		TokenMaker.make(req);
		BoardOption.clearSearch(req);
		acDAO.wathingPage(req);
		acDAO.loginCheck(req);
		brDAO.getPost(req, p);
		req.setAttribute("contentPage", "fan/soccer/soccerDetail.jsp");
		return "index";
	}

	@RequestMapping(value = "soccer.reg.go", method = RequestMethod.GET)
	public String soccerRegGo(HttpServletRequest req, PostVO p) {
		TokenMaker.make(req);
		acDAO.wathingPage(req);
		if (acDAO.loginCheck(req)) {
			req.setAttribute("contentPage", "fan/soccer/soccerReg.jsp");
		} else {
			req.setAttribute("contentPage", "account/loginPage.jsp");
		}
		return "index";
	}

	@RequestMapping(value = "soccer.reg.do", method = RequestMethod.POST)
	public String soccerRegDo(HttpServletRequest req, PostVO p, PointVO pv, PlusPointVO ppv) {
		TokenMaker.make(req);
		acDAO.loginCheck(req);
		int plusPoint = Integer.parseInt(req.getParameter("plusPoint")); // 포인트 추가
		brDAO.regPost(req, p);
		pDAO.calcAddPostAndAddCommentPoint(req, pv, ppv, plusPoint);
		brDAO.getAllPost(req, 1, 22);
		req.setAttribute("contentPage", "fan/soccer/soccerBoard.jsp");
		return "index";
	}

	@RequestMapping(value = "soccer.update.go", method = RequestMethod.GET)
	public String soccerUpdateGo(HttpServletRequest req, PostVO p) {
		TokenMaker.make(req);
		acDAO.wathingPage(req);
		acDAO.loginCheck(req);
		brDAO.getPost(req, p);
		req.setAttribute("contentPage", "fan/soccer/soccerUpdate.jsp");
		return "index";
	}

	@RequestMapping(value = "soccer.update.do", method = RequestMethod.POST)
	public String soccerUpdateDo(HttpServletRequest req, PostVO p) {
		TokenMaker.make(req);
		if (acDAO.loginCheck(req)) {
			brDAO.updatePost(req, p);
		}
		brDAO.getAllPost(req, 1, 22);
		req.setAttribute("contentPage", "fan/soccer/soccerBoard.jsp");
		return "index";
	}

	@RequestMapping(value = "soccer.delete.do", method = RequestMethod.GET)
	public String soccerDeleteDo(HttpServletRequest req, PostVO p) {
		TokenMaker.make(req);
		BoardOption.clearSearch(req);
		if (acDAO.loginCheck(req)) {
			brDAO.deletePost(req, p);
		}
		brDAO.getAllPost(req, 1, 22);
		req.setAttribute("contentPage", "fan/soccer/soccerBoard.jsp");
		return "index";
	}

	@RequestMapping(value = "/soccer.page.change", method = RequestMethod.GET)
	public String soccerPageChange(HttpServletRequest req) {
		TokenMaker.make(req);
		acDAO.wathingPage(req);
		acDAO.loginCheck(req);
		int pg = Integer.parseInt(req.getParameter("pg"));
		brDAO.getAllPost(req, pg, 22);
		req.setAttribute("contentPage", "fan/soccer/soccerBoard.jsp");
		return "index";
	}

	@RequestMapping(value = "/soccer.search.do", method = RequestMethod.GET)
	public String soccerSearchDo(HttpServletRequest req, BoardSelector bSel) {
		acDAO.loginCheck(req);
		brDAO.searchPost(req, bSel);
		brDAO.getAllPost(req, 1, 22);
		req.setAttribute("contentPage", "fan/soccer/soccerBoard.jsp");
		return "index";
	}

	@RequestMapping(value = "soccerReply.reg.do", method = RequestMethod.GET)
	public String soccerReplyRegDo(HttpServletRequest req, ReplyVO rp, PostVO p) {
		TokenMaker.make(req);
		if (acDAO.loginCheck(req)) {
			brDAO.regReply(req, rp);
		}
		brDAO.getPost(req, p);
		req.setAttribute("contentPage", "fan/soccer/soccerDetail.jsp");
		return "index";
	}

	@RequestMapping(value = "soccerReply.delete.do", method = RequestMethod.GET)
	public String soccerReplyDelete(HttpServletRequest req, ReplyVO rp, PostVO p) {
		TokenMaker.make(req);
		if (acDAO.loginCheck(req)) {
			brDAO.deleteReply(req, rp);
		}
		brDAO.getPost(req, p);
		req.setAttribute("contentPage", "fan/soccer/soccerDetail.jsp");
		return "index";
	}

	@RequestMapping(value = "soccerReply.update.do", method = RequestMethod.GET)
	public String soccerReplyUpdate(HttpServletRequest req, ReplyVO rp, PostVO p) {
		TokenMaker.make(req);
		if (acDAO.loginCheck(req)) {
			brDAO.updateReply(req, rp);
		}
		brDAO.getPost(req, p);
		req.setAttribute("contentPage", "fan/soccer/soccerDetail.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/expro/RecUpdate.do", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public @ResponseBody JSONObject RecUpdate(HttpServletRequest req, Reccomand rec) {
		int boardNo = Integer.parseInt(req.getParameter("no"));
		String memberId = req.getParameter("id");
		
		return brDAO.recommand(req, rec, boardNo, memberId);
	}
	
	
	@RequestMapping(value = "/expro/RecCount.do", method = RequestMethod.POST)
	public String RecCount(HttpServletRequest req, ReplyVO rp, PostVO p) {
		
		req.setAttribute("contentPage", "fan/soccer/soccerDetail.jsp");
		return "index";
	}
	
	

}
