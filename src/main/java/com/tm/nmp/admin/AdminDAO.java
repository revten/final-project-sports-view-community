package com.tm.nmp.admin;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminDAO {
	
	@Autowired
	private SqlSession ss;

	public void regClubInfo(HttpServletRequest req, ClubDTO c) {
		if(ss.getMapper(AdminMapper.class).regClubInfo(c) == 1) {
			System.out.println("구단 등록 성공");
		} else {
			System.out.println("구단 등록 실패");
		}
	}
	

}
