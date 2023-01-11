package com.tm.nmp.community;

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

	@Autowired
	private SqlSession ss;
	

	public void getSoccerBoard(HttpServletRequest req, CM_SC_TITLE sc) {

		List<CM_SC_TITLE> soccer = ss.getMapper(SoccerMapper.class).getSoccerBoard(sc);
		
		req.setAttribute("soccer", soccer);
	}

	public void getSoccerDetail(HttpServletRequest req,CM_SC_TITLE sc) {
		CM_SC_TITLE soccer = ss.getMapper(SoccerMapper.class).getSoccer(sc);
		req.setAttribute("soccer", soccer);
		
	}

	public void deleteSoccer(HttpServletRequest req, CM_SC_TITLE sc) {
		if(ss.getMapper(SoccerMapper.class).deleteSoccer(sc)==1) {
			req.setAttribute("result", "삭제성공");
		}else {
			req.setAttribute("result", "삭제실패");
		}
		
	}

	public void updateSoccer(HttpServletRequest req, CM_SC_TITLE sc) {
		if(ss.getMapper(SoccerMapper.class).updateSoccer(sc)==1) {
			req.setAttribute("result", "수정성공");
		}else {
			req.setAttribute("result", "수정실패");
		}
	}

	public void insertSoccerBoard(HttpServletRequest req, CM_SC_TITLE sc) {
		String path = req.getSession().getServletContext().getRealPath("resources/files/soccer_img");
		System.out.println(path);
		try {
			
			MultipartRequest mr = new MultipartRequest(req, path, 10 * 1024 * 1024, "utf-8", new DefaultFileRenamePolicy());
			
			String cat = mr.getParameter("cm_sc_cat");
			String title = mr.getParameter("cm_sc_title");
			String content = mr.getParameter("cm_sc_content");
			String img = mr.getFilesystemName("cm_sc_img");
			String video = mr.getParameter("cm_sc_video");
			String id = mr.getParameter("cm_sc_id");
			String nick = mr.getParameter("cm_sc_nick");
						
			System.out.println(cat);
			System.out.println(title);
			System.out.println(content);
			System.out.println(img);
			System.out.println(video);
			
			
			sc.setCm_sc_cat(cat);
			sc.setCm_sc_title(title);
			sc.setCm_sc_content(content);
			sc.setCm_sc_img(img);
			sc.setCm_sc_video(video);
			sc.setCm_sc_id(id);
			sc.setCm_sc_nick(nick);
			
			if (ss.getMapper(SoccerMapper.class).insertSoccer(sc) == 1) {
				req.setAttribute("result", "등록성공");
			}else {
				req.setAttribute("result", "등록실패");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	
	
}
