package com.tm.nmp.community;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CM_BS_DAO {

	@Autowired
	private SqlSession ss;

	public void getAllBaseball(HttpServletRequest req, CM_BS_TITLE bs) {
		List<CM_BS_TITLE> baseball = ss.getMapper(BaseballMapper.class).getAllbaseball(bs);
		
		req.setAttribute("balseball", baseball);
		
	}
	
	
}
