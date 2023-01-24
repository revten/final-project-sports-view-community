package com.tm.nmp.account;

import java.util.List;

public class EventVo {

	private List<Calendar> dateList;

	public EventVo() {
		// TODO Auto-generated constructor stub
	}

	public EventVo(List<Calendar> dateList) {
		super();
		this.dateList = dateList;
	}

	public List<Calendar> getDateList() {
		return dateList;
	}

	public void setDateList(List<Calendar> dateList) {
		this.dateList = dateList;
	}

}