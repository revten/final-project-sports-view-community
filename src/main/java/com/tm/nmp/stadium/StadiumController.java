package com.tm.nmp.stadium;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tm.nmp.board.BoardOption;
import com.tm.nmp.dao.AccountDAO;
import com.tm.nmp.model.AccountVO;
import com.tm.nmp.model.ClubImageDTO;
import com.tm.nmp.model.FavoriteClubDTO;
import com.tm.nmp.service.AdminService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping(value = "/stadium")
public class StadiumController {

	@Autowired
	private AccountDAO acDAO;

	@Autowired
	private StadiumDAO sdDAO;

	@Autowired
	private AdminService adminSv;

	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String stadiumMainGo(HttpServletRequest req) {
		log.info("stadium 메인 진입");
		acDAO.wathingPage(req);
		acDAO.loginCheck(req);

		req.setAttribute("contentPage", "stadium/stadiumMain.jsp");
		return "index";
	}

	@RequestMapping(value = "/baseball.go", method = RequestMethod.GET)
	public String baseballGo(HttpServletRequest req) {
		acDAO.loginCheck(req);
		req.setAttribute("contentPage", "stadium/baseball/baseball_stadium.jsp");
		return "index";
	}

	@RequestMapping(value = "/baseball.stadium.go.detail", method = RequestMethod.GET)
	public String baseballStadiumGoDetail(HttpServletRequest req) {
		acDAO.loginCheck(req);
		sdDAO.viewBaseballSeat(req);
		sdDAO.viewBaseballSeatDetail(req);
		req.setAttribute("contentPage", "stadium/baseball/baseball_stadium_detail.jsp");
		return "index";
	}

	@RequestMapping(value = "/soccer.go", method = RequestMethod.GET)
	public String soccerGo(HttpServletRequest req) {
		acDAO.loginCheck(req);
		req.setAttribute("contentPage", "stadium/soccer/soccer_stadium.jsp");
		return "index";
	}

	@RequestMapping(value = "/soccer.stadium.go.detail", method = RequestMethod.GET)
	public String soccerStadiumGoDetail(HttpServletRequest req) {
		acDAO.loginCheck(req);
		sdDAO.viewSoccerSeat(req);
		sdDAO.viewSoccerSeatDetail(req);
		req.setAttribute("contentPage", "stadium/soccer/soccer_stadium_detail.jsp");
		return "index";
	}

	@RequestMapping(value = "/basketball.go", method = RequestMethod.GET)
	public String basketballGo(HttpServletRequest req) {
		acDAO.loginCheck(req);
		req.setAttribute("contentPage", "stadium/basketball/basketball_stadium.jsp");
		return "index";
	}

	@RequestMapping(value = "/basketball2.go", method = RequestMethod.GET)
	public String basketballGo2(HttpServletRequest req) {
		acDAO.loginCheck(req);
		req.setAttribute("contentPage", "stadium/basketball/w_basketball_stadium.jsp");
		return "index";
	}

	@RequestMapping(value = "/basketball.stadium.go.detail", method = RequestMethod.GET)
	public String basketballStadiumGoDetail(HttpServletRequest req) {
		acDAO.loginCheck(req);
		sdDAO.viewBasketballSeat(req);
		sdDAO.viewBasketballSeatDetail(req);
		req.setAttribute("contentPage", "stadium/basketball/basketball_stadium_detail.jsp");
		return "index";
	}

	@RequestMapping(value = "/w_basketball.stadium.go.detail", method = RequestMethod.GET)
	public String wBasketballStadiumGoDetail(HttpServletRequest req) {
		acDAO.loginCheck(req);
		sdDAO.viewBasketballSeat(req);
		sdDAO.viewBasketballSeatDetail(req);
		req.setAttribute("contentPage", "stadium/basketball/w_basketball_stadium_detail.jsp");
		return "index";
	}

	@RequestMapping(value = "/volleyball.go", method = RequestMethod.GET)
	public String volleyballGo(HttpServletRequest req) {
		acDAO.loginCheck(req);
		req.setAttribute("contentPage", "stadium/volleyball/volleyball_stadium.jsp");
		return "index";
	}

