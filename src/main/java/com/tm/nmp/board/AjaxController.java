package com.tm.nmp.board;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tm.nmp.TokenMaker;

@Controller
public class AjaxController {
	
	@Autowired
	private BoardDAO brDAO;
	
	@ResponseBody
	@RequestMapping(value = "like.up.do", method = RequestMethod.POST)
	public void likeUpDo(HttpServletRequest req, @RequestBody LikeVO lk) {
		TokenMaker.make(req);
		System.out.println("좋아요 업");
		brDAO.likeUp(req, lk);
	}
	
	@ResponseBody
	@RequestMapping(value = "like.down.do", method = RequestMethod.POST)
	public void likeDownDo(HttpServletRequest req, @RequestBody LikeVO lk) {
		TokenMaker.make(req);
		System.out.println("좋아요 다운");
		brDAO.likeDown(req, lk);
	}
	
}
