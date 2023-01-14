package com.tm.nmp.mypage;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyPostDAO {
	
	@Autowired
	private SqlSession ss;

	public void getMyPostAll(HttpServletRequest req, MyPostDTO mpt) {
		
		req.setAttribute("MyPosts", ss.getMapper(MyPageMapper.class).getMyPostAll());
		
	}
	
	

}
