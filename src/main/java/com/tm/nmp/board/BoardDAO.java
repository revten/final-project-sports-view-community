package com.tm.nmp.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tm.nmp.account.AccountDTO;

@Service
public class BoardDAO {

	@Autowired
	private SqlSession ss;

	@Autowired
	private BoardOption bo;

	private int allPostCount;

	public int getallPostCount() {
		return allPostCount;
	}

	public void setallPostCount(int allPostCount) {
		this.allPostCount = allPostCount;
	}

	public void calcAllPostCount(int board_id) {
		BoardSelector bSel = new BoardSelector("", 0, 0, board_id);
		allPostCount = ss.getMapper(BoardMapper.class).calcAllPostCount(bSel);
	}

	public void getAllPost(HttpServletRequest req, int pageNbr, int board_id) {

		int count = bo.getCountPerPage();
		int start = (pageNbr - 1) * count + 1;
		int end = start + (count - 1);

		BoardSelector search = (BoardSelector) req.getSession().getAttribute("search");
		int postCount = 0;

		if (search == null) {
			search = new BoardSelector("", start, end, board_id);
			postCount = allPostCount;
		} else {
			search.setStart(start);
			search.setEnd(end);
			postCount = ss.getMapper(BoardMapper.class).calcAllPostCount(search);

		}

		List<PostVO> posts = ss.getMapper(BoardMapper.class).getAllPost(search);
		req.setAttribute("posts", posts);

		int pageCount = (int) Math.ceil(postCount / (double) count);
		req.setAttribute("pageCount", pageCount);
		req.setAttribute("curPage", pageNbr);
	}

	public void searchPost(HttpServletRequest req, BoardSelector bSel) {
		req.getSession().setAttribute("search", bSel);
	}

	public void getPost(HttpServletRequest req, PostVO p) {
		PostVO post = ss.getMapper(BoardMapper.class).getPost(p);
		post.setReplies(ss.getMapper(BoardMapper.class).getAllReplies(p));
		req.setAttribute("post", post);
	}

	public void regPost(HttpServletRequest req, PostVO p) {
		/*
		 * String token = req.getParameter("token"); String successToken = (String)
		 * req.getSession().getAttribute("successToken"); if
		 * (token.equals(successToken)) { return; }
		 */

		AccountDTO ac = (AccountDTO) req.getSession().getAttribute("loginAccount");
		p.setPost_member(ac.getMember_id());

		String regIp = getClientIp(req);
		System.out.println(regIp);
		p.setPost_reg_ip(regIp);

		String str = p.getPost_content();
		System.out.println("전체(글내용) 경로 :" + str);
		String tit = p.getPost_title();
		System.out.println("제목 :" + tit);

		if (str.contains("img")) {
			String[] contentSplit = str.split("/");
			String topSplit = contentSplit[5];
			System.out.println("첫번째 경로 :" + topSplit);
			String[] midSplit = topSplit.split("\"");
			System.out.println("중간 경로 :" + midSplit);
			String bottomSplit = midSplit[0];
			System.out.println("최종 경로 :" + bottomSplit);
			p.setPost_img(bottomSplit);
		} else {
			p.setPost_img("");
		}

		// 위 split 내용을 wg_img 컬럼에 set해준 것

//		p.setPost_content(p_txt.replace("\r\n", "<br>"));

		if (ss.getMapper(BoardMapper.class).regPost(p) == 1) {
			System.out.println("글 등록 성공");
			allPostCount++;
		} else {
			System.err.println("글 등록 실패");
		}
	}

	public void updatePost(HttpServletRequest req, PostVO p) {

		String regIp = getClientIp(req);
		System.out.println(regIp);
		p.setPost_reg_ip(regIp);

		String str = p.getPost_content();
		System.out.println("전체 경로 :" + str);

		if (str.contains("img")) {
			String[] contentSplit = str.split("/");
			String topSplit = contentSplit[5];
			System.out.println("첫번째 경로 :" + topSplit);
			String[] midSplit = topSplit.split("\"");
			System.out.println("중간 경로 :" + midSplit);
			String bottomSplit = midSplit[0];
			System.out.println("최종 경로 :" + bottomSplit);
			p.setPost_img(bottomSplit);
		} else {
			p.setPost_img("");
		}

		if (ss.getMapper(BoardMapper.class).updatePost(p) == 1) {
			req.setAttribute("result", "글수정 성공");
		} else {
			req.setAttribute("result", "글수정 실패");
		}
	}
	
