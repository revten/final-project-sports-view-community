package com.tm.nmp.admin;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tm.nmp.account.accountDAO;
import com.tm.nmp.board.BoardDAO;
import com.tm.nmp.board.BoardOption;

@Controller
public class AdminController {

	@Autowired
	private accountDAO acDAO;

	@Autowired
	private BoardDAO brDAO;

	@Autowired
	private AdminDAO adminDAO;

	@RequestMapping(value = "/admin.go", method = RequestMethod.GET)
	public String adminGo(HttpServletRequest req) {
//		acDAO.wathingPage(req);
//		acDAO.loginCheck(req);
		return "/admin/admin";
	}

	@RequestMapping(value = "/adminUser.go", method = RequestMethod.GET)
	public String adminMemberGo(HttpServletRequest req) {
//		acDAO.wathingPage(req);
//		acDAO.loginCheck(req);
		return "/admin/adminUser";
	}

	@RequestMapping(value = "/adminBoard.go", method = RequestMethod.GET)
	public String adminBoardGo(HttpServletRequest req) {
//		acDAO.wathingPage(req);
//		acDAO.loginCheck(req);
		return "/admin/adminBoard";
	}

	@RequestMapping(value = "/adminClub.go", method = RequestMethod.GET)
	public String adminClubGo(HttpServletRequest req, BoardOption bo) {
//		acDAO.wathingPage(req);
//		acDAO.loginCheck(req);
		adminDAO.getClubViewList(req, bo);
		return "/admin/adminClub";
	}

	@RequestMapping(value = "/adminClub.reg.go", method = RequestMethod.GET)
	public String adminClubRegGo(HttpServletRequest req) {
//		acDAO.wathingPage(req);
//		acDAO.loginCheck(req);
		return "/admin/adminClubReg";
	}

	@RequestMapping(value = "/adminClub.reg.do", method = RequestMethod.POST)
	public String adminClubRegDo(HttpServletRequest req, ClubDTO c, BoardOption bo) {
//		acDAO.wathingPage(req);
//		acDAO.loginCheck(req);

		adminDAO.regClubInfo(req, c);
		adminDAO.getClubViewList(req, bo);
		return "/admin/adminClub";
	}

	@RequestMapping(value = "/adminClub.image.upload.do", method = RequestMethod.POST)
	public @ResponseBody int adminClubImageUpload(HttpServletRequest req, ClubDTO c, BoardOption bo) {
		return adminDAO.uploadImage(req);
	}

}