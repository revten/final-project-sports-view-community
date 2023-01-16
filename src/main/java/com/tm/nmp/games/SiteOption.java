package com.tm.nmp.games;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

public class SiteOption {
	
	private int postCountPerPage; // 한페이지당 post개수

	public SiteOption() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SiteOption(int postCountPerPage) {
		super();
		this.postCountPerPage = postCountPerPage;
	}

	public int getPostCountPerPage() {
		return postCountPerPage;
	}

	public void setPostCountPerPage(int postCountPerPage) {
		this.postCountPerPage = postCountPerPage;
	}

	public static void clearSearch(HttpServletRequest req) {
		req.getSession().setAttribute("search", null);
	}
	
	
}
