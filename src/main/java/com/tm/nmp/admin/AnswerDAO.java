package com.tm.nmp.admin;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tm.nmp.mypage.MyPageMapper;


@Service
public class AnswerDAO {
	
	@Autowired
	private SqlSession ss;

	public void getAnswerAll(HttpServletRequest req) {
		
		req.setAttribute("answers", ss.getMapper(AdminMapper.class).getAnswerAll());
		
	}

	public void getAnswer(HttpServletRequest req, AnswerDTO as) {
		
		req.setAttribute("answer", ss.getMapper(AdminMapper.class).getAnswer(as));
		
	}

	public void updateAnswer(HttpServletRequest req, AnswerDTO as) {

		if (ss.getMapper(AdminMapper.class).updateAnswer(as) == 1) {
			System.out.println("수정 성공");
		} else {
			System.out.println("수정 실패");
		}
		
	}

	public void deleteAnswer(HttpServletRequest req, AnswerDTO as) {

		if (ss.getMapper(AdminMapper.class).deleteAnswer(as) == 1) {
			System.out.println("삭제 성공");
		} else {
			System.out.println("삭제 실패");
		}
	}
	
	

}
