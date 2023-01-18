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
public class CM_BK_DAO {

	@Autowired
	private SqlSession ss;

	public void getAllBasketball(HttpServletRequest req, CM_BK_TITLE BK) {
		List<CM_BK_TITLE> Basketball = ss.getMapper(BasketballMapper.class).getAllBasketball(BK);
		
		req.setAttribute("Basketball", Basketball);
		
	}

	public void getBasketballDetail(HttpServletRequest req, CM_BK_TITLE BK) {
		CM_BK_TITLE Basketball = ss.getMapper(BasketballMapper.class).getBasketball(BK);
		
		req.setAttribute("Basketball", Basketball);
		
	}

	public void deleteBasketball(HttpServletRequest req, CM_BK_TITLE BK) {
		if (ss.getMapper(BasketballMapper.class).deleteBasketball(BK) == 1) {
			req.setAttribute("result", "삭제성공");
		}else {
			req.setAttribute("result", "삭제실패");
		}
	}


	public void updateBasketball(HttpServletRequest req, CM_BK_TITLE BK) {
		if (ss.getMapper(BasketballMapper.class).updateBasketball(BK) == 1) {
			req.setAttribute("result", "수정성공");
		}else {
			req.setAttribute("result", "수정실패");
		}
		
	}

	public void inseertBasketball(HttpServletRequest req, CM_BK_TITLE BK) {
		String path = req.getSession().getServletContext().getRealPath("resources/files/Basketball_img");
		System.out.println("path");
		
		AccountDTO loginMember = (AccountDTO) req.getSession().getAttribute("loginAccount");
		String id = loginMember.getAc_id();
		String nick = loginMember.getAc_name();
		
		try {
			MultipartRequest mr = new MultipartRequest(req, path, 10 * 1024 * 1024, "utf-8", new DefaultFileRenamePolicy());
			
			String cat = mr.getParameter("cm_BK_cat");
			String title = mr.getParameter("cm_BK_title");
			String content = mr.getParameter("cm_BK_content");
			String img = mr.getFilesystemName("cm_BK_img");
			
			System.out.println(cat);
			System.out.println(title);
			System.out.println(content);
			System.out.println(img);
			System.out.println(id);
			System.out.println(nick);
			
			BK.setCm_bk_cat(cat);
			BK.setCm_bk_title(title);
			BK.setCm_bk_content(content);
			BK.setCm_bk_img(img);
			BK.setCm_bk_id(id);
			BK.setCm_bk_nick(nick);
			
			if (ss.getMapper(BasketballMapper.class).insertBasketball(BK) == 1) {
				req.setAttribute("result", "등록성공");
			}else {
				req.setAttribute("result", "등록실패");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
