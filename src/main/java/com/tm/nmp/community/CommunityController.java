package com.tm.nmp.community;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tm.nmp.account.AC_US_DAO;

@Controller
public class CommunityController {
	@Autowired
	private AC_US_DAO acDAO;
	
	@Autowired
	private CM_WG_DAO wgDAO;
	
	@Autowired
	private CM_RV_DAO rvDAO;
	
	@Autowired
	private CM_SC_DAO scDAO;
	
	@Autowired
	private CM_BS_DAO bsDAO;
	
	@Autowired
	private CM_BK_DAO bkDAO;
	
	@Autowired
	private CM_VL_DAO vlDAO;
	
	@RequestMapping(value = "withGoList.go", method = RequestMethod.GET)
	public String withGoListGo(HttpServletRequest req, CM_WG_TITLE wg) {
		acDAO.loginCheck(req);
		wgDAO.showWithGoList(req, wg);
		req.setAttribute("contentPage", "community/withGo/withGo.jsp");

		return "index";
	}
	
	@RequestMapping(value = "/withGoWrite.go", method = RequestMethod.GET)
	public String withGoWriteGo(HttpServletRequest req) {
		acDAO.loginCheck(req);
		req.setAttribute("contentPage", "community/withGo/withGoWrite.jsp");
		return "index";
	}
	
	@RequestMapping(value = "withGo.upload.do", method = RequestMethod.POST)
	public String withGoUploadDo(HttpServletRequest req, CM_WG_TITLE wg) {
		acDAO.loginCheck(req);
		wgDAO.regWithGo(req,wg);
		return "redirect:withGoDetail.go?wg_no="+wgDAO.withGoWrite(req, wg);
	}
	
	@RequestMapping(value = "withGoDetail.go", method = RequestMethod.GET)
	public String withGoDetailGo(HttpServletResponse res ,HttpServletRequest req, CM_WG_TITLE wg) {
		acDAO.loginCheck(req);
		wgDAO.showWithGoDetail(req, wg);
		req.setAttribute("contentPage", "community/withGo/withGoDetail.jsp");
		return "index";
	}
	
	@RequestMapping(value = "withGoDelete.do", method = RequestMethod.GET)
	public String withGoDeleteDo(HttpServletRequest req, CM_WG_TITLE wg) {
		acDAO.loginCheck(req);
		wgDAO.deleteWithGo(req, wg);
		wgDAO.showWithGoList(req, wg);
		req.setAttribute("contentPage", "community/withGo/withGo.jsp");
		return "index";
	}
	
	@RequestMapping(value = "withGoUpdate.go", method = RequestMethod.GET)
	public String withGoUpdateGo(HttpServletRequest req, CM_WG_TITLE wg) {
		acDAO.loginCheck(req);
		wgDAO.showWithGoDetail(req, wg);
		req.setAttribute("contentPage", "community/withGo/withGoUpdate.jsp");
		return "index";
	}
	
	@RequestMapping(value = "withGoUpdate.do", method = RequestMethod.POST)
	public String withGoUpdateDo(HttpServletRequest req, CM_WG_TITLE wg) {
		acDAO.loginCheck(req);
		wgDAO.updateWithGo(req, wg);
		wgDAO.showWithGoDetail(req, wg);
		req.setAttribute("contentPage", "community/withGo/withGoDetail.jsp");
		return "index";
	}
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
		return "redirect:reviewDetail.go?rv_no="+rvDAO.ReviewWrite(req, rv);
	}
	
	@RequestMapping(value = "reviewDetail.go", method = RequestMethod.GET)
	public String reviewDetailGo(HttpServletResponse res ,HttpServletRequest req, CM_RV_TITLE rv) {
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
	
	//야구게시판
	@RequestMapping(value = "baseballBoard.go", method = RequestMethod.GET)
	public String baseballBoardGO(HttpServletRequest req, CM_BS_TITLE bs) {
		acDAO.loginCheck(req);
		bsDAO.getAllBaseball(req, 1);
		
		req.setAttribute("contentPage", "community/baseball/baseballBoard.jsp");
		return "index";
	}
	
	//축구게시판
	@RequestMapping(value = "soccerBoard.go", method = RequestMethod.GET)
	public String soccerBoardGO(HttpServletRequest req, CM_SC_TITLE sc) {
		acDAO.loginCheck(req);
		scDAO.getSoccerBoard(req,1);
		
		req.setAttribute("contentPage", "community/soccer/soccerBoard.jsp");
		return "index";
	}
	
	@RequestMapping(value = "basketballBoard.go", method = RequestMethod.GET)
	public String basketballBoardGO(HttpServletRequest req, CM_BK_TITLE bk) {
		acDAO.loginCheck(req);
		bkDAO.getAllBasketball(req,bk);
		
		req.setAttribute("contentPage", "community/soccer/soccerBoard.jsp");
		return "index";
	}
	
	@RequestMapping(value = "volleyballBoard.go", method = RequestMethod.GET)
	public String volleyballBoardGO(HttpServletRequest req, CM_VL_TITLE vl) {
		acDAO.loginCheck(req);
		vlDAO.getAllVolleyball(req,vl);
		
		req.setAttribute("contentPage", "community/soccer/soccerBoard.jsp");
		return "index";
	}
	
	
	
}
