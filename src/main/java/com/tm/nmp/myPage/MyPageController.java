package com.tm.nmp.myPage;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tm.nmp.TokenMaker;
import com.tm.nmp.board.BoardDAO;
import com.tm.nmp.board.PostVO;
import com.tm.nmp.dao.AccountDAO;
import com.tm.nmp.fan.FanBoardController;
import com.tm.nmp.model.AccountVO;
import com.tm.nmp.point.PlusPointVO;
import com.tm.nmp.point.PointDAO;
import com.tm.nmp.point.PointVO;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping(value = "/myPage")
public class MyPageController {

	@Autowired
	private AccountDAO acDAO;
	
	@Autowired
	private PointDAO pDAO;
		
	@RequestMapping(value = "myPage.info.go", method = RequestMethod.GET)
	public String myPageInfoGo(HttpServletRequest req, AccountVO ac, PointVO pv, PlusPointVO ppv) {
		log.info("myPage 메인 진입");
		acDAO.loginCheck(req);
		req.setAttribute("contentPage", "myPage/myPageMyInfo.jsp");
		return "index";
	}
	
	@RequestMapping(value = "myPage.myPost.go", method = RequestMethod.GET)
	public String myPageMyPostGo(HttpServletRequest req, AccountVO ac, PostVO pvo) {
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
