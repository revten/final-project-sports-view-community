package com.tm.nmp.newsEvent;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tm.nmp.account.AC_US_DAO;

@Controller
public class NewsController {

	@Autowired
	private AC_US_DAO acDAO;

	@Autowired
	private NewsDAO nsDAO;
	
	@RequestMapping(value = "/news.soccer.go", method = RequestMethod.GET)
	public String goSoccerNews(HttpServletRequest req) {
		acDAO.loginCheck(req);
		req.setAttribute("contentPage", "newsEvent/news/soccerNews.jsp");
		return "index";
	}
	@RequestMapping(value = "/news.baseball.go", method = RequestMethod.GET)
	public String goBaseballNews(HttpServletRequest req) {
		acDAO.loginCheck(req);
		req.setAttribute("contentPage", "newsEvent/news/baseballNews.jsp");
		return "index";
	}
	@RequestMapping(value = "/news.basketball.go", method = RequestMethod.GET)
	public String goBasketballNews(HttpServletRequest req) {
		acDAO.loginCheck(req);
		req.setAttribute("contentPage", "newsEvent/news/basketballNews.jsp");
		return "index";
	}
	@RequestMapping(value = "/news.volleyball.go", method = RequestMethod.GET)
	public String goVolleyballNews(HttpServletRequest req) {
		acDAO.loginCheck(req);
		req.setAttribute("contentPage", "newsEvent/news/VolleyballNews.jsp");
		return "index";
	}
	@RequestMapping(value = "/news.sports.go", method = RequestMethod.GET)
	public String goSportsNews(HttpServletRequest req) {
		acDAO.loginCheck(req);
		req.setAttribute("contentPage", "newsEvent/news/sportsNews.jsp");
		return "index";
	}

	@RequestMapping(value = "/get.soccer.news.one", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public @ResponseBody JSONObject getSoccerNewsOne(HttpServletRequest req) {
		acDAO.loginCheck(req);
		return nsDAO.getSoccerNewsOne(req);
	}
	@RequestMapping(value = "/get.soccer.news.all", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public @ResponseBody JSONObject getSoccerNewsAll(HttpServletRequest req) {
		acDAO.loginCheck(req);
		return nsDAO.getSoccerNewsAll(req);
	}
	@RequestMapping(value = "/get.baseball.news.one", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public @ResponseBody JSONObject getBaseballNewsOne(HttpServletRequest req) {
		acDAO.loginCheck(req);
		return nsDAO.getBaseballNewsOne(req);
	}
	@RequestMapping(value = "/get.baseball.news.all", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public @ResponseBody JSONObject getBaseballNewsAll(HttpServletRequest req) {
		acDAO.loginCheck(req);
		return nsDAO.getBaseballNewsAll(req);
	}
	@RequestMapping(value = "/get.basketball.news.one", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public @ResponseBody JSONObject getBasketballNewsOne(HttpServletRequest req) {
		acDAO.loginCheck(req);
		return nsDAO.getBasketballNewsOne(req);
	}
	@RequestMapping(value = "/get.basketball.news.all", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public @ResponseBody JSONObject getBasketballNewsAll(HttpServletRequest req) {
		acDAO.loginCheck(req);
		return nsDAO.getBasketballNewsAll(req);
	}
	@RequestMapping(value = "/get.volleyball.news.one", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public @ResponseBody JSONObject getVolleyballNewsOne(HttpServletRequest req) {
		acDAO.loginCheck(req);
		return nsDAO.getVolleyballNewsOne(req);
	}
	@RequestMapping(value = "/get.volleyball.news.all", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public @ResponseBody JSONObject getVolleyballNewsAll(HttpServletRequest req) {
		acDAO.loginCheck(req);
		return nsDAO.getVolleyballNewsAll(req);
	}
	@RequestMapping(value = "/get.sports.news.all", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public @ResponseBody JSONObject getSportsNewsAll(HttpServletRequest req) {
		acDAO.loginCheck(req);
		return nsDAO.getSportsNewsAll(req);
	}

}
