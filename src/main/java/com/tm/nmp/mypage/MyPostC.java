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
		
		mpDAO.getMyPost(req, mp);
		req.setAttribute("contentPage", "myPage/myPageMyPostDetail.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/mypost.comment.insert", method = RequestMethod.POST)
	public String myPostCommentInsert(HttpServletRequest req, MyPostDTO mp, MyPostComment mpc) {
		
		acDAO.loginCheck(req);
		mpDAO.writeComment(req, mpc);
		mpDAO.getMyPost(req, mp);
		req.setAttribute("contentPage", "myPage/myPageMyPostDetail.jsp");
		return "index";
	}
	
	
	
	@RequestMapping(value = "/myPost.update.go", method = RequestMethod.GET)
	public String myPostUpdateGo(HttpServletRequest req, MyPostDTO mp) {
		
		acDAO.loginCheck(req);
		
		mpDAO.getMyPost(req, mp);
		req.setAttribute("contentPage", "myPage/myPageMyPostUpdate.jsp");
		return "index";
	}
	
	@RequestMapping(value = "mypost.update.do", method = RequestMethod.GET)
	public String myPostUpdateDo(HttpServletRequest req, MyPostDTO mp) {
		
		acDAO.loginCheck(req);
		mpDAO.updateMyPost(req, mp);
		mpDAO.getMyPost(req, mp);
		req.setAttribute("contentPage", "myPage/myPageMyPostDetail.jsp");
		return "index";
	}
	
	@RequestMapping(value = "mypost.delete.do", method = RequestMethod.GET)
	public String myPostDeleteDo(HttpServletRequest req, MyPostDTO mp) {
		
		acDAO.loginCheck(req);
		mpDAO.deleteMyPost(req, mp);
		mpDAO.getMyPostAll(req, 1);
		req.setAttribute("contentPage", "myPage/myPageMyPost.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/mypost.insert.go", method = RequestMethod.GET)
	public String mypostInsertGo(HttpServletRequest req) {
		acDAO.loginCheck(req);
		
		req.setAttribute("contentPage", "myPage/myPageMyPostReg.jsp");
		return "index";
	}
	
	@RequestMapping(value = "mypost.insert.do", method = RequestMethod.POST)
	public String myPostInserteDo(HttpServletRequest req, MyPostDTO mp) {
		
		acDAO.loginCheck(req);
		mpDAO.insertMyPost(req, mp);
		mpDAO.getMyPostAll(req, 1);
		req.setAttribute("contentPage", "myPage/myPageMyPost.jsp");
		return "index";
	}

}
