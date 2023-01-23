package com.tm.nmp.account;

import java.util.List;
import java.util.Random;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.tm.nmp.point.PointMapper;

@Service
public class AC_US_DAO {

	@Autowired
	private SqlSession ss;

	@Autowired
	private JavaMailSender mailSender;

	public boolean loginCheck(HttpServletRequest req) {
		AccountDTO a = (AccountDTO) req.getSession().getAttribute("loginAccount");
		if (a != null) {
			req.setAttribute("loginPage", "account/loginSuccess.jsp");
			return true;
		}
		req.setAttribute("loginPage", "account/login.jsp");
		return false;
	}

	public static String getClientIp(HttpServletRequest req) {

		String[] header_IPs = { "HTTP_CLIENT_IP", "HTTP_X_FORWARDED_FOR", "HTTP_X_FORWARDED",
				"HTTP_X_CLUSTER_CLIENT_IP", "HTTP_FORWARDED_FOR", "HTTP_FORWARDED", "X-Forwarded-For",
				"Proxy-Client-IP", "WL-Proxy-Client-IP" };

		for (String header : header_IPs) {
			String ip = req.getHeader(header);

			if (ip != null && !"unknown".equalsIgnoreCase(ip) && ip.length() != 0) {

				return ip;
			}
		}

		return req.getRemoteAddr();
	}

	public void accountRegDo(HttpServletRequest req, AccountDTO ac) {
		if (ss.getMapper(AccountMapper.class).regAccount(ac) == 1) {
			// pv.setUserId(ac.getMember_id());
			// ss.getMapper(PointMapper.class).pointTable(pv);
			System.out.println("가입 성공");
		} else {
			System.out.println("가입 실패");
		}
	}

	public void accountLoginDo(HttpServletRequest req, AccountDTO ac) {
		AccountDTO dbAccount = ss.getMapper(AccountMapper.class).accountLogin(ac);
		if (dbAccount != null) {
			if (ac.getMember_pwd().equals(dbAccount.getMember_pwd())) {
				req.getSession().setAttribute("loginAccount", dbAccount);
				req.getSession().setMaxInactiveInterval(60 * 60);
			}
		}
	}
	
	// .go가 매핑되는 순간, 이 메서드가 동작하면서 페이지 URL을 저장한다
	public void wathingPage(HttpServletRequest req) {
		String watchingPage = req.getRequestURL().toString();
		String param = req.getQueryString();
		if (req.getQueryString() != null) {
			watchingPage = watchingPage + "?" + param; // 수정할 글의 번호도 있으니까
		}
		req.getSession().setAttribute("watchingPage", watchingPage);
	}

	public void accountLogoutDo(HttpServletRequest req, AccountDTO ac) {
		req.getSession().setAttribute("loginAccount", null);
	}

