package com.tm.nmp.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tm.nmp.account.AccountDAO;
import com.tm.nmp.admin.ClubImageDTO;
import com.tm.nmp.model.AccountVO;
import com.tm.nmp.model.FavoriteClubDTO;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping(value = "/account")
public class AccountController {

	
	@Autowired
	private AccountDAO acDAO;
	
	@RequestMapping(value = "/login.go", method = RequestMethod.GET)
	public String accountLoginGo(HttpServletRequest req) {
		acDAO.loginCheck(req);
		req.setAttribute("contentPage", "account/loginPage.jsp");
		return "index";
	}

	// 회원가입 페이지로 이동 
	@RequestMapping(value = "/reg.go", method = RequestMethod.GET)
	public String accountRegGo(HttpServletRequest req) {
		
		log.info("회원가입 페이지");
		
		acDAO.loginCheck(req);

		// 회원가입시 구단 로고 이미지 불러오기
		List<ClubImageDTO> clubImages = acDAO.getAllClubLogos();
		req.setAttribute("clubImages", clubImages);

		req.setAttribute("contentPage", "account/accountReg.jsp");
		return "index";
	}

	// 아이디 중복 검사
	@RequestMapping(value = "/id.check", method = RequestMethod.POST)
	@ResponseBody
	public int idCheck(@RequestParam("id") String id) {
		
		log.info("아이디 중복 검사");
		
		int result = acDAO.idCheck(id);
		return result;
	}

	// 회원가입 하기
	@RequestMapping(value = "/reg.do", method = RequestMethod.POST)
	public String accountRegDo(HttpServletRequest req, AccountVO ac) {
		
		log.info("회원가입 하기");
		
		acDAO.accountRegDo(req, ac);

		// 회원가입시 관심 구단 등록
		String[] fcChosen = req.getParameterValues("club_id");
		List<FavoriteClubDTO> fcList = new ArrayList<>();
		if (fcChosen != null) {
			for (String f : fcChosen) {
				FavoriteClubDTO fc = new FavoriteClubDTO();
				fc.setUser_id(ac.getId());
				fc.setClub_id(Integer.parseInt(f));
				fcList.add(fc);
			}
			acDAO.regFavoriteClub(fcList);
		}

		acDAO.accountLoginDo(req, ac);
		acDAO.loginCheck(req);
		req.setAttribute("contentPage", "home.jsp");
		return "index";
	}

	// 이메일 인증
	@RequestMapping(value = "/email.auth.do", method = RequestMethod.GET)
	@ResponseBody
	public String userEmailCheckDo(HttpServletRequest req, String email) {
		acDAO.loginCheck(req);
		return acDAO.emailAuthDo(email);
	}

	// 휴대폰 인증 (회원가입)
	@RequestMapping(value = "/sendSms.do")
	@ResponseBody
	public String sendSms(HttpServletRequest req) throws Exception {
		return acDAO.sendSms(req);
	}

	// 로그인 하기
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public void accountLoginDo(HttpServletRequest req, AccountVO ac, HttpServletResponse response)
			throws IOException, ServletException {
		
		acDAO.accountLoginDo(req, ac);

		if (acDAO.loginCheck(req)) {
			String watchingPage = (String) req.getSession().getAttribute("watchingPage");
			System.out.println(watchingPage);
			response.sendRedirect(watchingPage);
		} else {
			//login.do가 실행되는 순간 loginPage가 Referer로 저장되어 loginPage를 보여주게됨
			String watchingPage = (String) req.getHeader("Referer");
			response.sendRedirect(watchingPage);
		}
	}

	// 로그아웃 하기
	@RequestMapping(value = "/logout.do", method = RequestMethod.GET)
	public String accountLogoutDo(HttpServletRequest req, HttpServletResponse resp, AccountVO ac) {
		acDAO.accountLogoutDo(req, resp, ac);
		acDAO.loginCheck(req);

		req.setAttribute("contentPage", "home.jsp");
		return "index";
	}

