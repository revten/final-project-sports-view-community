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
import com.tm.nmp.board.PostVO;
import com.tm.nmp.point.PointDAO;

@Controller
public class ReviewController {
	
	@Autowired
	private BoardDAO brDAO;

	@Autowired
	private AC_US_DAO acDAO;

	
	@RequestMapping(value = "review.board.go", method = RequestMethod.GET)
	public String reviewBoardGo(HttpServletRequest req, PostVO p) {
		TokenMaker.make(req);
		acDAO.wathingPage(req);
		acDAO.loginCheck(req);
		BoardOption.clearSearch(req);
		int post_board = Integer.parseInt(req.getParameter("post_board"));
		brDAO.getAllPost(req, 1, post_board, p); // 1은 첫페이지를 보여달라
		req.setAttribute("contentPage", "review/reviewBoard.jsp");
		return "index";
	}
}
