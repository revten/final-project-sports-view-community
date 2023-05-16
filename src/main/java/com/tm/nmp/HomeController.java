package com.tm.nmp;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tm.nmp.account.accountDAO;
import com.tm.nmp.admin.AdminController;

@Controller
public class HomeController {

	@Autowired
	private accountDAO acDAO;

	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);	
//	@Autowired
//	private BoardDAO brDAO;
//
//	private boolean firstReq;
//
//	public HomeController() {
//		firstReq = true;
//	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpServletRequest req) {

//		if (firstReq) {
//			brDAO.calcAllPostCount();
//			firstReq = false;
//		}
//
//		acDAO.wathingPage(req);
		acDAO.loginCheck(req);
		req.setAttribute("contentPage", "home.jsp");
		return "index";
	}

	@RequestMapping(value = "/index.go", method = RequestMethod.GET)
	public String indexGo(HttpServletRequest req) {
		acDAO.wathingPage(req);
		return home(req);
	}

	@RequestMapping(value = "/account.login.go", method = RequestMethod.GET)
	public String accountLoginGo(HttpServletRequest req) {
		acDAO.loginCheck(req);
		req.setAttribute("contentPage", "account/loginPage.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/myPage.main.go", method = RequestMethod.GET)
	public String myPageMainGo(HttpServletRequest req) {
		acDAO.wathingPage(req);
		acDAO.loginCheck(req);
		req.setAttribute("contentPage", "myPage/myPageMain.jsp");
		return "index";
	}
	
}
