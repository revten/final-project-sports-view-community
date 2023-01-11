package com.tm.nmp.community;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CommunitySoccerBoardController {
	@Autowired
	private CommunitySoccerBoardDAO scDAO;
	
	
	@RequestMapping(value = "/communitySoccer.write.go", method = RequestMethod.GET)
	public String communityWithGoGo(HttpServletRequest req) {

		
		req.setAttribute("contentPage", "community/soccer/communitySoccerWrite.jsp");
		return "index";
	}
	
}
