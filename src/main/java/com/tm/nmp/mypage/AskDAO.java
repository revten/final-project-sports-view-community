package com.tm.nmp.mypage;

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

@Service
public class AskDAO {
	
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
		AskSelector askSel = new AskSelector("",null,null);
		allPostCount = ss.getMapper(MyPageMapper.class).getAllAskCount(askSel);
	}

	public void getAskAll(HttpServletRequest req, int pageNo) {
		
		int count = 10;
		int start = (pageNo -1) * count + 1;
		int end = start + (count - 1);
		
		AskSelector search = (AskSelector) req.getSession().getAttribute("search");
		int postCount = 0;
		if (search == null) {
			search = new AskSelector("", new BigDecimal(start), new BigDecimal(end));
			postCount = allPostCount;
		} else {
			search.setStart(new BigDecimal(start));
			search.setEnd(new BigDecimal(end));
			postCount = ss.getMapper(MyPageMapper.class).getAllAskCount(search);
		}
		
		List<AskDTO> posts = ss.getMapper(MyPageMapper.class).getaskAll(search);
		
		int pageCount = (int) Math.ceil(postCount / (double) count);
		req.setAttribute("pageCount", pageCount);
		
		req.setAttribute("Asks", posts);
		req.setAttribute("curPage", pageNo);
		
		
	}

	public void getAsk(HttpServletRequest req, AskDTO ask) {
		AskDTO post = ss.getMapper(MyPageMapper.class).getAsk(ask);
		post.setAsk_comments(ss.getMapper(MyPageMapper.class).getAllAskComment(ask));
		req.setAttribute("ask", post);
		
	}

	public void updateAsk(HttpServletRequest req, AskDTO ask) {
		
		if (ss.getMapper(MyPageMapper.class).updateAsk(ask) == 1) {
			System.out.println("수정 성공");
		} else {
			System.out.println("수정 실패");
		}
		
	}

	public void deleteAsk(HttpServletRequest req, AskDTO ask) {
		
		if (ss.getMapper(MyPageMapper.class).deleteAsk(ask) == 1) {
			System.out.println("삭제 성공");
		} else {
			System.out.println("삭제 실패");
		}
		
	}

	public void insertAsk(HttpServletRequest req, AskDTO ask) {
		String path = req.getSession().getServletContext().getRealPath("resources/files/AskImg");
		MultipartRequest mr = null;
		System.out.println(path);
		
		AccountDTO loginMember = (AccountDTO) req.getSession().getAttribute("loginAccount");
		String ask_id = loginMember.getAc_id();
		String ask_nick = loginMember.getAc_nick();
		
		try {
			mr = new MultipartRequest(req, path, 30*1024*1024, "utf-8", new DefaultFileRenamePolicy());
			
			
			String ask_cat = mr.getParameter("ask_cat");
			String ask_title = mr.getParameter("ask_title");
			String ask_content = mr.getParameter("ask_content");
			ask_content = ask_content.replace("\r\n", "<br>");
			String ask_img = mr.getFilesystemName("ask_img");
			String ask_video = mr.getFilesystemName("ask_video");
			int ask_count = 0;
			
			System.out.println(ask_id);
			System.out.println(ask_nick);
			System.out.println(ask_cat);
			System.out.println(ask_title);
			System.out.println(ask_content);
			System.out.println(ask_img);
			System.out.println(ask_video);
			System.out.println(ask_count);
			
			ask.setAsk_id(ask_id);
			ask.setAsk_nick(ask_nick);
			ask.setAsk_cat(ask_cat);
			ask.setAsk_title(ask_title);
			ask.setAsk_content(ask_content);
			if(ask_img != null) {
				ask.setAsk_img(ask_img);
			}else {
				ask.setAsk_img(" ");
			}
			if(ask_video != null) {
				ask.setAsk_video(ask_video);
			}else {
				ask.setAsk_video(" ");
			}
			ask.setAsk_count(ask_count);
			
			
			
			if(ss.getMapper(MyPageMapper.class).insertAsk(ask)==1){
				req.setAttribute("r", "등록성공");
			}else {
				req.setAttribute("r", "등록실패");
				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
			String fileName1 = mr.getFilesystemName("ask_img");
			String fileName2 = mr.getFilesystemName("ask_vedio");
			new File(path + "/" + fileName1).delete();
			new File(path + "/" + fileName2).delete();
		}
		
	}

	public void writeComment(HttpServletRequest req, AskComment askC) {

		String ask_no = req.getParameter("ask_no");
		askC.setAsk_comment_boardno(Integer.parseInt(ask_no));
		String a = askC.getAsk_comment_content();
		System.out.println(a);
		

		if (ss.getMapper(MyPageMapper.class).writeAskComment(askC) == 1) {
			req.setAttribute("result", "댓글쓰기 성공");
		} else {
			req.setAttribute("result", "댓글쓰기실패");
		}
	}
	
	public void deleteCemment(HttpServletRequest req, AskComment askC) {
		if (ss.getMapper(MyPageMapper.class).deleteAskComment(askC) == 1) {
			req.setAttribute("result", "댓글삭제 성공");
		} else {
			req.setAttribute("result", "댓글삭제실패");
		}
		req.setAttribute("result", "댓글삭제실패");
	}
	
	public void updateComment(HttpServletRequest req, AskComment askC) {
		if (ss.getMapper(MyPageMapper.class).updateAskComment(askC) == 1) {
			req.setAttribute("result", "댓글수정 성공");
		} else {
			req.setAttribute("result", "댓글수정 실패");
		}
		req.setAttribute("result", "댓글수정 실패");
	}
	

}
