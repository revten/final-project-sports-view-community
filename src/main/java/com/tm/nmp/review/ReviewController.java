package com.tm.nmp.review;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tm.nmp.TokenMaker;
import com.tm.nmp.account.accountDAO;
import com.tm.nmp.board.BoardDAO;
import com.tm.nmp.board.BoardOption;
import com.tm.nmp.board.BoardSelector;
import com.tm.nmp.board.PostVO;
import com.tm.nmp.point.PlusPointVO;
import com.tm.nmp.point.PointDAO;
import com.tm.nmp.point.PointVO;

@Controller
public class ReviewController {
	
	@Autowired
	private BoardDAO brDAO;

	@Autowired
	private accountDAO acDAO;
	
	@Autowired
	private PointDAO ptDAO;

	
	@RequestMapping(value = "review.board.go", method = RequestMethod.GET)
	public String reviewBoardGo(HttpServletRequest req, PostVO p) {
		acDAO.wathingPage(req);
		acDAO.loginCheck(req);
		
		BoardOption.clearSearch(req);

		brDAO.getAllPost(req, 1, p); // 1은 첫페이지를 보여달라
		req.setAttribute("contentPage", "review/reviewBoard.jsp");
		return "index";
	}
	
	// 게시글
	@RequestMapping(value = "review.reg.go", method = RequestMethod.GET)
	public String reviewRegGo(HttpServletRequest req, PostVO p) {
		acDAO.wathingPage(req);
		// 글을 쓰려면 로그인을 하라는 것
		if (acDAO.loginCheck(req)) {
			req.setAttribute("contentPage", "review/reviewReg.jsp");
			brDAO.viewBoardName(req);
		} else {
			req.setAttribute("contentPage", "account/loginPage.jsp");
		}
		return "index";
	}

	@RequestMapping(value = "review.reg.do", method = RequestMethod.POST)
	public String reviewRegDo(HttpServletRequest req, PostVO p, PointVO pv, PlusPointVO ppv) {

		if (acDAO.loginCheck(req)) {
			brDAO.regPost(req, p);

			// 포인트 추가
			int plusPoint = Integer.parseInt(req.getParameter("plusPoint"));
			ptDAO.calcAddPostAndAddCommentPoint(req, pv, ppv, plusPoint);

			// 등록후에는 그 게시판 전체글을 보여줄것이라서
			BoardOption.clearSearch(req);
			brDAO.getAllPost(req, 1, p);
			req.setAttribute("contentPage", "review/reviewBoard.jsp");
		} else {
			req.setAttribute("contentPage", "account/loginPage.jsp");
		}
		return "index";
	}

	@RequestMapping(value = "review.detail.go", method = RequestMethod.GET)
	public String reviewDetailGo(HttpServletRequest req, HttpServletResponse res, PostVO p) {
		acDAO.wathingPage(req);

		brDAO.getPost(req, p); // 게시글 넘버로 불러오는 것이라 굳이 게시판 넘버가 필요없다
		brDAO.postCountUpdate(req, res, p);
		req.setAttribute("contentPage", "review/reviewDetail.jsp");
		return "index";
	}

	@RequestMapping(value = "review.update.go", method = RequestMethod.GET)
	public String reviewUpdateGo(HttpServletRequest req, PostVO p) {
		acDAO.wathingPage(req);

		if (acDAO.loginCheck(req)) {
			brDAO.getPost(req, p);
			req.setAttribute("contentPage", "review/reviewUpdate.jsp");
		} else {
			req.setAttribute("contentPage", "account/loginPage.jsp");
		}
		return "index";
	}

	@RequestMapping(value = "review.update.do", method = RequestMethod.POST)
	public String reviewUpdateDo(HttpServletRequest req, PostVO p) {

		if (acDAO.loginCheck(req)) {
			brDAO.updatePost(req, p);
			brDAO.getPost(req, p);
			req.setAttribute("contentPage", "review/reviewDetail.jsp");
		} else {
			req.setAttribute("contentPage", "account/loginPage.jsp");
		}
		return "index";
	}

	@RequestMapping(value = "review.delete.do", method = RequestMethod.GET)
	public String reviewDeleteDo(HttpServletRequest req, PostVO p) {

		if (acDAO.loginCheck(req)) {
			brDAO.deletePost(req, p);

			// 삭제후 전체글 조회
			BoardOption.clearSearch(req);
			
			brDAO.getAllPost(req, 1, p);
			req.setAttribute("contentPage", "review/reviewBoard.jsp");
		} else {
			req.setAttribute("contentPage", "account/loginPage.jsp");
		}
		return "index";
	}

	@RequestMapping(value = "/review.page.change", method = RequestMethod.GET)
	public String reviewPageChange(HttpServletRequest req, PostVO p) {
		TokenMaker.make(req);
		acDAO.wathingPage(req);
		acDAO.loginCheck(req);

		int pg = Integer.parseInt(req.getParameter("pg"));
		
		brDAO.getAllPost(req, pg, p);
		req.setAttribute("contentPage", "review/reviewBoard.jsp");
		return "index";
	}

	@RequestMapping(value = "/review.search.do", method = RequestMethod.GET)
	public String reviewSearchDo(HttpServletRequest req, BoardSelector bSel, PostVO p) {
		acDAO.loginCheck(req);

		brDAO.searchPost(req, bSel);

		brDAO.getAllPost(req, 1, p);
		req.setAttribute("contentPage", "review/reviewBoard.jsp");
		return "index";
	}
	
}
