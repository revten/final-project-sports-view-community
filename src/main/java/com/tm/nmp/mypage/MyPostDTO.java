package com.tm.nmp.mypage;

import java.util.Date;

public class MyPostDTO {

	private int mypost_no;
	private String mypost_nick;
	private String mypost_id;
	private String mypost_title;
	private String mypost_content;
	private Date mypost_date;
	private String mypost_img;
	private String mypost_video;
	private String mypost_cat;
	private int mypost_count;
	public MyPostDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MyPostDTO(int mypost_no, String mypost_nick, String mypost_id, String mypost_title, String mypost_content,
			Date mypost_date, String mypost_img, String mypost_video, String mypost_cat, int mypost_count) {
		super();
		this.mypost_no = mypost_no;
		this.mypost_nick = mypost_nick;
		this.mypost_id = mypost_id;
		this.mypost_title = mypost_title;
		this.mypost_content = mypost_content;
		this.mypost_date = mypost_date;
		this.mypost_img = mypost_img;
		this.mypost_video = mypost_video;
		this.mypost_cat = mypost_cat;
		this.mypost_count = mypost_count;
	}
	public int getMypost_no() {
		return mypost_no;
	}
	public void setMypost_no(int mypost_no) {
		this.mypost_no = mypost_no;
	}
	public String getMypost_nick() {
		return mypost_nick;
	}
	public void setMypost_nick(String mypost_nick) {
		this.mypost_nick = mypost_nick;
	}
	public String getMypost_id() {
		return mypost_id;
	}
	public void setMypost_id(String mypost_id) {
		this.mypost_id = mypost_id;
	}
	public String getMypost_title() {
		return mypost_title;
	}
	public void setMypost_title(String mypost_title) {
		this.mypost_title = mypost_title;
	}
	public String getMypost_content() {
		return mypost_content;
	}
	public void setMypost_content(String mypost_content) {
		this.mypost_content = mypost_content;
	}
	public Date getMypost_date() {
		return mypost_date;
	}
	public void setMypost_date(Date mypost_date) {
		this.mypost_date = mypost_date;
	}
	public String getMypost_img() {
		return mypost_img;
	}
	public void setMypost_img(String mypost_img) {
		this.mypost_img = mypost_img;
	}
	public String getMypost_video() {
		return mypost_video;
	}
	public void setMypost_video(String mypost_video) {
		this.mypost_video = mypost_video;
	}
	public String getMypost_cat() {
		return mypost_cat;
	}
	public void setMypost_cat(String mypost_cat) {
		this.mypost_cat = mypost_cat;
	}
	public int getMypost_count() {
		return mypost_count;
	}
	public void setMypost_count(int mypost_count) {
		this.mypost_count = mypost_count;
	}
	
	
	
}
