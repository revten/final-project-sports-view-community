package com.tm.nmp.games;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TotoDAO {
	
	@Autowired
	private SqlSession ss;

	public void getTotoAll(HttpServletRequest req) {
		
		req.setAttribute("totos", ss.getMapper(GamesMapper.class).getTotoAll());
		
	}
	
	

}
