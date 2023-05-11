package com.tm.nmp.admin;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.tm.nmp.board.BoardOption;

@Service
public class AdminDAO {

	@Autowired
	private SqlSession ss;

	private int allClubCount;

	private static final Logger logger = LoggerFactory.getLogger(AdminDAO.class);

	public int calcAllClubCount(BoardOption bo) {
		allClubCount = ss.getMapper(AdminMapper.class).calcAllClubCount(bo);
		System.out.println("전체 구단 수 : " + allClubCount);
		return allClubCount;
	}

	public void getClubViewList(HttpServletRequest req, BoardOption bo) {

		req.getParameter("page");

		if (bo.getField() == null) {
			bo.setField("name");
		}
		if (bo.getSearch() == null) {
			bo.setSearch("");
		}

		allClubCount = calcAllClubCount(bo); // 총 게시글 수
		System.out.println("조회구단수 : " + allClubCount);
		if (req.getParameter("page") == null) {
			bo.setCurPage(1); // 현재 보여주는 페이지
		} else {
			int page = Integer.parseInt(req.getParameter("page"));
			bo.setCurPage(page);
		}
		bo.setCountPerPage(3); // 한 페이장 게시글 수
		bo.setStartNum((bo.getCurPage() - 1) * bo.getCountPerPage() + 1); // 한 페이지의 첫 글
		bo.setEndNum(bo.getStartNum() + (bo.getCountPerPage() - 1)); // 한 페이지의 마지막 글
		bo.setStartPage(bo.getCurPage() - (bo.getCurPage() - 1) % 5); // 한화면에 보여줄 페이지 목록 처음
		bo.setEndPage(4);// 한화면에 보여줄 페이지 목록 마지막
		bo.setTotalPages((int) Math.ceil(allClubCount / (double) bo.getCountPerPage())); // 총 페이지수
		req.setAttribute("bo", bo);

		List<ClubListView> clubs = ss.getMapper(AdminMapper.class).getClubViewList(bo);
		req.setAttribute("clubs", clubs);
	}

	public int regClubInfo(ClubDTO c) {
		return ss.getMapper(AdminMapper.class).regClubInfo(c);
	}

	public void insertClubImages(ClubDTO c) {
	}

	public int updateImage(HttpServletRequest req, ClubImageDTO ci, MultipartFile multipartFile) {

		// MultipartFile : 스프링 프레임워크에서 제공하는 타입
		// (1) 파일 저장할 위치 설정
		String uploadFolder = req.getSession().getServletContext().getRealPath("resources/files");
//		String  = "C:\\Users\\kamir\\Desktop\\Projects\\FinalProject\\final-project-sports-view-community\\src\\main\\webapp\\resources\\files";

		// uploadFolder\\k-003.png으로 조립
		// 이렇게 업로드 하겠다라고 설계
		File saveFile = new File(uploadFolder, multipartFile.getOriginalFilename());
		int result = 0;
		try {
//			transferTo() : 물리적으로 파일 업로드가 됨
			multipartFile.transferTo(saveFile);
			int club_id = Integer.parseInt(req.getParameter("club_id"));
			int sort = Integer.parseInt(req.getParameter("sort"));

			ci.setClub_id(club_id);
			ci.setSort(sort);
			ci.setFile_name(saveFile.getName());

			result = ss.getMapper(AdminMapper.class).uploadImage(ci);
			System.out.println(result);

			if (result == 1) {
				req.setAttribute("result", "성공");
			} else {
				req.setAttribute("result", "실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
			new File(uploadFolder + "/" + saveFile).delete();
		}

		return result;
	}

}
