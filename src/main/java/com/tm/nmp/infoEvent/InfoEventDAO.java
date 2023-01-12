package com.tm.nmp.infoEvent;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


@Service
public class InfoEventDAO {

	@Autowired
	private SqlSession ss;

	public void getteamEventAll(HttpServletRequest req, TeamEventDTO te) {
		
		
		req.setAttribute("teamEvents", ss.getMapper(InfoEventMapper.class).showAllTeamEvent());
	}

	public void getteamEvent(HttpServletRequest req, TeamEventDTO te) {
		
		req.setAttribute("teamEvent", ss.getMapper(InfoEventMapper.class).showTeamEvent(te));
	}
	
	public void insertTeamEvent(HttpServletRequest req, TeamEventDTO te) {
		String path = req.getSession().getServletContext().getRealPath("resources/files/teamEventImg");
		System.out.println(path);
		
		try {
			MultipartRequest mr = new MultipartRequest(req, path, 30*1024*1024, "utf-8", new DefaultFileRenamePolicy());
			
			
			String ie_te_id = mr.getParameter("ie_te_id");
			String ie_te_nick = mr.getParameter("ie_te_nick");
			String ie_te_no = mr.getParameter("ie_te_no");
			String ie_te_sports = mr.getParameter("ie_te_sports");
			String ie_te_team = mr.getParameter("ie_te_team");
			String ie_te_title = mr.getParameter("ie_te_title");
			String ie_te_content = mr.getParameter("ie_te_content");
			ie_te_content = ie_te_content.replace("\r\n", "<br>");
			String ie_te_img = mr.getFilesystemName("ie_te_img");
			String ie_te_video = mr.getFilesystemName("ie_te_vedio");
			int ie_te_views = 0;
			int ie_te_comtNo = 0;
			String ie_te_ip = req.getRemoteAddr();
			
			
			
			te.setIe_te_id(ie_te_id);
			te.setIe_te_nick(ie_te_nick);
			te.setIe_te_no(Integer.parseInt(ie_te_no));
			te.setIe_te_sports(ie_te_sports);
			te.setIe_te_team(ie_te_team);
			te.setIe_te_title(ie_te_title);
			te.setIe_te_content(ie_te_content);
			if(ie_te_img != null) {
				te.setIe_te_img(ie_te_img);
			}else {
				te.setIe_te_img("");
			}
			if(ie_te_video != null) {
				te.setIe_te_img(ie_te_video);
			}else {
				te.setIe_te_img("");
			}
			te.setIe_te_views(ie_te_views);
			te.setIe_te_comtNo(ie_te_comtNo);
			te.setIe_te_ip(ie_te_ip);
			
			
			
			if(ss.getMapper(InfoEventMapper.class).insertTeamEvent(te)==1){
				req.setAttribute("r", "등록성공");
			}else {
				req.setAttribute("r", "등록실패");
				
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void updateTeamEvent(HttpServletRequest req, TeamEventDTO te) {
		String path = req.getSession().getServletContext().getRealPath("resources/files/teamEventImg");
		System.out.println(path);
		
		try {
			MultipartRequest mr = new MultipartRequest(req, path, 30*1024*1024, "utf-8", new DefaultFileRenamePolicy());
			
			String ie_te_id = mr.getParameter("ie_te_id");
			String ie_te_nick = mr.getParameter("ie_te_nick");
			String ie_te_no = mr.getParameter("ie_te_no");
			String ie_te_sports = mr.getParameter("ie_te_sports");
			String ie_te_team = mr.getParameter("ie_te_team");
			String ie_te_title = mr.getParameter("ie_te_title");
			String ie_te_content = mr.getParameter("ie_te_content");
			ie_te_content = ie_te_content.replace("\r\n", "<br>");
			String ie_te_img_old = mr.getParameter("ie_te_img");
			String ie_te_img = mr.getFilesystemName("ie_te_img");
			String ie_te_video_old = mr.getParameter("ie_te_video");
			String ie_te_video = mr.getFilesystemName("ie_te_video");
			
			
			
			te.setIe_te_id(ie_te_id);
			te.setIe_te_nick(ie_te_nick);
			te.setIe_te_no(Integer.parseInt(ie_te_no));
			te.setIe_te_sports(ie_te_sports);
			te.setIe_te_team(ie_te_team);
			te.setIe_te_title(ie_te_title);
			te.setIe_te_content(ie_te_content);
			if(ie_te_img != null) {
				te.setIe_te_img(ie_te_img_old);
			}else {
				te.setIe_te_img(ie_te_img);
				String delImg = path + "/" + ie_te_img_old;
				File f = new File(delImg);
				f.delete();
			}
			if(ie_te_video != null) {
				te.setIe_te_img(ie_te_video_old);
			}else {
				te.setIe_te_img(ie_te_video);
				String delVideo = path + "/" + ie_te_video_old;
				File f = new File(delVideo);
				f.delete();
			}
			
			
			
			if(ss.getMapper(InfoEventMapper.class).updateTeamEvent(te)==1){
				req.setAttribute("r", "수정성공");
			}else {
				req.setAttribute("r", "수정실패");
				
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
public void deleteTeamEvent(HttpServletRequest req, TeamEventDTO te) {
		InfoEventMapper im = ss.getMapper(InfoEventMapper.class);
		if(im.deleteTeamEvent(te)==1) {
			req.setAttribute("r", "삭제 성공");
		}else {
			req.setAttribute("r", "삭제 실패");
		}
	}

public void getteamEventSearch(HttpServletRequest req, TeamEventDTO te) {
	req.setAttribute("SearchTeamEvent", ss.getMapper(InfoEventMapper.class).showTeamEventBySearch(te));
	
}


	
	
}
