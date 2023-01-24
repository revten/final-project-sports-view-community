package com.tm.nmp.mypage;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tm.nmp.TokenMaker;
import com.tm.nmp.account.AC_US_DAO;
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
	public String soccerRegDo(HttpServletRequest req, PointVO pv, PlusPointVO ppv) {
		TokenMaker.make(req);
		acDAO.loginCheck(req);
		pDAO.showPoint(req, pv);
		pDAO.showPlusPoint(req, ppv);
		
		req.setAttribute("contentPage", "myPage/myPageMyPoint.jsp");
		return "index";
	}

}
