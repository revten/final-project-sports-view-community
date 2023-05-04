package com.tm.nmp.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tm.nmp.board.BoardMapper;
import com.tm.nmp.board.BoardOption;
import com.tm.nmp.board.PostVO;

@Service
public class AdminDAO {
	
	@Autowired
	private SqlSession ss;
	
	@Autowired
	private BoardOption bo;
	
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

	public void getClubViewList(HttpServletRequest req, BoardOption bo) {
		// TODO Auto-generated method stub

//		String field = (String) req.getSession().getAttribute("field");
//		String search = (String) req.getSession().getAttribute("search");
//		
		String field = req.getParameter("field");
		System.out.println(field);
		String search = req.getParameter("search");
		System.out.println(search);
		
		if(field == null) {
			bo.setField("");
		} else {
			bo.setField(field);
		}
		
		if(search == null) {
			bo.setSearch("");
		} else {
			bo.setSearch(search);
		}

		List<ClubViewDTO> clubs = ss.getMapper(AdminMapper.class).getClubViewList(bo);
		req.setAttribute("clubs", clubs);
	}
}
