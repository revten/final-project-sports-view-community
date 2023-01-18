package com.tm.nmp.community;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.tm.nmp.account.AccountDTO;

@Service
public class CM_SC_DAO {
	
	private int allPostCount;

	@Autowired
	private SqlSession ss;
	

	public int getAllPostCount() {
		return allPostCount;
	}

	public void setAllPostCount(int allPostCount) {
		this.allPostCount = allPostCount;
	}
	
	public void calcAllPostCount() {
		SoccerSelector scSel = new SoccerSelector("",null,null);
		allPostCount = ss.getMapper(SoccerMapper.class).getAllSoccerPostCount(scSel);
	}

	public void getSoccerBoard(HttpServletRequest req, int pageNo) {
		
		int count = 10;
		int start = (pageNo -1) * count + 1;
		int end = start + (count - 1);
		
		SoccerSelector search = (SoccerSelector) req.getSession().getAttribute("search");
		int postCount = 0;
		if (search == null) {
			search = new SoccerSelector("", new BigDecimal(start), new BigDecimal(end));
			postCount = allPostCount;
		} else {
			search.setStart(new BigDecimal(start));
			search.setEnd(new BigDecimal(end));
			postCount = ss.getMapper(SoccerMapper.class).getAllSoccerPostCount(search);
		}
		
		List<CM_SC_TITLE> posts = ss.getMapper(SoccerMapper.class).getSoccerBoard(search);
		
		int pageCount = (int) Math.ceil(postCount / (double) count);
		req.setAttribute("pageCount", pageCount);
		
		req.setAttribute("soccer", posts);
		req.setAttribute("curPage", pageNo);

	}

	public void getSoccerDetail(HttpServletRequest req, CM_SC_TITLE sc) {
		CM_SC_TITLE soccer = ss.getMapper(SoccerMapper.class).getSoccer(sc);
		soccer.setCm_sc_comments(ss.getMapper(SoccerMapper.class).getAllcomment(sc));
		req.setAttribute("soccer", soccer);
	}

	public void deleteSoccer(HttpServletRequest req, CM_SC_TITLE sc) {
		if (ss.getMapper(SoccerMapper.class).deleteSoccer(sc) == 1) {
			req.setAttribute("result", "삭제성공");
		} else {
			req.setAttribute("result", "삭제실패");
		}
	}

	public void updateSoccer(HttpServletRequest req, CM_SC_TITLE sc) {
		if (ss.getMapper(SoccerMapper.class).updateSoccer(sc) == 1) {
			req.setAttribute("result", "수정성공");
		} else {
			req.setAttribute("result", "수정실패");
		}
	}

	public void insertSoccerBoard(HttpServletRequest req, CM_SC_TITLE sc) {
		String path = req.getSession().getServletContext().getRealPath("resources/files/soccer_img");
		System.out.println(path);
		
		AccountDTO loginMember = (AccountDTO) req.getSession().getAttribute("loginAccount");
		String id = loginMember.getAc_id();
		String nick = loginMember.getAc_name();
		
		try {

			MultipartRequest mr = new MultipartRequest(req, path, 10 * 1024 * 1024, "utf-8",
					new DefaultFileRenamePolicy());

			String cat = mr.getParameter("cm_sc_cat");
			String title = mr.getParameter("cm_sc_title");
			String content = mr.getParameter("cm_sc_content");
			String img = mr.getFilesystemName("cm_sc_img");
			String video = mr.getFilesystemName("cm_sc_video");


			System.out.println(cat);
			System.out.println(title);
			System.out.println(content);
			System.out.println(img);
			System.out.println(video);
			System.out.println(id);
			System.out.println(nick);

			sc.setCm_sc_cat(cat);
			sc.setCm_sc_title(title);
			sc.setCm_sc_content(content);
			sc.setCm_sc_img(img);
			sc.setCm_sc_video(video);
			sc.setCm_sc_id(id);
			sc.setCm_sc_nick(nick);

			if (ss.getMapper(SoccerMapper.class).insertSoccer(sc) == 1) {
				req.setAttribute("result", "등록성공");
			} else {
				req.setAttribute("result", "등록실패");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public void searchCM_SC(HttpServletRequest req, SoccerSelector scSel) {
		req.getSession().setAttribute("search", scSel);
	}
	
	public void writeComment(HttpServletRequest req, CM_SC_CommentDTO scc) {

		String cm_sc_no = req.getParameter("cm_sc_no");
		scc.setCm_sc_comment_boardno(Integer.parseInt(cm_sc_no));
		String a = scc.getCm_sc_comment_content();
		System.out.println(a);
		

		if (ss.getMapper(SoccerMapper.class).writeSoccerComment(scc) == 1) {
			req.setAttribute("result", "댓글쓰기 성공");
		} else {
			req.setAttribute("result", "댓글쓰기실패");
		}
	}
	
	public void deleteComment(HttpServletRequest req, CM_SC_CommentDTO scc) {
		if (ss.getMapper(SoccerMapper.class).deleteSoccerComment(scc) == 1) {
			req.setAttribute("result", "댓글삭제 성공");
		} else {
			req.setAttribute("result", "댓글삭제실패");
		}
		req.setAttribute("result", "댓글삭제실패");
	}
	
	public void updateComment(HttpServletRequest req, CM_SC_CommentDTO scc) {
		if (ss.getMapper(SoccerMapper.class).updateSoccerComment(scc) == 1) {
			req.setAttribute("result", "댓글수정 성공");
		} else {
			req.setAttribute("result", "댓글수정 실패");
		}
		req.setAttribute("result", "댓글수정 실패");
	}
	
	

}
