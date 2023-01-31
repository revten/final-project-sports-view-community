package com.tm.nmp.board;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tm.nmp.account.AccountDTO;
import com.tm.nmp.board.PostVO;

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

	private int withGo;
	private int review;
	private int baseball;
	private int soccer;
	private int basketball;
	private int volleyball;
	private int clubEvent;

	public void calcAllPostCount() {
		BoardSelector bSelWithGo = new BoardSelector("", 0, 0, 11);
		withGo = ss.getMapper(BoardMapper.class).calcAllPostCount(bSelWithGo);
		
		BoardSelector bSelReview = new BoardSelector("", 0, 0, 12);
		review = ss.getMapper(BoardMapper.class).calcAllPostCount(bSelReview);
		
		BoardSelector bSelBaseBall = new BoardSelector("", 0, 0, 21);
		baseball = ss.getMapper(BoardMapper.class).calcAllPostCount(bSelBaseBall);
		
		BoardSelector bSelSoccer = new BoardSelector("", 0, 0, 22);
		soccer = ss.getMapper(BoardMapper.class).calcAllPostCount(bSelSoccer);
		
		BoardSelector bSelBasketball = new BoardSelector("", 0, 0, 23);
		basketball = ss.getMapper(BoardMapper.class).calcAllPostCount(bSelBasketball);
		
		BoardSelector bSelVolley = new BoardSelector("", 0, 0, 24);
		volleyball = ss.getMapper(BoardMapper.class).calcAllPostCount(bSelVolley);
		
		BoardSelector bSelClubEvent = new BoardSelector("", 0, 0, 31);
		clubEvent = ss.getMapper(BoardMapper.class).calcAllPostCount(bSelClubEvent);
	}

	public void getAllPost(HttpServletRequest req, int pageNbr, int post_board, PostVO p) {

		switch (post_board) {
		case 11:
			allPostCount = withGo;
			break;
		case 12:
			allPostCount = review;
			break;
		case 21:
			allPostCount = baseball;
			break;
		case 22:
			allPostCount = soccer;
			break;
		case 23:
			allPostCount = basketball;
			break;
		case 24:
			allPostCount = volleyball;
			break;
		case 31:
			allPostCount = clubEvent;
			break;
		}

		int count = bo.getCountPerPage();
		int start = (pageNbr - 1) * count + 1;
		int end = start + (count - 1);

		BoardSelector search = (BoardSelector) req.getSession().getAttribute("search");
		int postCount = 0;

		if (search == null) {
			search = new BoardSelector("", start, end, post_board);
			postCount = allPostCount;
		} else {
			search.setStart(start);
			search.setEnd(end);
			postCount = ss.getMapper(BoardMapper.class).calcAllPostCount(search);

		}

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

		int post_board = p.getPost_board();
		System.out.println(post_board);
		if (ss.getMapper(BoardMapper.class).regPost(p) == 1) {
			System.out.println("글 등록 성공");
			switch (post_board) {
			case 11:
				withGo++;
				break;
			case 12:
				review++;
				break;
			case 21:
				baseball++;
				break;
			case 22:
				soccer++;
				break;
			case 23:
				basketball++;
				break;
			case 24:
				volleyball++;
				break;
			case 31:
				clubEvent++;
				break;
			}
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
		int post_board = p.getPost_board();
		System.out.println(post_board);
		if (ss.getMapper(BoardMapper.class).deletePost(p) == 1) {
			req.setAttribute("result", "글삭제 성공");
			switch (post_board) {
			case 11:
				withGo--;
				break;
			case 12:
				review--;
				break;
			case 21:
				baseball--;
				break;
			case 22:
				soccer--;
				break;
			case 23:
				basketball--;
				break;
			case 24:
				volleyball--;
				break;
			case 31:
				clubEvent--;
				break;
			}
		} else {
			req.setAttribute("result", "글삭제실패");
		}
	}

	public ResultVO regReply(HttpServletRequest req, ReplyVO rp) {
		String token = req.getParameter("token");
		// 리플등록시에 세션에 세팅해둔 토큰을 불러온다.
		String successToken = (String) req.getSession().getAttribute("successToken");
		System.out.println("token : " + token);
		
		// 리플등록 비동기 요청에 대한 대답으로 새토큰과 등록성공여부, 등록한 리플 정보를 조회해서 받은 ReplyVO를 담아줄 ResultVO 객체를 만든다.
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
//			allReplyCount++;
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

	// 좋아요를 누른 회원인지 아닌지 체크하기
	public void likeCheck(HttpServletRequest req, PostVO p) {
		AccountDTO ac = (AccountDTO) req.getSession().getAttribute("loginAccount");
		LikeVO lk = new LikeVO();
		lk.setLike_member(ac.getMember_id());
		lk.setLike_post(p.getPost_id());
		int likeCheck = ss.getMapper(BoardMapper.class).likeCheck(lk);
		System.out.println("likeCheck: " + likeCheck);
		req.setAttribute("likeCheck", likeCheck);

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

		/*
		 * if(ss.getMapper(BoardMapper.class).postCountUpdate(p) == 1) {
		 * req.setAttribute("result", "조회수 성공"); }else { req.setAttribute("result",
		 * "조회수 실패"); }
		 */

	}

	public void likeUp(HttpServletRequest req, LikeVO lk) {
		if (ss.getMapper(BoardMapper.class).likeUp(lk) == 1) {
			req.setAttribute("result", "댓글수정 성공");
		} else {
			req.setAttribute("result", "댓글수정 실패");
		}
	}

	public void likeDown(HttpServletRequest req, LikeVO lk) {
		if (ss.getMapper(BoardMapper.class).likeDown(lk) == 1) {
			req.setAttribute("result", "댓글수정 성공");
		} else {
			req.setAttribute("result", "댓글수정 실패");
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
