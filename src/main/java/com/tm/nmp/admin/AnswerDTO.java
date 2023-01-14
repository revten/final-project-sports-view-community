package com.tm.nmp.admin;

import java.util.Date;

public class AnswerDTO {

	private int answer_no;
	private String answer_nick;
	private String answer_id;
	private String answer_title;
	private String answer_content;
	private Date answer_date;
	private String answer_img;
	private String answer_video;
	private String answer_cat;
	private int answer_count;
	public AnswerDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AnswerDTO(int answer_no, String answer_nick, String answer_id, String answer_title, String answer_content,
			Date answer_date, String answer_img, String answer_video, String answer_cat, int answer_count) {
		super();
		this.answer_no = answer_no;
		this.answer_nick = answer_nick;
		this.answer_id = answer_id;
		this.answer_title = answer_title;
		this.answer_content = answer_content;
		this.answer_date = answer_date;
		this.answer_img = answer_img;
		this.answer_video = answer_video;
		this.answer_cat = answer_cat;
		this.answer_count = answer_count;
	}
	public int getAnswer_no() {
		return answer_no;
	}
	public void setAnswer_no(int answer_no) {
		this.answer_no = answer_no;
	}
	public String getAnswer_nick() {
		return answer_nick;
	}
	public void setAnswer_nick(String answer_nick) {
		this.answer_nick = answer_nick;
	}
	public String getAnswer_id() {
		return answer_id;
	}
	public void setAnswer_id(String answer_id) {
		this.answer_id = answer_id;
	}
	public String getAnswer_title() {
		return answer_title;
	}
	public void setAnswer_title(String answer_title) {
		this.answer_title = answer_title;
	}
	public String getAnswer_content() {
		return answer_content;
	}
	public void setAnswer_content(String answer_content) {
		this.answer_content = answer_content;
	}
	public Date getAnswer_date() {
		return answer_date;
	}
	public void setAnswer_date(Date answer_date) {
		this.answer_date = answer_date;
	}
	public String getAnswer_img() {
		return answer_img;
	}
	public void setAnswer_img(String answer_img) {
		this.answer_img = answer_img;
	}
	public String getAnswer_video() {
		return answer_video;
	}
	public void setAnswer_video(String answer_video) {
		this.answer_video = answer_video;
	}
	public String getAnswer_cat() {
		return answer_cat;
	}
	public void setAnswer_cat(String answer_cat) {
		this.answer_cat = answer_cat;
	}
	public int getAnswer_count() {
		return answer_count;
	}
	public void setAnswer_count(int answer_count) {
		this.answer_count = answer_count;
	}
	
	
}
