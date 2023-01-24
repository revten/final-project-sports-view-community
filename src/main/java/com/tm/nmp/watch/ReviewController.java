package com.tm.nmp.watch;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tm.nmp.account.AC_US_DAO;

@Controller
public class ReviewController {

	@Autowired
	private AC_US_DAO acDAO;

	@Autowired
	private CM_RV_DAO rvDAO;

	@RequestMapping(value = "reviewList.go", method = RequestMethod.GET)
	public String reviewListGo(HttpServletRequest req, CM_RV_TITLE rv) {
		acDAO.loginCheck(req);
		rvDAO.showReviewList(req, rv);
		req.setAttribute("contentPage", "community/review/review.jsp");

		return "index";
	}

	@RequestMapping(value = "/reviewWrite.go", method = RequestMethod.GET)
	public String reviewWriteGo(HttpServletRequest req) {
		acDAO.loginCheck(req);
		req.setAttribute("contentPage", "community/review/reviewWrite.jsp");
		return "index";
	}

	@RequestMapping(value = "reviewWrite.do", method = RequestMethod.POST)
	public String reviewWriteDo(HttpServletRequest req, CM_RV_TITLE rv) {
		acDAO.loginCheck(req);
		rvDAO.regReview(req, rv);
		return "redirect:reviewDetail.go?rv_no=" + rvDAO.ReviewWrite(req, rv);
	}

	@RequestMapping(value = "reviewDetail.go", method = RequestMethod.GET)
	public String reviewDetailGo(HttpServletResponse res, HttpServletRequest req, CM_RV_TITLE rv) {
		acDAO.loginCheck(req);
		rvDAO.showReviewDetail(req, rv);
		req.setAttribute("contentPage", "community/review/reviewDetail.jsp");
		return "index";
	}

	@RequestMapping(value = "reviewDelete.do", method = RequestMethod.GET)
	public String reviewDeleteDo(HttpServletRequest req, CM_RV_TITLE rv) {
		acDAO.loginCheck(req);
		rvDAO.deleteReview(req, rv);
		rvDAO.showReviewList(req, rv);
		req.setAttribute("contentPage", "community/review/reviewDetail.jsp");
		return "index";
	}

	@RequestMapping(value = "reviewUpdate.go", method = RequestMethod.GET)
	public String reviewUpdateGo(HttpServletRequest req, CM_RV_TITLE rv) {
		acDAO.loginCheck(req);
		rvDAO.showReviewDetail(req, rv);
		req.setAttribute("contentPage", "community/review/reviewUpdate.jsp");
		return "index";
	}

	@RequestMapping(value = "reviewUpdate.do", method = RequestMethod.POST)
	public String reviewUpdateDo(HttpServletRequest req, CM_RV_TITLE rv) {
		acDAO.loginCheck(req);
		rvDAO.updateReview(req, rv);
		rvDAO.showReviewDetail(req, rv);
		req.setAttribute("contentPage", "community/review/reviewDetail.jsp");
		return "index";
	}

}
