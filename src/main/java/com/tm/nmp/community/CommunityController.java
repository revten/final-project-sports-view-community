package com.tm.nmp.community;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tm.nmp.account.AccountDAO;

@Controller
public class CommunityController {
	@Autowired
	private AccountDAO acDAO;
	
	@Autowired
	private CommunityDAO coDAO;
	
	@RequestMapping(value = "/communityWithGo.go", method = RequestMethod.GET)
	public String communityWithGoGo(HttpServletRequest req, CommunityDTO co) {
		acDAO.loginCheck(req);
		coDAO.showPostList(req, co);
		req.setAttribute("contentPage", "community/withGo/withGo.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/communityWrite.go", method = RequestMethod.GET)
	public String communityWriteGo(HttpServletRequest req) {
		acDAO.loginCheck(req);
		req.setAttribute("contentPage", "community/withGo/withGoWrite.jsp");
		return "index";
	}
	
	@RequestMapping(value = "withGoWrite.do", method = RequestMethod.POST)
	public String withGoWrite(HttpServletRequest req, CommunityDTO co) {
		acDAO.loginCheck(req);
		return "redirect:post.detail?_num="+coDAO.createPost(req, co);
	}
	
}