	/*
	 * public void searchIdDo(HttpServletRequest req, AccountDTO ac) {
	 * ac.setAc_name(ac.getAc_name()); ac.setAc_email(ac.getAc_email()); AccountDTO
	 * idSearch = ss.getMapper(AccountMapper.class).searchId(ac);
	 * 
	 * String getId = idSearch.getAc_id(); String result = getId;
	 * 
	 * int length = result.length();
	 * 
	 * String maskedId = "";
	 * 
	 * for (int i = 0; i < length; i++) { maskedId = i < length / 2 ? maskedId +
	 * result.charAt(i) : maskedId + "*"; } req.setAttribute("result", maskedId); }
	 */
	public String memberEmailCheckDo(String member_email) {
		Random random = new Random();
		int checknum = random.nextInt(888888) + 111111;

		// 이메일 보낼 양식
		String setFrom = "frvlv@naver.com";
		String toMail = member_email;
		String title = "비밀번호 인증 이메일 입니다.";
		String content = "인증번호는 " + checknum + " 입니다.";
		try {
			// 내용들을 담기
			MimeMessage mes = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(mes, true, "utf-8");
			helper.setFrom(setFrom);
			helper.setTo(toMail);
			helper.setSubject(title);
			helper.setText(content);
			mailSender.send(mes);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return Integer.toString(checknum);
	}

	public String emailCheckDo(String ac_email) {
		Random random = new Random();
		int checknum = random.nextInt(888888) + 111111;

		// 이메일 보낼 양식
		String setFrom = "frvlv@naver.com";
		String toMail = ac_email;
		String title = "비밀번호 인증 이메일 입니다.";
		String content = "인증번호는 " + checknum + " 입니다.";
		try {
			// 내용들을 담기
			MimeMessage mes = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(mes, true, "utf-8");
			helper.setFrom(setFrom);
			helper.setTo(toMail);
			helper.setSubject(title);
			helper.setText(content);
			mailSender.send(mes);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return Integer.toString(checknum);
	}

	public void changePwDo(HttpServletRequest req, AccountDTO ac) {
		if (ss.getMapper(AccountMapper.class).changePwDo(ac) == 1) {
			System.out.println("변경 완료");
			req.getSession().setAttribute("loginAccount", ss.getMapper(AccountMapper.class).accountLogin(ac));
		}
	}

	public void accountUpdate(HttpServletRequest req, AccountDTO ac) {
		if (ss.getMapper(AccountMapper.class).accountUpdate(ac) == 1) {
			System.out.println("수정 완료");
			req.getSession().setAttribute("loginAccount", ac);
		} else {
			System.out.println("수정 실패");
		}
	}

	public void accountDelete(HttpServletRequest req, AccountDTO ac) {
		if (ss.getMapper(AccountMapper.class).accountDelete(ac) == 1) {
			req.setAttribute("result", "탈퇴 성공");
		} else {
			req.setAttribute("result", "탈퇴실패");
		}
	}

	/*
	 * public int socialIdCheck(AccountDTO ac) {
	 * System.out.println(ac.getMember_id());
	 * System.out.println(ac.getMember_reg_type()); return
	 * ss.getMapper(AccountMapper.class).socialIdCheck(ac); }
	 */

	public void socialLogin(HttpServletRequest req, AccountDTO ac) {
		AccountDTO dbMember = ss.getMapper(AccountMapper.class).accountLogin(ac);
		if (dbMember != null) {
			System.out.println("로그인 성공");
			req.getSession().setAttribute("loginAccount", dbMember);
			req.getSession().setMaxInactiveInterval(60 * 60);
		} else {
			System.out.println("로그인 실패");
		}
	}

	public int idCheck(String id) {
		int cnt = ss.getMapper(AccountMapper.class).idCheck(id);
		System.out.println("cnt: " + cnt);
		return cnt;
	}

	/*
	 * public void socialReg(HttpServletRequest req, AccountDTO ac) { try {
	 * 
	 * req.setCharacterEncoding("utf-8");
	 * 
	 * String user_id_name = req.getParameter("user_id_name"); String user_pwd =
	 * " "; String user_reg_ip = " "; int user_auth_type =
	 * Integer.parseInt(req.getParameter("user_auth_type")); String user_email =
	 * " ";
	 * 
	 * ac.setUser_id_name(user_id_name); ac.setUser_pwd(user_pwd);
	 * ac.setUser_reg_ip(user_reg_ip); ac.setUser_auth_type(user_auth_type);
	 * ac.setUser_email(user_email);
	 * 
	 * if (ss.getMapper(AccountMapper.class).regAccount(ac) == 1) {
	 * System.out.println("회원 가입 성공"); } else { System.out.println("회원 가입 실패"); }
	 * 
	 * } catch (Exception e) { e.printStackTrace(); } }
	 */

	/*
	 * public void regProfile(HttpServletRequest req, AC_PF_TITLE ac) { try {
	 * req.setCharacterEncoding("utf-8");
	 * 
	 * int user_id = Integer.parseInt(req.getParameter("user_id")); int club_id =
	 * Integer.parseInt(req.getParameter("club_id")); String league_id =
	 * req.getParameter("league_id"); String profile_nick =
	 * req.getParameter("profile_nick"); String profile_intro =
	 * req.getParameter("profile_intro");
	 * 
	 * ac.setUser_id(user_id); ac.setClub_id(club_id); ac.setLeague_id(league_id);
	 * ac.setProfile_nick(profile_nick); ac.setProfile_intro(profile_intro);
	 * 
	 * ss.getMapper(AccountMapper.class).regProfile(ac);
	 * 
	 * } catch (Exception e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); }
	 * 
	 * }
	 */

	public List<Calendar> getCalendarList(String userId) {
		System.out.println(userId);
		List<Calendar> dates = ss.getMapper(PointMapper.class).getCalendarList(userId);
		for (Calendar c : dates) {
			System.out.println(c.getCal_date());
		}

		return dates;

	}


}
