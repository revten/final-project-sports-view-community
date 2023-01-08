package com.tm.mp.news;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Service;

@Service
public class NewsDAO {

	public JSONObject getNews(HttpServletRequest req) {

		HttpsURLConnection huc = null;
//		String keyword = req.getParameter("trip");
//		System.out.println(keyword);
		try {
			// 100
			String str = "여행";
			str = URLEncoder.encode(str, "utf-8");
			
			
			String url = "https://openapi.naver.com/v1/search/news.json";
				
			url += "?query=" + str;
			url += "&display=100";
			url += "&sort=sim";
			
			
			URL u = new URL(url);
			huc = (HttpsURLConnection) u.openConnection();
			huc.addRequestProperty("X-Naver-Client-Id", "KvO7Dl7LHxZBKpoeR18V");
			huc.addRequestProperty("X-Naver-Client-Secret", "1iWxDUwLyI");
			InputStream is = huc.getInputStream();
			InputStreamReader isr = new InputStreamReader(is, "utf-8");
			
			JSONParser jp = new JSONParser();
			JSONObject newsData =  (JSONObject) jp.parse(isr);

			return newsData;
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return null;


	}

}
