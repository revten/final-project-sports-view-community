package com.tm.nmp.fan;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tm.nmp.TokenMaker;
import com.tm.nmp.account.AccountDAO;
import com.tm.nmp.board.BoardDAO;
import com.tm.nmp.board.BoardSelector;
import com.tm.nmp.board.PostVO;
import com.tm.nmp.board.ReplyVO;
import com.tm.nmp.board.ResultVO;
import com.tm.nmp.clubEvent.ClubEventController;
import com.tm.nmp.point.PlusPointVO;
import com.tm.nmp.point.PointDAO;
import com.tm.nmp.point.PointVO;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping(value = "/fan")
public class FanBoardController {

	@Autowired
	private BoardDAO brDAO;

	@Autowired
	private AccountDAO acDAO;

	@Autowired
	private PointDAO ptDAO;

	@RequestMapping(value = "/board.go", method = RequestMethod.GET)
	public String fanBoardGo(HttpServletRequest req, PostVO p) {
		log.info("fan 메인 진입");
		System.out.println(p.getPost_board());
		acDAO.wathingPage(req);
		acDAO.loginCheck(req);

		brDAO.getAllPost(req, 1, p);
		req.setAttribute("contentPage", "fanBoard/fanBoard.jsp");
		return "index";
	}

// --------------------------------------------------------------------------------------

	// 게시글
	@RequestMapping(value = "/reg.go", method = RequestMethod.GET)
	public String fanRegGo(HttpServletRequest req, PostVO p) {
		acDAO.wathingPage(req);

		if (acDAO.loginCheck(req)) {
			req.setAttribute("contentPage", "fanBoard/fanPostReg.jsp");
			brDAO.viewBoardName(req);
		} else {
			req.setAttribute("contentPage", "account/loginPage.jsp");
		}
		return "index";
	}

	@RequestMapping(value = "/reg.do", method = RequestMethod.POST)
	public String fanRegDo(HttpServletRequest req, PostVO p, PointVO pv, PlusPointVO ppv) {

		if (acDAO.loginCheck(req)) {
			brDAO.regPost(req, p);

			// 포인트 추가
			int plusPoint = Integer.parseInt(req.getParameter("plusPoint"));
			ptDAO.calcAddPostAndAddCommentPoint(req, pv, ppv, plusPoint);

			brDAO.getAllPost(req, 1, p);
			req.setAttribute("contentPage", "fanBoard/fanBoard.jsp");

		} else {
			req.setAttribute("contentPage", "account/loginPage.jsp");
		}
		return "redirect:fan.board.go?post_board=" + p.getPost_board();
	}

	@RequestMapping(value = "/detail.go", method = RequestMethod.GET)
	public String fanDetailGo(HttpServletRequest req, HttpServletResponse res, PostVO p) {
		acDAO.wathingPage(req);

		brDAO.getPost(req, p); // 게시글 넘버로 불러오는 것이라 굳이 게시판 넘버가 필요없다
		brDAO.postCountUpdate(req, res, p);
		req.setAttribute("contentPage", "fanBoard/fanPostDetail.jsp");
		return "index";
	}

	@RequestMapping(value = "/update.go", method = RequestMethod.GET)
	public String fanUpdateGo(HttpServletRequest req, PostVO p) {
		acDAO.wathingPage(req);

		if (acDAO.loginCheck(req)) {
			brDAO.getPost(req, p);
			req.setAttribute("contentPage", "fanBoard/fanPostUpdate.jsp");
		} else {
			req.setAttribute("contentPage", "account/loginPage.jsp");
		}
		return "index";
	}

	@RequestMapping(value = "/update.do", method = RequestMethod.POST)
	public String fanUpdateDo(HttpServletRequest req, PostVO p) {

		if (acDAO.loginCheck(req)) {
			brDAO.updatePost(req, p);
			brDAO.getPost(req, p);
			req.setAttribute("contentPage", "fanBoard/fanPostDetail.jsp");
		} else {
			req.setAttribute("contentPage", "account/loginPage.jsp");
		}
		return "index";
	}

	@RequestMapping(value = "/delete.do", method = RequestMethod.GET)
	public String fanDeleteDo(HttpServletRequest req, PostVO p) {

		if (acDAO.loginCheck(req)) {
			brDAO.deletePost(req, p);

			brDAO.getAllPost(req, 1, p);
			req.setAttribute("contentPage", "fanBoard/fanBoard.jsp");
		} else {
			req.setAttribute("contentPage", "account/loginPage.jsp");
		}
		return "index";
	}

	@RequestMapping(value = "/page.change", method = RequestMethod.GET)
	public String fanPageChange(HttpServletRequest req, PostVO p) {
		acDAO.wathingPage(req);
		acDAO.loginCheck(req);

		int pg = Integer.parseInt(req.getParameter("pg"));
		brDAO.getAllPost(req, pg, p);
		req.setAttribute("contentPage", "fanBoard/fanBoard.jsp");
		return "index";
	}

	@RequestMapping(value = "/search.do", method = RequestMethod.GET)
	public String fanSearchDo(HttpServletRequest req, BoardSelector bSel, PostVO p) {
		acDAO.loginCheck(req);

		brDAO.searchPost(req, bSel);
		brDAO.getAllPost(req, 1, p);
		req.setAttribute("contentPage", "fanBoard/fanBoard.jsp");
		return "index";
	}

// --------------------------------------------------------------------------------------

	// 리플

	@RequestMapping(value = "fanReply.reg.do", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody ResultVO fanReplyRegDo(HttpServletRequest req, ReplyVO rp) {
		TokenMaker.make(req);
		return brDAO.regReply(req, rp);
	}

	@RequestMapping(value = "fanReply.delete.do", method = RequestMethod.GET)
	public @ResponseBody int fanReplyDelete(HttpServletRequest req, ReplyVO rp) {
		return brDAO.deleteReply(req, rp);
	}

	@RequestMapping(value = "fanReply.update.do", method = RequestMethod.GET)
	public @ResponseBody ResultVO fanReplyUpdate(HttpServletRequest req, ReplyVO rp) {
		return brDAO.updateReply(req, rp);
	}

}
