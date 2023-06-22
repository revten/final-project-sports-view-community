package com.tm.nmp.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.tm.nmp.board.BoardOption;
import com.tm.nmp.model.ClubDTO;
import com.tm.nmp.model.ClubImageDTO;
import com.tm.nmp.model.ClubListView;
import com.tm.nmp.service.AdminService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping(value = "/admin")
public class AdminController {
	
	@Autowired
	private AdminService adminSv;

	private int allClubCount;

	@RequestMapping(value = "/admin.go", method = RequestMethod.GET)
	public String adminGo(HttpServletRequest req) {
		log.info("admin 페이지 진입");

		return "/admin/admin";
	}

	@RequestMapping(value = "/adminUser.go", method = RequestMethod.GET)
	public String adminMemberGo(HttpServletRequest req) {

		return "/admin/adminUser";
	}

	@RequestMapping(value = "/adminBoard.go", method = RequestMethod.GET)
	public String adminBoardGo() {

		return "/admin/adminBoard";
	}
	
	// 전체 조회
	@RequestMapping(value = "/adminClub.go", method = RequestMethod.GET)
	public String getClubViewList(HttpServletRequest req, BoardOption boardOption) {
		
		req.getParameter("page");

		if (boardOption.getField() == null) {
			boardOption.setField("name");
		}
		if (boardOption.getSearch() == null) {
			boardOption.setSearch("");
		}

		// 총 구단 수
		allClubCount = adminSv.calcAllClubCount(boardOption); 
		log.info("전체 구단 수", allClubCount);

		System.out.println("조회구단수 : " + allClubCount);
		if (req.getParameter("page") == null) {
			boardOption.setCurPage(1); // 현재 보여주는 페이지
		} else {
			int page = Integer.parseInt(req.getParameter("page"));
			boardOption.setCurPage(page);
		}
		boardOption.setCountPerPage(10); // 한 페이장 게시글 수
		boardOption.setStartNum((boardOption.getCurPage() - 1) * boardOption.getCountPerPage() + 1); // 한 페이지의 첫 글
		boardOption.setEndNum(boardOption.getStartNum() + (boardOption.getCountPerPage() - 1)); // 한 페이지의 마지막 글
		boardOption.setStartPage(boardOption.getCurPage() - (boardOption.getCurPage() - 1) % 5); // 한화면에 보여줄 페이지 목록 처음
		boardOption.setEndPage(4);// 한화면에 보여줄 페이지 목록 마지막
		boardOption.setTotalPages((int) Math.ceil(allClubCount / (double) boardOption.getCountPerPage())); // 총 페이지수
		req.setAttribute("bo", boardOption);
		
		
		List<ClubListView> clubs = adminSv.getClubViewList(boardOption);
		req.setAttribute("clubs", clubs);

		return "/admin/adminClub";
	}
	
	// 구단 정보 조회
	@RequestMapping(value = "/adminClub.detail.go", method = RequestMethod.GET)
	public String getClubDetail(HttpServletRequest req) {
		int id = Integer.parseInt(req.getParameter("id"));
		log.info("club_id", id);

		ClubListView club = adminSv.getClubDetail(id);
		req.setAttribute("club", club);

		List<ClubImageDTO> ci = adminSv.getClubImages(id);
		req.setAttribute("clubImages", ci);
		return "/admin/adminClubDetail";
	}

	@RequestMapping(value = "/adminClub.reg.go", method = RequestMethod.GET)
	public String adminClubInsertGo(HttpServletRequest req) {
		return "/admin/adminClubReg";
	}

	// 구단등록하기
	@RequestMapping(value = "/adminClub.reg.do", method = RequestMethod.POST)
	public String insertClubInfo(@RequestParam("image") List<MultipartFile> filelist, HttpServletRequest req, ClubDTO club)
			throws IOException {

		List<ClubImageDTO> images = new ArrayList<>();
		for (MultipartFile file : filelist) {
			if (!file.isEmpty()) {
				ClubImageDTO ci = new ClubImageDTO();
				ci.setClub_id(club.getId());
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
						.getRealPath("resources/files/club_images/" + club.getId());
				File uploadPath = new File(uploadFolder);
				if (!uploadPath.exists()) {
					uploadPath.mkdirs();
				}
				log.info("파일  업로드 폴더 {}", uploadPath);
				// 파일 저장
				file.transferTo(new File(uploadPath, fileName));
				log.info("파일 이름 {}", file.getOriginalFilename());
				log.info("분류 {}", ci.getSort());
				log.info("파일 크기 {}", file.getSize());
				images.add(ci);// 파일 업로드가 성공한 경우에만 리스트에 추가
			}
		}
		for (ClubImageDTO i : images) {
			System.out.println("구단코드 : " + i.getClub_id());
			System.out.println("사진종류 : " + i.getSort());
			System.out.println("파일명 : " + i.getFile_name());
		}
		
		int result = adminSv.insertClubInfo(club);
		req.setAttribute("result", result);
		
		adminSv.insertClubImages(images);
		
		return "/admin/adminClub";
	}
	
	// 구단 이미지 한장 등록후 조회
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
			log.info("파일  업로드 폴더 {}", uploadPath);
			// 파일 저장
			try {
				file.transferTo(new File(uploadPath, fileName));
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			log.info("파일 이름 {}", file.getOriginalFilename());
			log.info("분류 {}", ci.getSort());
			log.info("파일 크기 {}", file.getSize());
		}

		int result = adminSv.insertOneClubImage(ci);
		return adminSv.getRecentClubImage();
	}

	// 구단 정보 수정페이지로 이동
	@RequestMapping(value = "/adminClub.update.go", method = RequestMethod.GET)
	public String updateClubGo(HttpServletRequest req) {
		int club_id = Integer.parseInt(req.getParameter("id"));
		log.info("club_id", club_id);

		ClubListView club = adminSv.getClubDetail(club_id);
		req.setAttribute("club", club);

		List<ClubImageDTO> ci = adminSv.getClubImages(club_id);
		req.setAttribute("clubImages", ci);
		return "/admin/adminClubUpdate";
	}

	// 구단 정보 수정
	@RequestMapping(value = "/adminClub.update.do", method = RequestMethod.GET)
	public String updateClub(HttpServletRequest req, ClubDTO c) {
//		adminDAO.updateClubInfo(c);
		return "/admin/adminClub";
	}

	// 구단 이미지 수정
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
			log.info("파일  업로드 폴더 {}", uploadPath);
			// 파일 저장
			try {
				file.transferTo(new File(uploadPath, fileName));
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			log.info("파일 이름 {}", file.getOriginalFilename());
			log.info("분류 {}", ci.getSort());
			log.info("파일 크기 {}", file.getSize());
		}
		int result = adminSv.updateClubImage(ci);
		return adminSv.getClubImages(id);
	}

}