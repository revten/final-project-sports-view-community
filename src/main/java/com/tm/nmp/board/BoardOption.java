package com.tm.nmp.board;

import javax.servlet.http.HttpServletRequest;

public class BoardOption {

	private int countPerPage;
	
	public static void clearSearch(HttpServletRequest req) {
		req.getSession().setAttribute("search", null);
	}

	public BoardOption() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BoardOption(int countPerPage) {
		super();
		this.countPerPage = countPerPage;
	}

	public int getCountPerPage() {
		return countPerPage;
	}

	public void setCountPerPage(int countPerPage) {
		this.countPerPage = countPerPage;
	}

}
