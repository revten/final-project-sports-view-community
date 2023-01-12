package com.tm.nmp.community;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tm.nmp.account.AccountDTO;

@Service
public class CM_WG_DAO {

	@Autowired
	private SqlSession ss;
	
	public void showWithGoList(HttpServletRequest req, CM_WG_TITLE wg) {

		if (wg.getSearch() == null) { // 검색기능
			wg.setSearch("");
		} else {
			req.setAttribute("search", wg.getSearch());
		}

		if (wg.getSort() == 1) { // 1 == 조회수 , 2 == 좋아요 정렬
			req.setAttribute("sort", 1);
		} else if (wg.getSort() == 2) {
			req.setAttribute("sort", 2);
		} else {
			req.setAttribute("sort", 0);
		}

		System.out.println("카테고리 :" + wg.getWg_cat());
		int allPost = ss.getMapper(WithGoMapper.class).getWithGoPostCount(wg);
		int totalPage = (int) Math.ceil((double) allPost / 10);
		req.setAttribute("r", totalPage); // r = 총 페이지 수

		String vpage = req.getParameter("vpage");
		if (vpage == null) {
			vpage = "1";
		}

		int page = Integer.parseInt(vpage);

		if (page != 1) {
			wg.setRnStart(page * 10 - 9);
			wg.setRnEnd(page * 10);
		} else {
			wg.setRnStart(1);
			wg.setRnEnd(10);
		}

		List<CM_WG_TITLE> posts = ss.getMapper(WithGoMapper.class).getWithGoPostList(wg);

		req.setAttribute("posts", posts);

	}

	public void showWithGoDetail(HttpServletRequest req, CM_WG_TITLE wg) {

		CM_WG_TITLE p = ss.getMapper(WithGoMapper.class).WithGoPostDetail(wg);

		req.setAttribute("p", p);
	}

	public int withGoWrite(HttpServletRequest req, CM_WG_TITLE wg) {
		int numResult = 0;
		
		if (wg.getWg_cat() == null) {
			wg.setWg_cat((String) req.getAttribute("wg_cat"));
		}
		

		if (ss.getMapper(WithGoMapper.class).writeWithGoPost(wg) == 1) {
			System.out.println("등록 성공");
			req.setAttribute("wg_cat", wg.getWg_cat());
			
			numResult = ss.getMapper(WithGoMapper.class).getWithGoPostNum(wg);
			System.out.println("numResult  : "+numResult);
			
		} else {
			System.out.println("등록 실패");
		}
		
		return numResult;

	}

	public void deleteWithGo(HttpServletRequest req, CM_WG_TITLE wg) {
		req.setAttribute("wg_cat", req.getParameter("wg_cat"));
		
		if (ss.getMapper(WithGoMapper.class).deleteWithGoPost(wg) == 1) {
			System.out.println("삭제 성공");
		} else {
			System.out.println("삭제 실패");
		}
	}

	public void updateWithGo(HttpServletRequest req, AccountDTO ac, CM_WG_TITLE wg) {
		req.setAttribute("wg_cat", req.getParameter("wg_cat"));
		
		if (ss.getMapper(WithGoMapper.class).updateWithGoPost(wg) == 1) {
			System.out.println("수정 성공");
		} else {
			System.out.println("수정 실패");
		}
	}
}
