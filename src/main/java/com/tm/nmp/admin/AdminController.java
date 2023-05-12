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
import org.springframework.web.bind.annotation.RequestParam;
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
	public String adminClubReg(@RequestParam("image") List<MultipartFile> filelist, HttpServletRequest req, ClubDTO c)
			throws IOException {

		List<ClubImageDTO> images = new ArrayList<>();
		for (MultipartFile file : filelist) {
			if (!file.isEmpty()) {
				ClubImageDTO ci = new ClubImageDTO();
				ci.setClub_id(c.getId());
				String fileName = file.getOriginalFilename();
				ci.setFile_name(fileName);

				if (fileName.contains("logo")) {
					ci.setSort(0);
				} else if (fileName.contains("stadium")) {
					ci.setSort(1);
				} else if (fileName.contains("seat")) {
					ci.setSort(2);
				} else if (fileName.contains("view")) {
					ci.setSort(3);
				}

				String uploadFolder = req.getSession().getServletContext()
						.getRealPath("resources/files/club_images/" + c.getId());
				File uploadPath = new File(uploadFolder);
				if (!uploadPath.exists()) {
					uploadPath.mkdirs();
				}
				logger.info("파일  업로드 폴더 {}", uploadPath);
				// 파일 저장
				file.transferTo(new File(uploadPath, fileName));
				logger.info("파일 이름 {}", file.getOriginalFilename());
				logger.info("분류 {}", ci.getSort());
				logger.info("파일 크기 {}", file.getSize());
				images.add(ci);// 파일 업로드가 성공한 경우에만 리스트에 추가
			}
		}
		for (ClubImageDTO i : images) {
			System.out.println("구단코드 : " + i.getClub_id());
			System.out.println("사진종류 : " + i.getSort());
			System.out.println("파일명 : " + i.getFile_name());
		}
		adminDAO.regClubInfo(c);
		adminDAO.insertClubImages(images);
		return "/admin/adminClub";
	}
	
	@RequestMapping(value="/adminClub.detail.go", method = RequestMethod.GET)
	public String getClubDetail(HttpServletRequest req) {
		int id = Integer.parseInt(req.getParameter("id"));
		System.out.println(id);
		ClubListView club = adminDAO.getClubDetail(id);
		req.setAttribute("club", club);
		List<ClubImageDTO> ci = adminDAO.getClubImages(id);
		req.setAttribute("clubImages", ci);
		return "/admin/adminClubDetail";
	}
	
	@RequestMapping(value="/adminClub.update.go", method = RequestMethod.GET)
	public String updateClubGo(HttpServletRequest req) {
		int id = Integer.parseInt(req.getParameter("id"));
		System.out.println(id);
		ClubListView club = adminDAO.getClubDetail(id);
		req.setAttribute("club", club);
/*		List<ClubImageDTO> cli = adminDAO.getClubImages(id);
		req.setAttribute("clubImages", cli);*/
		return "/admin/adminClubUpdate";
	}
	
	@RequestMapping(value="/adminClub.update.do", method = RequestMethod.GET)
	public String updateClub(HttpServletRequest req) {
		int id = Integer.parseInt(req.getParameter("id"));
		System.out.println(id);

		return "/admin/adminClub";
	}
	
	@RequestMapping(value = "/adminClub.updateImage.do", method = RequestMethod.POST)
	public @ResponseBody int adminClubUpdateImage(HttpServletRequest req, ClubImageDTO ci, MultipartFile file) {
		return adminDAO.updateImage(req, ci, file);
	}

}