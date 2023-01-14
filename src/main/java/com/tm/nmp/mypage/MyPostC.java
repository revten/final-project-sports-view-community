package com.tm.nmp.mypage;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tm.nmp.account.AccountDAO;

@Controller
public class MyPostC {
	
	@Autowired
	private AccountDAO acDAO;
	
	@Autowired
	private MyPostDAO mpDAO;
	
	@RequestMapping(value = "/myPage.myPost.detail.go", method = RequestMethod.GET)
	public String myPageServiceGo(HttpServletRequest req, MyPostDTO mp) {

		acDAO.loginCheck(req);
		
		mpDAO.getAsk(req, mp);
		req.setAttribute("contentPage", "myPage/myPageMyPostDetail.jsp");
		return "index";
	}

}
