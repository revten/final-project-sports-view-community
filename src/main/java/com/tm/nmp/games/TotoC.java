package com.tm.nmp.games;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tm.nmp.account.AC_US_DAO;

@Controller
public class TotoC {
	
	@Autowired
	private AC_US_DAO acDAO;
	
	@Autowired
	private TotoDAO ttDAO;
	
	@RequestMapping(value = "/games.toto.detail.go", method = RequestMethod.GET)
	public String gamesTotoDetailGo(HttpServletRequest req, TotoDTO tt) {

		acDAO.loginCheck(req);
		
		ttDAO.getToto(req, tt);
		req.setAttribute("contentPage", "games/totoDetail.jsp");
		return "index";
	}
	
	
	@RequestMapping(value = "toto.comment.insert", method = RequestMethod.POST)
	public String totoCommentinsert(HttpServletRequest req, TotoDTO tt, TotoComment ttc) {
		
		acDAO.loginCheck(req);
		ttDAO.writeComment(req, ttc);
		ttDAO.getToto(req, tt);
		req.setAttribute("contentPage", "games/totoDetail.jsp");
		return "index";
	}
	
	@RequestMapping(value = "toto.comment.delete.do", method = RequestMethod.GET)
	public String totoCommentdelete(HttpServletRequest req, TotoDTO tt, TotoComment ttc) {
		
		acDAO.loginCheck(req);
		ttDAO.deleteComment(req, ttc);
		ttDAO.getToto(req, tt);
		req.setAttribute("contentPage", "games/totoDetail.jsp");
		return "index";
	}
	
	
	
	
	@RequestMapping(value = "/toto.update.go", method = RequestMethod.GET)
	public String totoUpdateGo(HttpServletRequest req, TotoDTO tt) {
		
		acDAO.loginCheck(req);
		
		ttDAO.getToto(req, tt);
		req.setAttribute("contentPage", "games/totoUpdate.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/toto.update.do", method = RequestMethod.GET)
	public String totoUpdateDo(HttpServletRequest req, TotoDTO tt) {
		
		acDAO.loginCheck(req);
		ttDAO.updateToto(req, tt);
		ttDAO.getToto(req, tt);
		req.setAttribute("contentPage", "games/totoDetail.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/toto.delete.do", method = RequestMethod.GET)
	public String totoDeleteDo(HttpServletRequest req, TotoDTO tt) {
		
		acDAO.loginCheck(req);
		ttDAO.deleteToto(req, tt);
		ttDAO.getToto(req, tt);
		req.setAttribute("contentPage", "games/totoBoard.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/toto.insert.go", method = RequestMethod.GET)
	public String totoInsertGo(HttpServletRequest req) {
		acDAO.loginCheck(req);
		
		req.setAttribute("contentPage", "games/totoReg.jsp");
		return "index";
	}
	
	
	@RequestMapping(value = "toto.insert.do", method = RequestMethod.POST)
	public String myPostInserteDo(HttpServletRequest req, TotoDTO tt) {
		
		acDAO.loginCheck(req);
		ttDAO.insertToto(req, tt);
		ttDAO.getTotoAll(req,1);
		req.setAttribute("contentPage", "games/totoBoard.jsp");
		return "index";
	}
	
}
