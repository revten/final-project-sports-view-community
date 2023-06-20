package com.tm.nmp.stadium;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tm.nmp.account.AccountDAO;
import com.tm.nmp.admin.ClubImageDTO;

@Service
public class StadiumDAO {
	
	@Autowired
	private AccountDAO acDAO;
	
	@Autowired
	private SqlSessionTemplate sst;

	@RequestMapping(value = "/stadium.main.go", method = RequestMethod.GET)
	public String stadiumMainGo(HttpServletRequest req) {
		acDAO.wathingPage(req);
		acDAO.loginCheck(req);
		req.setAttribute("contentPage", "stadium/stadiumMain.jsp");
		return "index";
	}

	public void viewBaseballSeat(HttpServletRequest req) {
		String team = (String)req.getParameter("team");
		switch (team) {
		case "ssg":
			req.setAttribute("seat", "ssg.png");
			break;
		case "kiwoom":
			req.setAttribute("seat", "kiwoom.png");
			break;
		case "lg":
			req.setAttribute("seat", "lg.png");
			break;
		case "kt":
			req.setAttribute("seat", "kt.png");
			break;
		case "kia":
			req.setAttribute("seat", "kia.png");
			break;
		case "nc":
			req.setAttribute("seat", "nc.png");
			break;
		case "samsung":
			req.setAttribute("seat", "samsung.png");
			break;
		case "lotte":
			req.setAttribute("seat", "lotte.png");
			break;
		case "doosan":
			req.setAttribute("seat", "doosan.png");
			break;
		case "hanwha":
			req.setAttribute("seat", "hanwha.png");
			break;
		default:
			break;
		}
	}
	
	public void viewBaseballSeatDetail(HttpServletRequest req) {
		String team = (String)req.getParameter("team");
		switch (team) {
		case "ssg":
			req.setAttribute("seatDetail", "ssg");
			break;
		case "kiwoom":
			req.setAttribute("seatDetail", "kiwoom");
			break;
		case "lg":
			req.setAttribute("seatDetail", "lg");
			break;
		case "kt":
			req.setAttribute("seatDetail", "kt");
			break;
		case "kia":
			req.setAttribute("seatDetail", "kia");
			break;
		case "nc":
			req.setAttribute("seatDetail", "nc");
			break;
		case "samsung":
			req.setAttribute("seatDetail", "samsung");
			break;
		case "lotte":
			req.setAttribute("seatDetail", "lotte");
			break;
		case "doosan":
			req.setAttribute("seatDetail", "doosan");
			break;
		case "hanwha":
			req.setAttribute("seatDetail", "hanwha");
			break;
		default:
			break;
		}
	}
	
	public void viewSoccerSeat(HttpServletRequest req) {
		String team = (String)req.getParameter("team");
		switch (team) {
		case "gangwon":
			req.setAttribute("seat", "gangwon.png");
			break;
		case "gwangju":
			req.setAttribute("seat", "gwangju.png");
			break;
		case "daegu":
			req.setAttribute("seat", "daegu.png");
			break;
		case "djhc":
			req.setAttribute("seat", "djhc.png");
			break;
		case "seoul":
			req.setAttribute("seat", "seoul.png");
			break;
		case "suwon":
			req.setAttribute("seat", "suwon.png");
			break;
		case "suwon2":
			req.setAttribute("seat", "suwon2.png");
			break;
		case "uh":
			req.setAttribute("seat", "uh.png");
			break;
		case "incheon":
			req.setAttribute("seat", "incheon.png");
			break;
		case "hyundai":
			req.setAttribute("seat", "hyundai.png");
			break;
		case "jeju":
			req.setAttribute("seat", "jeju.png");
			break;
		case "steelers":
			req.setAttribute("seat", "steelers.png");
			break;
		default:
			break;
		}
	}
	
	public void viewSoccerSeatDetail(HttpServletRequest req) {
		String team = (String)req.getParameter("team");
		switch (team) {
		case "gangwon":
			req.setAttribute("seatDetail", "gangwon");
			break;
		case "gwangju":
			req.setAttribute("seatDetail", "gwangju");
			break;
		case "daegu":
			req.setAttribute("seatDetail", "daegu");
			break;
		case "djhc":
			req.setAttribute("seatDetail", "djhc");
			break;
		case "seoul":
			req.setAttribute("seatDetail", "seoul");
			break;
		case "suwon":
			req.setAttribute("seatDetail", "suwon");
			break;
		case "suwon2":
			req.setAttribute("seatDetail", "suwon2");
			break;
		case "uh":
			req.setAttribute("seatDetail", "uh");
			break;
		case "incheon":
			req.setAttribute("seatDetail", "incheon");
			break;
		case "hyundai":
			req.setAttribute("seatDetail", "hyundai");
			break;
		case "jeju":
			req.setAttribute("seatDetail", "jeju");
			break;
		case "steelers":
			req.setAttribute("seatDetail", "steelers");
			break;
		default:
			break;
		}
	}
	
