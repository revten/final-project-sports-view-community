package com.tm.nmp.board;

public class BoardSelector {

	private String search;
	private int start;
	private int end;

	private int Board_id;

	public BoardSelector() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BoardSelector(String search, int start, int end, int board_id) {
		super();
		this.search = search;
		this.start = start;
		this.end = end;
		Board_id = board_id;
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

	public int getBoard_id() {
		return Board_id;
	}

	public void setBoard_id(int board_id) {
		Board_id = board_id;
	}

}
