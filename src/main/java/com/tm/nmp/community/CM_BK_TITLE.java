package com.tm.nmp.community;

import java.sql.Date;

public class CM_BK_TITLE {
	private int cm_bk_no;
	private String cm_bk_nick;
	private String cm_bk_id;
	private String cm_bk_title;
	private String cm_bk_content;
	private Date cm_bk_date;
	private String cm_bk_img;
	private String cm_bk_cat;
	public CM_BK_TITLE() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CM_BK_TITLE(int cm_bk_no, String cm_bk_nick, String cm_bk_id, String cm_bk_title, String cm_bk_content,
			Date cm_bk_date, String cm_bk_img, String cm_bk_cat) {
		super();
		this.cm_bk_no = cm_bk_no;
		this.cm_bk_nick = cm_bk_nick;
		this.cm_bk_id = cm_bk_id;
		this.cm_bk_title = cm_bk_title;
		this.cm_bk_content = cm_bk_content;
		this.cm_bk_date = cm_bk_date;
		this.cm_bk_img = cm_bk_img;
		this.cm_bk_cat = cm_bk_cat;
	}
	public int getCm_bk_no() {
		return cm_bk_no;
	}
	public void setCm_bk_no(int cm_bk_no) {
		this.cm_bk_no = cm_bk_no;
	}
	public String getCm_bk_nick() {
		return cm_bk_nick;
	}
	public void setCm_bk_nick(String cm_bk_nick) {
		this.cm_bk_nick = cm_bk_nick;
	}
	public String getCm_bk_id() {
		return cm_bk_id;
	}
	public void setCm_bk_id(String cm_bk_id) {
		this.cm_bk_id = cm_bk_id;
	}
	public String getCm_bk_title() {
		return cm_bk_title;
	}
	public void setCm_bk_title(String cm_bk_title) {
		this.cm_bk_title = cm_bk_title;
	}
	public String getCm_bk_content() {
		return cm_bk_content;
	}
	public void setCm_bk_content(String cm_bk_content) {
		this.cm_bk_content = cm_bk_content;
	}
	public Date getCm_bk_date() {
		return cm_bk_date;
	}
	public void setCm_bk_date(Date cm_bk_date) {
		this.cm_bk_date = cm_bk_date;
	}
	public String getCm_bk_img() {
		return cm_bk_img;
	}
	public void setCm_bk_img(String cm_bk_img) {
		this.cm_bk_img = cm_bk_img;
	}
	public String getCm_bk_cat() {
		return cm_bk_cat;
	}
	public void setCm_bk_cat(String cm_bk_cat) {
		this.cm_bk_cat = cm_bk_cat;
	}
	
}
