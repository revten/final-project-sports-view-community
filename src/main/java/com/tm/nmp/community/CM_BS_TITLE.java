package com.tm.nmp.community;

import java.sql.Date;
import java.util.List;

public class CM_BS_TITLE {
	private int cm_bs_no;
	private String cm_bs_nick;
	private String cm_bs_id;
	private String cm_bs_title;
	private String cm_bs_content;
	private Date cm_bs_date;
	private String cm_bs_img;
	private String cm_bs_cat;
	
	private List <CM_BS_CommentDTO> cm_bs_comments;

	public CM_BS_TITLE() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CM_BS_TITLE(int cm_bs_no, String cm_bs_nick, String cm_bs_id, String cm_bs_title, String cm_bs_content,
			Date cm_bs_date, String cm_bs_img, String cm_bs_cat, List<CM_BS_CommentDTO> cm_bs_comments) {
		super();
		this.cm_bs_no = cm_bs_no;
		this.cm_bs_nick = cm_bs_nick;
		this.cm_bs_id = cm_bs_id;
		this.cm_bs_title = cm_bs_title;
		this.cm_bs_content = cm_bs_content;
		this.cm_bs_date = cm_bs_date;
		this.cm_bs_img = cm_bs_img;
		this.cm_bs_cat = cm_bs_cat;
		this.cm_bs_comments = cm_bs_comments;
	}

	public int getCm_bs_no() {
		return cm_bs_no;
	}

	public void setCm_bs_no(int cm_bs_no) {
		this.cm_bs_no = cm_bs_no;
	}

	public String getCm_bs_nick() {
		return cm_bs_nick;
	}

	public void setCm_bs_nick(String cm_bs_nick) {
		this.cm_bs_nick = cm_bs_nick;
	}

	public String getCm_bs_id() {
		return cm_bs_id;
	}

	public void setCm_bs_id(String cm_bs_id) {
		this.cm_bs_id = cm_bs_id;
	}

	public String getCm_bs_title() {
		return cm_bs_title;
	}

	public void setCm_bs_title(String cm_bs_title) {
		this.cm_bs_title = cm_bs_title;
	}

	public String getCm_bs_content() {
		return cm_bs_content;
	}

	public void setCm_bs_content(String cm_bs_content) {
		this.cm_bs_content = cm_bs_content;
	}

	public Date getCm_bs_date() {
		return cm_bs_date;
	}

	public void setCm_bs_date(Date cm_bs_date) {
		this.cm_bs_date = cm_bs_date;
	}

	public String getCm_bs_img() {
		return cm_bs_img;
	}

	public void setCm_bs_img(String cm_bs_img) {
		this.cm_bs_img = cm_bs_img;
	}

	public String getCm_bs_cat() {
		return cm_bs_cat;
	}

	public void setCm_bs_cat(String cm_bs_cat) {
		this.cm_bs_cat = cm_bs_cat;
	}

	public List<CM_BS_CommentDTO> getCm_bs_comments() {
		return cm_bs_comments;
	}

	public void setCm_bs_comments(List<CM_BS_CommentDTO> cm_bs_comments) {
		this.cm_bs_comments = cm_bs_comments;
	}
	
	
	
}
