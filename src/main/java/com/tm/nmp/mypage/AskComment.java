package com.tm.nmp.mypage;

import java.math.BigDecimal;
import java.util.Date;

public class AskComment {

	public BigDecimal ask_comment_no;
	public int ask_comment_boardno;
	public String ask_comment_content;
	public Date ask_comment_date;
	public String ac_nick;
	public AskComment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AskComment(BigDecimal ask_comment_no, int ask_comment_boardno, String ask_comment_content,
			Date ask_comment_date, String ac_nick) {
		super();
		this.ask_comment_no = ask_comment_no;
		this.ask_comment_boardno = ask_comment_boardno;
		this.ask_comment_content = ask_comment_content;
		this.ask_comment_date = ask_comment_date;
		this.ac_nick = ac_nick;
	}
	public BigDecimal getAsk_comment_no() {
		return ask_comment_no;
	}
	public void setAsk_comment_no(BigDecimal ask_comment_no) {
		this.ask_comment_no = ask_comment_no;
	}
	public int getAsk_comment_boardno() {
		return ask_comment_boardno;
	}
	public void setAsk_comment_boardno(int ask_comment_boardno) {
		this.ask_comment_boardno = ask_comment_boardno;
	}
	public String getAsk_comment_content() {
		return ask_comment_content;
	}
	public void setAsk_comment_content(String ask_comment_content) {
		this.ask_comment_content = ask_comment_content;
	}
	public Date getAsk_comment_date() {
		return ask_comment_date;
	}
	public void setAsk_comment_date(Date ask_comment_date) {
		this.ask_comment_date = ask_comment_date;
	}
	public String getAc_nick() {
		return ac_nick;
	}
	public void setAc_nick(String ac_nick) {
		this.ac_nick = ac_nick;
	}
	
	
}
