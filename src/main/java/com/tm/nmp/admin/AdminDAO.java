package com.tm.nmp.admin;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.tm.nmp.board.BoardOption;

@Service
public class AdminDAO {
	
	@Autowired
	private SqlSession ss;
	
	private int allClubCount;
	
	
	public int calcAllClubCount(BoardOption bo) {
		allClubCount = ss.getMapper(AdminMapper.class).calcAllClubCount(bo);
		System.out.println("전체 구단 수 : " + allClubCount);
		return allClubCount;
	}

	public void regClubInfo(HttpServletRequest req, ClubDTO c) {
		if(ss.getMapper(AdminMapper.class).regClubInfo(c) == 1) {
			System.out.println("구단 등록 성공");
		} else {
			System.out.println("무결성 검증 실패");
		}
	}

	public void getClubViewList(HttpServletRequest req, BoardOption bo) {
		
//		allClubCount = calcAllClubCount();
//		System.out.println(allClubCount);
		req.getParameter("page");
		
		if(bo.getField() == null) {
			bo.setField("name");
		}
		if(bo.getSearch() == null) {
			bo.setSearch("");
		}		

		allClubCount = calcAllClubCount(bo); // 총 게시글 수
		System.out.println("조회구단수 : " + allClubCount);
		if(req.getParameter("page") == null) {
			bo.setCurPage(1); // 현재 보여주는 페이지
		} else {
			int page = Integer.parseInt(req.getParameter("page"));
			bo.setCurPage(page);
		}
		bo.setCountPerPage(3); // 한 페이장 게시글 수
		bo.setStartNum((bo.getCurPage() - 1) * bo.getCountPerPage() + 1);  // 한 페이지의 첫 글
		bo.setEndNum(bo.getStartNum() + (bo.getCountPerPage() - 1)); // 한 페이지의 마지막 글
		bo.setStartPage(bo.getCurPage()-(bo.getCurPage()-1)%5); // 한화면에 보여줄 페이지 목록 처음
		bo.setEndPage(4);// 한화면에 보여줄 페이지 목록 마지막
		bo.setTotalPages((int) Math.ceil(allClubCount / (double) bo.getCountPerPage())); // 총 페이지수
		req.setAttribute("bo", bo);
		
		List<ClubListView> clubs = ss.getMapper(AdminMapper.class).getClubViewList(bo);
		req.setAttribute("clubs", clubs);
	}

	public int uploadImage(HttpServletRequest req, ClubImageDTO ci) {
		
		String path = req.getSession().getServletContext().getRealPath("resources/files");
		MultipartRequest mr = null;
		int result = 0;
		try {
			mr = new MultipartRequest(req, path, 31457200, "utf-8", new DefaultFileRenamePolicy());
			System.out.println(mr.getFilesystemName("file_name"));
			
			int club_id = Integer.parseInt(mr.getParameter("club_id"));
			int sort = Integer.parseInt(mr.getParameter("sort"));
			
			ci.setClub_id(club_id);
			ci.setSort(sort);
			
			String file_name = mr.getFilesystemName("file_name");
			ci.setFile_name(file_name);
			System.out.println("저장되는 경로(실제 서버) : " + path);
			System.out.println("사진 이름 : " + file_name);
			
			result = ss.getMapper(AdminMapper.class).uploadImage(ci);
			System.out.println(result);
			if( result ==1) {
				req.setAttribute("result", "성공");
			}else {
				req.setAttribute("result", "실패");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			String fileName = mr.getFilesystemName("file_name");
			new File(path + "/" + fileName).delete();
			req.setAttribute("result", "업로드 실패");
		}
		return result;
	}
}
