package com.tm.nmp.account;

import java.util.Date;

public class AC_PF_TITLE {
	private int profile_id;
	private int user_id;
	private int club_id;
	private String league_id;
	private String profile_nick;
	private String profile_intro;
	private Date profile_birth;
	private int profile_sex;
	private int profile_subs;
	private Date profile_subs_begin;
	private Date profile_subs_end;
	private Date profile_update_date;
	
	public AC_PF_TITLE() {
		// TODO Auto-generated constructor stub
	}

	public AC_PF_TITLE(int profile_id, int user_id, int club_id, String league_id, String profile_nick,
			String profile_intro, Date profile_birth, int profile_sex, int profile_subs, Date profile_subs_begin,
			Date profile_subs_end, Date profile_update_date) {
		super();
		this.profile_id = profile_id;
		this.user_id = user_id;
		this.club_id = club_id;
		this.league_id = league_id;
		this.profile_nick = profile_nick;
		this.profile_intro = profile_intro;
		this.profile_birth = profile_birth;
		this.profile_sex = profile_sex;
		this.profile_subs = profile_subs;
		this.profile_subs_begin = profile_subs_begin;
		this.profile_subs_end = profile_subs_end;
		this.profile_update_date = profile_update_date;
	}

	public int getProfile_id() {
		return profile_id;
	}

	public void setProfile_id(int profile_id) {
		this.profile_id = profile_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getClub_id() {
		return club_id;
	}

	public void setClub_id(int club_id) {
		this.club_id = club_id;
	}

	public String getLeague_id() {
		return league_id;
	}

	public void setLeague_id(String league_id) {
		this.league_id = league_id;
	}

	public String getProfile_nick() {
		return profile_nick;
	}

	public void setProfile_nick(String profile_nick) {
		this.profile_nick = profile_nick;
	}

	public String getProfile_intro() {
		return profile_intro;
	}

	public void setProfile_intro(String profile_intro) {
		this.profile_intro = profile_intro;
	}

	public Date getProfile_birth() {
		return profile_birth;
	}

	public void setProfile_birth(Date profile_birth) {
		this.profile_birth = profile_birth;
	}

	public int getProfile_sex() {
		return profile_sex;
	}

	public void setProfile_sex(int profile_sex) {
		this.profile_sex = profile_sex;
	}

	public int getProfile_subs() {
		return profile_subs;
	}

	public void setProfile_subs(int profile_subs) {
		this.profile_subs = profile_subs;
	}

	public Date getProfile_subs_begin() {
		return profile_subs_begin;
	}

	public void setProfile_subs_begin(Date profile_subs_begin) {
		this.profile_subs_begin = profile_subs_begin;
	}

	public Date getProfile_subs_end() {
		return profile_subs_end;
	}

	public void setProfile_subs_end(Date profile_subs_end) {
		this.profile_subs_end = profile_subs_end;
	}

	public Date getProfile_update_date() {
		return profile_update_date;
	}

	public void setProfile_update_date(Date profile_update_date) {
		this.profile_update_date = profile_update_date;
	}
	
}
