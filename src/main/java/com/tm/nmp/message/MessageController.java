package com.tm.nmp.message;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tm.nmp.account.AC_US_DAO;

@Controller
public class MessageController {

	@Autowired
	private messageDAO msDAO;
	
	@Autowired
	private AC_US_DAO acDAO;
	
	@RequestMapping(value = "message.go", method = RequestMethod.GET)
	public String goMessage(HttpServletRequest req) {
		
		msDAO.getMember(req);
		
		if(acDAO.loginCheck(req)) {
			msDAO.getMsg(req);
		}
		req.setAttribute("contentPage", "message/message.jsp");
		return "index";
	}
	
	@RequestMapping(value = "message.delete", method = RequestMethod.GET)
	public String deleteMessage(MessageVO mv, HttpServletRequest req) {
		
		msDAO.getMember(req);
		
		if(acDAO.loginCheck(req)) {
			msDAO.deleteMsg(mv, req);
			msDAO.getMsg(req);
		}
		req.setAttribute("contentPage", "message/message.jsp");
		return "index";
	}
	
	@RequestMapping(value = "message.send", method = RequestMethod.GET)
	public String sendMessage(MessageVO mv, HttpServletRequest req) {
		
		msDAO.getMember(req);
		
		if(acDAO.loginCheck(req)) {
			msDAO.sendMsg(mv,req);
			msDAO.getMsg(req);
		}
		req.setAttribute("contentPage", "message/message.jsp");
		return "index";
	}
	
	
	
}
