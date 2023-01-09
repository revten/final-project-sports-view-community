package com.tm.nmp.stadium;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tm.nmp.account.AccountDAO;

@Controller
public class StadiumController {

	@Autowired
	private AccountDAO acDAO;
	
	@RequestMapping(value = "/baseball.go", method = RequestMethod.GET)
	public String baseballGo(HttpServletRequest req) {
		acDAO.loginCheck(req);
		req.setAttribute("contentPage", "stadium/baseball/baseball.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/ssgStadium.go", method = RequestMethod.GET)
	public String ssgStadiumGo(HttpServletRequest req) {
		acDAO.loginCheck(req);
		req.setAttribute("contentPage", "stadium/baseball/ssgStadium.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/ssgStadiumWith.go", method = RequestMethod.GET)
	public String ssgStadiumWithGo(HttpServletRequest req) {
		acDAO.loginCheck(req);
		req.setAttribute("contentPage", "community/withGo/baseball/ssgStadiumWithGo.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/kiwoomStadium.go", method = RequestMethod.GET)
	public String kiwoomStadiumGo(HttpServletRequest req) {
		acDAO.loginCheck(req);
		req.setAttribute("contentPage", "stadium/baseball/kiwoomStadium.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/kiwoomStadiumWith.go", method = RequestMethod.GET)
	public String kiwoomStadiumWithGo(HttpServletRequest req) {
		acDAO.loginCheck(req);
		req.setAttribute("contentPage", "community/withGo/baseball/kiwoomStadiumWithGo.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/soccer.go", method = RequestMethod.GET)
	public String soccerGo(HttpServletRequest req) {
		acDAO.loginCheck(req);
		req.setAttribute("contentPage", "stadium/soccer.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/basketball.go", method = RequestMethod.GET)
	public String basketballGo(HttpServletRequest req) {
		acDAO.loginCheck(req);
		req.setAttribute("contentPage", "stadium/basketball.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/volleyball.go", method = RequestMethod.GET)
	public String volleyballGo(HttpServletRequest req) {
		acDAO.loginCheck(req);
		req.setAttribute("contentPage", "stadium/volleyball.jsp");
		return "index";
	}
	
}
