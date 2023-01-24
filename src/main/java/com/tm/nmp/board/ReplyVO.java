package com.tm.nmp.board;

import java.util.Date;

public class ReplyVO {

	int reply_id; // 댓글PK primary key
	int reply_board; // 게시판PK not null
	int reply_post; // 게시글PK not null

	String reply_member; // 회원 PK not null
	String reply_content; // 댓글 내용 not null
	Date reply_reg_date; // 댓글 등록일시 not null
	Date reply_update_date; // 댓글 수정일시 null
	int reply_like_count; // 댓글 추천수 not null
	String reply_reg_ip;

	public ReplyVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ReplyVO(int reply_id, int reply_board, int reply_post, String reply_member, String reply_content,
			Date reply_reg_date, Date reply_update_date, int reply_like_count, String reply_reg_ip) {
		super();
		this.reply_id = reply_id;
		this.reply_board = reply_board;
		this.reply_post = reply_post;
		this.reply_member = reply_member;
		this.reply_content = reply_content;
		this.reply_reg_date = reply_reg_date;
		this.reply_update_date = reply_update_date;
		this.reply_like_count = reply_like_count;
		this.reply_reg_ip = reply_reg_ip;
	}

	public int getReply_id() {
		return reply_id;
	}

	public void setReply_id(int reply_id) {
		this.reply_id = reply_id;
	}

	public int getReply_board() {
		return reply_board;
	}

	public void setReply_board(int reply_board) {
		this.reply_board = reply_board;
	}

	public int getReply_post() {
		return reply_post;
	}

	public void setReply_post(int reply_post) {
		this.reply_post = reply_post;
	}

	public String getReply_member() {
		return reply_member;
	}

	public void setReply_member(String reply_member) {
		this.reply_member = reply_member;
	}

	public String getReply_content() {
		return reply_content;
	}

	public void setReply_content(String reply_content) {
		this.reply_content = reply_content;
	}

	public Date getReply_reg_date() {
		return reply_reg_date;
	}

	public void setReply_reg_date(Date reply_reg_date) {
		this.reply_reg_date = reply_reg_date;
	}

	public Date getReply_update_date() {
		return reply_update_date;
	}

	public void setReply_update_date(Date reply_update_date) {
		this.reply_update_date = reply_update_date;
	}

	public int getReply_like_count() {
		return reply_like_count;
	}

	public void setReply_like_count(int reply_like_count) {
		this.reply_like_count = reply_like_count;
	}

	public String getReply_reg_ip() {
		return reply_reg_ip;
	}

	public void setReply_reg_ip(String reply_reg_ip) {
		this.reply_reg_ip = reply_reg_ip;
	}

}
