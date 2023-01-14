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
	
	

}