	public void viewBasketballSeat(HttpServletRequest req) {
		String team = (String)req.getParameter("team");
		switch (team) {
		case "kbl":
			req.setAttribute("seat", "kbl.png");
			break;
		case "kogas":
			req.setAttribute("seat", "kogas.png");
			break;
		case "kt":
			req.setAttribute("seat", "kt.png");
			break;
		case "samsung":
			req.setAttribute("seat", "samsung.png");
			break;
		case "sk":
			req.setAttribute("seat", "sk.png");
			break;
		case "kgc":
			req.setAttribute("seat", "kgc.png");
			break;
		case "hyundai":
			req.setAttribute("seat", "hyundai.png");
			break;
		case "db":
			req.setAttribute("seat", "db.png");
			break;
		case "kcc":
			req.setAttribute("seat", "kcc.png");
			break;
		case "kcc2":
			req.setAttribute("seat", "kcc2.png");
			break;
		case "lg":
			req.setAttribute("seat", "lg.png");
			break;
		case "bnk":
			req.setAttribute("seat", "bnk.png");
			break;
		case "hana":
			req.setAttribute("seat", "hana.png");
			break;
		case "won":
			req.setAttribute("seat", "won.png");
			break;
		case "samsung2":
			req.setAttribute("seat", "samsung2.png");
			break;
		case "shinhan":
			req.setAttribute("seat", "shinhan.png");
			break;
		case "kb":
			req.setAttribute("seat", "kb.png");
			break;
		default:
			break;
		}
	}
	
	public void viewBasketballSeatDetail(HttpServletRequest req) {
		String team = (String)req.getParameter("team");
		switch (team) {
		case "kbl":
			req.setAttribute("seatDetail", "kbl");
			break;
		case "kogas":
			req.setAttribute("seatDetail", "kogas");
			break;
		case "kt":
			req.setAttribute("seatDetail", "kt");
			break;
		case "samsung":
			req.setAttribute("seatDetail", "samsung");
			break;
		case "sk":
			req.setAttribute("seatDetail", "sk");
			break;
		case "kgc":
			req.setAttribute("seatDetail", "kgc");
			break;
		case "hyundai":
			req.setAttribute("seatDetail", "hyundai");
			break;
		case "db":
			req.setAttribute("seatDetail", "db");
			break;
		case "kcc":
			req.setAttribute("seatDetail", "kcc");
			break;
		case "kcc2":
			req.setAttribute("seatDetail", "kcc2");
			break;
		case "lg":
			req.setAttribute("seatDetail", "lg");
			break;
		case "bnk":
			req.setAttribute("seatDetail", "bnk");
			break;
		case "hana":
			req.setAttribute("seatDetail", "hana");
			break;
		case "won":
			req.setAttribute("seatDetail", "won");
			break;
		case "samsung2":
			req.setAttribute("seatDetail", "samsung2");
			break;
		case "shinhan":
			req.setAttribute("seatDetail", "shinhan");
			break;
		case "kb":
			req.setAttribute("seatDetail", "kb");
		default:
			break;
		}
	}
	
	public void viewVolleyballSeat(HttpServletRequest req) {
		String team = (String)req.getParameter("team");
		switch (team) {
		case "kal":
			req.setAttribute("seat", "kal.png");
			break;
		case "kb":
			req.setAttribute("seat", "kb.png");
			break;
		case "kepco":
			req.setAttribute("seat", "kepco.png");
			break;
		case "won":
			req.setAttribute("seat", "won.png");
			break;
		case "ok":
			req.setAttribute("seat", "ok.png");
			break;
		case "samsung":
			req.setAttribute("seat", "samsung.png");
			break;
		case "hyundai":
			req.setAttribute("seat", "hyundai.png");
			break;
		case "hyundai2":
			req.setAttribute("seat", "hyundai2.png");
			break;
		case "hipass":
			req.setAttribute("seat", "hipass.png");
			break;
		case "gs":
			req.setAttribute("seat", "gs.png");
			break;
		case "kgc":
			req.setAttribute("seat", "kgc.png");
			break;
		case "ibk":
			req.setAttribute("seat", "ibk.png");
			break;
		case "heungkuk":
			req.setAttribute("seat", "heungkuk.png");
			break;
		case "gwangju":
			req.setAttribute("seat", "gwangju.png");
			break;
		default:
			break;
		}
	}

	public void viewVolleyballSeatDetail(HttpServletRequest req) {
		String team = (String)req.getParameter("team");
		switch (team) {
		case "kal":
			req.setAttribute("seatDetail", "kal");
			break;
		case "kb":
			req.setAttribute("seatDetail", "kb");
			break;
		case "kepco":
			req.setAttribute("seatDetail", "kepco");
			break;
		case "won":
			req.setAttribute("seatDetail", "won");
			break;
		case "ok":
			req.setAttribute("seatDetail", "ok");
			break;
		case "samsung":
			req.setAttribute("seatDetail", "samsung");
			break;
		case "hyundai":
			req.setAttribute("seatDetail", "hyundai");
			break;
		case "hyundai2":
			req.setAttribute("seatDetail", "hyundai2");
			break;
		case "hipass":
			req.setAttribute("seatDetail", "hipass");
			break;
		case "gs":
			req.setAttribute("seatDetail", "gs");
			break;
		case "kgc":
			req.setAttribute("seatDetail", "kgc");
			break;
		case "ibk":
			req.setAttribute("seatDetail", "ibk");
			break;
		case "heungkuk":
			req.setAttribute("seatDetail", "heungkuk");
			break;
		case "gwangju":
			req.setAttribute("seatDetail", "gwangju");
			break;
		default:
			break;
		}
	}
	
	public List<ClubImageDTO> getLogoBySports(int league_id) {
		return sst.selectList("StadiumMapper.getLogoBySports", league_id);
	}

}
