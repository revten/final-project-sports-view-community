package com.tm.nmp.community;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tm.nmp.account.AccountDTO;

@Service
public class CommunityDAO {

	@Autowired
	private SqlSession ss;
	
	public void showWithGoList(HttpServletRequest req, CommunityDTO co) {

		if (co.getSearch() == null) { // 검색기능
			co.setSearch("");
		} else {
			req.setAttribute("search", co.getSearch());
		}

		if (co.getSort() == 1) { // 1 == 조회수 , 2 == 좋아요 정렬
			req.setAttribute("sort", 1);
		} else if (co.getSort() == 2) {
			req.setAttribute("sort", 2);
		} else {
			req.setAttribute("sort", 0);
		}

		System.out.println("카테고리 :" + co.getWg_cat());
		int allPost = ss.getMapper(CommunityMapper.class).getAllPostCount(co);
		int totalPage = (int) Math.ceil((double) allPost / 10);
		req.setAttribute("r", totalPage); // r = 총 페이지 수

		String vpage = req.getParameter("vpage");
		if (vpage == null) {
			vpage = "1";
		}

		int page = Integer.parseInt(vpage);

		if (page != 1) {
			co.setRnStart(page * 10 - 9);
			co.setRnEnd(page * 10);
		} else {
			co.setRnStart(1);
			co.setRnEnd(10);
		}

		List<CommunityDTO> posts = ss.getMapper(CommunityMapper.class).getPostList(co);

		req.setAttribute("posts", posts);

	}

	public void showWithGoDetail(HttpServletRequest req, CommunityDTO co) {

		CommunityDTO p = ss.getMapper(CommunityMapper.class).postDetail(co);

		req.setAttribute("p", p);
	}

	public int withGoWrite(HttpServletRequest req, CommunityDTO co) {
		int numResult = 0;
		
		if (co.getWg_cat() == null) {
			co.setWg_cat((String) req.getAttribute("wg_cat"));
		}
		

		if (ss.getMapper(CommunityMapper.class).writePost(co) == 1) {
			System.out.println("등록 성공");
			req.setAttribute("wg_cat", co.getWg_cat());
			
			numResult = ss.getMapper(CommunityMapper.class).getPostNum(co);
			System.out.println("numResult  : "+numResult);
			
		} else {
			System.out.println("등록 실패");
		}
		
		return numResult;

	}

	public void deleteWithGo(HttpServletRequest req, CommunityDTO co) {
		req.setAttribute("wg_cat", req.getParameter("wg_cat"));
		
		if (ss.getMapper(CommunityMapper.class).deletePost(co) == 1) {
			System.out.println("삭제 성공");
		} else {
			System.out.println("삭제 실패");
		}
	}

	public void updateWithGo(HttpServletRequest req, AccountDTO ac, CommunityDTO co) {
		req.setAttribute("wg_cat", req.getParameter("wg_cat"));
		
		if (ss.getMapper(CommunityMapper.class).updatePost(co) == 1) {
			System.out.println("수정 성공");
		} else {
			System.out.println("수정 실패");
		}
	}
}
