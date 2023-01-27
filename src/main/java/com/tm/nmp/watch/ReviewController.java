package com.tm.nmp.watch;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tm.nmp.TokenMaker;
import com.tm.nmp.account.AC_US_DAO;
import com.tm.nmp.board.BoardDAO;
import com.tm.nmp.board.BoardOption;
import com.tm.nmp.point.PointDAO;

@Controller
public class ReviewController {
	
	@Autowired
	private BoardDAO brDAO;

	@Autowired
	private AC_US_DAO acDAO;

	@Autowired
	private PointDAO ptDAO;
	
	@RequestMapping(value = "/review.board.go", method = RequestMethod.GET)
	public String reviewBoardGo(HttpServletRequest req) {
		TokenMaker.make(req);
		acDAO.wathingPage(req);
		acDAO.loginCheck(req);

		// fan메인에서 어떤 게시판으로 갈지 파라미터를 받아서 설정
		BoardOption.clearSearch(req);
		int post_board = Integer.parseInt(req.getParameter("post_board"));
		brDAO.getAllPost(req, 1, post_board); // 1은 첫페이지를 보여달라

		req.setAttribute("contentPage", "watch/review/reviewBoard.jsp");
		return "index";
	}
}
