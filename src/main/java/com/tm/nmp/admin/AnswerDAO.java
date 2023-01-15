package com.tm.nmp.admin;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.tm.nmp.account.AccountDTO;
import com.tm.nmp.games.GamesMapper;
import com.tm.nmp.mypage.MyPageMapper;


@Service
public class AnswerDAO {
	
	@Autowired
	private SqlSession ss;

	public void getAnswerAll(HttpServletRequest req) {
		
		req.setAttribute("answers", ss.getMapper(AdminMapper.class).getAnswerAll());
		
	}

	public void getAnswer(HttpServletRequest req, AnswerDTO as) {
		
		req.setAttribute("answer", ss.getMapper(AdminMapper.class).getAnswer(as));
		
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
	
	

}