	@RequestMapping(value = "/volleyball2.go", method = RequestMethod.GET)
	public String volleyballGo2(HttpServletRequest req) {
		acDAO.loginCheck(req);
		req.setAttribute("contentPage", "stadium/volleyball/w_volleyball_stadium.jsp");
		return "index";
	}

	@RequestMapping(value = "/volleyball.stadium.go.detail", method = RequestMethod.GET)
	public String volleyballStadiumGoDetail(HttpServletRequest req) {
		acDAO.loginCheck(req);
		sdDAO.viewVolleyballSeat(req);
		sdDAO.viewVolleyballSeatDetail(req);
		req.setAttribute("contentPage", "stadium/volleyball/volleyball_stadium_detail.jsp");
		return "index";
	}

	// 만든거
	@RequestMapping(value = "/w_volleyball.stadium.go.detail", method = RequestMethod.GET)
	public String wvolleyballStadiumGoDetail(HttpServletRequest req) {
		acDAO.loginCheck(req);
		sdDAO.viewVolleyballSeat(req);
		sdDAO.viewVolleyballSeatDetail(req);
		req.setAttribute("contentPage", "stadium/volleyball/w_volleyball_stadium_detail.jsp");
		return "index";
	}

	@RequestMapping(value = "/getClubList.go", method = RequestMethod.GET)
	public String getLogoBySports(HttpServletRequest req, BoardOption boardOption) {

		log.info("stadium 리그별 팀리스트 진입");
		acDAO.loginCheck(req);

		String sports_id = req.getParameter("sports_id");
		if (sports_id.equals("0") || sports_id == null) {
			boardOption.setField("");
		} else {
			boardOption.setField(sports_id);
		}

		String league_id = req.getParameter("league_id");
		if (league_id.equals("0") || league_id == null) {
			boardOption.setField2("");
		} else {
			boardOption.setField2(league_id);
		}

		String search = req.getParameter("search-club-input");
		if (search == null) {
			boardOption.setSearch("");
		} else {
			boardOption.setSearch(search);
		}

		List<ClubImageDTO> clubImages = sdDAO.getLogoBySports(boardOption);
		
		// 관심 구단 등록 여부
		AccountVO a = (AccountVO) req.getSession().getAttribute("loginAccount");

		for (ClubImageDTO ci : clubImages) {
			if (a != null) {
				FavoriteClubDTO fvClub = new FavoriteClubDTO(a.getId(), ci.getClub_id());
				ci.setFavored(sdDAO.checkClubFavored(fvClub));
			} else {
				ci.setFavored(0);
			}
		}

		req.setAttribute("clubImages", clubImages);
		req.setAttribute("contentPage", "stadium/stadiumClubList.jsp");
		return "index";
	}

	// 관심구단 등록
	@RequestMapping(value = "/create.club.fav", method = RequestMethod.GET)
	@ResponseBody
	public int createClubFav(FavoriteClubDTO fvClub, HttpServletRequest request) {
		log.info("관심 구단 등록");
		return sdDAO.createClubFav(fvClub);
	}

	// 관심구단 삭제
	@RequestMapping(value = "/delete.club.fav", method = RequestMethod.GET)
	@ResponseBody
	public int deleteClubFav(FavoriteClubDTO fvClub, HttpServletRequest request) {
		log.info("관심 구단 해제");
		return sdDAO.deleteClubFav(fvClub);
	}

	// 관심 구단 조회
	@RequestMapping(value = "/go.camping.like", method = RequestMethod.GET)
	public String goCampingLike(HttpServletRequest request) {

		// 이미지 처리
		request.setAttribute("Click", 1);
		mDAO.getUserLikeCampingSites(request);

		aDAO.loginCheck(request);

		request.setAttribute("contentPage", "camping-search/camping-like.jsp");

		return "index";
	}

	
	@RequestMapping(value = "/stadium.detail.go", method = RequestMethod.GET)
	public String getStadiumDetail(HttpServletRequest req) {

		acDAO.loginCheck(req);
		int club_id = Integer.parseInt(req.getParameter("club_id"));
		System.out.println(club_id);

		List<ClubImageDTO> clubImages = adminSv.getClubImages(club_id);

		req.setAttribute("clubImages", clubImages);
		req.setAttribute("contentPage", "stadium/stadiumDetail.jsp");
		return "index";
	}

}
