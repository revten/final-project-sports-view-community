package com.tm.nmp.account;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.tm.nmp.SHA256Util;
import com.tm.nmp.admin.ClubImageDTO;
import com.tm.nmp.board.PostVO;

import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;

@Service
public class accountDAO {

	private static final Logger logger = LoggerFactory.getLogger(accountDAO.class);

	@Autowired
	private SqlSession ss;

	@Autowired
	private JavaMailSender mailSender;

	// 로그인 영역 표시
	public boolean loginCheck(HttpServletRequest req) {

		AccountDTO a = (AccountDTO) req.getSession().getAttribute("loginAccount");
		if (a != null) {
			req.setAttribute("loginPage", "account/loginSuccess.jsp");
			return true;
		}
		req.setAttribute("loginPage", "account/login.jsp");
		return false;
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

	// 아이디 중복 검사
	public int idCheck(String id) {
		int cnt = ss.getMapper(AccountMapper.class).idCheck(id);
		return cnt;
	}

	// 이메일 인증
	public String emailAuthDo(String email) {
		Random random = new Random();
		int checknum = random.nextInt(888888) + 111111;

		// 이메일 보낼 양식
		String setFrom = "trainst37@naver.com";
		String toMail = email;
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

	// 휴대폰 인증 coolsms
	public String sendSms(HttpServletRequest req) throws CoolsmsException {

		String api_key = "NCS7QARZ4KC7D3TV";
		String api_secret = "BSWCYXI3HQUQE1QMS17RMT5BD9EQAPHV";
		Message coolsms = new Message(api_key, api_secret); // 수신번호(문자를 받을 사람)

		Random rand = new Random();
		String numStr = "";
		for (int i = 0; i < 4; i++) {
			String ran = Integer.toString(rand.nextInt(10));
			numStr += ran;
		}

		HashMap<String, String> set = new HashMap<String, String>();
		set.put("to", req.getParameter("num")); // 발신번호(문자를 보낼 사람) jsp에서 전송한 발신번호를 받아 map에 저장한다.
		set.put("from", "01050950203"); // 문자내용
		set.put("type", "sms"); // 문자 타입
		set.put("text", "인증번호 : [" + numStr + "]");
		set.put("app_version", "test app 1.2");
		logger.info("set", set);

		System.out.println(set);
		try {
			JSONObject result = coolsms.send(set); // 보내기&전송결과받기
			return numStr;
		} catch (CoolsmsException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCode());
			return null;
		}
	}

	// 회원가입시 구단 로고 이미지 불러오기
	public List<ClubImageDTO> getAllClubLogos() {
		return ss.getMapper(AccountMapper.class).getAllClubLogos();
	}

	// 회원가입
	public void accountRegDo(HttpServletRequest req, AccountDTO ac) {

		// salt 생성
		String salt = SHA256Util.generateSalt();
		// db에 저장할 salt 세팅
		ac.setSalt(salt);

		// 유저가 입력한 password
		String password = ac.getPassword();
		// 유저가 입력한 password와 위에서 생성한 satl를 조합하여 password 완성
		password = SHA256Util.getEncrypt(password, salt);
		// db에 저장할 최종 password를 세팅
		ac.setPassword(password);

		if (ss.getMapper(AccountMapper.class).regAccount(ac) != 0) {
			// pv.setUserId(ac.getMember_id());
			// ss.getMapper(PointMapper.class).pointTable(pv);
			System.out.println("가입 성공");
		} else {
			System.out.println("가입 실패");
		}
	}

	// 회원가입시 관심 구단 등록
	public void regFavoriteClub(List<FavoriteClubDTO> favoriteClubs) {
		ss.getMapper(AccountMapper.class).regFavoriteClub(favoriteClubs);
	}

	// 로그인 하기
	public void accountLoginDo(HttpServletRequest req, AccountDTO ac) {

		AccountDTO dbAccount = ss.getMapper(AccountMapper.class).accountLogin(ac);

		if (dbAccount != null) {

			// db에 저장된 salt 가져오기
			String dbSalt = dbAccount.getSalt();
			// 유저가 입력한 password 가져오기
			String password = ac.getPassword();

			// db에서 가져온 salt와 유저가 입력한 password 조합하여 최종 password 산출
			password = SHA256Util.getEncrypt(password, dbSalt);

			// db에 저장된 password와 최종 산출된 password를 비교
			if (password.equals(dbAccount.getPassword())) {
				req.getSession().setAttribute("loginAccount", dbAccount);
				req.getSession().setMaxInactiveInterval(60 * 60);
			} else {
				req.setAttribute("r", "비밀번호 오류!");
			}
		} else {
			req.setAttribute("r", "존재하지 않는 회원");
		}
	}

	// 로그아웃
	public void accountLogoutDo(HttpServletRequest req, HttpServletResponse resp, AccountDTO ac) {

		req.getSession().setAttribute("loginAccount", null);

		Cookie loginCookie = new Cookie("loginCookie", null); // choiceCookieName(쿠키 이름)에 대한 값을 null로 지정

		loginCookie.setPath("/");
		loginCookie.setMaxAge(0); // 유효시간을 0으로 설정

		logger.info("유효기간 체크 : ", loginCookie.getMaxAge());
		logger.info("값 체크 :  " + loginCookie.getValue());
		resp.addCookie(loginCookie);
	}

	// 아이디 찾기
	public String searchId(HttpServletRequest req) {
		String nickname = req.getParameter("nickname");
		String email = req.getParameter("email");

		Map<String, String> findId = new HashMap<String, String>();
		findId.put("nickname", nickname);
		findId.put("email", email);

		return ss.getMapper(AccountMapper.class).searchId(findId);
	}

	// 비밀번호 변경하기
	public void changePwDo(HttpServletRequest req, AccountDTO ac) {
		if (ss.getMapper(AccountMapper.class).changePwDo(ac) == 1) {
			System.out.println("변경 완료");
			req.getSession().setAttribute("loginAccount", ss.getMapper(AccountMapper.class).accountLogin(ac));
		}
	}

	// 회원 탈퇴하기
	public void deleteAccount(HttpServletRequest req, String id) {
		if (ss.getMapper(AccountMapper.class).deleteAccount(id) == 1) {
			req.setAttribute("result", "탈퇴 성공");
		} else {
			req.setAttribute("result", "탈퇴실패");
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

	public int socialIdCheck(AccountDTO ac) {
		System.out.println(ac.getId());
		System.out.println(ac.getJoin_type());
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

			String member_id = req.getParameter("member_id");
			String member_pwd = " ";
			String nickname = " ";
			int member_auth_type = 1;
			int member_reg_type = Integer.parseInt(req.getParameter("member_reg_type"));
			String member_reg_ip = " ";

			String member_email;
			if (member_reg_type == 1) {
				member_email = member_id + "@kakao.com";
			} else if (member_reg_type == 2) {
				member_email = member_id + "@naver.com";
			} else {
				member_email = member_id + "@google.com";
			}

			String member_intro = " ";
			int member_subs = 0;
			int club_id = 0;
			int member_admin = 0;

			ac.setMember_id(member_id);
			ac.setMember_pwd(member_pwd);
			ac.setMember_nick(nickname);
			ac.setMember_auth_type(member_auth_type);
			ac.setMember_reg_ip(member_reg_ip);
			ac.setMember_email(member_email);
			ac.setMember_intro(member_intro);
			ac.setMember_subs(member_subs);
			ac.setClub_id(club_id);
			ac.setMember_admin(member_admin);

			if (ss.getMapper(AccountMapper.class).regAccount(ac) == 1) {
				System.out.println("회원 가입 성공");
			} else {
				System.out.println("회원 가입 실패");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void showAccount(AccountDTO ac, HttpServletRequest req) {
		AccountDTO a = (AccountDTO) req.getSession().getAttribute("loginAccount");
		a.setId(a.getId());
		List<AccountDTO> Account = ss.getMapper(AccountMapper.class).showAccount(ac);
		req.setAttribute("account", Account);
	}

	public void getMyPosts(HttpServletRequest req, PostVO postVO) {
		postVO.setPost_member(req.getParameter("post_member"));
		List<PostVO> myPosts = ss.getMapper(AccountMapper.class).getMyPosts(postVO);
		req.setAttribute("MyPosts", myPosts);

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

}