	// 아이디 찾는 창으로
	@RequestMapping(value = "/search.id.go", method = RequestMethod.GET)
	public String searchIdGo(HttpServletRequest req) {
		acDAO.loginCheck(req);
		req.setAttribute("contentPage", "account/search_id.jsp");
		return "index";
	}

	// 아이디 찾기
	@RequestMapping(value = "/search.id.do", method = RequestMethod.POST)
	@ResponseBody
	public String searchId(HttpServletRequest req) {
		return acDAO.searchId(req);
	}

	// 비밀번호 찾기 페이지로 이동
	@RequestMapping(value = "/search.pw.go", method = RequestMethod.GET)
	public String searchPwGo(HttpServletRequest req) {
		acDAO.loginCheck(req);
		req.setAttribute("contentPage", "account/search_pw.jsp");
		return "index";
	}

	// 비밀번호 변경 페이지로 이동
	@RequestMapping(value = "/change.pw.go", method = RequestMethod.GET)
	public String searchPwDo(HttpServletRequest req, AccountVO ac) {
		acDAO.loginCheck(req);
		req.setAttribute("contentPage", "account/pwReg.jsp");
		return "index";
	}

	// 비밀번호 변경하기
	@RequestMapping(value = "/change.pw.do", method = RequestMethod.POST)
	public String changePwDo(HttpServletRequest req, AccountVO ac) {
		acDAO.loginCheck(req);
		acDAO.changePwDo(req, ac);
		req.setAttribute("contentPage", "home.jsp");
		return "index";
	}

	// 회원 탈퇴하기
	@RequestMapping(value = "/delete.go", method = RequestMethod.GET)
	public String myPageDeleteGo(HttpServletRequest req) {
		
		String id = req.getParameter("ac_id");
		System.out.println(id);
		
		acDAO.deleteAccount(req, id);

		acDAO.loginCheck(req);
		req.setAttribute("contentPage", "home.jsp");
		return "index";
	}




	@RequestMapping(value = "/social.id.check", method = RequestMethod.GET)
	@ResponseBody
	public int socialIdCheck(HttpServletRequest req, AccountVO ac) {
		acDAO.loginCheck(req);
		return acDAO.socialIdCheck(ac);
	}

	@RequestMapping(value = "/socialLogin.go", method = RequestMethod.GET)
	public String socialRegGo(AccountVO a, HttpServletRequest req) {
		acDAO.loginCheck(req);
		req.setAttribute("contentPage", "account/socialLogin.jsp");
		return "index";
	}

	@RequestMapping(value = "/social.login.do", method = RequestMethod.GET)
	public String socialLoginDo(HttpServletRequest req, AccountVO ac) {
		if (req.getParameter("member_id") != null) {
			acDAO.socialLogin(req, ac);
			acDAO.loginCheck(req);
		} else {
			System.out.println("로그인 실패");
		}
		req.setAttribute("contentPage", "home.jsp");

		return "index";
	}

	@RequestMapping(value = "/social.reg.do", method = RequestMethod.GET)
	public String socialRegDo(HttpServletRequest req, AccountVO ac) {
		acDAO.socialReg(req, ac);
		acDAO.accountLoginDo(req, ac);
		acDAO.loginCheck(req);
		req.setAttribute("contentPage", "account/socialProfileReg.jsp");

		return "profile_index";
	}
	

	

	@RequestMapping(value = "/update.go", method = RequestMethod.GET)
	public String accountModifyGo(HttpServletRequest req) {
		acDAO.loginCheck(req);
		req.setAttribute("contentPage", "myPage/myPageMyInfoUpdate.jsp");
		return "index";
	}

	@RequestMapping(value = "/update.do", method = RequestMethod.POST)
	public String accountModifyDo(HttpServletRequest req, AccountVO ac) {
		acDAO.loginCheck(req);
		acDAO.accountUpdate(req, ac);
		req.setAttribute("contentPage", "myPage/myPageMyInfo.jsp");
		return "index";
	}


}
