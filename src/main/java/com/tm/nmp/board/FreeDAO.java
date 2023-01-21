package com.tm.nmp.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tm.nmp.account.AccountDTO;
import com.tm.nmp.games.GamesAnalyzeCmnt;

@Service
public class FreeDAO {

	@Autowired
	private SqlSession ss;

	@Autowired
	private BoardOption bo;

	private int allPostCount;

	public int getallPostCount() {
		return allPostCount;
	}

	public void setallPostCount(int allPostCount) {
		this.allPostCount = allPostCount;
	}

	public void calcAllPostCount(int board_id) {
		BoardSelector bSel = new BoardSelector("", 0, 0, board_id);
		allPostCount = ss.getMapper(FreeMapper.class).calcAllPostCOunt(bSel);
	}

	public void getAllPost(HttpServletRequest req, int pageNbr, int board_id) {

		int count = bo.getCountPerPage();
		int start = (pageNbr - 1) * count + 1;
		int end = start + (count - 1);

		BoardSelector search = (BoardSelector) req.getSession().getAttribute("search");
		int postCount = 0;

		if (search == null) {
			search = new BoardSelector("", start, end, board_id);
			postCount = allPostCount;
		} else {
			search.setStart(start);
			search.setEnd(end);
			postCount = ss.getMapper(FreeMapper.class).calcAllPostCOunt(search);

		}

		List<PostVO> posts = ss.getMapper(FreeMapper.class).getAllPost(search);
		req.setAttribute("posts", posts);

		int pageCount = (int) Math.ceil(postCount / (double) count);
		req.setAttribute("pageCount", pageCount);
		req.setAttribute("curPage", pageNbr);
	}

	public void searchPost(HttpServletRequest req, BoardSelector bSel) {
		req.getSession().setAttribute("search", bSel);
	}

	public void getPost(HttpServletRequest req, PostVO p) {
		PostVO post = ss.getMapper(FreeMapper.class).getPost(p);
		post.setReplies(ss.getMapper(FreeMapper.class).getAllReplies(p));
		req.setAttribute("post", post);
	}

	public void regPost(HttpServletRequest req, PostVO p) {
		String token = req.getParameter("token");
		String successToken = (String) req.getSession().getAttribute("successToken");
		// 맨처음 글등록 - 189
		if (token.equals(successToken)) {
			return;
		}

		AccountDTO ac = (AccountDTO) req.getSession().getAttribute("loginAccount");
		p.setMember_id(ac.getMember_id());
		String p_txt = p.getPost_content();
		System.out.println("전체 경로 :" + p_txt);
		String[] contentSplit = p_txt.split("/");
		String topSplit = contentSplit[5];
		System.out.println("첫번째 경로 :" + topSplit);
		String[] midSplit = topSplit.split("\"");
		System.out.println("중간 경로 :" + midSplit);
		String bottomSplit = midSplit[0];
		System.out.println("최종 경로 :" + bottomSplit);

		p.setPost_img(bottomSplit);
		// 위 split 내용을 wg_img 컬럼에 set해준 것

//		p.setPost_content(p_txt.replace("\r\n", "<br>"));

		if (ss.getMapper(FreeMapper.class).regPost(p) == 1) {
			System.out.println("글 등록 성공");
			req.getSession().setAttribute("successToken", token);
			allPostCount++;
		} else {
			System.err.println("글 등록 실패");
		}
	}

	public void deletePost(HttpServletRequest req, PostVO p) {
		if (ss.getMapper(FreeMapper.class).deletePost(p) == 1) {
			req.setAttribute("result", "글삭제 성공");
			allPostCount--;
		} else {
			req.setAttribute("result", "글삭제실패");
		}
		req.setAttribute("result", "글삭제실패");
	}

	public void updatePost(HttpServletRequest req, PostVO p) {

		String str = p.getPost_content();
		System.out.println("전체 경로 :" + str);
		String[] contentSplit = str.split("/");
		String topSplit = contentSplit[5];
		System.out.println("첫번째 경로 :" + topSplit);
		String[] midSplit = topSplit.split("\"");
		System.out.println("중간 경로 :" + midSplit);
		String bottomSplit = midSplit[0];
		System.out.println("최종 경로 :" + bottomSplit);

		p.setPost_img(bottomSplit);

		if (ss.getMapper(FreeMapper.class).updatePost(p) == 1) {
			req.setAttribute("result", "글수정 성공");
		} else {
			req.setAttribute("result", "글수정 실패");
		}
		req.setAttribute("result", "글수정 실패");
	}
	
	
	
	public void regReply(HttpServletRequest req, ReplyVO rp) {
		String token = req.getParameter("token");
		String successToken = (String) req.getSession().getAttribute("successToken");

		if (successToken != null && token.equals(successToken)) {
			return;
		}

		AccountDTO ac = (AccountDTO) req.getSession().getAttribute("loginAccount");
		rp.setMember_id(ac.getMember_id());

		if (ss.getMapper(FreeMapper.class).regReply(rp) == 1) {
			req.setAttribute("result", "댓글쓰기 성공");
			req.getSession().setAttribute("successToken", token);
//			allReplyCount++;
		} else {
			req.setAttribute("result", "댓글쓰기실패");
		}
	}

	public void deleteReply(HttpServletRequest req, ReplyVO rp) {
		if (ss.getMapper(FreeMapper.class).deleteReply(rp) == 1) {
			req.setAttribute("result", "댓글삭제 성공");
			allPostCount--;
		} else {
			req.setAttribute("result", "댓글삭제실패");
		}
		req.setAttribute("result", "댓글삭제실패");
	}

	public void updateReply(HttpServletRequest req, ReplyVO rp) {
		if (ss.getMapper(FreeMapper.class).updateReply(rp) == 1) {
			req.setAttribute("result", "댓글수정 성공");
		} else {
			req.setAttribute("result", "댓글수정 실패");
		}
		req.setAttribute("result", "댓글수정 실패");
	}
}
