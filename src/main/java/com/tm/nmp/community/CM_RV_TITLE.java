package com.tm.nmp.community;

import java.util.Date;

public class CM_RV_TITLE {
private int rv_no;
private String rv_nick;
private String rv_id;
private String rv_title;
private String rv_content;
private Date rv_date;
private String rv_img;
private String rv_video;
private String rv_cat;
private int rv_count;
private int rv_like;
private String search;
private int sort;

private int rnStart;
private int rnEnd;

public CM_RV_TITLE() {
	// TODO Auto-generated constructor stub
}

public CM_RV_TITLE(int rv_no, String rv_nick, String rv_id, String rv_title, String rv_content, Date rv_date,
		String rv_img, String rv_video, String rv_cat, int rv_count, int rv_like, String search, int sort, int rnStart,
		int rnEnd) {
	super();
	this.rv_no = rv_no;
	this.rv_nick = rv_nick;
	this.rv_id = rv_id;
	this.rv_title = rv_title;
	this.rv_content = rv_content;
	this.rv_date = rv_date;
	this.rv_img = rv_img;
	this.rv_video = rv_video;
	this.rv_cat = rv_cat;
	this.rv_count = rv_count;
	this.rv_like = rv_like;
	this.search = search;
	this.sort = sort;
	this.rnStart = rnStart;
	this.rnEnd = rnEnd;
}

public int getRv_no() {
	return rv_no;
}

public void setRv_no(int rv_no) {
	this.rv_no = rv_no;
}

public String getRv_nick() {
	return rv_nick;
}

public void setRv_nick(String rv_nick) {
	this.rv_nick = rv_nick;
}

public String getRv_id() {
	return rv_id;
}

public void setRv_id(String rv_id) {
	this.rv_id = rv_id;
}

public String getRv_title() {
	return rv_title;
}

public void setRv_title(String rv_title) {
	this.rv_title = rv_title;
}

public String getRv_content() {
	return rv_content;
}

public void setRv_content(String rv_content) {
	this.rv_content = rv_content;
}

public Date getRv_date() {
	return rv_date;
}

public void setRv_date(Date rv_date) {
	this.rv_date = rv_date;
}

public String getRv_img() {
	return rv_img;
}

public void setRv_img(String rv_img) {
	this.rv_img = rv_img;
}

public String getRv_video() {
	return rv_video;
}

public void setRv_video(String rv_video) {
	this.rv_video = rv_video;
}

public String getRv_cat() {
	return rv_cat;
}

public void setRv_cat(String rv_cat) {
	this.rv_cat = rv_cat;
}

public int getRv_count() {
	return rv_count;
}

public void setRv_count(int rv_count) {
	this.rv_count = rv_count;
}

public int getRv_like() {
	return rv_like;
}

public void setRv_like(int rv_like) {
	this.rv_like = rv_like;
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
