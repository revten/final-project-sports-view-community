package com.tm.nmp.games;

import java.util.Date;
import java.util.List;

public class TotoDTO {

	private int toto_no;
	private String toto_nick;
	private String toto_id;
	private String toto_title;
	private String toto_content;
	private Date toto_date;
	private String toto_img;
	private String toto_video;
	private String toto_cat;
	private int toto_count;
	
	private List<TotoComment> toto_comments;
	private String ac_nick;
	public TotoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TotoDTO(int toto_no, String toto_nick, String toto_id, String toto_title, String toto_content,
			Date toto_date, String toto_img, String toto_video, String toto_cat, int toto_count,
			List<TotoComment> toto_comments, String ac_nick) {
		super();
		this.toto_no = toto_no;
		this.toto_nick = toto_nick;
		this.toto_id = toto_id;
		this.toto_title = toto_title;
		this.toto_content = toto_content;
		this.toto_date = toto_date;
		this.toto_img = toto_img;
		this.toto_video = toto_video;
		this.toto_cat = toto_cat;
		this.toto_count = toto_count;
		this.toto_comments = toto_comments;
		this.ac_nick = ac_nick;
	}
	public int getToto_no() {
		return toto_no;
	}
	public void setToto_no(int toto_no) {
		this.toto_no = toto_no;
	}
	public String getToto_nick() {
		return toto_nick;
	}
	public void setToto_nick(String toto_nick) {
		this.toto_nick = toto_nick;
	}
	public String getToto_id() {
		return toto_id;
	}
	public void setToto_id(String toto_id) {
		this.toto_id = toto_id;
	}
	public String getToto_title() {
		return toto_title;
	}
	public void setToto_title(String toto_title) {
		this.toto_title = toto_title;
	}
	public String getToto_content() {
		return toto_content;
	}
	public void setToto_content(String toto_content) {
		this.toto_content = toto_content;
	}
	public Date getToto_date() {
		return toto_date;
	}
	public void setToto_date(Date toto_date) {
		this.toto_date = toto_date;
	}
	public String getToto_img() {
		return toto_img;
	}
	public void setToto_img(String toto_img) {
		this.toto_img = toto_img;
	}
	public String getToto_video() {
		return toto_video;
	}
	public void setToto_video(String toto_video) {
		this.toto_video = toto_video;
	}
	public String getToto_cat() {
		return toto_cat;
	}
	public void setToto_cat(String toto_cat) {
		this.toto_cat = toto_cat;
	}
	public int getToto_count() {
		return toto_count;
	}
	public void setToto_count(int toto_count) {
		this.toto_count = toto_count;
	}
	public List<TotoComment> getToto_coments() {
		return toto_comments;
	}
	public void setToto_comments(List<TotoComment> toto_comments) {
		this.toto_comments = toto_comments;
	}
	public String getAc_nick() {
		return ac_nick;
	}
	public void setAc_nick(String ac_nick) {
		this.ac_nick = ac_nick;
	}

	
	
	
}
