package com.tm.nmp.community;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tm.nmp.account.AC_US_DAO;

@Controller
public class CommunityBasketballController {
	
	@Autowired
	private AC_US_DAO acDAO;
	
	@Autowired
	private CM_BK_DAO bkDAO;
	
	@RequestMapping(value = "BasketballBoardDetail.go", method = RequestMethod.GET)
	public String withGoListGo(HttpServletRequest req, CM_BK_TITLE bk) {
		acDAO.loginCheck(req);
		bkDAO.getBasketballDetail(req, bk);
		
		req.setAttribute("contentPage", "community/basketball/basketballDetail.jsp");

		return "index";
	}
	
	@RequestMapping(value = "BasketballDelete.do", method = RequestMethod.GET)
	public String BasketballDeleteDo(HttpServletRequest req, CM_BK_TITLE bk) {
		acDAO.loginCheck(req);
		bkDAO.deleteBasketball(req, bk);
		bkDAO.getAllBasketball(req, bk);
		
		req.setAttribute("contentPage", "community/basketball/basketballBoard.jsp");
		
		return "index";
	}
	
	@RequestMapping(value = "BasketballUpdate.go", method = RequestMethod.GET)
	public String BasketballUpdateGo(HttpServletRequest req, CM_BK_TITLE bk) {
		acDAO.loginCheck(req);
		bkDAO.getBasketballDetail(req, bk);
		
		req.setAttribute("contentPage", "community/basketball/basketballUpdate.jsp");
		
		return "index";
	}
	
	@RequestMapping(value = "BasketballUpdate.do", method = RequestMethod.GET)
	public String BasketballUpdateDo(HttpServletRequest req, CM_BK_TITLE bk) {
		acDAO.loginCheck(req);
		bkDAO.updateBasketball(req,bk);
		bkDAO.getAllBasketball(req, bk);
		
		req.setAttribute("contentPage", "community/basketball/basketballBoard.jsp");
		
		return "index";
	}
	
	@RequestMapping(value = "BasketballInsert.go", method = RequestMethod.GET)
	public String BasketballInsertGo(HttpServletRequest req, CM_BK_TITLE bk) {
		acDAO.loginCheck(req);
		
		req.setAttribute("contentPage", "community/basketball/basketballInsert.jsp");
		
		return "index";
	}
	
	@RequestMapping(value = "BasketballInsert.do", method = RequestMethod.POST)
	public String BasketballInsertDo(HttpServletRequest req, CM_BK_TITLE bk) {
		acDAO.loginCheck(req);
		bkDAO.inseertBasketball(req,bk);
		bkDAO.getAllBasketball(req, bk);
		
		req.setAttribute("contentPage", "community/basketball/basketballBoard.jsp");
		
		return "index";
	}
	
	

}
