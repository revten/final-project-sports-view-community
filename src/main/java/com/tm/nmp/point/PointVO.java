package com.tm.nmp.point;

public class PointVO {

	private String point_member;
	private String point_grade;
	private int point;
	public PointVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PointVO(String point_member, String point_grade, int point) {
		super();
		this.point_member = point_member;
		this.point_grade = point_grade;
		this.point = point;
	}
	public String getPoint_member() {
		return point_member;
	}
	public void setPoint_member(String point_member) {
		this.point_member = point_member;
	}
	public String getPoint_grade() {
		return point_grade;
	}
	public void setPoint_grade(String point_grade) {
		this.point_grade = point_grade;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	
	
	
	
	
	
}
