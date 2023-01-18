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
		
		AccountDTO account = (AccountDTO) req.getSession().getAttribute("loginAccount");
		tt.setToto_id(account.getAc_id());

		String str = tt.getToto_content();
		System.out.println("전체 경로 :" + str);
		String[] contentSplit = str.split("/");
		String topSplit = contentSplit[5];
		System.out.println("첫번째 경로 :" + topSplit);
		String[] midSplit = topSplit.split("\"");
		System.out.println("중간 경로 :" + midSplit);
		String bottomSplit = midSplit[0];
		System.out.println("최종 경로 :" + bottomSplit);

		tt.setToto_img(bottomSplit);
		
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
		
		// ck에디터 그대로 복붙하면 됨
				AccountDTO account = (AccountDTO) req.getSession().getAttribute("loginAccount");
				// loginAccount 가져오는 내용
				tt.setToto_id(account.getAc_id());
				tt.setAc_nick(account.getAc_nick());
				tt.setToto_title(req.getParameter("toto_title"));
				tt.setToto_cat(req.getParameter("toto_cat"));
				// wg_id(해당 게시판 작성자 아이디인데 DB설계 시 관계형으로 생성을 했기 때문에 어카운트의 ac_id를 set설정해줘야 한다)
				String str = tt.getToto_content();
				// wg_content(게시판 컨텐츠 sc_content)
				System.out.println("전체 경로 :" + str);
				// wg_img 삽입을 위해(전체 경로에서 split하는 내용임)
				String[] contentSplit = str.split("/");
				String topSplit = contentSplit[5];
				System.out.println("첫번째 경로 :" + topSplit);
				String[] midSplit = topSplit.split("\"");
				System.out.println("중간 경로 :" + midSplit);
				String bottomSplit = midSplit[0];
				System.out.println("최종 경로 :" + bottomSplit);
				
				tt.setToto_img(bottomSplit);
				//위 split 내용을 wg_img 컬럼에 set해준 것
				int toto_count = 0;
				tt.setToto_count(toto_count);
				
				if(ss.getMapper(GamesMapper.class).insertToto(tt)==1){
					req.setAttribute("r", "등록성공");
				}else {
					req.setAttribute("r", "등록실패");
					
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
