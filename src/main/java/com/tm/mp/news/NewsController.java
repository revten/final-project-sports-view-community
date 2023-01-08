package com.tm.mp.news;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tm.mp.account.AccountDAO;

@Controller
public class NewsController {

	@Autowired
	private AccountDAO acDAO;

	@Autowired
	private NewsDAO nsDAO;

	@RequestMapping(value = "/get.news", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public @ResponseBody JSONObject getNews(HttpServletRequest req) {
		acDAO.loginCheck(req);
		return nsDAO.getNews(req);
	}

}
