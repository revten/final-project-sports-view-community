package com.tm.nmp.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
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
	
	@Autowired
	private SqlSessionTemplate sst;

	private int allClubCount;

	private static final Logger logger = LoggerFactory.getLogger(AdminDAO.class);

	public int calcAllClubCount(BoardOption bo) {
		allClubCount = sst.selectOne("AdminMapper.calcAllClubCount", bo);
		logger.info("전체 구단 수", allClubCount);
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
		bo.setCountPerPage(10); // 한 페이장 게시글 수
		bo.setStartNum((bo.getCurPage() - 1) * bo.getCountPerPage() + 1); // 한 페이지의 첫 글
		bo.setEndNum(bo.getStartNum() + (bo.getCountPerPage() - 1)); // 한 페이지의 마지막 글
		bo.setStartPage(bo.getCurPage() - (bo.getCurPage() - 1) % 5); // 한화면에 보여줄 페이지 목록 처음
		bo.setEndPage(4);// 한화면에 보여줄 페이지 목록 마지막
		bo.setTotalPages((int) Math.ceil(allClubCount / (double) bo.getCountPerPage())); // 총 페이지수
		req.setAttribute("bo", bo);

		List<ClubListView> clubs = sst.selectList("AdminMapper.getClubViewList", bo);
		req.setAttribute("clubs", clubs);
	}

	public void regClubInfo(ClubDTO c) {
		sst.insert("AdminMapper.regClubInfo", c);
	}

	public void insertClubImages(List<ClubImageDTO> images) {
		sst.insert("AdminMapper.insertClubImages", images);
	}
	
	public ClubListView getClubDetail(int id) {
		return sst.selectOne("AdminMapper.getClubDetail", id);
	}
	
	public List<ClubImageDTO> getClubImages(int id) {
		return sst.selectList("AdminMapper.getClubImages", id);
	} 

	public int updateImage(HttpServletRequest req, ClubImageDTO ci, MultipartFile multipartFile) {
		return 1;
	}


}
