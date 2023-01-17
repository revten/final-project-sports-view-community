package com.tm.nmp.admin;

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
public class AnswerDAO {
	
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
		AnswerSelector asSel = new AnswerSelector("",null,null);
		allPostCount = ss.getMapper(AdminMapper.class).getAllPostCount(asSel);
	}

	public void getAnswerAll(HttpServletRequest req, int pageNo) {
		
		int count = 10;
		int start = (pageNo -1) * count + 1;
		int end = start + (count - 1);
		
		AnswerSelector search = (AnswerSelector) req.getSession().getAttribute("search");
		int postCount = 0;
		if (search == null) {
			search = new AnswerSelector("", new BigDecimal(start), new BigDecimal(end));
			postCount = allPostCount;
		} else {
			search.setStart(new BigDecimal(start));
			search.setEnd(new BigDecimal(end));
			postCount = ss.getMapper(AdminMapper.class).getAllPostCount(search);
		}
		
		List<AnswerDTO> posts = ss.getMapper(AdminMapper.class).getAnswerAll(search);
		
		int pageCount = (int) Math.ceil(postCount / (double) count);
		req.setAttribute("pageCount", pageCount);
		
		req.setAttribute("answers", posts);
		req.setAttribute("curPage", pageNo);
		
		
	}

	public void getAnswer(HttpServletRequest req, AnswerDTO as) {
		AnswerDTO post = ss.getMapper(AdminMapper.class).getAnswer(as);
		post.setAnswer_comments(ss.getMapper(AdminMapper.class).getAllComment(as));
		req.setAttribute("answer", post);
		
	}

	public void updateAnswer(HttpServletRequest req, AnswerDTO as) {

		if (ss.getMapper(AdminMapper.class).updateAnswer(as) == 1) {
			System.out.println("수정 성공");
		} else {
			System.out.println("수정 실패");
		}
		
	}

	public void deleteAnswer(HttpServletRequest req, AnswerDTO as) {

		if (ss.getMapper(AdminMapper.class).deleteAnswer(as) == 1) {
			System.out.println("삭제 성공");
		} else {
			System.out.println("삭제 실패");
		}
	}

	public void insertAnswer(HttpServletRequest req, AnswerDTO as) {
		
		String path = req.getSession().getServletContext().getRealPath("resources/files/answerImg");
		MultipartRequest mr = null;
		System.out.println(path);
		
		AccountDTO loginMember = (AccountDTO) req.getSession().getAttribute("loginAccount");
		String answer_id = loginMember.getAc_id();
		String answer_nick = loginMember.getAc_nick();
		
		try {
			mr = new MultipartRequest(req, path, 30*1024*1024, "utf-8", new DefaultFileRenamePolicy());
			
			
			String answer_cat = mr.getParameter("answer_cat");
			String answer_title = mr.getParameter("answer_title");
			String answer_content = mr.getParameter("answer_content");
			answer_content = answer_content.replace("\r\n", "<br>");
			String answer_img = mr.getFilesystemName("answer_img");
			String answer_video = mr.getFilesystemName("answer_video");
			int answer_count = 0;
			
			System.out.println(answer_id);
			System.out.println(answer_nick);
			System.out.println(answer_cat);
			System.out.println(answer_title);
			System.out.println(answer_content);
			System.out.println(answer_img);
			System.out.println(answer_video);
			System.out.println(answer_count);
			
			as.setAnswer_id(answer_id);
			as.setAnswer_nick(answer_nick);
			as.setAnswer_cat(answer_cat);
			as.setAnswer_title(answer_title);
			as.setAnswer_content(answer_content);
			if(answer_img != null) {
				as.setAnswer_img(answer_img);
			}else {
				as.setAnswer_img(" ");
			}
			if(answer_video != null) {
				as.setAnswer_video(answer_video);
			}else {
				as.setAnswer_video(" ");
			}
			as.setAnswer_count(answer_count);
			
			
			
			if(ss.getMapper(AdminMapper.class).insertAnswer(as)==1){
				req.setAttribute("r", "등록성공");
			}else {
				req.setAttribute("r", "등록실패");
				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
			String fileName1 = mr.getFilesystemName("answer_img");
			String fileName2 = mr.getFilesystemName("answer_vedio");
			new File(path + "/" + fileName1).delete();
			new File(path + "/" + fileName2).delete();
		}
		
	}
	
	
	public void writeComment(HttpServletRequest req, AnswerComment asc) {

		String answer_no = req.getParameter("answer_no");
		asc.setanswer_comment_boardno(Integer.parseInt(answer_no));
		String a = asc.getanswer_comment_content();
		System.out.println(a);
		

		if (ss.getMapper(AdminMapper.class).writeComment(asc) == 1) {
			req.setAttribute("result", "댓글쓰기 성공");
		} else {
			req.setAttribute("result", "댓글쓰기실패");
		}
	}
	
	public void deleteCemment(HttpServletRequest req, AnswerComment asc) {
		if (ss.getMapper(AdminMapper.class).deleteComment(asc) == 1) {
			req.setAttribute("result", "댓글삭제 성공");
		} else {
			req.setAttribute("result", "댓글삭제실패");
		}
		req.setAttribute("result", "댓글삭제실패");
	}
	
	public void updateComment(HttpServletRequest req, AnswerComment asc) {
		if (ss.getMapper(AdminMapper.class).updateComment(asc) == 1) {
			req.setAttribute("result", "댓글수정 성공");
		} else {
			req.setAttribute("result", "댓글수정 실패");
		}
		req.setAttribute("result", "댓글수정 실패");
	}
	
	

}
