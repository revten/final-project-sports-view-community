package com.tm.nmp.admin;

import java.util.ArrayList;
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
	
	public int calcAllClubCount() {
		return calcAllClubCount("", "");
	}
	
	public int calcAllClubCount(String field, String search) {
		allClubCount = ss.getMapper(AdminMapper.class).calcAllClubCount(field, search);
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

	public void getClubViewList(HttpServletRequest req) {
		// TODO Auto-generated method stub

//		String field = (String) req.getSession().getAttribute("field");
//		String search = (String) req.getSession().getAttribute("search");
		
		BoardOption bo = new BoardOption(0, "name", "", 0, 0, 0);
		
		String field = req.getParameter("field");
		System.out.println("field : " + field);
		String search = req.getParameter("search");
		System.out.println("search : " + search);
		
		if(field == null) {
			bo.setField("name");
		} else {
			bo.setField(field);
		}
		
		if(search == null) {
			bo.setSearch("");
		} else {
			bo.setSearch(search);
		}
		
		System.out.println("getField : " + bo.getField());
		System.out.println("getSearch : " + bo.getSearch());
		List<ClubView> clubs = new ArrayList<>();	
		clubs = ss.getMapper(AdminMapper.class).getClubViewList(bo);
		System.out.println(clubs.size());
		req.setAttribute("clubs", clubs);
	}
}
