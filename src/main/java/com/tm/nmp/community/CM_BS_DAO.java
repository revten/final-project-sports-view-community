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
public class CM_BS_DAO {
	
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
		BaseballSelector bsSel = new BaseballSelector("",null,null);
		allPostCount = ss.getMapper(BaseballMapper.class).getAllBaseballPostCount(bsSel);
	}


	public void getAllBaseball(HttpServletRequest req, int pageNo) {
		int count = 10;
		int start = (pageNo -1) * count + 1;
		int end = start + (count - 1);
		
		BaseballSelector search = (BaseballSelector) req.getSession().getAttribute("search");
		int postCount = 0;
		if (search == null) {
			search = new BaseballSelector("", new BigDecimal(start), new BigDecimal(end));
			postCount = allPostCount;
		} else {
			search.setStart(new BigDecimal(start));
			search.setEnd(new BigDecimal(end));
			postCount = ss.getMapper(BaseballMapper.class).getAllBaseballPostCount(search);
		}
		
		List<CM_BS_TITLE> posts = ss.getMapper(BaseballMapper.class).getAllbaseball(search);
		
		int pageCount = (int) Math.ceil(postCount / (double) count);
		req.setAttribute("pageCount", pageCount);
		
		req.setAttribute("baseball", posts);
		req.setAttribute("curPage", pageNo);
		
		
		
	}

	public void getBaseballDetail(HttpServletRequest req, CM_BS_TITLE bs) {
		CM_BS_TITLE baseball = ss.getMapper(BaseballMapper.class).getBaseball(bs);
		
		req.setAttribute("baseball", baseball);
		
	}

	public void deleteBaseball(HttpServletRequest req, CM_BS_TITLE bs) {
		if (ss.getMapper(BaseballMapper.class).deleteBaseball(bs) == 1) {
			req.setAttribute("result", "삭제성공");
		}else {
			req.setAttribute("result", "삭제실패");
		}
	}


	public void updateBaseball(HttpServletRequest req, CM_BS_TITLE bs) {
		if (ss.getMapper(BaseballMapper.class).updateBaseball(bs) == 1) {
			req.setAttribute("result", "수정성공");
		}else {
			req.setAttribute("result", "수정실패");
		}
		
	}

	public void inseertBaseball(HttpServletRequest req, CM_BS_TITLE bs) {
		String path = req.getSession().getServletContext().getRealPath("resources/files/baseball_img");
		System.out.println("path");
		
		AccountDTO loginMember = (AccountDTO) req.getSession().getAttribute("loginAccount");
		String id = loginMember.getAc_id();
		String nick = loginMember.getAc_name();
		
		try {
			MultipartRequest mr = new MultipartRequest(req, path, 10 * 1024 * 1024, "utf-8", new DefaultFileRenamePolicy());
			
			String cat = mr.getParameter("cm_bs_cat");
			String title = mr.getParameter("cm_bs_title");
			String content = mr.getParameter("cm_bs_content");
			String img = mr.getFilesystemName("cm_bs_img");
			
			System.out.println(cat);
			System.out.println(title);
			System.out.println(content);
			System.out.println(img);
			System.out.println(id);
			System.out.println(nick);
			
			bs.setCm_bs_cat(cat);
			bs.setCm_bs_title(title);
			bs.setCm_bs_content(content);
			bs.setCm_bs_img(img);
			bs.setCm_bs_id(id);
			bs.setCm_bs_nick(nick);
			
			if (ss.getMapper(BaseballMapper.class).insertBaseball(bs) == 1) {
				req.setAttribute("result", "등록성공");
			}else {
				req.setAttribute("result", "등록실패");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}