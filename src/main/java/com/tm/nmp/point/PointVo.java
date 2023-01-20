package com.tm.nmp.point;

public class PointVo {

	private String userId;
	private String grade;
	private int point;
	int bonusPoint;	// 보너스 포인트
	double bonusRatio;	// 포인트 적립 비율
	double saleRatio;	// 할인률
	
	
	
	public PointVo() {
		if (grade == "다이아몬드") {
			bonusRatio = 0.05;
			saleRatio = 0.1;
		}else if (grade == "플래티넘") {
			bonusRatio = 0.04;
			saleRatio = 0.08;
		}else if (grade == "골드") {
			bonusRatio = 0.03;
			saleRatio = 0.06;
		}else if (grade == "실버") {
			bonusRatio = 0.02;
			saleRatio = 0.04;
		}else if (grade == "브론즈") {
			bonusRatio = 0.01;
			saleRatio = 0.02;
		}else {
			bonusRatio = 0;
			saleRatio = 0;
		}
		
	}												// 게시판, 댓글로 받을 포인트
		public int calcAddPostAndAddCommentPoint(int plusPoint) {
			point += (point + plusPoint);
			return point;
		}
	
		// 영수증 첨부에 따른 추가 포인트           price = 영수증의 price
		public int calcReceiptPrice(int price) {
			bonusPoint += price * bonusRatio; // 등급별 보너스% 다르게
			point += (point + bonusPoint);
			return point;
		}
		
		public String showBonusInfo() {
			return userId + "님의 등급은" + grade + "이며, 보너스 포인트는 " + bonusPoint + "입니다.";
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

	public void setGrade(int point) {
		if(point >= 7000)
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
		this.grade = grade;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}
	
	
	
}
