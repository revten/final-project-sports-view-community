package com.tm.nmp;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

public class TokenMaker {
		public static void make(HttpServletRequest req) {
			
			Date d = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss:SS");
			String token = sdf.format(d);
			req.setAttribute("token", token);
		}
}
