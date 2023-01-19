package com.tm.nmp.admin;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tm.nmp.account.AC_US_DAO;
import com.tm.nmp.games.TotoDTO;

@Controller
public class AnswerC {
	
	@Autowired
	private AC_US_DAO acDAO;
	
	@Autowired
	private AnswerDAO asDAO;
	
	@RequestMapping(value = "/admin.answer.detail.go", method = RequestMethod.GET)
	public String adminAnswerBoardGo(HttpServletRequest req, AnswerDTO as) {
		acDAO.loginCheck(req);
		
		asDAO.getAnswer(req, as);
		req.setAttribute("contentPage", "admin/answerDetail.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/answer.comment.insert", method = RequestMethod.POST)
	public String answerCommentInsert(HttpServletRequest req, AnswerDTO as, AnswerComment asc) {
		acDAO.loginCheck(req);
		asDAO.writeComment(req, asc);
		asDAO.getAnswer(req, as);
		req.setAttribute("contentPage", "admin/answerDetail.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/answer.update.go", method = RequestMethod.GET)
	public String answerUpdateGo(HttpServletRequest req, AnswerDTO as) {
		acDAO.loginCheck(req);
		
		asDAO.getAnswer(req, as);
		req.setAttribute("contentPage", "admin/answerUpdate.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/answer.update.do", method = RequestMethod.GET)
	public String answerUpdateDo(HttpServletRequest req, AnswerDTO as) {
		acDAO.loginCheck(req);
		asDAO.updateAnswer(req, as);
		asDAO.getAnswer(req, as);
		req.setAttribute("contentPage", "admin/answerDetail.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/answer.delete.do", method = RequestMethod.GET)
	public String answerDeleteDo(HttpServletRequest req, AnswerDTO as) {
		acDAO.loginCheck(req);
		asDAO.deleteAnswer(req, as);
		asDAO.getAnswerAll(req,1);
		req.setAttribute("contentPage", "admin/answerBoard.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/answer.insert.go", method = RequestMethod.GET)
	public String answerInsertGo(HttpServletRequest req) {
		acDAO.loginCheck(req);
		
		req.setAttribute("contentPage", "admin/answerReg.jsp");
		return "index";
	}
	
	
	@RequestMapping(value = "answer.insert.do", method = RequestMethod.POST)
	public String myPostInserteDo(HttpServletRequest req, AnswerDTO as) {
		
		acDAO.loginCheck(req);
		asDAO.insertAnswer(req, as);
		asDAO.getAnswerAll(req,1);
		req.setAttribute("contentPage", "admin/answerBoard.jsp");
		return "index";
	}
	
	
	
	

}
