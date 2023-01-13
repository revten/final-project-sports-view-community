package com.tm.nmp.infoEvent;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.tm.nmp.account.AccountDTO;



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
		MultipartRequest mr = null;
		System.out.println(path);
		
		AccountDTO loginMember = (AccountDTO) req.getSession().getAttribute("loginAccount");
		String ie_te_id = loginMember.getAc_id();
		String ie_te_nick = loginMember.getAc_nick();
		
		try {
			mr = new MultipartRequest(req, path, 30*1024*1024, "utf-8", new DefaultFileRenamePolicy());
			
			
			String ie_te_sports = mr.getParameter("ie_te_sports");
			String ie_te_team = mr.getParameter("ie_te_team");
			String ie_te_title = mr.getParameter("ie_te_title");
			String ie_te_content = mr.getParameter("ie_te_content");
			ie_te_content = ie_te_content.replace("\r\n", "<br>");
			String ie_te_img = mr.getFilesystemName("ie_te_img");
			String ie_te_video = mr.getFilesystemName("ie_te_video");
			int ie_te_views = 0;
			int ie_te_comtNo = 0;
			String ie_te_ip = req.getRemoteAddr();
			
			System.out.println(ie_te_id);
			System.out.println(ie_te_nick);
			System.out.println(ie_te_sports);
			System.out.println(ie_te_team);
			System.out.println(ie_te_title);
			System.out.println(ie_te_content);
			System.out.println(ie_te_img);
			System.out.println(ie_te_video);
			System.out.println(ie_te_views);
			System.out.println(ie_te_comtNo);
			System.out.println(ie_te_ip);
			
			te.setIe_te_id(ie_te_id);
			te.setIe_te_nick(ie_te_nick);
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
				te.setIe_te_video(ie_te_video);
			}else {
				te.setIe_te_video("");
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
			e.printStackTrace();
			String fileName = mr.getFilesystemName("ie_te_vedio");
			new File(path + "/" + fileName).delete();
		}
		
	}
	
	public void updateTeamEvent(HttpServletRequest req, TeamEventDTO te) {
		String path = req.getSession().getServletContext().getRealPath("resources/files/teamEventImg");
		System.out.println(path);
		String ie_te_img_old = null;
		String ie_te_img = null;
		AccountDTO loginMember = (AccountDTO) req.getSession().getAttribute("loginAccount");
		String ie_te_id = loginMember.getAc_id();
		String ie_te_nick = loginMember.getAc_nick();
		
		try {
			MultipartRequest mr = new MultipartRequest(req, path, 30*1024*1024, "utf-8", new DefaultFileRenamePolicy());
			
			String ie_te_sports = mr.getParameter("ie_te_sports");
			String ie_te_team = mr.getParameter("ie_te_team");
			String ie_te_title = mr.getParameter("ie_te_title");
			String ie_te_content = mr.getParameter("ie_te_content");
			ie_te_content = ie_te_content.replace("\r\n", "<br>");
			ie_te_img_old = mr.getParameter("ie_te_img");
			ie_te_img = mr.getFilesystemName("ie_te_img");
			String ie_te_video_old = mr.getParameter("ie_te_video");
			String ie_te_video = mr.getFilesystemName("ie_te_video_new");
			
			System.out.println(ie_te_id);
			System.out.println(ie_te_nick);
			System.out.println(ie_te_sports);
			System.out.println(ie_te_team);
			System.out.println(ie_te_title);
			System.out.println(ie_te_content);
			System.out.println(ie_te_img);
			System.out.println(ie_te_video);
			
			te.setIe_te_id(ie_te_id);
			te.setIe_te_nick(ie_te_nick);
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
				te.setIe_te_img(ie_te_video);
			}else {
				te.setIe_te_img(ie_te_video_old);
				String delVideo = path + "/" + ie_te_video_old;
				File f = new File(delVideo);
				f.delete();
			}
			
			
			
			if(ss.getMapper(InfoEventMapper.class).updateTeamEvent(te)==1){
				req.setAttribute("r", "수정성공");
				if(!ie_te_img_old.equals(ie_te_img)) {
					ie_te_img_old = URLDecoder.decode(ie_te_img_old, "utf-8");
					new File(path + "/" + ie_te_img_old).delete();
					
				}
			}else {
				req.setAttribute("r", "수정실패");
				if(!ie_te_img_old.equals(ie_te_img)) {
					ie_te_img = URLDecoder.decode(ie_te_img, "utf-8");
					new File(path + "/" + ie_te_img).delete();
					
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
			req.setAttribute("r", "수정실패");
			if(!ie_te_img_old.equals(ie_te_img)) {
				try {
				ie_te_img = URLDecoder.decode(ie_te_img, "utf-8");
				} catch (UnsupportedEncodingException el) {
				}
				new File(path + "/" + ie_te_img).delete();
		}
		
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
