package com.tm.nmp.community;

import java.sql.Date;

public class CM_SC_TITLE {
	private int cm_sc_no;
	private String cm_sc_nick;
	private String cm_sc_id;
	private String cm_sc_title;
	private String cm_sc_content;
	private Date cm_sc_date;
	private String cm_sc_img;
	private String cm_sc_video;
	private String cm_sc_cat;
	
	public CM_SC_TITLE() {
		// TODO Auto-generated constructor stub
	}

	public CM_SC_TITLE(int cm_sc_no, String cm_sc_nick, String cm_sc_id, String cm_sc_title, String cm_sc_content,
			Date cm_sc_date, String cm_sc_img, String cm_sc_video, String cm_sc_cat) {
		super();
		this.cm_sc_no = cm_sc_no;
		this.cm_sc_nick = cm_sc_nick;
		this.cm_sc_id = cm_sc_id;
		this.cm_sc_title = cm_sc_title;
		this.cm_sc_content = cm_sc_content;
		this.cm_sc_date = cm_sc_date;
		this.cm_sc_img = cm_sc_img;
		this.cm_sc_video = cm_sc_video;
		this.cm_sc_cat = cm_sc_cat;
	}

	public int getCm_sc_no() {
		return cm_sc_no;
	}

	public void setCm_sc_no(int cm_sc_no) {
		this.cm_sc_no = cm_sc_no;
	}

	public String getCm_sc_nick() {
		return cm_sc_nick;
	}

	public void setCm_sc_nick(String cm_sc_nick) {
		this.cm_sc_nick = cm_sc_nick;
	}

	public String getCm_sc_id() {
		return cm_sc_id;
	}

	public void setCm_sc_id(String cm_sc_id) {
		this.cm_sc_id = cm_sc_id;
	}

	public String getCm_sc_title() {
		return cm_sc_title;
	}

	public void setCm_sc_title(String cm_sc_title) {
		this.cm_sc_title = cm_sc_title;
	}

	public String getCm_sc_content() {
		return cm_sc_content;
	}

	public void setCm_sc_content(String cm_sc_content) {
		this.cm_sc_content = cm_sc_content;
	}

	public Date getCm_sc_date() {
		return cm_sc_date;
	}

	public void setCm_sc_date(Date cm_sc_date) {
		this.cm_sc_date = cm_sc_date;
	}

	public String getCm_sc_img() {
		return cm_sc_img;
	}

	public void setCm_sc_img(String cm_sc_img) {
		this.cm_sc_img = cm_sc_img;
	}

	public String getCm_sc_video() {
		return cm_sc_video;
	}

	public void setCm_sc_video(String cm_sc_video) {
		this.cm_sc_video = cm_sc_video;
	}

	public String getCm_sc_cat() {
		return cm_sc_cat;
	}

	public void setCm_sc_cat(String cm_sc_cat) {
		this.cm_sc_cat = cm_sc_cat;
	}
	
}
