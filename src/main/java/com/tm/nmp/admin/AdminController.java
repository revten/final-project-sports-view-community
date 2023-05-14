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

	private int allClubCount;

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
	public String getClubViewList(HttpServletRequest req, BoardOption bo) {
//		acDAO.wathingPage(req);
//		acDAO.loginCheck(req);

		req.getParameter("page");

		if (bo.getField() == null) {
			bo.setField("name");
		}
		if (bo.getSearch() == null) {
			bo.setSearch("");
		}

		allClubCount = adminDAO.calcAllClubCount(bo); // 총 게시글 수
		logger.info("전체 구단 수", allClubCount);

		System.out.println("조회구단수 : " + allClubCount);
		if (req.getParameter("page") == null) {
			bo.setCurPage(1); // 현재 보여주는 페이지
		} else {
			int page = Integer.parseInt(req.getParameter("page"));
			bo.setCurPage(page);
		}
		bo.setCountPerPage(10); // 한 페이장 게시글 수
		bo.setStartNum((bo.getCurPage() - 1) * bo.getCountPerPage() + 1); // 한 페이지의 첫 글
		bo.setEndNum(bo.getStartNum() + (bo.getCountPerPage() - 1)); // 한 페이지의 마지막 글
		bo.setStartPage(bo.getCurPage() - (bo.getCurPage() - 1) % 5); // 한화면에 보여줄 페이지 목록 처음
		bo.setEndPage(4);// 한화면에 보여줄 페이지 목록 마지막
		bo.setTotalPages((int) Math.ceil(allClubCount / (double) bo.getCountPerPage())); // 총 페이지수
		req.setAttribute("bo", bo);

		List<ClubListView> clubs = adminDAO.getClubViewList(bo);
		req.setAttribute("clubs", clubs);

		return "/admin/adminClub";
	}

	@RequestMapping(value = "/adminClub.detail.go", method = RequestMethod.GET)
	public String getClubDetail(HttpServletRequest req) {
		int id = Integer.parseInt(req.getParameter("id"));
		logger.info("club_id", id);

		ClubListView club = adminDAO.getClubDetail(id);
		req.setAttribute("club", club);

		List<ClubImageDTO> ci = adminDAO.getClubImages(id);
		req.setAttribute("clubImages", ci);
		return "/admin/adminClubDetail";
	}

	@RequestMapping(value = "/adminClub.reg.go", method = RequestMethod.GET)
	public String adminClubInsertGo(HttpServletRequest req) {
//		acDAO.wathingPage(req);
//		acDAO.loginCheck(req);
		return "/admin/adminClubReg";
	}

	@RequestMapping(value = "/adminClub.reg.do", method = RequestMethod.POST)
	public String insertClubInfo(@RequestParam("image") List<MultipartFile> filelist, HttpServletRequest req, ClubDTO c)
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
		adminDAO.insertClubInfo(c);
		adminDAO.insertClubImages(images);
		return "/admin/adminClub";
	}

	@ResponseBody
	@RequestMapping(value = "/adminClub.insertOneImage.do", method = RequestMethod.POST)
	public ClubImageDTO adminClubInsertOneImage(HttpServletRequest req, ClubImageDTO ci, MultipartFile file) {

		if (!file.isEmpty()) {
			String fileName = file.getOriginalFilename();
			ci.setFile_name(fileName);

			String uploadFolder = req.getSession().getServletContext()
					.getRealPath("resources/files/club_images/" + ci.getClub_id());
			File uploadPath = new File(uploadFolder);
			if (!uploadPath.exists()) {
				uploadPath.mkdirs();
			}
			logger.info("파일  업로드 폴더 {}", uploadPath);
			// 파일 저장
			try {
				file.transferTo(new File(uploadPath, fileName));
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			logger.info("파일 이름 {}", file.getOriginalFilename());
			logger.info("분류 {}", ci.getSort());
			logger.info("파일 크기 {}", file.getSize());
		}

		int result = adminDAO.insertOneClubImage(ci);
		return adminDAO.getRecentClubImage();
	}

	@RequestMapping(value = "/adminClub.update.go", method = RequestMethod.GET)
	public String updateClubGo(HttpServletRequest req) {
		int club_id = Integer.parseInt(req.getParameter("id"));
		logger.info("club_id", club_id);

		ClubListView club = adminDAO.getClubDetail(club_id);
		req.setAttribute("club", club);

		List<ClubImageDTO> ci = adminDAO.getClubImages(club_id);
		req.setAttribute("clubImages", ci);
		return "/admin/adminClubUpdate";
	}

	@RequestMapping(value = "/adminClub.update.do", method = RequestMethod.GET)
	public String updateClub(HttpServletRequest req, ClubDTO c) {
//		adminDAO.updateClubInfo(c);
		return "/admin/adminClub";
	}

	@RequestMapping(value = "/adminClub.updateImage.do", method = RequestMethod.POST)
	public @ResponseBody List<ClubImageDTO> adminClubUpdateImage(HttpServletRequest req, ClubImageDTO ci,
			MultipartFile file) {
		int id = ci.getClub_id();

		System.out.println(id);
		if (!file.isEmpty()) {
			String fileName = file.getOriginalFilename();
			ci.setFile_name(fileName);

			String uploadFolder = req.getSession().getServletContext()
					.getRealPath("resources/files/club_images/" + ci.getClub_id());
			File uploadPath = new File(uploadFolder);
			if (!uploadPath.exists()) {
				uploadPath.mkdirs();
			}
			logger.info("파일  업로드 폴더 {}", uploadPath);
			// 파일 저장
			try {
				file.transferTo(new File(uploadPath, fileName));
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			logger.info("파일 이름 {}", file.getOriginalFilename());
			logger.info("분류 {}", ci.getSort());
			logger.info("파일 크기 {}", file.getSize());
		}
		int result = adminDAO.updateClubImage(ci);
		return adminDAO.getClubImages(id);
	}

}