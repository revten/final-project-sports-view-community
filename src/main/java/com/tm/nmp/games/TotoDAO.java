package com.tm.nmp.games;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.tm.nmp.account.AccountDTO;
import com.tm.nmp.mypage.MyPageMapper;

@Service
public class TotoDAO {
	
	private int allPostCount;
	
	@Autowired
	private SqlSession ss;
	
	@Autowired
	private SiteOption so;
	
	public int getAllPostCount() {
		return allPostCount;
	}

	public void setAllPostCount(int allPostCount) {
		this.allPostCount = allPostCount;
	}
	
	public void calcAllPostCount() {
		TotoSelector ttSel = new TotoSelector("",null,null);
		allPostCount = ss.getMapper(GamesMapper.class).getAllTotoPostCount(ttSel);
	}
	

	public void getTotoAll(HttpServletRequest req, int pageNo) {
		
		int count = so.getPostCountPerPage();
		int start = (pageNo -1) * count + 1;
		int end = start + (count - 1);
		
		TotoSelector search = (TotoSelector) req.getSession().getAttribute("search");
		int postCount = 0;
		if (search == null) {
			search = new TotoSelector("", new BigDecimal(start), new BigDecimal(end));
			postCount = allPostCount;
		} else {
			search.setStart(new BigDecimal(start));
			search.setEnd(new BigDecimal(end));
			postCount = ss.getMapper(GamesMapper.class).getAllTotoPostCount(search);
		}
		
		List<TotoDTO> posts = ss.getMapper(GamesMapper.class).getTotoAll(search);
		
		int pageCount = (int) Math.ceil(postCount / (double) count);
		req.setAttribute("pageCount", pageCount);
		
		req.setAttribute("totos", posts);
		req.setAttribute("curPage", pageNo);
		
	}

	public void getToto(HttpServletRequest req, TotoDTO tt) {
		TotoDTO post = ss.getMapper(GamesMapper.class).getToto(tt);
		post.setToto_comments(ss.getMapper(GamesMapper.class).getAllTotocomment(tt));
		req.setAttribute("toto", post); // 
		
	}

	public void updateToto(HttpServletRequest req, TotoDTO tt) {
		
		if (ss.getMapper(GamesMapper.class).updateToto(tt) == 1) {
			System.out.println("수정 성공");
		} else {
			System.out.println("수정 실패");
		}
		
	}

	public void deleteToto(HttpServletRequest req, TotoDTO tt) {
		
		if (ss.getMapper(GamesMapper.class).deleteToto(tt) == 1) {
			System.out.println("삭제 성공");
		} else {
			System.out.println("삭제 실패");
		}
	}

	public void insertToto(HttpServletRequest req, TotoDTO tt) {
		
		String path = req.getSession().getServletContext().getRealPath("resources/files/totoImg");
		MultipartRequest mr = null;
		System.out.println(path);
		
		AccountDTO loginMember = (AccountDTO) req.getSession().getAttribute("loginAccount");
		String toto_id = loginMember.getAc_id();
		String toto_nick = loginMember.getAc_nick();
		
		try {
			mr = new MultipartRequest(req, path, 30*1024*1024, "utf-8", new DefaultFileRenamePolicy());
			
			
			String toto_cat = mr.getParameter("toto_cat");
			String toto_title = mr.getParameter("toto_title");
			String toto_content = mr.getParameter("toto_content");
			toto_content = toto_content.replace("\r\n", "<br>");
			String toto_img = mr.getFilesystemName("toto_img");
			String toto_video = mr.getFilesystemName("toto_video");
			int toto_count = 0;
			
			System.out.println(toto_id);
			System.out.println(toto_nick);
			System.out.println(toto_cat);
			System.out.println(toto_title);
			System.out.println(toto_content);
			System.out.println(toto_img);
			System.out.println(toto_video);
			System.out.println(toto_count);
			
			tt.setToto_id(toto_id);
			tt.setToto_nick(toto_nick);
			tt.setToto_cat(toto_cat);
			tt.setToto_title(toto_title);
			tt.setToto_content(toto_content);
			if(toto_img != null) {
				tt.setToto_img(toto_img);
			}else {
				tt.setToto_img(" ");
			}
			if(toto_video != null) {
				tt.setToto_video(toto_video);
			}else {
				tt.setToto_video(" ");
			}
			tt.setToto_count(toto_count);
			
			
			
			if(ss.getMapper(GamesMapper.class).insertToto(tt)==1){
				req.setAttribute("r", "등록성공");
			}else {
				req.setAttribute("r", "등록실패");
				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
			String fileName1 = mr.getFilesystemName("toto_img");
			String fileName2 = mr.getFilesystemName("toto_vedio");
			new File(path + "/" + fileName1).delete();
			new File(path + "/" + fileName2).delete();
		}
	}
	
	public void searchToto(HttpServletRequest req, TotoSelector ttSel) {
		req.getSession().setAttribute("search", ttSel);
	}
	
	
	public void writeComment(HttpServletRequest req, TotoComment ttc) {

		String toto_no = req.getParameter("toto_no");
		ttc.setToto_comment_boardno(Integer.parseInt(toto_no));
		String a = ttc.getToto_comment_content();
		System.out.println(a);
		

		if (ss.getMapper(GamesMapper.class).writeTotoComment(ttc) == 1) {
			req.setAttribute("result", "댓글쓰기 성공");
		} else {
			req.setAttribute("result", "댓글쓰기실패");
		}
	}
	
	public void deleteComment(HttpServletRequest req, TotoComment ttc) {
		if (ss.getMapper(GamesMapper.class).deleteTotoComment(ttc) == 1) {
			req.setAttribute("result", "댓글삭제 성공");
		} else {
			req.setAttribute("result", "댓글삭제실패");
		}
		req.setAttribute("result", "댓글삭제실패");
	}
	
	public void updateComment(HttpServletRequest req, TotoComment ttc) {
		if (ss.getMapper(GamesMapper.class).updateTotoComment(ttc) == 1) {
			req.setAttribute("result", "댓글수정 성공");
		} else {
			req.setAttribute("result", "댓글수정 실패");
		}
		req.setAttribute("result", "댓글수정 실패");
	}
	
	

}
