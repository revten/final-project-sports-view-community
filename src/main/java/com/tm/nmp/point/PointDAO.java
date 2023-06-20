package com.tm.nmp.point;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tm.nmp.model.AccountVO;

@Service
public class PointDAO {
	
	int bonusPoint;	// 보너스 포인트
	double bonusRatio;	// 포인트 적립 비율
	double saleRatio;	// 할인률
	
	@Autowired
	private SqlSession ss;
	
	
	public void setBonusRatio(PointVO pv) {
		if (pv.getPoint_grade() == "챌린저") {
			bonusRatio = 0.05;
			saleRatio = 0.1;
		}else if (pv.getPoint_grade() == "그랜드마스터") {
			bonusRatio = 0.04;
			saleRatio = 0.08;
		}else if (pv.getPoint_grade() == "마스터") {
			bonusRatio = 0.03;
			saleRatio = 0.06;
		}else if (pv.getPoint_grade() == "다이아몬드") {
			bonusRatio = 0.02;
			saleRatio = 0.04;
		}else if (pv.getPoint_grade() == "플래티넘") {
			bonusRatio = 0.01;
			saleRatio = 0.02;
		}else {
			bonusRatio = 0;
			saleRatio = 0;
		}
	}

// 영수증 첨부에 따른 추가 포인트           price = 영수증의 price
	public void calcReceiptPrice(PointVO pv, int price) {
		bonusPoint += price * bonusRatio; // 등급별 보너스% 다르게
		int point = pv.getPoint() + bonusPoint;
		pv.setPoint(point);
		
	}
	
	
	
	// 게시판, 댓글로 받을 포인트
	public void calcAddPostAndAddCommentPoint(HttpServletRequest req,PointVO pv, PlusPointVO ppv, int plusPoint) {
		
		AccountVO ac = (AccountVO) req.getSession().getAttribute("loginAccount");
		pv.setPoint_member(ac.getId());
		ppv.setPlusPoint_member(ac.getId());
		ppv.setPlusPoint(plusPoint);
		
		// 현재 포인트 조회
		int nPoint = ss.getMapper(PointMapper.class).getNpoint(pv);
		
		// 현재포인트 + 추가될포인트
		int point = nPoint + plusPoint;
		System.out.println(nPoint);
		System.out.println(point);
		
		pv.setPoint(point);
		if(point >= 7000)
			pv.setPoint_grade("챌린저");
		else if(point >=6000)
			pv.setPoint_grade("그랜드마스터");
		else if(point >=5000)
			pv.setPoint_grade("마스터");
		else if(point >=4000)
			pv.setPoint_grade("다이아몬드");
		else if(point >=3000)
			pv.setPoint_grade("플래티넘");
		else if(point >=2000)
			pv.setPoint_grade("골드");
		else if(point >=1000)
			pv.setPoint_grade("실버");
		else
			pv.setPoint_grade("브론즈");
		
		if(ss.getMapper(PointMapper.class).updatePoint(pv)==1) {
			ss.getMapper(PointMapper.class).insertPlusPoint(ppv);
			req.setAttribute("r", "성공");
		}else{
			req.setAttribute("r", "실패");
		};
	}
	
	

	public void showPoint(HttpServletRequest req, PointVO pv) {
		AccountVO ac = (AccountVO) req.getSession().getAttribute("loginAccount");
		pv.setPoint_member(ac.getId());
		req.setAttribute("point", ss.getMapper(PointMapper.class).getPoint(pv));
		
	}

	public void showPlusPoint(HttpServletRequest req, PlusPointVO ppv) {
		AccountVO ac = (AccountVO) req.getSession().getAttribute("loginAccount");
		ppv.setPlusPoint_member(ac.getId());
		List<PlusPointVO> plusPoint = ss.getMapper(PointMapper.class).getPlusPoint(ppv);
		req.setAttribute("plusPoint", plusPoint);
	}

	

}
