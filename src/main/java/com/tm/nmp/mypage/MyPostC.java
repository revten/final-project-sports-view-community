package com.tm.nmp.mypage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MyPostC {
	
	@Autowired
	private MyPostDAO mpDAO;

}
