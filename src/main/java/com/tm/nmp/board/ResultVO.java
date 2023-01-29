package com.tm.nmp.board;

// Ajax 요청에  대한 결과를 담아주기 위하여 생성하였다

public class ResultVO {

	private String token;
	private int result;
	private ReplyVO replyVO;

	public ResultVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ResultVO(String token, int result, ReplyVO replyVO) {
		super();
		this.token = token;
		this.result = result;
		this.replyVO = replyVO;
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

	public ReplyVO getReplyVO() {
		return replyVO;
	}

	public void setReplyVO(ReplyVO replyVO) {
		this.replyVO = replyVO;
	}

	@Override
	public String toString() {
		return "ResultVO [token=" + token + ", result=" + result + ", replyVO=" + replyVO + "]";
	}

}
