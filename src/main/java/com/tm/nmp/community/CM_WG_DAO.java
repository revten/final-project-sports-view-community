package com.tm.nmp.community;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tm.nmp.account.AccountDTO;

@Service
public class CM_WG_DAO {

	@Autowired
	private SqlSession ss;

	public void showWithGoList(HttpServletRequest req, CM_WG_TITLE wg) {
		wg.setWg_cat(wg.getWg_cat());
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
			System.out.println("numResult  : " + numResult);

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

	public void updateWithGo(HttpServletRequest req, CM_WG_TITLE wg) {
		req.setAttribute("wg_cat", req.getParameter("wg_cat"));
		
		AccountDTO account = (AccountDTO) req.getSession().getAttribute("loginAccount");
		wg.setWg_id(account.getAc_id());
		
		String str = wg.getWg_content();
		System.out.println("전체 경로 :" + str);
		String[] contentSplit = str.split("/");
		String topSplit = contentSplit[5];
		System.out.println("첫번째 경로 :" + topSplit);
		String[] midSplit = topSplit.split("\"");
		System.out.println("중간 경로 :" + midSplit);
		String bottomSplit = midSplit[0];
		System.out.println("최종 경로 :" + bottomSplit);
		
		wg.setWg_img(bottomSplit);
		if (ss.getMapper(WithGoMapper.class).updateWithGoPost(wg) == 1) {
			System.out.println("수정 성공");
		} else {
			System.out.println("수정 실패");
		}
	}

	public void regWithGo(HttpServletRequest req, CM_WG_TITLE wg) {
		// ck에디터 그대로 복붙하면 됨
		AccountDTO account = (AccountDTO) req.getSession().getAttribute("loginAccount");
		// loginAccount 가져오는 내용
		wg.setWg_id(account.getAc_id());
		// wg_id(해당 게시판 작성자 아이디인데 DB설계 시 관계형으로 생성을 했기 때문에 어카운트의 ac_id를 set설정해줘야 한다)
		String str = wg.getWg_content();
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
		
		wg.setWg_img(bottomSplit);
		//위 split 내용을 wg_img 컬럼에 set해준 것

		if (ss.getMapper(WithGoMapper.class).writeWithGoPost(wg) == 1) {
			System.out.println("등록 성공");
		} else {
			System.err.println("실패");
		}

	}
}
