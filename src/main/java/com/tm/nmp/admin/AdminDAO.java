package com.tm.nmp.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tm.nmp.board.BoardOption;

@Service
public class AdminDAO {
	
	@Autowired
	private SqlSession ss;
	
	private int allClubCount;
	
	
	public int calcAllClubCount(BoardOption bo) {
		allClubCount = ss.getMapper(AdminMapper.class).calcAllClubCount(bo);
		System.out.println("전체 구단 수 : " + allClubCount);
		return allClubCount;
	}

	public void regClubInfo(HttpServletRequest req, ClubDTO c) {
		if(ss.getMapper(AdminMapper.class).regClubInfo(c) == 1) {
			System.out.println("구단 등록 성공");
		} else {
			System.out.println("무결성 검증 실패");
		}
	}

	public void getClubViewList(HttpServletRequest req, BoardOption bo) {
		
//		allClubCount = calcAllClubCount();
//		System.out.println(allClubCount);
		req.getParameter("page");
	
		
		if(bo.getField() == null) {
			bo.setField("name");
		}
		if(bo.getSearch() == null) {
			bo.setSearch("");
		}		

		allClubCount = calcAllClubCount(bo); // 총 게시글 수
		System.out.println("조회구단수 : " + allClubCount);
		if(req.getParameter("page") == null) {
			bo.setCurPage(1); // 현재 보여주는 페이지
		} else {
			int page = Integer.parseInt(req.getParameter("page"));
			bo.setCurPage(page);
		}
		bo.setCountPerPage(3); // 한 페이장 게시글 수
		bo.setStartNum((bo.getCurPage() - 1) * bo.getCountPerPage() + 1);  // 한 페이지의 첫 글
		bo.setEndNum(bo.getStartNum() + (bo.getCountPerPage() - 1)); // 한 페이지의 마지막 글
		bo.setStartPage(bo.getCurPage()-(bo.getCurPage()-1)%5); // 한화면에 보여줄 페이지 목록 처음
		bo.setEndPage(4);// 한화면에 보여줄 페이지 목록 마지막
		bo.setTotalPages((int) Math.ceil(allClubCount / (double) bo.getCountPerPage())); // 총 페이지수
		req.setAttribute("bo", bo);
		
		List<ClubListView> clubs = ss.getMapper(AdminMapper.class).getClubViewList(bo);
		req.setAttribute("clubs", clubs);
	}
}
