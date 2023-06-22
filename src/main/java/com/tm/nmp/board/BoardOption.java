package com.tm.nmp.board;

import lombok.Data;

@Data
public class BoardOption {

	private int board_id; // 게시판 번호
	private String field; // 검색 영역
	private String field2; // 검색 영역2 (stadium 페이지에서 활용)
	private String search; // 검색어
	private int countPerPage; // 한 페이지당 글 수
	private int startNum; // 한 페이지의 첫 글
	private int endNum; // 한 페이지의 마지막 글
	private int startPage; // 한화면에 보여줄 페이지 목록 처음
	private int endPage; // 한화면에 보여줄 페이지 목록 마지막
	private int totalPages; // 총 페이지 수
	private int curPage; // 현재 보여주는 페이지
	// 총 게시글 수 -> DAO allPostCount

	public BoardOption() {
		super();
		// TODO Auto-generated constructor stub
	}

}
