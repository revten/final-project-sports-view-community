package com.tm.nmp.games;

import java.math.BigDecimal;
import java.util.Date;

public class TotoComment {
	
	public BigDecimal toto_comment_no;
	public int toto_comment_boardno;
	public String toto_comment_content;
	public Date toto_comment_date;
	public String ac_nick;
	public TotoComment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TotoComment(BigDecimal toto_comment_no, int toto_comment_boardno, String toto_comment_content,
			Date toto_comment_date, String ac_nick) {
		super();
		this.toto_comment_no = toto_comment_no;
		this.toto_comment_boardno = toto_comment_boardno;
		this.toto_comment_content = toto_comment_content;
		this.toto_comment_date = toto_comment_date;
		this.ac_nick = ac_nick;
	}
	public BigDecimal getToto_comment_no() {
		return toto_comment_no;
	}
	public void setToto_comment_no(BigDecimal toto_comment_no) {
		this.toto_comment_no = toto_comment_no;
	}
	public int getToto_comment_boardno() {
		return toto_comment_boardno;
	}
	public void setToto_comment_boardno(int toto_comment_boardno) {
		this.toto_comment_boardno = toto_comment_boardno;
	}
	public String getToto_comment_content() {
		return toto_comment_content;
	}
	public void setToto_comment_content(String toto_comment_content) {
		this.toto_comment_content = toto_comment_content;
	}
	public Date getToto_comment_date() {
		return toto_comment_date;
	}
	public void setToto_comment_date(Date toto_comment_date) {
		this.toto_comment_date = toto_comment_date;
	}
	public String getAc_nick() {
		return ac_nick;
	}
	public void setAc_nick(String ac_nick) {
		this.ac_nick = ac_nick;
	}
	
	
	
	
}
