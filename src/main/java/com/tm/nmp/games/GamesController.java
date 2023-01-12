package com.tm.nmp.games;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tm.nmp.account.AccountDAO;

@Controller
public class GamesController {
	
	@Autowired
	private AccountDAO acDAO;

	@RequestMapping(value = "/games.analystBoard.go", method = RequestMethod.GET)
	public String home(HttpServletRequest req) {
		acDAO.loginCheck(req);
		req.setAttribute("contentPage", "games/gamesAnalystBoard.jsp");
		return "index";
	}
}
