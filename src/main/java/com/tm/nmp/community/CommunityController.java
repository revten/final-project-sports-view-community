package com.tm.nmp.community;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tm.nmp.account.AccountDAO;

@Controller
public class CommunityController {
	@Autowired
	private AccountDAO acDAO;
	
	@Autowired
	private CommunityDAO coDAO;
	
	@RequestMapping(value = "withGoList.go", method = RequestMethod.GET)
	public String withGoListGo(HttpServletRequest req, CommunityDTO co) {
		acDAO.loginCheck(req);
		coDAO.showWithGoList(req, co);
		req.setAttribute("contentPage", "community/withGo/withGo.jsp");

		return "index";
	}
	
	@RequestMapping(value = "/withGoWrite.go", method = RequestMethod.GET)
	public String withGoWriteGo(HttpServletRequest req) {
		acDAO.loginCheck(req);
		req.setAttribute("contentPage", "community/withGo/withGoWrite.jsp");
		return "index";
	}
	
	@RequestMapping(value = "withGoWrite.do", method = RequestMethod.POST)
	public String withGoWriteDo(HttpServletRequest req, CommunityDTO co) {
		acDAO.loginCheck(req);
		return "redirect:withGoDetail.go?wg_no="+coDAO.withGoWrite(req, co);
	}
	
	@RequestMapping(value = "withGoDetail.go", method = RequestMethod.GET)
	public String withGoDetailGo(HttpServletResponse res ,HttpServletRequest req, CommunityDTO co) {
		acDAO.loginCheck(req);
		coDAO.showWithGoDetail(req, co);
		req.setAttribute("contentPage", "community/withGo/withGoDetail.jsp");
		return "index";
	}
	
	@RequestMapping(value = "withGoDelete.do", method = RequestMethod.GET)
	public String withGoDeleteDo(HttpServletRequest req, CommunityDTO co) {
		acDAO.loginCheck(req);
		coDAO.deleteWithGo(req, co);
		coDAO.showWithGoList(req, co);
		req.setAttribute("contentPage", "community/withGo/withGo.jsp");
		return "index";
	}
	
	@RequestMapping(value = "withGoUpdate.go", method = RequestMethod.GET)
	public String withGoUpdateGo(HttpServletRequest req, CommunityDTO co) {
		acDAO.loginCheck(req);
		coDAO.showWithGoDetail(req, co);
		req.setAttribute("contentPage", "community/withGo/withGoUpdate.jsp");
		return "index";
	}
	
	@RequestMapping(value = "withGoUpdate.do", method = RequestMethod.POST)
	public String withGoUpdateDo(HttpServletRequest req, CommunityDTO co) {
		acDAO.loginCheck(req);
		coDAO.deleteWithGo(req, co);
		req.setAttribute("contentPage", "community/withGo/withGoDetail.jsp");
		return "index";
	}
	
}
