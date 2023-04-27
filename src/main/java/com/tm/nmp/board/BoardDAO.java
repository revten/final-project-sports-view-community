package com.tm.nmp.board;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tm.nmp.account.AccountDTO;

@Service
public class BoardDAO {

	@Autowired
	private SqlSession ss;

	@Autowired
	private BoardOption bo;
	
	@Autowired
	private BoardNumberList boardNumberList;
	
	private int allPostCount;
	
	// 각 게시판별로 게시글수 저장
	private HashMap<Integer, Integer> calcPostCount = new HashMap<Integer, Integer>();
	
	public void calcAllPostCount() {
		for(int i : boardNumberList.getBoardNumberList()) {
			BoardSelector bs = new BoardSelector("", 0, 0, i);
			calcPostCount.put(i, ss.getMapper(BoardMapper.class).calcAllPostCount(bs));
			System.out.println("게시판번호 " + i + " : " + calcPostCount.get(i)); // 각 게시판별 총 게시글 수
		}
	}

	
	public void getAllPost(HttpServletRequest req, int pageNbr, PostVO p) {

		allPostCount = calcPostCount.get(p.getPost_board());
		System.out.println("전체 게시글 수 : " + allPostCount);

		int count = bo.getCountPerPage();
		int start = (pageNbr - 1) * count + 1;
		int end = start + (count - 1);

		BoardSelector search = (BoardSelector) req.getSession().getAttribute("search");
		int postCount = 0;

		if (search == null) {
			search = new BoardSelector("", start, end, p.getPost_board());
			postCount = allPostCount;
		} else {
			search.setStart(start);
			search.setEnd(end);
			postCount = ss.getMapper(BoardMapper.class).calcAllPostCount(search);
		}
		System.out.println("postCount : " + postCount);
		
		int catNum = p.getPost_category();

		String category = Integer.toString(catNum);

		switch (category) {
		case "0":
			category = "잡담";
			break;
		case "1":
			category = "질문";
			break;
		case "2":
			category = "정보";
			break;
		case "3":
			category = "분석";
			break;
		}

		req.setAttribute("post_category", category);

		int board_num = p.getPost_board();

		String board_name = "";
		switch (board_num) {
		case 21:
			board_name = "야구";
			break;
		case 22:
			board_name = "축구";
			break;
		case 23:
			board_name = "농구";
			break;
		case 24:
			board_name = "배구";
			break;
		}
		req.setAttribute("board_name", board_name);

		List<PostVO> posts = ss.getMapper(BoardMapper.class).getAllPost(search);
		System.out.println(posts);
		req.setAttribute("posts", posts);

		int pageCount = (int) Math.ceil(postCount / (double) count);
		System.out.println("pageCount : " + pageCount);
		
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
		
		System.out.println("게시판 번호 : " + p.getPost_board());
		allPostCount = calcPostCount.get(p.getPost_board());
		System.out.println("등록전 게시글수 : " + allPostCount);
		allPostCount++;

		AccountDTO ac = (AccountDTO) req.getSession().getAttribute("loginAccount");
		p.setPost_member(ac.getMember_id());

		String regIp = getClientIp(req);
		System.out.println("등록 ip : " + regIp);
		p.setPost_reg_ip(regIp);

		String str = p.getPost_content();
		System.out.println("전체(글내용) 경로 :" + str);
		String tit = p.getPost_title();
		System.out.println("제목 :" + tit);
		
		// ck4의 컨텐츠에 img 자체가 저장되어 이미지만에 대한 정보를 DB에 저장하기 위한 작업
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

		if (ss.getMapper(BoardMapper.class).regPost(p) == 1) {
			System.out.println("글 등록 성공");
			calcPostCount.replace(p.getPost_board(), allPostCount);
			System.out.println("등록후 게시글수 : " + allPostCount);
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
		
		System.out.println("게시판 번호 : " + p.getPost_board());
		allPostCount = calcPostCount.get(p.getPost_board());
		System.out.println("삭제전 게시글수 : " + allPostCount);
		allPostCount--;
		
		if (ss.getMapper(BoardMapper.class).deletePost(p) == 1) {
			System.out.println("글 삭제 성공");
			calcPostCount.replace(p.getPost_board(), allPostCount);
			System.out.println("삭제후 게시글수 : " + allPostCount);
			
		} else {
			req.setAttribute("result", "글삭제실패");
		}
	}

	
	public ResultVO regReply(HttpServletRequest req, ReplyVO rp) {
		String token = req.getParameter("token");
		// 리플등록시에 세션에 세팅해둔 토큰을 불러온다.
		String successToken = (String) req.getSession().getAttribute("successToken");
		System.out.println("token : " + token);

		// 리플등록 비동기 요청에 대한 대답으로 새토큰과 등록성공여부, 등록한 리플 정보를 조회해서 받은 ReplyVO를 담아줄 ResultVO
		// 객체를 만든다.
		ResultVO resultVO = new ResultVO();

		// TokenMaker로 만든 토큰과 리플등록시에 만든 토큰을 비교한다.
		if (successToken != null && token.equals(successToken)) {
			resultVO.setResult(0);
			resultVO.setToken(token);
			System.out.println(resultVO.toString());
			return resultVO;
		}

		// 리플 등록시에 regIp가 not null이므로 세팅해주자
		String regIp = getClientIp(req);
		System.out.println(regIp);
		rp.setReply_reg_ip(regIp);

		// 리플을 등록한 사람도 세팅해주자
		AccountDTO ac = (AccountDTO) req.getSession().getAttribute("loginAccount");
		rp.setReply_member(ac.getMember_id());

		int a = ss.getMapper(BoardMapper.class).regReply(rp);
		System.out.println(a);
		if (a == -1) {
			req.setAttribute("result", "댓글쓰기 성공");
			// 생성토큰을 저장해두기
			req.getSession().setAttribute("successToken", token);

			// 성공한 값으로 1을 넘김
			resultVO.setResult(1);
			resultVO.setToken((String) req.getAttribute("token"));
			ReplyVO replyVO = ss.getMapper(BoardMapper.class).getReply();
			System.out.println(replyVO.toString());
			resultVO.setReplyVO(replyVO);
			System.out.println(resultVO.toString());
			return resultVO;
		}
		return resultVO;
	}

	
	public int deleteReply(HttpServletRequest req, ReplyVO rp) {
		if (ss.getMapper(BoardMapper.class).deleteReply(rp) == -1) {
			req.setAttribute("result", "댓글삭제 성공");
			return 1;
		} else {
			req.setAttribute("result", "댓글삭제실패");
			return 0;
		}
	}

	
	public ResultVO updateReply(HttpServletRequest req, ReplyVO rp) {
		ResultVO resultVO = new ResultVO();
		int a = ss.getMapper(BoardMapper.class).updateReply(rp);
		System.out.println(a);
		if (a == 1) {
			resultVO.setResult(1);
			ReplyVO replyVO = ss.getMapper(BoardMapper.class).getReply();
			System.out.println(replyVO.toString());
			resultVO.setReplyVO(replyVO);
			System.out.println(resultVO.toString());
			req.setAttribute("result", "댓글수정 성공");
			return resultVO;
		} 
		return resultVO;
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

	
	public void postCountUpdate(HttpServletRequest req, HttpServletResponse res, PostVO p) {

		Cookie[] cookies = req.getCookies();
		int visitor = 0;

		for (Cookie cookie : cookies) {
			System.out.println(cookie.getName());
			if (cookie.getName().equals("visit")) {
				visitor = 1;

				System.out.println("visit 통과");

				if (cookie.getValue().contains(req.getParameter("post_id"))) {
					System.out.println("visitif 통과");
				} else {
					cookie.setValue(cookie.getValue() + "-" + req.getParameter("post_id"));
					res.addCookie(cookie);

					ss.getMapper(BoardMapper.class).postCountUpdate(p);
				}
			}
		}

		if (visitor == 0) {
			Cookie cookie1 = new Cookie("visit", req.getParameter("post_id"));
			res.addCookie(cookie1);

			ss.getMapper(BoardMapper.class).postCountUpdate(p);
		}
	}

	
	public void viewBoardName(HttpServletRequest req) {

		String board_num = req.getParameter("post_board");
		System.out.println(board_num);
		String board_name = "";
		switch (board_num) {
		case "21":
			board_name = "야구";
			break;
		case "22":
			board_name = "축구";
			break;
		case "23":
			board_name = "농구";
			break;
		case "24":
			board_name = "배구";
			break;
		}

		req.setAttribute("board_name", board_name);
	}

}
