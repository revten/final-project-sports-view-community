package com.tm.nmp.point;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PointDAO {
	
	int bonusPoint;	// 보너스 포인트
	double bonusRatio;	// 포인트 적립 비율
	double saleRatio;	// 할인률
	
	@Autowired
	private SqlSession ss;
	
	
	public void setGrade(PointVo pv) {
		if (pv.getGrade() == "다이아몬드") {
			bonusRatio = 0.05;
			saleRatio = 0.1;
		}else if (pv.getGrade() == "플래티넘") {
			bonusRatio = 0.04;
			saleRatio = 0.08;
		}else if (pv.getGrade() == "골드") {
			bonusRatio = 0.03;
			saleRatio = 0.06;
		}else if (pv.getGrade() == "실버") {
			bonusRatio = 0.02;
			saleRatio = 0.04;
		}else if (pv.getGrade() == "브론즈") {
			bonusRatio = 0.01;
			saleRatio = 0.02;
		}else {
			bonusRatio = 0;
			saleRatio = 0;
		}
	}

	// 게시판, 댓글로 받을 포인트
	public void calcAddPostAndAddCommentPoint(PointVo pv, int plusPoint) {
		int point = pv.getPoint() + plusPoint;
		pv.setPoint(point);
	}

// 영수증 첨부에 따른 추가 포인트           price = 영수증의 price
	public void calcReceiptPrice(PointVo pv, int price) {
		bonusPoint += price * bonusRatio; // 등급별 보너스% 다르게
		int point = pv.getPoint() + bonusPoint;
		pv.setPoint(point);
	}
	
	public void setGrade(PointVo pv, int point) {
		if(point >= 7000)
			pv.setGrade("다이아몬드");
		else if(point >=6000)
			pv.setGrade("플래티넘");
		else if(point >=5000)
			pv.setGrade("골드");
		else if(point >=4000)
			pv.setGrade("실버");
		else if(point >=3000)
			pv.setGrade("브론즈");
		else if(point >=2000)
			pv.setGrade("멤버");
		else if(point >=1000)
			pv.setGrade("루키");
		else
			pv.setGrade("뉴비");
	}

	

}
