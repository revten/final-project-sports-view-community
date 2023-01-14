package com.tm.nmp.mypage;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tm.nmp.account.AccountDAO;

@Controller
public class MyPageController {

	@Autowired
	private AccountDAO acDAO;

	@Autowired
	private MyPageDAO mpDAO;

	@RequestMapping(value = "myPage.info.go", method = RequestMethod.GET)
	public String myPageInfoGo(HttpServletRequest req) {
		acDAO.loginCheck(req);
		req.setAttribute("contentPage", "myPage/myPageInfo.jsp");
		return "index";
	}

	@RequestMapping(value = "/myPage.myPost.go", method = RequestMethod.GET)
	public String myPageMyPostGo(HttpServletRequest req) {

		acDAO.loginCheck(req);
		req.setAttribute("contentPage", "myPage/myPageMyPost.jsp");
		return "index";
	}

	@RequestMapping(value = "/myPage.service.go", method = RequestMethod.GET)
	public String myPageServiceGo(HttpServletRequest req) {

		acDAO.loginCheck(req);
		req.setAttribute("contentPage", "myPage/myPageService.jsp");
		return "index";
	}
}
