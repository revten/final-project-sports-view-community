package com.tm.nmp.stadium;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tm.nmp.account.AC_US_DAO;

@Controller
public class StadiumController {

	@Autowired
	private AC_US_DAO acDAO;
	
	@Autowired
	private StadiumDAO sdDAO;
	
	@RequestMapping(value = "/baseball.go", method = RequestMethod.GET)
	public String baseballGo(HttpServletRequest req) {
		acDAO.loginCheck(req);
		req.setAttribute("contentPage", "stadium/baseball/baseball_stadium.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/baseball.stadium.go.detail", method = RequestMethod.GET)
	public String baseballStadiumGoDetail(HttpServletRequest req) {
		acDAO.loginCheck(req);
		sdDAO.viewBaseballSeat(req);
		sdDAO.viewBaseballSeatDetail(req);
		req.setAttribute("contentPage", "stadium/baseball/baseball_stadium_detail.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/soccer.go", method = RequestMethod.GET)
	public String soccerGo(HttpServletRequest req) {
		acDAO.loginCheck(req);
		req.setAttribute("contentPage", "stadium/soccer/soccer_stadium.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/soccer.stadium.go.detail", method = RequestMethod.GET)
	public String soccerStadiumGoDetail(HttpServletRequest req) {
		acDAO.loginCheck(req);
		sdDAO.viewSoccerSeat(req);
		sdDAO.viewSoccerSeatDetail(req);
		req.setAttribute("contentPage", "stadium/soccer/soccer_stadium_detail.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/basketball.go", method = RequestMethod.GET)
	public String basketballGo(HttpServletRequest req) {
		acDAO.loginCheck(req);
		req.setAttribute("contentPage", "stadium/basketball/basketball_stadium.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/basketball2.go", method = RequestMethod.GET)
	public String basketballGo2(HttpServletRequest req) {
		acDAO.loginCheck(req);
		req.setAttribute("contentPage", "stadium/basketball/w_basketball_stadium.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/basketball.stadium.go.detail", method = RequestMethod.GET)
	public String basketballStadiumGoDetail(HttpServletRequest req) {
		acDAO.loginCheck(req);
		sdDAO.viewBasketballSeat(req);
		sdDAO.viewBasketballSeatDetail(req);
		req.setAttribute("contentPage", "stadium/basketball/basketball_stadium_detail.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/w_basketball.stadium.go.detail", method = RequestMethod.GET)
	public String wBasketballStadiumGoDetail(HttpServletRequest req) {
		acDAO.loginCheck(req);
		sdDAO.viewBasketballSeat(req);
		sdDAO.viewBasketballSeatDetail(req);
		req.setAttribute("contentPage", "stadium/basketball/w_basketball_stadium_detail.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/volleyball.go", method = RequestMethod.GET)
	public String volleyballGo(HttpServletRequest req) {
		acDAO.loginCheck(req);
		req.setAttribute("contentPage", "stadium/volleyball/volleyball_stadium.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/volleyball2.go", method = RequestMethod.GET)
	public String volleyballGo2(HttpServletRequest req) {
		acDAO.loginCheck(req);
		req.setAttribute("contentPage", "stadium/volleyball/w_volleyball_stadium.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/volleyball.stadium.go.detail", method = RequestMethod.GET)
	public String volleyballStadiumGoDetail(HttpServletRequest req) {
		acDAO.loginCheck(req);
		sdDAO.viewVolleyballSeat(req);
		req.setAttribute("contentPage", "stadium/volleyball/volleyball_stadium_detail.jsp");
		return "index";
	}
	
}
