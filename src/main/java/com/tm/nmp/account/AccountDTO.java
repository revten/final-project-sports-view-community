package com.tm.nmp.account;

import java.util.Date;

public class AccountDTO {
	private String ac_id;
	private String ac_pw;
	private String ac_nick;
	private String ac_name;
	private String ac_pwConfirm;
	private String ac_addr;
	private String ac_email;
	private String ac_linkWhere;
	private Date ac_date;
	public AccountDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AccountDTO(String ac_id, String ac_pw, String ac_nick, String ac_name, String ac_pwConfirm, String ac_addr,
			String ac_email, String ac_linkWhere, Date ac_date) {
		super();
		this.ac_id = ac_id;
		this.ac_pw = ac_pw;
		this.ac_nick = ac_nick;
		this.ac_name = ac_name;
		this.ac_pwConfirm = ac_pwConfirm;
		this.ac_addr = ac_addr;
		this.ac_email = ac_email;
		this.ac_linkWhere = ac_linkWhere;
		this.ac_date = ac_date;
	}
	public String getAc_id() {
		return ac_id;
	}
	public void setAc_id(String ac_id) {
		this.ac_id = ac_id;
	}
	public String getAc_pw() {
		return ac_pw;
	}
	public void setAc_pw(String ac_pw) {
		this.ac_pw = ac_pw;
	}
	public String getAc_nick() {
		return ac_nick;
	}
	public void setAc_nick(String ac_nick) {
		this.ac_nick = ac_nick;
	}
	public String getAc_name() {
		return ac_name;
	}
	public void setAc_name(String ac_name) {
		this.ac_name = ac_name;
	}
	public String getAc_pwConfirm() {
		return ac_pwConfirm;
	}
	public void setAc_pwConfirm(String ac_pwConfirm) {
		this.ac_pwConfirm = ac_pwConfirm;
	}
	public String getAc_addr() {
		return ac_addr;
	}
	public void setAc_addr(String ac_addr) {
		this.ac_addr = ac_addr;
	}
	public String getAc_email() {
		return ac_email;
	}
	public void setAc_email(String ac_email) {
		this.ac_email = ac_email;
	}
	public String getAc_linkWhere() {
		return ac_linkWhere;
	}
	public void setAc_linkWhere(String ac_linkWhere) {
		this.ac_linkWhere = ac_linkWhere;
	}
	public Date getAc_date() {
		return ac_date;
	}
	public void setAc_date(Date ac_date) {
		this.ac_date = ac_date;
	}

}
