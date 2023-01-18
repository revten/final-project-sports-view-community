package com.tm.nmp.mypage;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tm.nmp.account.AC_US_DAO;

@Controller
public class MyPageController {

	@Autowired
	private AC_US_DAO acDAO;

	@Autowired
	private MyPageDAO mpDAO;
	
	@Autowired
	private MyPostDAO mptDAO;
	
	@Autowired
	private AskDAO askDAO;

	@RequestMapping(value = "myPage.info.go", method = RequestMethod.GET)
	public String myPageInfoGo(HttpServletRequest req) {
		acDAO.loginCheck(req);
		req.setAttribute("contentPage", "myPage/myPageInfo.jsp");
		return "index";
	}

	@RequestMapping(value = "/myPage.myPost.go", method = RequestMethod.GET)
	public String myPageMyPostGo(HttpServletRequest req, MyPostDTO mpt) {

		acDAO.loginCheck(req);
		mptDAO.getMyPostAll(req, 1);
		
		req.setAttribute("contentPage", "myPage/myPageMyPost.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/mypost.page.change", method = RequestMethod.GET)
	public String myPostPageChange(HttpServletRequest req, MyPostDTO mpt) {
		int p = Integer.parseInt(req.getParameter("p"));
		mptDAO.getMyPostAll(req, p);
		acDAO.loginCheck(req);
		
		req.setAttribute("contentPage", "myPage/myPageMyPost.jsp");
		return "index";
	}

	@RequestMapping(value = "/myPage.service.go", method = RequestMethod.GET)
	public String myPageServiceGo(HttpServletRequest req) {

		acDAO.loginCheck(req);
		
		askDAO.getAskAll(req);
		req.setAttribute("contentPage", "myPage/myPageService.jsp");
		return "index";
	}
}
