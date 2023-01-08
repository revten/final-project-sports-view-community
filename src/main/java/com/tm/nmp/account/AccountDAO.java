package com.tm.nmp.account;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Random;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.tm.nmp.mypage.MyPageMapper;

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
		String path = req.getSession().getServletContext().getRealPath("resources/files/account");
		MultipartRequest mr = null;
		try {
			mr = new MultipartRequest(req, path, 10 * 1024 * 1024, "utf-8", new DefaultFileRenamePolicy());

			String ac_id = mr.getParameter("ac_id");
			String ac_pw = mr.getParameter("ac_pw");
			String ac_name = mr.getParameter("ac_name");
			String ac_addr = mr.getParameter("ac_addr");
			String ac_email = mr.getParameter("ac_email");
			String ac_pic = mr.getFilesystemName("ac_pic");
			String ac_linkWhere = "1";

			ac.setAc_id(ac_id);
			ac.setAc_pw(ac_pw);
			ac.setAc_name(ac_name);
			ac.setAc_addr(ac_addr);
			ac.setAc_email(ac_email);
			ac.setAc_pic(ac_pic);
			ac.setAc_linkWhere(ac_linkWhere);

			if (ss.getMapper(AccountMapper.class).regAccount(ac) == 1) {
				System.out.println("가입 성공");
			} else {
				System.out.println("가입 실패");
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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

	public void accountUpdate(HttpServletRequest req) {
		String path = req.getSession().getServletContext().getRealPath("resources/files/account");
		MultipartRequest mr = null;

		AccountDTO loginMember = (AccountDTO) req.getSession().getAttribute("loginAccount");

		System.out.println(loginMember.toString());
		String oldFile = loginMember.getAc_pic();
		String newFile = null;

		try {
			mr = new MultipartRequest(req, path, 10 * 1024 * 1024, "utf-8", new DefaultFileRenamePolicy());
			newFile = mr.getFilesystemName("ac_newpic");

			if (newFile == null) {
				newFile = oldFile;
			}

			String ac_id = mr.getParameter("ac_id");
			String ac_pw = mr.getParameter("ac_pw");
			String ac_name = mr.getParameter("ac_name");
			String ac_addr = mr.getParameter("ac_addr");
			String ac_email = mr.getParameter("ac_email");
			String ac_newpic = newFile;

			AccountDTO ac = new AccountDTO();

			ac.setAc_id(ac_id);
			ac.setAc_pw(ac_pw);
			ac.setAc_name(ac_name);
			ac.setAc_addr(ac_addr);
			ac.setAc_email(ac_email);
			ac.setAc_pic(ac_newpic);

			System.out.println(ac.toString());

			if (ss.getMapper(AccountMapper.class).accountUpdate(ac) == 1) {
				req.setAttribute("result", "수정성공");
				req.getSession().setAttribute("loginAccount", ac);

				if (!oldFile.equals(newFile)) {
					oldFile = URLDecoder.decode(oldFile, "utf-8");
					new File(path + "/" + oldFile).delete();
				}
			} else {
				req.setAttribute("result", "수정실패");
				if (!oldFile.equals(newFile)) {
					newFile = URLDecoder.decode(newFile, "utf-8");
					new File(path + "/" + newFile).delete();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "수정실패");
			if (!oldFile.equals(newFile)) {
				try {
					newFile = URLDecoder.decode(newFile, "utf-8");
				} catch (UnsupportedEncodingException e1) {

				}
				new File(path + "/" + newFile).delete();
			}
		}
	}

	public void accountDelete(HttpServletRequest req) {
		try {
			AccountDTO a = (AccountDTO) req.getSession().getAttribute("loginAccount");

			if (ss.getMapper(AccountMapper.class).accountDelete(a) == 1) {
				req.setAttribute("result", "탈퇴 성공");

				String path = req.getSession().getServletContext().getRealPath("resources/files/account");
				String ac_newpic = a.getAc_pic();
				ac_newpic = URLDecoder.decode(ac_newpic, "utf-8");
				new File(path + "/" + ac_newpic).delete();

				/*
				 * logout(req); loginCheck(req);
				 */

			} else {
				req.setAttribute("result", "탈퇴실패");
			}

		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "탈퇴실패");
		}

	}

	/*
	 * private void loginCheck(HttpServletRequest req) { AccountDTO a = (AccountDTO)
	 * req.getSession().getAttribute("loginAccount"); if (a != null) {
	 * req.setAttribute("loginPage", "account/loginSuccess.jsp"); } else {
	 * req.setAttribute("loginPage", "account/login.jsp"); }
	 * 
	 * }
	 * 
	 * private void logout(HttpServletRequest req) {
	 * req.getSession().setAttribute("loginAccount", null);
	 * 
	 * }
	 */

}
