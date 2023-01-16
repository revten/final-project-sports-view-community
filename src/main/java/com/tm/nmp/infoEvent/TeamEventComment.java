package com.tm.nmp.infoEvent;

import java.math.BigDecimal;
import java.util.Date;

public class TeamEventComment {
	
	public BigDecimal ie_te_comment_no;
	public int ie_te_comment_boardno;
	public String ie_te_comment_content;
	public Date ie_te_comment_date;
	public String ac_nick;
	public TeamEventComment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TeamEventComment(BigDecimal ie_te_comment_no, int ie_te_comment_boardno, String ie_te_comment_content,
			Date ie_te_comment_date, String ac_nick) {
		super();
		this.ie_te_comment_no = ie_te_comment_no;
		this.ie_te_comment_boardno = ie_te_comment_boardno;
		this.ie_te_comment_content = ie_te_comment_content;
		this.ie_te_comment_date = ie_te_comment_date;
		this.ac_nick = ac_nick;
	}
	public BigDecimal getIe_te_comment_no() {
		return ie_te_comment_no;
	}
	public void setIe_te_comment_no(BigDecimal ie_te_comment_no) {
		this.ie_te_comment_no = ie_te_comment_no;
	}
	public int getIe_te_comment_boardno() {
		return ie_te_comment_boardno;
	}
	public void setIe_te_comment_boardno(int ie_te_comment_boardno) {
		this.ie_te_comment_boardno = ie_te_comment_boardno;
	}
	public String getIe_te_comment_content() {
		return ie_te_comment_content;
	}
	public void setIe_te_comment_content(String ie_te_comment_content) {
		this.ie_te_comment_content = ie_te_comment_content;
	}
	public Date getIe_te_comment_date() {
		return ie_te_comment_date;
	}
	public void setIe_te_comment_date(Date ie_te_comment_date) {
		this.ie_te_comment_date = ie_te_comment_date;
	}
	public String getAc_nick() {
		return ac_nick;
	}
	public void setAc_nick(String ac_nick) {
		this.ac_nick = ac_nick;
	}
	
}
