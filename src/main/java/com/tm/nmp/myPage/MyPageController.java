package com.tm.nmp.myPage;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tm.nmp.TokenMaker;
import com.tm.nmp.account.accountDAO;
import com.tm.nmp.account.AccountDTO;
import com.tm.nmp.board.BoardDAO;
import com.tm.nmp.board.PostVO;
import com.tm.nmp.point.PlusPointVO;
import com.tm.nmp.point.PointDAO;
import com.tm.nmp.point.PointVO;

@Controller
public class MyPageController {

	@Autowired
	private accountDAO acDAO;
	
	@Autowired
	private PointDAO pDAO;
		
	@RequestMapping(value = "myPage.info.go", method = RequestMethod.GET)
	public String myPageInfoGo(HttpServletRequest req, AccountDTO ac, PointVO pv, PlusPointVO ppv) {
		acDAO.loginCheck(req);
		req.setAttribute("contentPage", "myPage/myPageMyInfo.jsp");
		return "index";
	}
	
	@RequestMapping(value = "myPage.myPost.go", method = RequestMethod.GET)
	public String myPageMyPostGo(HttpServletRequest req, AccountDTO ac, PostVO pvo) {
		acDAO.loginCheck(req);
		acDAO.getMyPosts(req, pvo);
		req.setAttribute("contentPage", "myPage/myPageMyPost.jsp");
		return "index";
	}
	
	@RequestMapping(value = "myPage.pointInfo.go", method = RequestMethod.GET)
	public String myPagePointInfoGo(HttpServletRequest req, PointVO pv, PlusPointVO ppv) {
		acDAO.loginCheck(req);
		pDAO.showPoint(req, pv);
		pDAO.showPlusPoint(req, ppv);
		
		req.setAttribute("contentPage", "myPage/myPageMyPoint.jsp");
		return "index";
	}
	
}
