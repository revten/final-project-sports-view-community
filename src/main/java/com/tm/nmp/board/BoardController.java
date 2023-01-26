package com.tm.nmp.board;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tm.nmp.TokenMaker;
import com.tm.nmp.account.AC_US_DAO;

@Controller
public class BoardController {
	
	@Autowired
	private BoardDAO brDAO;
	
	@Autowired
	private AC_US_DAO acDAO;
	
	@RequestMapping(value = "post.board.go", method = RequestMethod.GET)
	public String postBoardGo(HttpServletRequest req) {
		TokenMaker.make(req);
		int post_board = Integer.parseInt(req.getParameter("post_board"));
		acDAO.loginCheck(req);
		brDAO.getAllPost(req, 1, post_board);
		
		req.setAttribute("contentPage", "fan/baseball/baseballBoard.jsp");
		return "index";
	}
	
	@RequestMapping(value = "post.delete.do", method = RequestMethod.GET)
	public String postDeleteDo(HttpServletRequest req, PostVO p) {
		TokenMaker.make(req);
		BoardOption.clearSearch(req);
		if (acDAO.loginCheck(req)) {
			brDAO.deletePost(req, p);
		}
		brDAO.getAllPost(req, 1, 21);
		req.setAttribute("contentPage", "fan/baseball/baseballBoard.jsp");
		return "index";
	}

	
}
