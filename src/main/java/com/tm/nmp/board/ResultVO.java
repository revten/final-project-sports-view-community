package com.tm.nmp.board;

public class ResultVO {

	private String token;
	private int result;
	
	public ResultVO() {
		// TODO Auto-generated constructor stub
	}

	public ResultVO(String token, int result) {
		super();
		this.token = token;
		this.result = result;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "ResultVO [token=" + token + ", result=" + result + "]";
	}
	
}
