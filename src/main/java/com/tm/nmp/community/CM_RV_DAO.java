package com.tm.nmp.community;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tm.nmp.account.AccountDTO;

@Service
public class CM_RV_DAO {

	@Autowired
	private SqlSession ss;

	public void showReviewList(HttpServletRequest req, CM_RV_TITLE rv) {

		if (rv.getSearch() == null) { // 검색기능
			rv.setSearch("");
		} else {
			req.setAttribute("search", rv.getSearch());
		}

		if (rv.getSort() == 1) { // 1 == 조회수 , 2 == 좋아요 정렬
			req.setAttribute("sort", 1);
		} else if (rv.getSort() == 2) {
			req.setAttribute("sort", 2);
		} else {
			req.setAttribute("sort", 0);
		}

		System.out.println("카테고리 :" + rv.getRv_cat());
		int allPost = ss.getMapper(ReviewMapper.class).getReviewPostCount(rv);
		int totalPage = (int) Math.ceil((double) allPost / 10);
		req.setAttribute("r", totalPage); // r = 총 페이지 수

		String vpage = req.getParameter("vpage");
		if (vpage == null) {
			vpage = "1";
		}

		int page = Integer.parseInt(vpage);

		if (page != 1) {
			rv.setRnStart(page * 10 - 9);
			rv.setRnEnd(page * 10);
		} else {
			rv.setRnStart(1);
			rv.setRnEnd(10);
		}

		List<CM_RV_TITLE> posts = ss.getMapper(ReviewMapper.class).getReviewPostList(rv);

		req.setAttribute("posts", posts);

	}

	public void showReviewDetail(HttpServletRequest req, CM_RV_TITLE rv) {

		CM_RV_TITLE p = ss.getMapper(ReviewMapper.class).reviewPostDetail(rv);

		req.setAttribute("p", p);
	}

	public int ReviewWrite(HttpServletRequest req, CM_RV_TITLE rv) {
		int numResult = 0;

		if (rv.getRv_cat() == null) {
			rv.setRv_cat((String) req.getAttribute("Rv_cat"));
		}

		if (ss.getMapper(ReviewMapper.class).writeReviewPost(rv) == 1) {
			System.out.println("등록 성공");
			req.setAttribute("rv_cat", rv.getRv_cat());

			numResult = ss.getMapper(ReviewMapper.class).getReviewPostNum(rv);
			System.out.println("numResult  : " + numResult);

		} else {
			System.out.println("등록 실패");
		}

		return numResult;

	}

	public void deleteReview(HttpServletRequest req, CM_RV_TITLE rv) {
		req.setAttribute("rv_cat", req.getParameter("Rv_cat"));

		if (ss.getMapper(ReviewMapper.class).deleteReviewPost(rv) == 1) {
			System.out.println("삭제 성공");
		} else {
			System.out.println("삭제 실패");
		}
	}

	public void updateReview(HttpServletRequest req, AccountDTO ac, CM_RV_TITLE rv) {
		req.setAttribute("rv_cat", req.getParameter("rv_cat"));

		if (ss.getMapper(ReviewMapper.class).updateReviewPost(rv) == 1) {
			System.out.println("수정 성공");
		} else {
			System.out.println("수정 실패");
		}
	}
}
