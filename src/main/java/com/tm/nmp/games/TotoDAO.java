package com.tm.nmp.games;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tm.nmp.mypage.MyPageMapper;

@Service
public class TotoDAO {
	
	@Autowired
	private SqlSession ss;

	public void getTotoAll(HttpServletRequest req) {
		
		req.setAttribute("totos", ss.getMapper(GamesMapper.class).getTotoAll());
		
	}

	public void getToto(HttpServletRequest req, TotoDTO tt) {
		
		req.setAttribute("toto", ss.getMapper(GamesMapper.class).getToto(tt));
	}

	public void updateToto(HttpServletRequest req, TotoDTO tt) {
		
		if (ss.getMapper(GamesMapper.class).updateToto(tt) == 1) {
			System.out.println("수정 성공");
		} else {
			System.out.println("수정 실패");
		}
		
	}

	public void deleteToto(HttpServletRequest req, TotoDTO tt) {
		
		if (ss.getMapper(GamesMapper.class).deleteToto(tt) == 1) {
			System.out.println("삭제 성공");
		} else {
			System.out.println("삭제 실패");
		}
	}
	
	

}
