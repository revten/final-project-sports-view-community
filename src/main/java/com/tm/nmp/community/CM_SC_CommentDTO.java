package com.tm.nmp.community;

import java.math.BigDecimal;
import java.util.Date;

public class CM_SC_CommentDTO {
	
	public BigDecimal cm_sc_comment_no;
	public int cm_sc_comment_boardno;
	public String cm_sc_comment_content;
	public Date cm_sc_comment_date;
	public String ac_nick;
	public CM_SC_CommentDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CM_SC_CommentDTO(BigDecimal cm_sc_comment_no, int cm_sc_comment_boardno, String cm_sc_comment_content,
			Date cm_sc_comment_date, String ac_nick) {
		super();
		this.cm_sc_comment_no = cm_sc_comment_no;
		this.cm_sc_comment_boardno = cm_sc_comment_boardno;
		this.cm_sc_comment_content = cm_sc_comment_content;
		this.cm_sc_comment_date = cm_sc_comment_date;
		this.ac_nick = ac_nick;
	}
	public BigDecimal getCm_sc_comment_no() {
		return cm_sc_comment_no;
	}
	public void setCm_sc_comment_no(BigDecimal cm_sc_comment_no) {
		this.cm_sc_comment_no = cm_sc_comment_no;
	}
	public int getCm_sc_comment_boardno() {
		return cm_sc_comment_boardno;
	}
	public void setCm_sc_comment_boardno(int cm_sc_comment_boardno) {
		this.cm_sc_comment_boardno = cm_sc_comment_boardno;
	}
	public String getCm_sc_comment_content() {
		return cm_sc_comment_content;
	}
	public void setCm_sc_comment_content(String cm_sc_comment_content) {
		this.cm_sc_comment_content = cm_sc_comment_content;
	}
	public Date getCm_sc_comment_date() {
		return cm_sc_comment_date;
	}
	public void setCm_sc_comment_date(Date cm_sc_comment_date) {
		this.cm_sc_comment_date = cm_sc_comment_date;
	}
	public String getAc_nick() {
		return ac_nick;
	}
	public void setAc_nick(String ac_nick) {
		this.ac_nick = ac_nick;
	}
	
}