	public void deletePost(HttpServletRequest req, PostVO p) {
		if (ss.getMapper(BoardMapper.class).deletePost(p) == 1) {
			req.setAttribute("result", "글삭제 성공");
			allPostCount--;
		} else {
			req.setAttribute("result", "글삭제실패");
		}
	}

	public void regReply(HttpServletRequest req, ReplyVO rp) {
		String token = req.getParameter("token");
		String successToken = (String) req.getSession().getAttribute("successToken");

		if (successToken != null && token.equals(successToken)) {
			return;
		}
		
		String regIp = getClientIp(req);
		System.out.println(regIp);
		rp.setReply_reg_ip(regIp);
		
		AccountDTO ac = (AccountDTO) req.getSession().getAttribute("loginAccount");
		rp.setReply_member(ac.getMember_id());

		if (ss.getMapper(BoardMapper.class).regReply(rp) == 1) {
			req.setAttribute("result", "댓글쓰기 성공");
			req.getSession().setAttribute("successToken", token);
//			allReplyCount++;
		} else {
			req.setAttribute("result", "댓글쓰기실패");
		}
	}

	public void deleteReply(HttpServletRequest req, ReplyVO rp) {
		if (ss.getMapper(BoardMapper.class).deleteReply(rp) == 1) {
			req.setAttribute("result", "댓글삭제 성공");
			allPostCount--;
		} else {
			req.setAttribute("result", "댓글삭제실패");
		}
		req.setAttribute("result", "댓글삭제실패");
	}

	public void updateReply(HttpServletRequest req, ReplyVO rp) {
		if (ss.getMapper(BoardMapper.class).updateReply(rp) == 1) {
			req.setAttribute("result", "댓글수정 성공");
		} else {
			req.setAttribute("result", "댓글수정 실패");
		}
		req.setAttribute("result", "댓글수정 실패");
	}

	public static String getClientIp(HttpServletRequest req) {

		String[] header_IPs = { "HTTP_CLIENT_IP", "HTTP_X_FORWARDED_FOR", "HTTP_X_FORWARDED",
				"HTTP_X_CLUSTER_CLIENT_IP", "HTTP_FORWARDED_FOR", "HTTP_FORWARDED", "X-Forwarded-For",
				"Proxy-Client-IP", "WL-Proxy-Client-IP" };

		for (String header : header_IPs) {
			String ip = req.getHeader(header);

			if (ip != null && !"unknown".equalsIgnoreCase(ip) && ip.length() != 0) {
				return ip;
			}
		}

		return req.getRemoteAddr();
	}

	public JSONObject recommand(HttpServletRequest req, Reccomand rec, int post_id, String member_id) {
		
		try {
			rec.setPost_id(post_id);
			rec.setMember_id(member_id);
			if(ss.getMapper(BoardMapper.class).AddRecommand(rec)==1) {
				System.out.println("추천성공");
			}else {
				System.out.println("실패...");
			}
			// int rCount = ss.getMapper(BoardMapper.class).getReccomed(rec);
			// String rCountString = Integer.toString(rCount);
			// JSONObject count = (JSONObject) rCountStirng;
			
			// return count;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
		
	}

	
	public void postCountUpdate(HttpServletRequest req, PostVO p) {
	
		/*Cookie[] cookies = req.getCookies();
		int visitor = 0;
		
		for (Cookie cookie : cookies) {
			System.out.println(cookie.getName());
			if(cookie.getName().equals("visit")) {
				visitor = 1;
				
				System.out.println("visit 통과");
			
			if (cookie.getValue().contains(req.getParameter("id"))) {
				System.out.println("visitif 통과");
			} else {
				cookie.setValue(cookie.getValue()+ "-" + req.getParameter("id"));
				res.addCookie(cookie);
				
				ss.getMapper(BoardMapper.class).postCountUpdate(p);
			}
		}
	}
		
		if(visitor == 0) {
			Cookie cookie1 = new Cookie("visit", req.getParameter("id"));
			res.addCookie(cookie1);
			
			ss.getMapper(BoardMapper.class).postCountUpdate(p);
		}*/
		 
		if(ss.getMapper(BoardMapper.class).postCountUpdate(p) == 1) {
			req.setAttribute("result", "조회수 성공");
		}else {
			req.setAttribute("result", "조회수 실패");
		}
	}
	
}
