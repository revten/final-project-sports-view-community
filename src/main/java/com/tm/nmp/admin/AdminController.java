package com.tm.nmp.admin;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

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

	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

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
	public String adminBoardGo() {
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
	public String adminClubReg(HttpServletRequest req, ClubDTO c, ClubImageDTO ci, MultipartHttpServletRequest mhsr)
			throws IOException {
		System.out.println("adminClub.reg.do");
		System.out.println(c.getId());

		List<MultipartFile> list = mhsr.getFiles("image");
		List<ClubImageDTO> images = new ArrayList<>();

		/*
		 * for (ClubImageDTO aa : images) { if (aa.getFile_name().contains("logo")) {
		 * aa.setSort(0); } }
		 */

		for (MultipartFile mf : list) {
			if (mf.getSize() != 0) {
				String fileName = mf.getOriginalFilename();
				String uploadFolder = "";
				ci.setClub_id(c.getId());
				ci.setFile_name(fileName);

				if (fileName.contains("logo")) {
					uploadFolder = req.getSession().getServletContext().getRealPath("resources/files/admin/logo");
				} else if (fileName.contains("stadium")) {
					uploadFolder = req.getSession().getServletContext().getRealPath("resources/files/admin/stadium");
				} else if (fileName.contains("seat")) {
					uploadFolder = req.getSession().getServletContext().getRealPath("resources/files/admin/seat");
				} else if (fileName.contains("view")) {
					uploadFolder = req.getSession().getServletContext()
							.getRealPath("resources/files/admin/view" + c.getId());
				}
				System.out.println(ci.getSort());
				mf.transferTo(new File(uploadFolder, fileName));
/*				logger.info("파일 이름 {}", mf.getOriginalFilename());
				logger.info("파일 크기 {}", mf.getSize());*/
				images.add(ci);
			}
		}
		/*
		 * int result = adminDAO.regClubInfo(c); adminDAO.insertClubImages(c);
		 */
		return "/admin/adminClub";
	}

	@RequestMapping(value = "/adminClub.updateImage.do", method = RequestMethod.POST)
	public @ResponseBody int adminClubUpdateImage(HttpServletRequest req, ClubImageDTO ci, MultipartFile file) {
		System.out.println("controller");
		return adminDAO.updateImage(req, ci, file);
	}

}