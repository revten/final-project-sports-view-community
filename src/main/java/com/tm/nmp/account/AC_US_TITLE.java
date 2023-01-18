package com.tm.nmp.account;

import java.util.Date;

public class AC_US_TITLE {
	private int user_id; //sequence
	private String user_id_name; //id
	private String user_pwd;
	private String user_pwdConfirm;
	private int user_reg_type; // null
	private Date user_reg_date;
	private String user_reg_ip;
	private int user_admin; // 0: user 1:admin
	private int user_auth_type; // 0: email 1:social
	private String user_email;
	private Date user_date_withdrawn; // 탈퇴 날짜
	
	public AC_US_TITLE() {
		// TODO Auto-generated constructor stub
	}

	public AC_US_TITLE(int user_id, String user_id_name, String user_pwd, String user_pwdConfirm, int user_reg_type,
			Date user_reg_date, String user_reg_ip, int user_admin, int user_auth_type, String user_email,
			Date user_date_withdrawn) {
		super();
		this.user_id = user_id;
		this.user_id_name = user_id_name;
		this.user_pwd = user_pwd;
		this.user_pwdConfirm = user_pwdConfirm;
		this.user_reg_type = user_reg_type;
		this.user_reg_date = user_reg_date;
		this.user_reg_ip = user_reg_ip;
		this.user_admin = user_admin;
		this.user_auth_type = user_auth_type;
		this.user_email = user_email;
		this.user_date_withdrawn = user_date_withdrawn;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUser_id_name() {
		return user_id_name;
	}

	public void setUser_id_name(String user_id_name) {
		this.user_id_name = user_id_name;
	}

	public String getUser_pwd() {
		return user_pwd;
	}

	public void setUser_pwd(String user_pwd) {
		this.user_pwd = user_pwd;
	}

	public String getUser_pwdConfirm() {
		return user_pwdConfirm;
	}

	public void setUser_pwdConfirm(String user_pwdConfirm) {
		this.user_pwdConfirm = user_pwdConfirm;
	}

	public int getUser_reg_type() {
		return user_reg_type;
	}

	public void setUser_reg_type(int user_reg_type) {
		this.user_reg_type = user_reg_type;
	}

	public Date getUser_reg_date() {
		return user_reg_date;
	}

	public void setUser_reg_date(Date user_reg_date) {
		this.user_reg_date = user_reg_date;
	}

	public String getUser_reg_ip() {
		return user_reg_ip;
	}

	public void setUser_reg_ip(String user_reg_ip) {
		this.user_reg_ip = user_reg_ip;
	}

	public int getUser_admin() {
		return user_admin;
	}

	public void setUser_admin(int user_admin) {
		this.user_admin = user_admin;
	}

	public int getUser_auth_type() {
		return user_auth_type;
	}

	public void setUser_auth_type(int user_auth_type) {
		this.user_auth_type = user_auth_type;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public Date getUser_date_withdrawn() {
		return user_date_withdrawn;
	}

	public void setUser_date_withdrawn(Date user_date_withdrawn) {
		this.user_date_withdrawn = user_date_withdrawn;
	}
	
}