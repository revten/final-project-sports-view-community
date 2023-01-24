package com.tm.nmp.mypage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.tm.nmp.account.AC_US_DAO;

@Controller
public class MyPageController {

	@Autowired
	private AC_US_DAO acDAO;

}
