package com.tm.nmp.fan;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tm.nmp.TokenMaker;
import com.tm.nmp.account.AC_US_DAO;
import com.tm.nmp.board.BoardDAO;
import com.tm.nmp.board.BoardOption;
import com.tm.nmp.board.BoardSelector;
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

	@RequestMapping(value = "fan.board.go", method = RequestMethod.GET)
	public String fanBoardGo(HttpServletRequest req, PostVO p) {
		System.out.println(p.getPost_board());
		acDAO.wathingPage(req);
		acDAO.loginCheck(req);
		// 홈에서 더 팬을 눌렀을때 우선 야구 게시판이 뜨게 설정해둠
		BoardOption.clearSearch(req);
		brDAO.getAllPost(req, 1, p); // 1은 첫페이지를 보여달라
		req.setAttribute("contentPage", "fan/fanBoard.jsp");
		return "index";
	}

// --------------------------------------------------------------------------------------

	// 게시글
	@RequestMapping(value = "fan.reg.go", method = RequestMethod.GET)
	public String fanRegGo(HttpServletRequest req, PostVO p) {
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
	public String fanRegDo(RedirectAttributes redir, HttpServletRequest req, PostVO p, PointVO pv, PlusPointVO ppv) {

		if (acDAO.loginCheck(req)) {
			brDAO.regPost(req, p);

			// 포인트 추가
			int plusPoint = Integer.parseInt(req.getParameter("plusPoint"));
			ptDAO.calcAddPostAndAddCommentPoint(req, pv, ppv, plusPoint);

			// 등록후에는 그 게시판 전체글을 보여줄것이라서
			BoardOption.clearSearch(req);
			brDAO.getAllPost(req, 1, p);
			req.setAttribute("contentPage", "fan/fanBoard.jsp");

		} else {
			req.setAttribute("contentPage", "account/loginPage.jsp");
		}
		redir.addAttribute("post_board", p.getPost_board());
		return "redirect:fan.board.go?post_board={post_board}";
	}

	@RequestMapping(value = "fan.detail.go", method = RequestMethod.GET)
	public String fanDetailGo(HttpServletRequest req, HttpServletResponse res, PostVO p) {
		acDAO.wathingPage(req);

		brDAO.getPost(req, p); // 게시글 넘버로 불러오는 것이라 굳이 게시판 넘버가 필요없다
		brDAO.postCountUpdate(req, res, p);
		req.setAttribute("contentPage", "fan/fanPostDetail.jsp");
		return "index";
	}

	@RequestMapping(value = "fan.update.go", method = RequestMethod.GET)
	public String fanUpdateGo(HttpServletRequest req, PostVO p) {
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

		if (acDAO.loginCheck(req)) {
			brDAO.deletePost(req, p);

			// 삭제후 전체글 조회
			BoardOption.clearSearch(req);
			brDAO.getAllPost(req, 1, p);
			req.setAttribute("contentPage", "fan/fanBoard.jsp");
		} else {
			req.setAttribute("contentPage", "account/loginPage.jsp");
		}
		return "index";
	}

	@RequestMapping(value = "/fan.page.change", method = RequestMethod.GET)
	public String fanPageChange(HttpServletRequest req, PostVO p) {
		acDAO.wathingPage(req);
		acDAO.loginCheck(req);

		int pg = Integer.parseInt(req.getParameter("pg"));
		brDAO.getAllPost(req, pg, p);
		req.setAttribute("contentPage", "fan/fanBoard.jsp");
		return "index";
	}

	@RequestMapping(value = "/fan.search.do", method = RequestMethod.GET)
	public String fanSearchDo(HttpServletRequest req, BoardSelector bSel, PostVO p) {
		acDAO.loginCheck(req);

		brDAO.searchPost(req, bSel);
		brDAO.getAllPost(req, 1, p);
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

	@RequestMapping(value = "fanReply.delete.do", method = RequestMethod.GET)
	public @ResponseBody int fanReplyDelete(HttpServletRequest req, ReplyVO rp) {
		return brDAO.deleteReply(req, rp);
	}

	@RequestMapping(value = "fanReply.update.do", method = RequestMethod.GET)
	public @ResponseBody ResultVO fanReplyUpdate(HttpServletRequest req, ReplyVO rp) {
		return brDAO.updateReply(req, rp);
	}

}
