package com.tm.nmp.mypage;

import java.math.BigDecimal;
import java.util.Date;

public class MyPostComment {
	
	public BigDecimal mypost_comment_no;
	public int mypost_comment_boardno;
	public String mypost_comment_content;
	public Date mypost_comment_date;
	public String ac_nick;
	public MyPostComment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MyPostComment(BigDecimal mypost_comment_no, int mypost_comment_boardno, String mypost_comment_content,
			Date mypost_comment_date, String ac_nick) {
		super();
		this.mypost_comment_no = mypost_comment_no;
		this.mypost_comment_boardno = mypost_comment_boardno;
		this.mypost_comment_content = mypost_comment_content;
		this.mypost_comment_date = mypost_comment_date;
		this.ac_nick = ac_nick;
	}
	public BigDecimal getMypost_comment_no() {
		return mypost_comment_no;
	}
	public void setMypost_comment_no(BigDecimal mypost_comment_no) {
		this.mypost_comment_no = mypost_comment_no;
	}
	public int getMypost_comment_boardno() {
		return mypost_comment_boardno;
	}
	public void setMypost_comment_boardno(int mypost_comment_boardno) {
		this.mypost_comment_boardno = mypost_comment_boardno;
	}
	public String getMypost_comment_content() {
		return mypost_comment_content;
	}
	public void setMypost_comment_content(String mypost_comment_content) {
		this.mypost_comment_content = mypost_comment_content;
	}
	public Date getMypost_comment_date() {
		return mypost_comment_date;
	}
	public void setMypost_comment_date(Date mypost_comment_date) {
		this.mypost_comment_date = mypost_comment_date;
	}
	public String getAc_nick() {
		return ac_nick;
	}
	public void setAc_nick(String ac_nick) {
		this.ac_nick = ac_nick;
	}

	
}
