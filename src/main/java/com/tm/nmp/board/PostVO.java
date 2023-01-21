package com.tm.nmp.board;

import java.util.Date;
import java.util.List;

public class PostVO {
	int post_id; // 게시글PK primary key
	int board_id; // 게시판FK not null - 어느 게시판인가
	String member_id; // 회원 FK not null
	String post_title; // 글 제목 not null
	int post_category; // 글 종류 1:잡담, 2:질문, 3:정보
	String post_content; // 글 내용 not null
	Date post_reg_date; // 글 작성시간 not null
	Date post_update_date; // 글 수정시간
	String post_img; // 첨부이미지
	String post_file; // 첨부파일
	int post_hit_count; // 글 조회수 not null
	int post_like_count; // 글 추천수 not null
	int post_scrap_count; // 글 스크랩수 not null
	int post_comment_count; // 글 댓글수 not null
	String post_reg_ip; // 글 작성 ip not null

	String member_nick; // profile DB에서 닉네임을 가져와 게시판에 보여줄 항목이라 미리 만들어둠
	// 등급 아이콘
	// 팬인 구단 로고
	String sports_name; // 함께가기/리뷰/분석 게시판을 위한 요소
	String club_name; // 함께가기/리뷰/분석 게시판을 위한 요소
	String league_name; // 함께가기/리뷰/분석 게시판을 위한 요소
	private List<ReplyVO> replies; // 글과 함께 댓글 같이 보여줄 것이기 때문에 가져옴

	public PostVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PostVO(int post_id, int board_id, String member_id, String post_title, int post_category,
			String post_content, Date post_reg_date, Date post_update_date, String post_img, String post_file,
			int post_hit_count, int post_like_count, int post_scrap_count, int post_comment_count, String post_reg_ip,
			String member_nick, String sports_name, String club_name, String league_name, List<ReplyVO> replies) {
		super();
		this.post_id = post_id;
		this.board_id = board_id;
		this.member_id = member_id;
		this.post_title = post_title;
		this.post_category = post_category;
		this.post_content = post_content;
		this.post_reg_date = post_reg_date;
		this.post_update_date = post_update_date;
		this.post_img = post_img;
		this.post_file = post_file;
		this.post_hit_count = post_hit_count;
		this.post_like_count = post_like_count;
		this.post_scrap_count = post_scrap_count;
		this.post_comment_count = post_comment_count;
		this.post_reg_ip = post_reg_ip;
		this.member_nick = member_nick;
		this.sports_name = sports_name;
		this.club_name = club_name;
		this.league_name = league_name;
		this.replies = replies;
	}

	public int getPost_id() {
		return post_id;
	}

	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}

	public int getBoard_id() {
		return board_id;
	}

	public void setBoard_id(int board_id) {
		this.board_id = board_id;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public String getPost_title() {
		return post_title;
	}

	public void setPost_title(String post_title) {
		this.post_title = post_title;
	}

	public int getPost_category() {
		return post_category;
	}

	public void setPost_category(int post_category) {
		this.post_category = post_category;
	}

	public String getPost_content() {
		return post_content;
	}

	public void setPost_content(String post_content) {
		this.post_content = post_content;
	}

	public Date getPost_reg_date() {
		return post_reg_date;
	}

	public void setPost_reg_date(Date post_reg_date) {
		this.post_reg_date = post_reg_date;
	}

	public Date getPost_update_date() {
		return post_update_date;
	}

	public void setPost_update_date(Date post_update_date) {
		this.post_update_date = post_update_date;
	}

	public String getPost_img() {
		return post_img;
	}

	public void setPost_img(String post_img) {
		this.post_img = post_img;
	}

	public String getPost_file() {
		return post_file;
	}

	public void setPost_file(String post_file) {
		this.post_file = post_file;
	}

	public int getPost_hit_count() {
		return post_hit_count;
	}

	public void setPost_hit_count(int post_hit_count) {
		this.post_hit_count = post_hit_count;
	}

	public int getPost_like_count() {
		return post_like_count;
	}

	public void setPost_like_count(int post_like_count) {
		this.post_like_count = post_like_count;
	}

	public int getPost_scrap_count() {
		return post_scrap_count;
	}

	public void setPost_scrap_count(int post_scrap_count) {
		this.post_scrap_count = post_scrap_count;
	}

	public int getPost_comment_count() {
		return post_comment_count;
	}

	public void setPost_comment_count(int post_comment_count) {
		this.post_comment_count = post_comment_count;
	}

	public String getPost_reg_ip() {
		return post_reg_ip;
	}

	public void setPost_reg_ip(String post_reg_ip) {
		this.post_reg_ip = post_reg_ip;
	}

	public String getMember_nick() {
		return member_nick;
	}

	public void setMember_nick(String member_nick) {
		this.member_nick = member_nick;
	}

	public String getSports_name() {
		return sports_name;
	}

	public void setSports_name(String sports_name) {
		this.sports_name = sports_name;
	}

	public String getClub_name() {
		return club_name;
	}

	public void setClub_name(String club_name) {
		this.club_name = club_name;
	}

	public String getLeague_name() {
		return league_name;
	}

	public void setLeague_name(String league_name) {
		this.league_name = league_name;
	}

	public List<ReplyVO> getReplies() {
		return replies;
	}

	public void setReplies(List<ReplyVO> replies) {
		this.replies = replies;
	}

}
