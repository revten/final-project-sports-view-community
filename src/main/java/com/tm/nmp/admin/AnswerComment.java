package com.tm.nmp.admin;

import java.math.BigDecimal;
import java.util.Date;

public class AnswerComment {
	
	public BigDecimal answer_comment_no;
	public int answer_comment_boardno;
	public String answer_comment_content;
	public Date answer_comment_date;
	public String ac_nick;
	public AnswerComment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AnswerComment(BigDecimal answer_comment_no, int answer_comment_boardno, String answer_comment_content,
			Date answer_comment_date, String ac_nick) {
		super();
		this.answer_comment_no = answer_comment_no;
		this.answer_comment_boardno = answer_comment_boardno;
		this.answer_comment_content = answer_comment_content;
		this.answer_comment_date = answer_comment_date;
		this.ac_nick = ac_nick;
	}
	public BigDecimal getanswer_comment_no() {
		return answer_comment_no;
	}
	public void setanswer_comment_no(BigDecimal answer_comment_no) {
		this.answer_comment_no = answer_comment_no;
	}
	public int getanswer_comment_boardno() {
		return answer_comment_boardno;
	}
	public void setanswer_comment_boardno(int answer_comment_boardno) {
		this.answer_comment_boardno = answer_comment_boardno;
	}
	public String getanswer_comment_content() {
		return answer_comment_content;
	}
	public void setanswer_comment_content(String answer_comment_content) {
		this.answer_comment_content = answer_comment_content;
	}
	public Date getanswer_comment_date() {
		return answer_comment_date;
	}
	public void setanswer_comment_date(Date answer_comment_date) {
		this.answer_comment_date = answer_comment_date;
	}
	public String getAc_nick() {
		return ac_nick;
	}
	public void setAc_nick(String ac_nick) {
		this.ac_nick = ac_nick;
	}
	
	

}
