package com.tm.nmp.board;

public class BoardOption {

	private int board_id; // 게시판 번호
	private String field; // 검색 영역
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

	public BoardOption(int board_id, String field, String search, int countPerPage, int startNum, int endNum,
			int startPage, int endPage, int totalPages, int curPage) {
		super();
		this.board_id = board_id;
		this.field = field;
		this.search = search;
		this.countPerPage = countPerPage;
		this.startNum = startNum;
		this.endNum = endNum;
		this.startPage = startPage;
		this.endPage = endPage;
		this.totalPages = totalPages;
		this.curPage = curPage;
	}

	public int getBoard_id() {
		return board_id;
	}

	public void setBoard_id(int board_id) {
		this.board_id = board_id;
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

	public int getCountPerPage() {
		return countPerPage;
	}

	public void setCountPerPage(int countPerPage) {
		this.countPerPage = countPerPage;
	}

	public int getStartNum() {
		return startNum;
	}

	public void setStartNum(int startNum) {
		this.startNum = startNum;
	}

	public int getEndNum() {
		return endNum;
	}

	public void setEndNum(int endNum) {
		this.endNum = endNum;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public int getCurPage() {
		return curPage;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}

	@Override
	public String toString() {
		return "BoardOption [board_id=" + board_id + ", field=" + field + ", search=" + search + ", countPerPage="
				+ countPerPage + ", startNum=" + startNum + ", endNum=" + endNum + ", startPage=" + startPage
				+ ", endPage=" + endPage + ", totalPages=" + totalPages + ", curPage=" + curPage + "]";
	}

}
