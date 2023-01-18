package com.tm.nmp.community;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tm.nmp.account.AccountDAO;

@Controller
public class CommunityVolleyballController {
	
	@Autowired
	private AccountDAO acDAO;
	
	@Autowired
	private CM_VL_DAO vlDAO;
	
	@RequestMapping(value = "VolleyballBoardDetail.go", method = RequestMethod.GET)
	public String withGoListGo(HttpServletRequest req, CM_VL_TITLE vl) {
		acDAO.loginCheck(req);
		vlDAO.getVolleyballDetail(req, vl);
		
		req.setAttribute("contentPage", "community/volleyball/volleyballDetail.jsp");

		return "index";
	}
	
	@RequestMapping(value = "VolleyballDelete.do", method = RequestMethod.GET)
	public String VolleyballDeleteDo(HttpServletRequest req, CM_VL_TITLE vl) {
		acDAO.loginCheck(req);
		vlDAO.deleteVolleyball(req, vl);
		vlDAO.getAllVolleyball(req, vl);
		
		req.setAttribute("contentPage", "community/volleyball/volleyballBoard.jsp");
		
		return "index";
	}
	
	@RequestMapping(value = "VolleyballUpdate.go", method = RequestMethod.GET)
	public String VolleyballUpdateGo(HttpServletRequest req, CM_VL_TITLE vl) {
		acDAO.loginCheck(req);
		vlDAO.getVolleyballDetail(req, vl);
		
		req.setAttribute("contentPage", "community/volleyball/volleyballUpdate.jsp");
		
		return "index";
	}
	
	@RequestMapping(value = "VolleyballUpdate.do", method = RequestMethod.GET)
	public String VolleyballUpdateDo(HttpServletRequest req, CM_VL_TITLE vl) {
		acDAO.loginCheck(req);
		vlDAO.updateVolleyball(req,vl);
		vlDAO.getAllVolleyball(req, vl);
		
		req.setAttribute("contentPage", "community/volleyball/volleyballBoard.jsp");
		
		return "index";
	}
	
	@RequestMapping(value = "VolleyballInsert.go", method = RequestMethod.GET)
	public String VolleyballInsertGo(HttpServletRequest req, CM_VL_TITLE vl) {
		acDAO.loginCheck(req);
		
		req.setAttribute("contentPage", "community/volleyball/volleyballInsert.jsp");
		
		return "index";
	}
	
	@RequestMapping(value = "VolleyballInsert.do", method = RequestMethod.POST)
	public String VolleyballInsertDo(HttpServletRequest req, CM_VL_TITLE vl) {
		acDAO.loginCheck(req);
		vlDAO.inseertVolleyball(req,vl);
		vlDAO.getAllVolleyball(req, vl);
		
		req.setAttribute("contentPage", "community/volleyball/volleyballBoard.jsp");
		
		return "index";
	}

}
