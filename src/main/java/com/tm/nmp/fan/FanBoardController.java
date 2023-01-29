package com.tm.nmp.fan;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tm.nmp.TokenMaker;
import com.tm.nmp.account.AC_US_DAO;
import com.tm.nmp.board.BoardDAO;
import com.tm.nmp.board.BoardOption;
import com.tm.nmp.board.BoardSelector;
import com.tm.nmp.board.LikeVO;
import com.tm.nmp.board.PostVO;
import com.tm.nmp.board.ReplyVO;
import com.tm.nmp.board.ResultVO;
import com.tm.nmp.point.PlusPointVO;
import com.tm.nmp.point.PointDAO;
import com.tm.nmp.point.PointVO;

@Controller
public class FanBoardController {

	@Autowired
	private BoardDAO brDAO;

	@Autowired
	private AC_US_DAO acDAO;

	@Autowired
	private PointDAO ptDAO;

	@RequestMapping(value = "fan.main.go", method = RequestMethod.GET)
	public String fanMainGo(HttpServletRequest req, PostVO p) {
		acDAO.wathingPage(req);
		acDAO.loginCheck(req);
		req.setAttribute("contentPage", "fan/fanBoard.jsp");
		return "index";
	}

	@RequestMapping(value = "fan.board.go", method = RequestMethod.GET)
	public String fanBoardGo(HttpServletRequest req, PostVO p) {
		TokenMaker.make(req);
		acDAO.wathingPage(req);
		acDAO.loginCheck(req);
		// 홈에서 더 팬을 눌렀을때 우선 야구 게시판이 뜨게 설정해둠
		BoardOption.clearSearch(req);
		int post_board = Integer.parseInt(req.getParameter("post_board"));
		brDAO.getAllPost(req, 1, post_board, p); // 1은 첫페이지를 보여달라
		req.setAttribute("contentPage", "fan/fanBoard.jsp");
		return "index";
	}

// --------------------------------------------------------------------------------------

	// 게시글
	@RequestMapping(value = "fan.reg.go", method = RequestMethod.GET)
	public String fanRegGo(HttpServletRequest req, PostVO p) {
		TokenMaker.make(req);
		acDAO.wathingPage(req);
		// 글을 쓰려면 로그인을 하라는 것
		if (acDAO.loginCheck(req)) {
			req.setAttribute("contentPage", "fan/fanPostReg.jsp");
			brDAO.viewBoardName(req);
		} else {
			req.setAttribute("contentPage", "account/loginPage.jsp");
		}
		return "index";
	}

	@RequestMapping(value = "fan.reg.do", method = RequestMethod.POST)
	public String fanRegDo(HttpServletRequest req, PostVO p, PointVO pv, PlusPointVO ppv) {
		TokenMaker.make(req);

		if (acDAO.loginCheck(req)) {
			// PostVo안에 post_board가 들어있으니 따로 넘겨줄 필요는 없음
			brDAO.regPost(req, p);

			// 포인트 추가
			int plusPoint = Integer.parseInt(req.getParameter("plusPoint"));
			ptDAO.calcAddPostAndAddCommentPoint(req, pv, ppv, plusPoint);

			// 등록후에는 그 게시판 전체글을 보여줄것이라서
			BoardOption.clearSearch(req);
			int post_board = Integer.parseInt(req.getParameter("post_board"));
			brDAO.getAllPost(req, 1, post_board, p);
			req.setAttribute("contentPage", "fan/fanBoard.jsp");
		} else {
			req.setAttribute("contentPage", "account/loginPage.jsp");
		}
		return "index";
	}

	@RequestMapping(value = "fan.detail.go", method = RequestMethod.GET)
	public String fanDetailGo(HttpServletRequest req, HttpServletResponse res, PostVO p) {
		TokenMaker.make(req);
		acDAO.wathingPage(req);

		// 이미 추천한 게시물인지 체크하기
		if (acDAO.loginCheck(req)) {
			brDAO.likeCheck(req, p);
		}

		brDAO.getPost(req, p); // 게시글 넘버로 불러오는 것이라 굳이 게시판 넘버가 필요없다
		brDAO.postCountUpdate(req, res, p);
		req.setAttribute("contentPage", "fan/fanPostDetail.jsp");
		return "index";
	}

	@RequestMapping(value = "fan.update.go", method = RequestMethod.GET)
	public String fanUpdateGo(HttpServletRequest req, PostVO p) {
		TokenMaker.make(req);
		acDAO.wathingPage(req);

		if (acDAO.loginCheck(req)) {
			brDAO.getPost(req, p);
			req.setAttribute("contentPage", "fan/fanPostUpdate.jsp");
		} else {
			req.setAttribute("contentPage", "account/loginPage.jsp");
		}
		return "index";
	}

