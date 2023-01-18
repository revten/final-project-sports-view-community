package com.tm.nmp.community;

import java.sql.Date;

public class CM_VL_TITLE {

	private int cm_vl_no;
	private String cm_vl_nick;
	private String cm_vl_id;
	private String cm_vl_title;
	private String cm_vl_content;
	private Date cm_vl_date;
	private String cm_vl_img;
	private String cm_vl_cat;
	public CM_VL_TITLE() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CM_VL_TITLE(int cm_vl_no, String cm_vl_nick, String cm_vl_id, String cm_vl_title, String cm_vl_content,
			Date cm_vl_date, String cm_vl_img, String cm_vl_cat) {
		super();
		this.cm_vl_no = cm_vl_no;
		this.cm_vl_nick = cm_vl_nick;
		this.cm_vl_id = cm_vl_id;
		this.cm_vl_title = cm_vl_title;
		this.cm_vl_content = cm_vl_content;
		this.cm_vl_date = cm_vl_date;
		this.cm_vl_img = cm_vl_img;
		this.cm_vl_cat = cm_vl_cat;
	}
	public int getCm_vl_no() {
		return cm_vl_no;
	}
	public void setCm_vl_no(int cm_vl_no) {
		this.cm_vl_no = cm_vl_no;
	}
	public String getCm_vl_nick() {
		return cm_vl_nick;
	}
	public void setCm_vl_nick(String cm_vl_nick) {
		this.cm_vl_nick = cm_vl_nick;
	}
	public String getCm_vl_id() {
		return cm_vl_id;
	}
	public void setCm_vl_id(String cm_vl_id) {
		this.cm_vl_id = cm_vl_id;
	}
	public String getCm_vl_title() {
		return cm_vl_title;
	}
	public void setCm_vl_title(String cm_vl_title) {
		this.cm_vl_title = cm_vl_title;
	}
	public String getCm_vl_content() {
		return cm_vl_content;
	}
	public void setCm_vl_content(String cm_vl_content) {
		this.cm_vl_content = cm_vl_content;
	}
	public Date getCm_vl_date() {
		return cm_vl_date;
	}
	public void setCm_vl_date(Date cm_vl_date) {
		this.cm_vl_date = cm_vl_date;
	}
	public String getCm_vl_img() {
		return cm_vl_img;
	}
	public void setCm_vl_img(String cm_vl_img) {
		this.cm_vl_img = cm_vl_img;
	}
	public String getCm_vl_cat() {
		return cm_vl_cat;
	}
	public void setCm_vl_cat(String cm_vl_cat) {
		this.cm_vl_cat = cm_vl_cat;
	}
	
}
