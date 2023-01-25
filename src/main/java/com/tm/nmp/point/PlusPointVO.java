package com.tm.nmp.point;

import java.util.Date;

public class PlusPointVO {
	private String plusPoint_member;
	private int plusPoint;
	private Date plusPoint_date;
	public PlusPointVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PlusPointVO(String plusPoint_member, int plusPoint, Date plusPoint_date) {
		super();
		this.plusPoint_member = plusPoint_member;
		this.plusPoint = plusPoint;
		this.plusPoint_date = plusPoint_date;
	}
	public String getPlusPoint_member() {
		return plusPoint_member;
	}
	public void setPlusPoint_member(String plusPoint_member) {
		this.plusPoint_member = plusPoint_member;
	}
	public int getPlusPoint() {
		return plusPoint;
	}
	public void setPlusPoint(int plusPoint) {
		this.plusPoint = plusPoint;
	}
	public Date getPlusPoint_date() {
		return plusPoint_date;
	}
	public void setPlusPoint_date(Date plusPoint_date) {
		this.plusPoint_date = plusPoint_date;
	}
	
	
}
