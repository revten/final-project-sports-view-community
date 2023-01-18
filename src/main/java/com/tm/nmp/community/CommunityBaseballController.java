package com.tm.nmp.community;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tm.nmp.account.AccountDAO;

@Controller
public class CommunityBaseballController {

	@Autowired
	private AccountDAO acDAO;
	
	@Autowired
	private CM_BS_DAO bsDAO;
	
	@RequestMapping(value = "baseballBoardDetail.go", method = RequestMethod.GET)
	public String withGoListGo(HttpServletRequest req, CM_BS_TITLE bs) {
		acDAO.loginCheck(req);
		bsDAO.getBaseballDetail(req, bs);
		
		req.setAttribute("contentPage", "community/baseball/baseballDetail.jsp");

		return "index";
	}
	
	@RequestMapping(value = "baseballDelete.do", method = RequestMethod.GET)
	public String baseballDeleteDo(HttpServletRequest req, CM_BS_TITLE bs) {
		acDAO.loginCheck(req);
		bsDAO.deleteBaseball(req, bs);
		bsDAO.getAllBaseball(req, 1);
		
		req.setAttribute("contentPage", "community/baseball/baseballBoard.jsp");
		
		return "index";
	}
	
	@RequestMapping(value = "baseballUpdate.go", method = RequestMethod.GET)
	public String baseballUpdateGo(HttpServletRequest req, CM_BS_TITLE bs) {
		acDAO.loginCheck(req);
		bsDAO.getBaseballDetail(req, bs);
		
		req.setAttribute("contentPage", "community/baseball/baseballUpdate.jsp");
		
		return "index";
	}
	
	@RequestMapping(value = "baseballUpdate.do", method = RequestMethod.GET)
	public String baseballUpdateDo(HttpServletRequest req, CM_BS_TITLE bs) {
		acDAO.loginCheck(req);
		bsDAO.updateBaseball(req,bs);
		bsDAO.getAllBaseball(req, 1);
		
		req.setAttribute("contentPage", "community/baseball/baseballBoard.jsp");
		
		return "index";
	}
	
	@RequestMapping(value = "baseballInsert.go", method = RequestMethod.GET)
	public String baseballInsertGo(HttpServletRequest req, CM_BS_TITLE bs) {
		acDAO.loginCheck(req);
		
		req.setAttribute("contentPage", "community/baseball/baseballInsert.jsp");
		
		return "index";
	}
	
	@RequestMapping(value = "baseballInsert.do", method = RequestMethod.POST)
	public String baseballInsertDo(HttpServletRequest req, CM_BS_TITLE bs) {
		acDAO.loginCheck(req);
		bsDAO.inseertBaseball(req,bs);
		bsDAO.getAllBaseball(req, 1);
		
		req.setAttribute("contentPage", "community/baseball/baseballBoard.jsp");
		
		return "index";
	}
}
