package com.tm.nmp.board;

import javax.servlet.http.HttpServletRequest;

public class BoardOption {
	
	private int post_board;
	private String field;
	private String search;
	private int start;
	private int end;
	private int countPerPage;
	
	public static void clearSearch(HttpServletRequest req) {
		req.getSession().setAttribute("search", null);
	}

	public BoardOption() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BoardOption(int post_board, String field, String search, int start, int end, int countPerPage) {
		super();
		this.post_board = post_board;
		this.field = field;
		this.search = search;
		this.start = start;
		this.end = end;
		this.countPerPage = countPerPage;
	}

	public int getPost_board() {
		return post_board;
	}

	public void setPost_board(int post_board) {
		this.post_board = post_board;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
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

	public int getCountPerPage() {
		return countPerPage;
	}

	public void setCountPerPage(int countPerPage) {
		this.countPerPage = countPerPage;
	}

}
