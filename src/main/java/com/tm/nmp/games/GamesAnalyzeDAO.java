package com.tm.nmp.games;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tm.nmp.account.AccountDTO;

@Service
public class GamesAnalyzeDAO {

	private int allPostCount;

	@Autowired
	private SqlSession ss;


	private SiteOption so; // 한페이지에 몇개씩 보여줄것인지 밖으로 빼~기

	public int getAllPostCount() {
		return allPostCount;
	}

	public void setAllPostCount(int allPostCount) {
		this.allPostCount = allPostCount;
	} 

	public void calcAllPostCount() {
		GamesSelector gSel = new GamesSelector("", null, null);
		allPostCount = ss.getMapper(GamesAnalyzeBoardMapper.class).getAllAnalyzePostCount(gSel);
	}

	public void getAllPost(HttpServletRequest req, int pageNo) {

		int count = so.getPostCountPerPage();
		int start = (pageNo - 1) * count + 1;
		int end = start + (count - 1);
		
		// 조회/검색
		GamesSelector search = (GamesSelector) req.getSession().getAttribute("search");
		int postCount = 0;
		if (search == null) {
			search = new GamesSelector("", new BigDecimal(start), new BigDecimal(end));
			postCount = allPostCount;
		} else {
			search.setStart(new BigDecimal(start));
			search.setEnd(new BigDecimal(end));
			postCount = ss.getMapper(GamesAnalyzeBoardMapper.class).getAllAnalyzePostCount(search);
		}

		// 체크
		List<GamesAnalyzeBoard> posts = ss.getMapper(GamesAnalyzeBoardMapper.class).getAllAnalyzePost(search);

//		for (GamesAnalyzeBoard post : posts) {
//			post.anlyz_cmnts(ss.getMapper( .class).getReply(post));
//		}

		int pageCount = (int) Math.ceil(postCount / (double) count);
		req.setAttribute("pageCount", pageCount);

		req.setAttribute("posts", posts);
		req.setAttribute("curPage", pageNo);
	}
	

	public void getPost(HttpServletRequest req, GamesAnalyzeBoard gp) {
		GamesAnalyzeBoard post  = ss.getMapper(GamesAnalyzeBoardMapper.class).getAnalyzePost(gp);
		post.setAnlyz_cmnts(ss.getMapper(GamesAnalyzeBoardMapper.class).getAllAnalyzeCmnt(gp));
		req.setAttribute("post", post);
	}

	public void writePost(HttpServletRequest req, GamesAnalyzeBoard gp) {
		String token = req.getParameter("token");
		String successToken = (String) req.getSession().getAttribute("successToken");
		// 맨처음 글등록 - 189
		if (token.equals(successToken)) {
			return;
		}

		AccountDTO ac = (AccountDTO) req.getSession().getAttribute("loginAccount");
		gp.setAnlyz_id(ac.getMember_id());
		String gp_txt = gp.getAnlyz_content();
		gp.setAnlyz_content(gp_txt.replace("\r\n", "<br>"));

		if (ss.getMapper(GamesAnalyzeBoardMapper.class).writeAnalyzePost(gp) == 1) {
			req.setAttribute("result", "글쓰기 성공");
			req.getSession().setAttribute("successToken", token);
			// 처음 쓰면 189
			allPostCount++;
		} else {
			req.setAttribute("result", "글쓰기실패");
		}
	}

	public void deletePost(HttpServletRequest req, GamesAnalyzeBoard gp) {
		if (ss.getMapper(GamesAnalyzeBoardMapper.class).deleteAnalyzePost(gp) == 1) {
			req.setAttribute("result", "글삭제 성공");
			allPostCount--;
		} else {
			req.setAttribute("result", "글삭제실패");
		}
		req.setAttribute("result", "글삭제실패");
	}

	public void updatePost(HttpServletRequest req, GamesAnalyzeBoard gp) {
		if (ss.getMapper(GamesAnalyzeBoardMapper.class).updateAnalyzePost(gp) == 1) {
			req.setAttribute("result", "글수정 성공");
		} else {
			req.setAttribute("result", "글수정 실패");
		}
		req.setAttribute("result", "글수정 실패");
	}


	// 리플 부분
/*	public void writeCmnt(HttpServletRequest req, GamesAnalyzeCmnt gc) {
		String token = req.getParameter("token");
		String successToken = (String) req.getSession().getAttribute("successToken");

		if (successToken != null && token.equals(successToken)) {
			return;
		}

		AccountDTO ac = (AccountDTO) req.getSession().getAttribute("loginAccount");
		gc.setANLYZ_CMNT_BLNGD(ac.getAc_id());

		if (ss.getMapper(GamesAnalyzeCmntMapper.class).writeCmnt(gc) == 1) {
			req.setAttribute("result", "댓글쓰기 성공");
			req.getSession().setAttribute("successToken", token);
			allCmntCount++;
		} else {
			req.setAttribute("result", "댓글쓰기실패");
		}
	}

	public void deleteCmnt(HttpServletRequest req, GamesAnalyzeCmnt gc) {
		if (ss.getMapper(GamesAnalyzeCmntMapper.class).deleteCmnt(gc) == 1) {
			req.setAttribute("result", "댓글삭제 성공");
			allPostCount--;
		} else {
			req.setAttribute("result", "댓글삭제실패");
		}
		req.setAttribute("result", "댓글삭제실패");
	}

	public void updateCmnt(HttpServletRequest req, GamesAnalyzeCmnt gc) {
		if (ss.getMapper(GamesAnalyzeCmntMapper.class).updateCmnt(gc) == 1) {
			req.setAttribute("result", "댓글수정 성공");
		} else {
			req.setAttribute("result", "댓글수정 실패");
		}
		req.setAttribute("result", "댓글수정 실패");
	}*/

	public void searchPost(HttpServletRequest req, GamesSelector gSel) {
		req.getSession().setAttribute("search", gSel);
	}

}
