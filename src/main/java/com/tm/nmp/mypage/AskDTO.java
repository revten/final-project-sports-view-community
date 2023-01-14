package com.tm.nmp.mypage;

import java.util.Date;

public class AskDTO {

	private int ask_no;
	private String ask_nick;
	private String ask_id;
	private String ask_title;
	private String ask_content;
	private Date ask_date;
	private String ask_img;
	private String ask_video;
	private String ask_cat;
	private int ask_count;
	public AskDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AskDTO(int ask_no, String ask_nick, String ask_id, String ask_title, String ask_content, Date ask_date,
			String ask_img, String ask_video, String ask_cat, int ask_count) {
		super();
		this.ask_no = ask_no;
		this.ask_nick = ask_nick;
		this.ask_id = ask_id;
		this.ask_title = ask_title;
		this.ask_content = ask_content;
		this.ask_date = ask_date;
		this.ask_img = ask_img;
		this.ask_video = ask_video;
		this.ask_cat = ask_cat;
		this.ask_count = ask_count;
	}
	public int getAsk_no() {
		return ask_no;
	}
	public void setAsk_no(int ask_no) {
		this.ask_no = ask_no;
	}
	public String getAsk_nick() {
		return ask_nick;
	}
	public void setAsk_nick(String ask_nick) {
		this.ask_nick = ask_nick;
	}
	public String getAsk_id() {
		return ask_id;
	}
	public void setAsk_id(String ask_id) {
		this.ask_id = ask_id;
	}
	public String getAsk_title() {
		return ask_title;
	}
	public void setAsk_title(String ask_title) {
		this.ask_title = ask_title;
	}
	public String getAsk_content() {
		return ask_content;
	}
	public void setAsk_content(String ask_content) {
		this.ask_content = ask_content;
	}
	public Date getAsk_date() {
		return ask_date;
	}
	public void setAsk_date(Date ask_date) {
		this.ask_date = ask_date;
	}
	public String getAsk_img() {
		return ask_img;
	}
	public void setAsk_img(String ask_img) {
		this.ask_img = ask_img;
	}
	public String getAsk_video() {
		return ask_video;
	}
	public void setAsk_video(String ask_video) {
		this.ask_video = ask_video;
	}
	public String getAsk_cat() {
		return ask_cat;
	}
	public void setAsk_cat(String ask_cat) {
		this.ask_cat = ask_cat;
	}
	public int getAsk_count() {
		return ask_count;
	}
	public void setAsk_count(int ask_count) {
		this.ask_count = ask_count;
	}
	
	
}
