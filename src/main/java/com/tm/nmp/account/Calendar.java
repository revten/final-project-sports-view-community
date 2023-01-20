package com.tm.nmp.account;

import java.util.Date;

public class Calendar {
	
	private String userId;
	private Date cal_date;
	
	public Calendar() {
		// TODO Auto-generated constructor stub
	}

	public Calendar(String userId, Date cal_date) {
		super();
		this.userId = userId;
		this.cal_date = cal_date;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Date getCal_date() {
		return cal_date;
	}

	public void setCal_date(Date cal_date) {
		this.cal_date = cal_date;
	}


	
	

}
