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
public class CM_VL_DAO {

	@Autowired
	private SqlSession ss;

	public void getAllVolleyball(HttpServletRequest req, CM_VL_TITLE VL) {
		List<CM_VL_TITLE> Volleyball = ss.getMapper(VolleyballMapper.class).getAllVolleyball(VL);
		
		req.setAttribute("Volleyball", Volleyball);
		
	}

	public void getVolleyballDetail(HttpServletRequest req, CM_VL_TITLE VL) {
		CM_VL_TITLE Volleyball = ss.getMapper(VolleyballMapper.class).getVolleyball(VL);
		
		req.setAttribute("Volleyball", Volleyball);
		
	}

	public void deleteVolleyball(HttpServletRequest req, CM_VL_TITLE VL) {
		if (ss.getMapper(VolleyballMapper.class).deleteVolleyball(VL) == 1) {
			req.setAttribute("result", "삭제성공");
		}else {
			req.setAttribute("result", "삭제실패");
		}
	}


	public void updateVolleyball(HttpServletRequest req, CM_VL_TITLE VL) {
		if (ss.getMapper(VolleyballMapper.class).updateVolleyball(VL) == 1) {
			req.setAttribute("result", "수정성공");
		}else {
			req.setAttribute("result", "수정실패");
		}
		
	}

	public void inseertVolleyball(HttpServletRequest req, CM_VL_TITLE VL) {
		String path = req.getSession().getServletContext().getRealPath("resources/files/Volleyball_img");
		System.out.println("path");
		
		AccountDTO loginMember = (AccountDTO) req.getSession().getAttribute("loginAccount");
		String id = loginMember.getAc_id();
		String nick = loginMember.getAc_name();
		
		try {
			MultipartRequest mr = new MultipartRequest(req, path, 10 * 1024 * 1024, "utf-8", new DefaultFileRenamePolicy());
			
			String cat = mr.getParameter("cm_VL_cat");
			String title = mr.getParameter("cm_VL_title");
			String content = mr.getParameter("cm_VL_content");
			String img = mr.getFilesystemName("cm_VL_img");
			
			System.out.println(cat);
			System.out.println(title);
			System.out.println(content);
			System.out.println(img);
			System.out.println(id);
			System.out.println(nick);
			
			VL.setCm_vl_cat(cat);
			VL.setCm_vl_title(title);
			VL.setCm_vl_content(content);
			VL.setCm_vl_img(img);
			VL.setCm_vl_id(id);
			VL.setCm_vl_nick(nick);
			
			if (ss.getMapper(VolleyballMapper.class).insertVolleyball(VL) == 1) {
				req.setAttribute("result", "등록성공");
			}else {
				req.setAttribute("result", "등록실패");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
