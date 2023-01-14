package com.tm.nmp.admin;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AnswerDAO {
	
	@Autowired
	private SqlSession ss;

	public void getAnswerAll(HttpServletRequest req) {
		
		req.setAttribute("answers", ss.getMapper(AdminMapper.class).getAnswerAll());
		
	}
	
	

}
