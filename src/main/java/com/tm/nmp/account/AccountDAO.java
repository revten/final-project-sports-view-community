package com.tm.nmp.account;

import java.util.Random;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class AccountDAO {

	@Autowired
	private SqlSession ss;

	@Autowired
	private JavaMailSender mailSender;

	public void loginCheck(HttpServletRequest req) {
		AccountDTO a = (AccountDTO) req.getSession().getAttribute("loginAccount");
		if (a != null) {
			req.setAttribute("loginPage", "account/loginSuccess.jsp");
		} else {
			req.setAttribute("loginPage", "account/login.jsp");
		}

	}

	public void accountRegDo(HttpServletRequest req, AccountDTO ac) {
		if (ss.getMapper(AccountMapper.class).regAccount(ac) == 1) {
			System.out.println("가입 성공");
		} else {
			System.out.println("가입 실패");
		}
	}

	public void accountLoginDo(HttpServletRequest req, AccountDTO ac) {
		AccountDTO dbAccount = ss.getMapper(AccountMapper.class).accountLogin(ac);

		if (dbAccount != null) {
			if (ac.getAc_pw().equals(dbAccount.getAc_pw())) {
				req.getSession().setAttribute("loginAccount", dbAccount);
				req.getSession().setMaxInactiveInterval(60 * 60);
			} else {
				req.setAttribute("result", "비밀번호 오류");
			}
		} else {
			req.setAttribute("result", "가입하지 않은 회원");
		}

	}

	public void accountLogoutDo(HttpServletRequest req, AccountDTO ac) {
		req.getSession().setAttribute("loginAccount", null);
	}

	public void searchIdDo(HttpServletRequest req, AccountDTO ac) {
		ac.setAc_name(ac.getAc_name());
		ac.setAc_email(ac.getAc_email());
		AccountDTO idSearch = ss.getMapper(AccountMapper.class).searchId(ac);

		String getId = idSearch.getAc_id();
		String result = getId;

		int length = result.length();

		String maskedId = "";

		for (int i = 0; i < length; i++) {
			maskedId = i < length / 2 ? maskedId + result.charAt(i) : maskedId + "*";
		}
		req.setAttribute("result", maskedId);
	}

	public String emailCheckDo(String ac_email) {
		Random random = new Random();
		int checknum = random.nextInt(888888) + 111111;

		// 이메일 보낼 양식
		String setFrom = "frvlv6@naver.com";
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

	public int socialIdCheck(AccountDTO ac) {
		System.out.println(ac.getAc_id());
		System.out.println(ac.getAc_linkWhere());
		return ss.getMapper(AccountMapper.class).socialIdCheck(ac);
	}

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

	public void socialReg(HttpServletRequest req, AccountDTO ac) {
		try {

			req.setCharacterEncoding("utf-8");

			String ac_id = req.getParameter("ac_id");
			System.out.println(ac_id);
			String ac_pw = " ";
			String ac_nick = " ";
			String ac_name = req.getParameter("ac_name");
			System.out.println(ac_name);
			String ac_addr = " ";
			String ac_email = req.getParameter("ac_email");
			System.out.println(ac_email);
			String ac_linkWhere = req.getParameter("ac_linkWhere");
			System.out.println(ac_linkWhere);

			ac.setAc_id(ac_id); // 네카구
			ac.setAc_pw(ac_pw);
			ac.setAc_nick(ac_nick);
			ac.setAc_name(ac_name); // 네카구
			ac.setAc_addr(ac_addr);
			ac.setAc_email(ac_email); // 네
			ac.setAc_linkWhere(ac_linkWhere);// 네카구

			if (ss.getMapper(AccountMapper.class).regAccount(ac) == 1) {
				System.out.println("회원 가입 성공");
			} else {
				System.out.println("회원 가입 실패");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
