package com.tm.nmp.withGo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import com.tm.nmp.point.PlusPointVO;
import com.tm.nmp.point.PointDAO;
import com.tm.nmp.point.PointVO;

@Controller
public class WithGoController {
	
	@Autowired
	private BoardDAO brDAO;

	@Autowired
	private AC_US_DAO acDAO;
	
	@Autowired
	private PointDAO ptDAO;
	
	@RequestMapping(value = "withGo.board.go", method = RequestMethod.GET)
	public String fanBoardGo(HttpServletRequest req, PostVO p) {

		acDAO.wathingPage(req);
		acDAO.loginCheck(req);

		BoardOption.clearSearch(req);
		brDAO.getAllPost(req, 1, 11, p); // 1은 첫페이지를 보여달라

		req.setAttribute("contentPage", "withGo/withGoBoard.jsp");
		return "index";
	}
	
	// 게시글
	@RequestMapping(value = "withGo.reg.go", method = RequestMethod.GET)
	public String withGoRegGo(HttpServletRequest req, PostVO p) {
		TokenMaker.make(req);
		acDAO.wathingPage(req);
		// 글을 쓰려면 로그인을 하라는 것
		if (acDAO.loginCheck(req)) {
			req.setAttribute("contentPage", "withGo/withGoReg.jsp");
			brDAO.viewBoardName(req);
		} else {
			req.setAttribute("contentPage", "account/loginPage.jsp");
		}
		return "index";
	}

	@RequestMapping(value = "withGo.reg.do", method = RequestMethod.POST)
	public String withGoRegDo(HttpServletRequest req, PostVO p, PointVO pv, PlusPointVO ppv) {
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
			req.setAttribute("contentPage", "withGo/withGoBoard.jsp");
		} else {
			req.setAttribute("contentPage", "account/loginPage.jsp");
		}
		return "index";
	}

	@RequestMapping(value = "withGo.detail.go", method = RequestMethod.GET)
	public String withGoDetailGo(HttpServletRequest req, HttpServletResponse res, PostVO p) {
		TokenMaker.make(req);
		acDAO.wathingPage(req);

		// 이미 추천한 게시물인지 체크하기
		if (acDAO.loginCheck(req)) {
			brDAO.likeCheck(req, p);
		}

		brDAO.getPost(req, p); // 게시글 넘버로 불러오는 것이라 굳이 게시판 넘버가 필요없다
		brDAO.postCountUpdate(req, res, p);
		req.setAttribute("contentPage", "withGo/withGoDetail.jsp");
		return "index";
	}

	@RequestMapping(value = "withGo.update.go", method = RequestMethod.GET)
	public String withGoUpdateGo(HttpServletRequest req, PostVO p) {
		TokenMaker.make(req);
		acDAO.wathingPage(req);

		if (acDAO.loginCheck(req)) {
			brDAO.getPost(req, p);
			req.setAttribute("contentPage", "withGo/withGoUpdate.jsp");
		} else {
			req.setAttribute("contentPage", "account/loginPage.jsp");
		}
		return "index";
	}

	@RequestMapping(value = "withGo.update.do", method = RequestMethod.POST)
	public String withGoUpdateDo(HttpServletRequest req, PostVO p) {
		TokenMaker.make(req);

		if (acDAO.loginCheck(req)) {
			brDAO.updatePost(req, p);
			brDAO.getPost(req, p);
			req.setAttribute("contentPage", "withGo/withGoDetail.jsp");
		} else {
			req.setAttribute("contentPage", "account/loginPage.jsp");
		}
		return "index";
	}

	@RequestMapping(value = "withGo.delete.do", method = RequestMethod.GET)
	public String withGoDeleteDo(HttpServletRequest req, PostVO p) {
		TokenMaker.make(req);

		if (acDAO.loginCheck(req)) {
			brDAO.deletePost(req, p);

			// 삭제후 전체글 조회
			BoardOption.clearSearch(req);
			int post_board = Integer.parseInt(req.getParameter("post_board"));
			brDAO.getAllPost(req, 1, post_board, p);
			req.setAttribute("contentPage", "withGo/withGoBoard.jsp");
		} else {
			req.setAttribute("contentPage", "account/loginPage.jsp");
		}
		return "index";
	}

	@RequestMapping(value = "/withGo.page.change", method = RequestMethod.GET)
	public String withGoPageChange(HttpServletRequest req, PostVO p) {
		TokenMaker.make(req);
		acDAO.wathingPage(req);
		acDAO.loginCheck(req);

		// 그 게시판에 해당하는 결과를 도출하기 위해 post_board가 필요
		int pg = Integer.parseInt(req.getParameter("pg"));
		int post_board = Integer.parseInt(req.getParameter("post_board"));
		brDAO.getAllPost(req, pg, post_board, p);
		req.setAttribute("contentPage", "withGo/withGoBoard.jsp");
		return "index";
	}

	@RequestMapping(value = "/withGo.search.do", method = RequestMethod.GET)
	public String withGoSearchDo(HttpServletRequest req, BoardSelector bSel, PostVO p) {
		acDAO.loginCheck(req);
		// BoardSelector안에 post_board가 들어있으니 따로 넘겨줄 필요는 없다
		brDAO.searchPost(req, bSel);

		// 위와 달리 검색후 보여주는 페이지에선 post_board필요하다
		int post_board = Integer.parseInt(req.getParameter("post_board"));
		brDAO.getAllPost(req, 1, post_board, p);
		req.setAttribute("contentPage", "withGo/withGoBoard.jsp");
		return "index";
	}
}
