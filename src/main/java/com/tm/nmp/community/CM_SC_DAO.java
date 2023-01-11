package com.tm.nmp.community;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CM_SC_DAO {

	@Autowired
	private SqlSession ss;

	public void getSoccerBoard(HttpServletRequest req, CM_SC_TITLE sc) {

		List<CM_SC_TITLE> soccer = ss.getMapper(SoccerMapper.class).getSoccerBoard(sc);
		
		req.setAttribute("soccer", soccer);
	}

	public void getSoccerDetail(HttpServletRequest req,CM_SC_TITLE sc) {
		CM_SC_TITLE soccer = ss.getMapper(SoccerMapper.class).getSoccer(sc);
		req.setAttribute("soccer", soccer);
		
	}

	public void deleteSoccer(HttpServletRequest req, CM_SC_TITLE sc) {
		if(ss.getMapper(SoccerMapper.class).deleteSoccer(sc)==1) {
			req.setAttribute("result", "삭제성공");
		}else {
			req.setAttribute("result", "삭제실패");
		}
		
	}

	public void updateSoccer(HttpServletRequest req, CM_SC_TITLE sc) {
		if(ss.getMapper(SoccerMapper.class).updateSoccer(sc)==1) {
			req.setAttribute("result", "수정성공");
		}else {
			req.setAttribute("result", "수정실패");
		}
	}

	
	
}
