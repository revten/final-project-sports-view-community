package com.tm.nmp.board;

public class BoardSelector {
	
	private String search;
	private int start;
	private int end;
	private int post_board;
	public BoardSelector() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BoardSelector(String search, int start, int end, int post_board) {
		super();
		this.search = search;
		this.start = start;
		this.end = end;
		this.post_board = post_board;
	}
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	public int getPost_board() {
		return post_board;
	}
	public void setPost_board(int post_board) {
		this.post_board = post_board;
	}
	
}
