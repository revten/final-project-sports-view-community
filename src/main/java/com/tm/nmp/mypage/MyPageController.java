package com.tm.nmp.mypage;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tm.nmp.TokenMaker;
import com.tm.nmp.account.AC_US_DAO;
import com.tm.nmp.account.AccountDTO;
import com.tm.nmp.board.PostVO;
import com.tm.nmp.point.PlusPointVO;
import com.tm.nmp.point.PointDAO;
import com.tm.nmp.point.PointVO;

@Controller
public class MyPageController {

	@Autowired
	private AC_US_DAO acDAO;
	
	@Autowired
	private PointDAO pDAO;
	
	@RequestMapping(value = "myPage.pointInfo.go", method = RequestMethod.GET)
	public String myPagePointInfoGo(HttpServletRequest req, PointVO pv, PlusPointVO ppv) {
		TokenMaker.make(req);
		acDAO.loginCheck(req);
		pDAO.showPoint(req, pv);
		pDAO.showPlusPoint(req, ppv);
		
		req.setAttribute("contentPage", "myPage/myPageMyPoint.jsp");
		return "index";
	}
	
	@RequestMapping(value = "myPage.info.go", method = RequestMethod.GET)
	public String myPageInfoGo(HttpServletRequest req, AccountDTO ac, PointVO pv, PlusPointVO ppv) {
		TokenMaker.make(req);
		acDAO.loginCheck(req);
		req.setAttribute("contentPage", "myPage/myPageInfo.jsp");
		return "index";
	}
	
	@RequestMapping(value = "myPage.myPost.go", method = RequestMethod.GET)
	public String myPageMyPostGo(HttpServletRequest req, AccountDTO ac, PointVO pv, PlusPointVO ppv, PostVO pvo) {
		TokenMaker.make(req);
		acDAO.loginCheck(req);
		acDAO.getMyPosts(req, pvo);
		req.setAttribute("contentPage", "myPage/myPageMyPost.jsp");
		return "index";
	}
	
	@RequestMapping(value = "myPage.myPost.detail.go", method = RequestMethod.GET)
	public String myPageMyPostDetailGo(HttpServletRequest req, AccountDTO ac, PointVO pv, PlusPointVO ppv, PostVO pvo) {
		TokenMaker.make(req);
		acDAO.loginCheck(req);
		acDAO.getMyDeatailPosts(req, pvo);
		req.setAttribute("contentPage", "myPage/myPageMyPostDetail.jsp");
		return "index";
	}
	
	
	
	@RequestMapping(value = "myPage.service.go", method = RequestMethod.GET)
	public String myPageMyServiceGo(HttpServletRequest req, AccountDTO ac, PointVO pv, PlusPointVO ppv) {
		TokenMaker.make(req);
		acDAO.loginCheck(req);
		
		req.setAttribute("contentPage", "myPage/myPageService.jsp");
		return "index";
	}
	
}
