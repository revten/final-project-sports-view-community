package com.tm.nmp.community;

import java.util.Date;

public class CommunityDTO {
private int wg_no;
private String wg_nick;
private String wg_id;
private String wg_title;
private String wg_content;
private Date wg_date;
private String wg_img;
private String wg_video;
private String wg_cat;
private int wg_count;
private int wg_like;
private String search;
private int sort;

private int rnStart;
private int rnEnd;

public CommunityDTO() {
	// TODO Auto-generated constructor stub
}

public CommunityDTO(int wg_no, String wg_nick, String wg_id, String wg_title, String wg_content, Date wg_date,
		String wg_img, String wg_video, String wg_cat, int wg_count, int wg_like, String search, int sort, int rnStart,
		int rnEnd) {
	super();
	this.wg_no = wg_no;
	this.wg_nick = wg_nick;
	this.wg_id = wg_id;
	this.wg_title = wg_title;
	this.wg_content = wg_content;
	this.wg_date = wg_date;
	this.wg_img = wg_img;
	this.wg_video = wg_video;
	this.wg_cat = wg_cat;
	this.wg_count = wg_count;
	this.wg_like = wg_like;
	this.search = search;
	this.sort = sort;
	this.rnStart = rnStart;
	this.rnEnd = rnEnd;
}

public int getWg_no() {
	return wg_no;
}

public void setWg_no(int wg_no) {
	this.wg_no = wg_no;
}

public String getWg_nick() {
	return wg_nick;
}

public void setWg_nick(String wg_nick) {
	this.wg_nick = wg_nick;
}

public String getWg_id() {
	return wg_id;
}

public void setWg_id(String wg_id) {
	this.wg_id = wg_id;
}

public String getWg_title() {
	return wg_title;
}

public void setWg_title(String wg_title) {
	this.wg_title = wg_title;
}

public String getWg_content() {
	return wg_content;
}

public void setWg_content(String wg_content) {
	this.wg_content = wg_content;
}

public Date getWg_date() {
	return wg_date;
}

public void setWg_date(Date wg_date) {
	this.wg_date = wg_date;
}

public String getWg_img() {
	return wg_img;
}

public void setWg_img(String wg_img) {
	this.wg_img = wg_img;
}

public String getWg_video() {
	return wg_video;
}

public void setWg_video(String wg_video) {
	this.wg_video = wg_video;
}

public String getWg_cat() {
	return wg_cat;
}

public void setWg_cat(String wg_cat) {
	this.wg_cat = wg_cat;
}

public int getWg_count() {
	return wg_count;
}

public void setWg_count(int wg_count) {
	this.wg_count = wg_count;
}

public int getWg_like() {
	return wg_like;
}

public void setWg_like(int wg_like) {
	this.wg_like = wg_like;
}

public String getSearch() {
	return search;
}

public void setSearch(String search) {
	this.search = search;
}

public int getSort() {
	return sort;
}

public void setSort(int sort) {
	this.sort = sort;
}

public int getRnStart() {
	return rnStart;
}

public void setRnStart(int rnStart) {
	this.rnStart = rnStart;
}

public int getRnEnd() {
	return rnEnd;
}

public void setRnEnd(int rnEnd) {
	this.rnEnd = rnEnd;
}

}
