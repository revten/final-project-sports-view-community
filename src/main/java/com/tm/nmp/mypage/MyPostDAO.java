package com.tm.nmp.mypage;

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
import com.tm.nmp.community.ReviewMapper;
import com.tm.nmp.games.GamesMapper;
import com.tm.nmp.games.TotoComment;
import com.tm.nmp.games.TotoDTO;
import com.tm.nmp.games.TotoSelector;
import com.tm.nmp.infoEvent.InfoEventMapper;

@Service
public class MyPostDAO {
	
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
		MyPostSelector mpSel = new MyPostSelector("",null,null);
		allPostCount = ss.getMapper(MyPageMapper.class).getAllMPPostCount(mpSel);
	}

	public void getMyPostAll(HttpServletRequest req, int pageNo) {
		
		int count = 10;
		int start = (pageNo -1) * count + 1;
		int end = start + (count - 1);
		
		MyPostSelector search = (MyPostSelector) req.getSession().getAttribute("search");
		int postCount = 0;
		if (search == null) {
			search = new MyPostSelector("", new BigDecimal(start), new BigDecimal(end));
			postCount = allPostCount;
		} else {
			search.setStart(new BigDecimal(start));
			search.setEnd(new BigDecimal(end));
			postCount = ss.getMapper(MyPageMapper.class).getAllMPPostCount(search);
		}
		
		List<MyPostDTO> posts = ss.getMapper(MyPageMapper.class).getMyPostAll(search);
		
		int pageCount = (int) Math.ceil(postCount / (double) count);
		req.setAttribute("pageCount", pageCount);
		
		req.setAttribute("MyPosts", posts);
		req.setAttribute("curPage", pageNo);
		
		
	}

	public void getMyPost(HttpServletRequest req, MyPostDTO mp) {
		MyPostDTO post = ss.getMapper(MyPageMapper.class).getMyPost(mp);
		post.setMypost_comments(ss.getMapper(MyPageMapper.class).getAllPostComment(mp));
		
		req.setAttribute("MyPost", post);
		
	}

	public void updateMyPost(HttpServletRequest req, MyPostDTO mp) {
		
		if (ss.getMapper(MyPageMapper.class).updateMyPost(mp) == 1) {
			System.out.println("수정 성공");
		} else {
			System.out.println("수정 실패");
		}
		
	}

	public void deleteMyPost(HttpServletRequest req, MyPostDTO mp) {
		
		if (ss.getMapper(MyPageMapper.class).deleteMyPost(mp) == 1) {
			System.out.println("삭제 성공");
		} else {
			System.out.println("삭제 실패");
		}
		
	}

	public void insertMyPost(HttpServletRequest req, MyPostDTO mp) {
		String path = req.getSession().getServletContext().getRealPath("resources/files/myPostImg");
		MultipartRequest mr = null;
		System.out.println(path);
		
		AccountDTO loginMember = (AccountDTO) req.getSession().getAttribute("loginAccount");
		String mypost_id = loginMember.getAc_id();
		String mypost_nick = loginMember.getAc_nick();
		
		try {
			mr = new MultipartRequest(req, path, 30*1024*1024, "utf-8", new DefaultFileRenamePolicy());
			
			
			String mypost_cat = mr.getParameter("mypost_cat");
			String mypost_title = mr.getParameter("mypost_title");
			String mypost_content = mr.getParameter("mypost_content");
			mypost_content = mypost_content.replace("\r\n", "<br>");
			String mypost_img = mr.getFilesystemName("mypost_img");
			String mypost_video = mr.getFilesystemName("mypost_video");
			int mypost_count = 0;
			
			System.out.println(mypost_id);
			System.out.println(mypost_nick);
			System.out.println(mypost_cat);
			System.out.println(mypost_title);
			System.out.println(mypost_content);
			System.out.println(mypost_img);
			System.out.println(mypost_video);
			System.out.println(mypost_count);
			
			mp.setMypost_id(mypost_id);
			mp.setMypost_nick(mypost_nick);
			mp.setMypost_cat(mypost_cat);
			mp.setMypost_title(mypost_title);
			mp.setMypost_content(mypost_content);
			if(mypost_img != null) {
				mp.setMypost_img(mypost_img);
			}else {
				mp.setMypost_img(" ");
			}
			if(mypost_video != null) {
				mp.setMypost_video(mypost_video);
			}else {
				mp.setMypost_video(" ");
			}
			mp.setMypost_count(mypost_count);
			
			
			
			if(ss.getMapper(MyPageMapper.class).insertMyPost(mp)==1){
				req.setAttribute("r", "등록성공");
			}else {
				req.setAttribute("r", "등록실패");
				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
			String fileName1 = mr.getFilesystemName("mypost_img");
			String fileName2 = mr.getFilesystemName("mypost_vedio");
			new File(path + "/" + fileName1).delete();
			new File(path + "/" + fileName2).delete();
		}
		
	}
	
	public void writeComment(HttpServletRequest req, MyPostComment mpc) {

		String mypost_no = req.getParameter("mypost_no");
		mpc.setMypost_comment_boardno(Integer.parseInt(mypost_no));
		String a = mpc.getMypost_comment_content();
		System.out.println(a);
		

		if (ss.getMapper(MyPageMapper.class).writeComment(mpc) == 1) {
			req.setAttribute("result", "댓글쓰기 성공");
		} else {
			req.setAttribute("result", "댓글쓰기실패");
		}
	}
	
	public void deleteComment(HttpServletRequest req, MyPostComment mpc) {
		if (ss.getMapper(MyPageMapper.class).deleteComment(mpc) == 1) {
			req.setAttribute("result", "댓글삭제 성공");
		} else {
			req.setAttribute("result", "댓글삭제실패");
		}
		req.setAttribute("result", "댓글삭제실패");
	}
	
	public void updateComment(HttpServletRequest req, MyPostComment mpc) {
		if (ss.getMapper(MyPageMapper.class).updateComment(mpc) == 1) {
			req.setAttribute("result", "댓글수정 성공");
		} else {
			req.setAttribute("result", "댓글수정 실패");
		}
		req.setAttribute("result", "댓글수정 실패");
	}
	
	

}
