package com.tm.nmp.board;

public class BoardNumberList {
	private int[] boardNumberList;
	private int totalBoard;

	public BoardNumberList() {
		super();
		// TODO Auto-generated constructor stub
		boardNumberList = new int[] { 11, 12, 21, 22, 23, 24, 31 };
		// 11 : review 게시판
		// 12 : withGo 게시판
		// 21 : theFan - baseball 게시판
		// 22 : theFan - soccer 게시판
		// 23 : theFan - basketball 게시판
		// 24 : theFan - volleyball 게시판
		// 31 : clubEvent 게시판
		// 게시판 추가시 여기 게시판 번호만 추가해주면 됨
		totalBoard = boardNumberList.length;
	}

	public BoardNumberList(int[] boardNumberList, int totalBoard) {
		super();
		this.boardNumberList = boardNumberList;
		this.totalBoard = totalBoard;
	}

	public int[] getBoardNumberList() {
		return boardNumberList;
	}

	public void setBoardNumberList(int[] boardNumberList) {
		this.boardNumberList = boardNumberList;
	}

	public int getTotalBoard() {
		return totalBoard;
	}

	public void setTotalBoard(int totalBoard) {
		this.totalBoard = totalBoard;
	}

}
