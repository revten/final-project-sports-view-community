package com.tm.nmp.newsEvent;

import java.util.Date;
import java.util.List;

public class ClubEventDTO {

	private int ie_te_no;
	private String ie_te_id;
	private String ie_te_nick;
	private String ie_te_sports;
	private String ie_te_club;
	private String ie_te_title;
	private String ie_te_content;
	private Date ie_te_regdate;
	private String ie_te_img;
	private String ie_te_video;
	private int ie_te_views;
	private int ie_te_comtNo;
	private String ie_te_ip;
	
	private List<ClubEventComment> ie_te_comments;

	public ClubEventDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ClubEventDTO(int ie_te_no, String ie_te_id, String ie_te_nick, String ie_te_sports, String ie_te_club,
			String ie_te_title, String ie_te_content, Date ie_te_regdate, String ie_te_img, String ie_te_video,
			int ie_te_views, int ie_te_comtNo, String ie_te_ip, List<ClubEventComment> ie_te_comments) {
		super();
		this.ie_te_no = ie_te_no;
		this.ie_te_id = ie_te_id;
		this.ie_te_nick = ie_te_nick;
		this.ie_te_sports = ie_te_sports;
		this.ie_te_club = ie_te_club;
		this.ie_te_title = ie_te_title;
		this.ie_te_content = ie_te_content;
		this.ie_te_regdate = ie_te_regdate;
		this.ie_te_img = ie_te_img;
		this.ie_te_video = ie_te_video;
		this.ie_te_views = ie_te_views;
		this.ie_te_comtNo = ie_te_comtNo;
		this.ie_te_ip = ie_te_ip;
		this.ie_te_comments = ie_te_comments;
	}

	public int getIe_te_no() {
		return ie_te_no;
	}

	public void setIe_te_no(int ie_te_no) {
		this.ie_te_no = ie_te_no;
	}

	public String getIe_te_id() {
		return ie_te_id;
	}

	public void setIe_te_id(String ie_te_id) {
		this.ie_te_id = ie_te_id;
	}

	public String getIe_te_nick() {
		return ie_te_nick;
	}

	public void setIe_te_nick(String ie_te_nick) {
		this.ie_te_nick = ie_te_nick;
	}

	public String getIe_te_sports() {
		return ie_te_sports;
	}

	public void setIe_te_sports(String ie_te_sports) {
		this.ie_te_sports = ie_te_sports;
	}

	public String getIe_te_club() {
		return ie_te_club;
	}

	public void setIe_te_club(String ie_te_club) {
		this.ie_te_club = ie_te_club;
	}

	public String getIe_te_title() {
		return ie_te_title;
	}

	public void setIe_te_title(String ie_te_title) {
		this.ie_te_title = ie_te_title;
	}

	public String getIe_te_content() {
		return ie_te_content;
	}

	public void setIe_te_content(String ie_te_content) {
		this.ie_te_content = ie_te_content;
	}

	public Date getIe_te_regdate() {
		return ie_te_regdate;
	}

	public void setIe_te_regdate(Date ie_te_regdate) {
		this.ie_te_regdate = ie_te_regdate;
	}

	public String getIe_te_img() {
		return ie_te_img;
	}

	public void setIe_te_img(String ie_te_img) {
		this.ie_te_img = ie_te_img;
	}

	public String getIe_te_video() {
		return ie_te_video;
	}

	public void setIe_te_video(String ie_te_video) {
		this.ie_te_video = ie_te_video;
	}

	public int getIe_te_views() {
		return ie_te_views;
	}

	public void setIe_te_views(int ie_te_views) {
		this.ie_te_views = ie_te_views;
	}

	public int getIe_te_comtNo() {
		return ie_te_comtNo;
	}

	public void setIe_te_comtNo(int ie_te_comtNo) {
		this.ie_te_comtNo = ie_te_comtNo;
	}

	public String getIe_te_ip() {
		return ie_te_ip;
	}

	public void setIe_te_ip(String ie_te_ip) {
		this.ie_te_ip = ie_te_ip;
	}

	public List<ClubEventComment> getIe_te_comments() {
		return ie_te_comments;
	}

	public void setIe_te_comments(List<ClubEventComment> ie_te_comments) {
		this.ie_te_comments = ie_te_comments;
	}
	
	

	
	
	
	
}
