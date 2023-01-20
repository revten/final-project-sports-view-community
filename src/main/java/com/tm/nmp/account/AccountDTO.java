package com.tm.nmp.account;

import java.util.Date;

public class AccountDTO {
	private String member_id;
	private String member_pwd;
	private String member_pwConfirm;
	private String member_nick;
	private int member_auth_type;
	private int member_reg_type;
	private Date member_reg_date;
	private String member_reg_ip;
	private String member_email;
	private String member_intro;
	private int club_id;
	private int member_subs;
	private Date member_subs_begin;
	private Date member_subs_end;
	private Date member_update_date;
	private Date member_date_withdrawn;
	private int member_admin;
	
	public AccountDTO() {
		// TODO Auto-generated constructor stub
	}

	public AccountDTO(String member_id, String member_pwd, String member_pwConfirm, String member_nick,
			int member_auth_type, int member_reg_type, Date member_reg_date, String member_reg_ip, String member_email,
			String member_intro, int club_id, int member_subs, Date member_subs_begin, Date member_subs_end,
			Date member_update_date, Date member_date_withdrawn, int member_admin) {
		super();
		this.member_id = member_id;
		this.member_pwd = member_pwd;
		this.member_pwConfirm = member_pwConfirm;
		this.member_nick = member_nick;
		this.member_auth_type = member_auth_type;
		this.member_reg_type = member_reg_type;
		this.member_reg_date = member_reg_date;
		this.member_reg_ip = member_reg_ip;
		this.member_email = member_email;
		this.member_intro = member_intro;
		this.club_id = club_id;
		this.member_subs = member_subs;
		this.member_subs_begin = member_subs_begin;
		this.member_subs_end = member_subs_end;
		this.member_update_date = member_update_date;
		this.member_date_withdrawn = member_date_withdrawn;
		this.member_admin = member_admin;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public String getMember_pwd() {
		return member_pwd;
	}

	public void setMember_pwd(String member_pwd) {
		this.member_pwd = member_pwd;
	}

	public String getMember_pwConfirm() {
		return member_pwConfirm;
	}

	public void setMember_pwConfirm(String member_pwConfirm) {
		this.member_pwConfirm = member_pwConfirm;
	}

	public String getMember_nick() {
		return member_nick;
	}

	public void setMember_nick(String member_nick) {
		this.member_nick = member_nick;
	}

	public int getMember_auth_type() {
		return member_auth_type;
	}

	public void setMember_auth_type(int member_auth_type) {
		this.member_auth_type = member_auth_type;
	}

	public int getMember_reg_type() {
		return member_reg_type;
	}

	public void setMember_reg_type(int member_reg_type) {
		this.member_reg_type = member_reg_type;
	}

	public Date getMember_reg_date() {
		return member_reg_date;
	}

	public void setMember_reg_date(Date member_reg_date) {
		this.member_reg_date = member_reg_date;
	}

	public String getMember_reg_ip() {
		return member_reg_ip;
	}

	public void setMember_reg_ip(String member_reg_ip) {
		this.member_reg_ip = member_reg_ip;
	}

	public String getMember_email() {
		return member_email;
	}

	public void setMember_email(String member_email) {
		this.member_email = member_email;
	}

	public String getMember_intro() {
		return member_intro;
	}

	public void setMember_intro(String member_intro) {
		this.member_intro = member_intro;
	}

	public int getClub_id() {
		return club_id;
	}

	public void setClub_id(int club_id) {
		this.club_id = club_id;
	}

	public int getMember_subs() {
		return member_subs;
	}

	public void setMember_subs(int member_subs) {
		this.member_subs = member_subs;
	}

	public Date getMember_subs_begin() {
		return member_subs_begin;
	}

	public void setMember_subs_begin(Date member_subs_begin) {
		this.member_subs_begin = member_subs_begin;
	}

	public Date getMember_subs_end() {
		return member_subs_end;
	}

	public void setMember_subs_end(Date member_subs_end) {
		this.member_subs_end = member_subs_end;
	}

	public Date getMember_update_date() {
		return member_update_date;
	}

	public void setMember_update_date(Date member_update_date) {
		this.member_update_date = member_update_date;
	}

	public Date getMember_date_withdrawn() {
		return member_date_withdrawn;
	}

	public void setMember_date_withdrawn(Date member_date_withdrawn) {
		this.member_date_withdrawn = member_date_withdrawn;
	}

	public int getMember_admin() {
		return member_admin;
	}

	public void setMember_admin(int member_admin) {
		this.member_admin = member_admin;
	}
	
}
