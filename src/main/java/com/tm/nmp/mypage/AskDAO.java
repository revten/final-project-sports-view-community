package com.tm.nmp.mypage;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AskDAO {
	
	@Autowired
	private SqlSession ss;

	public void getAskAll(HttpServletRequest req) {
		
		req.setAttribute("Asks", ss.getMapper(MyPageMapper.class).getAskAll());
		
	}

	public void getAsk(HttpServletRequest req, AskDTO ask) {

		req.setAttribute("Ask", ss.getMapper(MyPageMapper.class).getAsk(ask));
		
	}

	public void updateAsk(HttpServletRequest req, AskDTO ask) {
		
		if (ss.getMapper(MyPageMapper.class).updateAsk(ask) == 1) {
			System.out.println("수정 성공");
		} else {
			System.out.println("수정 실패");
		}
		
	}

	public void deleteMyPost(HttpServletRequest req, AskDTO ask) {
		
		if (ss.getMapper(MyPageMapper.class).deleteAsk(ask) == 1) {
			System.out.println("삭제 성공");
		} else {
			System.out.println("삭제 실패");
		}
		
	}
	
	

}