	@RequestMapping(value = "fan.update.do", method = RequestMethod.POST)
	public String fanUpdateDo(HttpServletRequest req, PostVO p) {
		TokenMaker.make(req);

		if (acDAO.loginCheck(req)) {
			brDAO.updatePost(req, p);
			brDAO.getPost(req, p);
			req.setAttribute("contentPage", "fan/fanPostDetail.jsp");
		} else {
			req.setAttribute("contentPage", "account/loginPage.jsp");
		}
		return "index";
	}

	@RequestMapping(value = "fan.delete.do", method = RequestMethod.GET)
	public String fanDeleteDo(HttpServletRequest req, PostVO p) {
		TokenMaker.make(req);

		if (acDAO.loginCheck(req)) {
			brDAO.deletePost(req, p);

			// 삭제후 전체글 조회
			BoardOption.clearSearch(req);
			int post_board = Integer.parseInt(req.getParameter("post_board"));
			brDAO.getAllPost(req, 1, post_board, p);
			req.setAttribute("contentPage", "fan/fanBoard.jsp");
		} else {
			req.setAttribute("contentPage", "account/loginPage.jsp");
		}
		return "index";
	}

	@RequestMapping(value = "/fan.page.change", method = RequestMethod.GET)
	public String fanPageChange(HttpServletRequest req, PostVO p) {
		TokenMaker.make(req);
		acDAO.wathingPage(req);
		acDAO.loginCheck(req);

		// 그 게시판에 해당하는 결과를 도출하기 위해 post_board가 필요
		int pg = Integer.parseInt(req.getParameter("pg"));
		int post_board = Integer.parseInt(req.getParameter("post_board"));
		brDAO.getAllPost(req, pg, post_board, p);
		req.setAttribute("contentPage", "fan/fanBoard.jsp");
		return "index";
	}

	@RequestMapping(value = "/fan.search.do", method = RequestMethod.GET)
	public String fanSearchDo(HttpServletRequest req, BoardSelector bSel, PostVO p) {
		acDAO.loginCheck(req);
		// BoardSelector안에 post_board가 들어있으니 따로 넘겨줄 필요는 없다
		brDAO.searchPost(req, bSel);

		// 위와 달리 검색후 보여주는 페이지에선 post_board필요하다
		int post_board = Integer.parseInt(req.getParameter("post_board"));
		brDAO.getAllPost(req, 1, post_board, p);
		req.setAttribute("contentPage", "fan/fanBoard.jsp");
		return "index";
	}

// --------------------------------------------------------------------------------------

	// 리플

	@RequestMapping(value = "fanReply.reg.do", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody ResultVO fanReplyRegDo(HttpServletRequest req, ReplyVO rp) {
		TokenMaker.make(req);
		return brDAO.regReply(req, rp);
	}
	/*
	 * @RequestMapping(value = "fanReply.reg.do", method = RequestMethod.GET) public
	 * String fanReplyRegDo(HttpServletRequest req, ReplyVO rp, PostVO p) {
	 * TokenMaker.make(req); if (acDAO.loginCheck(req)) { brDAO.regReply(req, rp); }
	 * else { req.setAttribute("contentPage", "account/loginPage.jsp"); }
	 * brDAO.getPost(req, p); req.setAttribute("contentPage",
	 * "fan/fanPostDetail.jsp"); return "index"; }
	 */

	@RequestMapping(value = "fanReply.delete.do", method = RequestMethod.GET)
	public @ResponseBody int fanReplyDelete(HttpServletRequest req, ReplyVO rp) {
		return brDAO.deleteReply(req, rp);
	}

	@RequestMapping(value = "fanReply.update.do", method = RequestMethod.GET)
	public String fanReplyUpdate(HttpServletRequest req, ReplyVO rp, PostVO p) {
		TokenMaker.make(req);
		if (acDAO.loginCheck(req)) {
			brDAO.updateReply(req, rp);
		} else {
			req.setAttribute("contentPage", "account/loginPage.jsp");
		}
		brDAO.getPost(req, p);
		req.setAttribute("contentPage", "fan/fanPostDetail.jsp");
		return "index";
	}

	// 좋아요 (진행중)
	@ResponseBody
	@RequestMapping(value = "like.up.do", method = RequestMethod.POST)
	public void likeUpDo(HttpServletRequest req, @RequestBody LikeVO lk) {
		TokenMaker.make(req);
		System.out.println("좋아요 업");
		brDAO.likeUp(req, lk);
	}

	@ResponseBody
	@RequestMapping(value = "like.down.do", method = RequestMethod.POST)
	public void likeDownDo(HttpServletRequest req, @RequestBody LikeVO lk) {
		TokenMaker.make(req);
		System.out.println("좋아요 다운");
		brDAO.likeDown(req, lk);
	}

}
