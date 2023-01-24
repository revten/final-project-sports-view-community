package com.tm.nmp.message;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tm.nmp.account.AccountDTO;

@Service
public class messageDAO {

	@Autowired
	private SqlSession ss;

	public void getMember(HttpServletRequest req) {
		try {
			req.setAttribute("members", ss.getMapper(MessageMapper.class).getMember());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void getMsg(HttpServletRequest req) {
		
		try {
			AccountDTO ac = (AccountDTO) req.getSession().getAttribute("loginAccount");
			req.setAttribute("msgs", ss.getMapper(MessageMapper.class).getMsg(ac));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteMsg(MessageVO mv, HttpServletRequest req) {
		try {
			if (ss.getMapper(MessageMapper.class).deleteMsg(mv) == 1) {
				req.setAttribute("result", "쪽지삭제 성공");
			}else {
				req.setAttribute("result", "쪽지삭제실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "쪽지삭제실패");
		}
		
	}

	public void sendMsg(MessageVO mv, HttpServletRequest req) {
		try {
			AccountDTO ac = (AccountDTO) req.getSession().getAttribute("loginAccount");
			mv.setMessage_from(ac.getMember_id());
			if (ss.getMapper(MessageMapper.class).sendMsg(mv) == 1) {
				req.setAttribute("result", "쪽지보내기 성공");
			}else {
				req.setAttribute("result", "쪽지보내기실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "쪽지보내기실패");
		}
		
	}
	
	
}
