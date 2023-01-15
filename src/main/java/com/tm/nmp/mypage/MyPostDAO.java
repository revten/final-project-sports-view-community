package com.tm.nmp.mypage;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tm.nmp.community.ReviewMapper;

@Service
public class MyPostDAO {
	
	@Autowired
	private SqlSession ss;

	public void getMyPostAll(HttpServletRequest req, MyPostDTO mpt) {
		
		req.setAttribute("MyPosts", ss.getMapper(MyPageMapper.class).getMyPostAll());
		
	}

	public void getMyPost(HttpServletRequest req, MyPostDTO mp) {
		
		req.setAttribute("MyPost", ss.getMapper(MyPageMapper.class).getMyPost(mp));
		
	}

	public void updateMyPost(HttpServletRequest req, MyPostDTO mp) {
		
		if (ss.getMapper(MyPageMapper.class).updateMyPost(mp) == 1) {
			System.out.println("수정 성공");
		} else {
			System.out.println("수정 실패");
		}
		
	}

	public void deleteMyPost(HttpServletRequest req, MyPostDTO mp) {
		
		if (ss.getMapper(MyPageMapper.class).deleteMyPost(mp) == 1) {
			System.out.println("삭제 성공");
		} else {
			System.out.println("삭제 실패");
		}
		
	}
	
	

}
