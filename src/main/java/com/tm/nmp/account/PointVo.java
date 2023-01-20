package com.tm.nmp.account;

public class PointVo {

	private String userId;
	private String grade;
	private int point;
	
	public PointVo() {
		// TODO Auto-generated constructor stub
	}

	public PointVo(String userId, String grade, int point) {
		super();
		this.userId = userId;
		this.grade = grade;
		this.point = point;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
	/*	if(point >= 7000)
			grade = "다이아몬드";
		else if(point >=6000)
			grade = "플래티넘";
		else if(point >=5000)
			grade = "골드";
		else if(point >=4000)
			grade = "실버";
		else if(point >=3000)
			grade = "브론즈";
		else if(point >=2000)
			grade = "멤버";
		else if(point >=1000)
			grade = "루키";
		else
			grade = "뉴비";
		return grade;*/
		this.grade = grade;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}
	
	
}
