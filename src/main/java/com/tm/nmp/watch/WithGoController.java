package com.tm.nmp.watch;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tm.nmp.account.AC_US_DAO;

@Controller
public class WithGoController {
	@Autowired
	private AC_US_DAO acDAO;

	@Autowired
	private CM_WG_DAO wgDAO;

	@RequestMapping(value = "withGoList.go", method = RequestMethod.GET)
	public String withGoListGo(HttpServletRequest req, CM_WG_TITLE wg) {
		acDAO.wathingPage(req);
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
		wgDAO.regWithGo(req, wg);
		return "redirect:withGoDetail.go?wg_no=" + wgDAO.withGoWrite(req, wg);
	}

	@RequestMapping(value = "withGoDetail.go", method = RequestMethod.GET)
	public String withGoDetailGo(HttpServletResponse res, HttpServletRequest req, CM_WG_TITLE wg) {
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

}
