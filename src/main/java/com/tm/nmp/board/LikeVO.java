package com.tm.nmp.board;

public class LikeVO {
	int like_id;
	int like_post;
	String like_member;
	int like_count;

	public LikeVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LikeVO(int like_id, int like_post, String like_member, int like_count) {
		super();
		this.like_id = like_id;
		this.like_post = like_post;
		this.like_member = like_member;
		this.like_count = like_count;
	}

	public int getLike_id() {
		return like_id;
	}

	public void setLike_id(int like_id) {
		this.like_id = like_id;
	}

	public int getLike_post() {
		return like_post;
	}

	public void setLike_post(int like_post) {
		this.like_post = like_post;
	}

	public String getLike_member() {
		return like_member;
	}

	public void setLike_member(String like_member) {
		this.like_member = like_member;
	}

	public int getLike_count() {
		return like_count;
	}

	public void setLike_count(int like_count) {
		this.like_count = like_count;
	}

}
