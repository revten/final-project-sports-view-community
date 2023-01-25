package com.tm.nmp.board;

public class Reccomand {
	private int post_id;
	private String member_id;
	public Reccomand() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Reccomand(int post_id, String member_id) {
		super();
		this.post_id = post_id;
		this.member_id = member_id;
	}
	public int getPost_id() {
		return post_id;
	}
	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	
	
}
