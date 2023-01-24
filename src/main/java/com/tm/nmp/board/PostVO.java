package com.tm.nmp.board;

import java.util.Date;
import java.util.List;

public class PostVO {
	int post_id; // PK
	int post_board; // 게시판FK
	String post_member; // 회원 FK
	int post_sports; // null 가능
	int post_league; // null 가능
	int post_club; // null 가능
	String post_title; // 글 제목
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

	String member_nick; // 다른 테이블에서 관계형으로 닉네임을 가져와 게시판에 보여줄 항목이라 미리 만들어둠
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

	public PostVO(int post_id, int post_board, String post_member, int post_sports, int post_league, int post_club,
			String post_title, int post_category, String post_content, Date post_reg_date, Date post_update_date,
			String post_img, String post_file, int post_hit_count, int post_like_count, int post_scrap_count,
			int post_comment_count, String post_reg_ip, String member_nick, String sports_name, String club_name,
			String league_name, List<ReplyVO> replies) {
		super();
		this.post_id = post_id;
		this.post_board = post_board;
		this.post_member = post_member;
		this.post_sports = post_sports;
		this.post_league = post_league;
		this.post_club = post_club;
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

	public int getPost_board() {
		return post_board;
	}

	public void setPost_board(int post_board) {
		this.post_board = post_board;
	}

	public String getPost_member() {
		return post_member;
	}

	public void setPost_member(String post_member) {
		this.post_member = post_member;
	}

	public int getPost_sports() {
		return post_sports;
	}

	public void setPost_sports(int post_sports) {
		this.post_sports = post_sports;
	}

	public int getPost_league() {
		return post_league;
	}

	public void setPost_league(int post_league) {
		this.post_league = post_league;
	}

	public int getPost_club() {
		return post_club;
	}

	public void setPost_club(int post_club) {
		this.post_club = post_club;
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
