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
			rv.setRv_cat((String) req.getAttribute("rv_cat"));
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
		req.setAttribute("rv_cat", req.getParameter("rv_cat"));

		if (ss.getMapper(ReviewMapper.class).deleteReviewPost(rv) == 1) {
			System.out.println("삭제 성공");
		} else {
			System.out.println("삭제 실패");
		}
	}

	public void updateReview(HttpServletRequest req, CM_RV_TITLE rv) {
		req.setAttribute("wg_cat", req.getParameter("rv_cat"));

		AccountDTO account = (AccountDTO) req.getSession().getAttribute("loginAccount");
		rv.setRv_id(account.getAc_id());

		String str = rv.getRv_content();
		System.out.println("전체 경로 :" + str);
		String[] contentSplit = str.split("/");
		String topSplit = contentSplit[5];
		System.out.println("첫번째 경로 :" + topSplit);
		String[] midSplit = topSplit.split("\"");
		System.out.println("중간 경로 :" + midSplit);
		String bottomSplit = midSplit[0];
		System.out.println("최종 경로 :" + bottomSplit);

		rv.setRv_img(bottomSplit);
		if (ss.getMapper(ReviewMapper.class).updateReviewPost(rv) == 1) {
			System.out.println("수정 성공");
		} else {
			System.out.println("수정 실패");
		}
	}
	
	public void regReview(HttpServletRequest req, CM_RV_TITLE rv) {
		// ck에디터 그대로 복붙하면 됨
		AccountDTO account = (AccountDTO) req.getSession().getAttribute("loginAccount");
		// loginAccount 가져오는 내용
		rv.setRv_id(account.getAc_id());
		rv.setRv_nick(account.getAc_nick());
		// wg_id(해당 게시판 작성자 아이디인데 DB설계 시 관계형으로 생성을 했기 때문에 어카운트의 ac_id를 set설정해줘야 한다)
		String str = rv.getRv_content();
		// wg_content(게시판 컨텐츠 sc_content)
		System.out.println("전체 경로 :" + str);
		// wg_img 삽입을 위해(전체 경로에서 split하는 내용임)
		String[] contentSplit = str.split("/");
		String topSplit = contentSplit[5];
		System.out.println("첫번째 경로 :" + topSplit);
		String[] midSplit = topSplit.split("\"");
		System.out.println("중간 경로 :" + midSplit);
		String bottomSplit = midSplit[0];
		System.out.println("최종 경로 :" + bottomSplit);
		
		rv.setRv_img(bottomSplit);
		//위 split 내용을 wg_img 컬럼에 set해준 것

		if (ss.getMapper(ReviewMapper.class).writeReviewPost(rv) == 1) {
			System.out.println("등록 성공");
		} else {
			System.err.println("실패");
		}
	}
}
