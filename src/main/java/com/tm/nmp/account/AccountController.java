package com.tm.nmp.account;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AccountController {
	
	@Autowired
	private accountDAO acDAO;
	
	// 회원가입 페이지로 이동
	@RequestMapping(value = "/account.reg.go", method = RequestMethod.GET)
	public String accountRegGo(HttpServletRequest req) {
		acDAO.loginCheck(req);
		req.setAttribute("contentPage", "account/accountReg.jsp");
		return "index";
	}
	
	// 아이디 중복 검사
	@RequestMapping(value = "/account.id.check", method = RequestMethod.POST)
	@ResponseBody
	public int idCheck(@RequestParam("id") String id) {
		int result = acDAO.idCheck(id);
		return result;
	}
	
	// 회원가입
	@RequestMapping(value = "/account.reg.do", method = RequestMethod.POST)
	public String accountRegDo(HttpServletRequest req, AccountDTO ac) {
		acDAO.accountRegDo(req, ac);
		
		if(ac.getFavorite_clubs()!= null) {
			List<FavoriteClubDTO> favoriteClubs = new ArrayList<>();
			for(FavoriteClubDTO f : ac.getFavorite_clubs()) {
				FavoriteClubDTO fc = new FavoriteClubDTO();
				fc.setUser_id(ac.getId());
				fc.setClub_id(f.getClub_id());
				
				favoriteClubs.add(f);
			}
			acDAO.regFavoriteClub(favoriteClubs);
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
	@RequestMapping(value = "/account.login.do", method = RequestMethod.POST)
	public void accountLoginDo(HttpServletRequest req, AccountDTO ac, HttpServletResponse response) throws IOException, ServletException {
		acDAO.accountLoginDo(req, ac);
		
		if(acDAO.loginCheck(req)) {
			String watchingPage = (String) req.getSession().getAttribute("watchingPage");
			System.out.println(watchingPage);
			response.sendRedirect(watchingPage);	
		}else {
			// account.login.do가 실행되는 순간 loginPage가 Referer로 저장되어 loginPage를 보여주게됨
			String watchingPage = (String) req.getHeader("Referer");
			response.sendRedirect(watchingPage);	
		}
	}
	
	// 로그아웃 하기
	@RequestMapping(value = "/account.logout.do", method = RequestMethod.GET)
	public String accountLogoutDo(HttpServletRequest req, HttpServletResponse resp, AccountDTO ac) {
		acDAO.accountLogoutDo(req, resp, ac);
		acDAO.loginCheck(req);
		
		req.setAttribute("contentPage", "home.jsp");
		return "index";
	}
	

	
	
	
	@RequestMapping(value = "/search.id.go", method = RequestMethod.GET)
	public String searchIdGo(HttpServletRequest req) {
		acDAO.loginCheck(req);
		req.setAttribute("contentPage", "account/search_id.jsp");
		return "index";
	}

	/*@RequestMapping(value = "/search.id.do", method = RequestMethod.POST)
	public String searchIdDo(HttpServletRequest req, AccountDTO ac) {
		acDAO.searchIdDo(req, ac);
		acDAO.loginCheck(req);
		req.setAttribute("contentPage", "account/search_result_id.jsp");
		return "index";
	}*/

	@RequestMapping(value = "/search.pw.go", method = RequestMethod.GET)
	public String searchPwGo(HttpServletRequest req) {
		acDAO.loginCheck(req);
		req.setAttribute("contentPage", "account/search_pw.jsp");
		return "index";
	}

	@RequestMapping(value = "/search.pw.do", method = RequestMethod.POST)
	public String searchPwDo(HttpServletRequest req, AccountDTO ac) {
		acDAO.loginCheck(req);
		req.setAttribute("Account", ac);
		req.setAttribute("contentPage", "account/pwReg.jsp");
		return "index";
	}
	
	
	@RequestMapping(value = "/change.pw.do", method = RequestMethod.POST)
	public String changePwDo(HttpServletRequest req, AccountDTO ac) {
		acDAO.changePwDo(req, ac);
		req.setAttribute("contentPage", "home.jsp");
		acDAO.loginCheck(req);
		return "index";
	}
	
	@RequestMapping(value = "/account.update.go", method = RequestMethod.GET)
	public String accountModifyGo(HttpServletRequest req) {
		acDAO.loginCheck(req);
		req.setAttribute("contentPage", "myPage/myPageMyInfoUpdate.jsp");
		return "index";
	}

	@RequestMapping(value = "/account.update.do", method = RequestMethod.POST)
	public String accountModifyDo(HttpServletRequest req, AccountDTO ac) {
		acDAO.loginCheck(req);
		acDAO.accountUpdate(req, ac);
		req.setAttribute("contentPage", "myPage/myPageMyInfo.jsp");
		return "index";
	}

	@RequestMapping(value = "/account.delete.go", method = RequestMethod.GET)
	public String myPageDeleteGo(HttpServletRequest req, AccountDTO ac) {
		acDAO.accountDelete(req, ac);
		acDAO.accountLogoutDo(req, ac);
		acDAO.loginCheck(req);
		req.setAttribute("contentPage", "home.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/social.id.check", method = RequestMethod.GET)
	@ResponseBody
	public int socialIdCheck(HttpServletRequest req, AccountDTO ac) {
		acDAO.loginCheck(req);
		return acDAO.socialIdCheck(ac);
	}
	
	@RequestMapping(value = "/socialLogin.go", method = RequestMethod.GET)
	public String socialRegGo(AccountDTO a, HttpServletRequest req) {
		acDAO.loginCheck(req);
		req.setAttribute("contentPage", "account/socialLogin.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/social.login.do", method = RequestMethod.GET)
	public String socialLoginDo(HttpServletRequest req, AccountDTO ac) {
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
	public String socialRegDo(HttpServletRequest req, AccountDTO ac) {
		acDAO.socialReg(req, ac);
		acDAO.accountLoginDo(req, ac);
		acDAO.loginCheck(req);
		req.setAttribute("contentPage", "account/socialProfileReg.jsp");

		return "profile_index";
	}
	
	@RequestMapping(value = "/profile.reg.do", method = RequestMethod.POST)
	public String profileRegDo(HttpServletRequest req, AccountDTO ac) {
		acDAO.regProfile(req, ac);
		acDAO.accountLoginDo(req, ac);
		acDAO.loginCheck(req);
		req.setAttribute("contentPage", "home.jsp");

		return "index";
	}

}
