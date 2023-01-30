<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/paginationjs/2.1.4/pagination.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/paginationjs/2.1.4/pagination.css"/>
</head>
<body>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<div class="nav__menu" id="nav-menu" style="width:59%;align:center;">
				<ul class="nav__list">
					<li class="nav__item"><a href='news.soccer.go'>축구</a></li>
						
					<li class="nav__item"> <a href='news.baseball.go'>야구</a></li>
					<li class="nav__item"><a href='news.basketball.go'>농구</a></li>
					<li class="nav__item"> <a href='news.volleyball.go'>배구 </a></li>
				</ul>
		</div>
		<br><br>
		
		
		<div class="div_news_content">
		<div class="div_news">
		<div id="SoccerNews"></div>
		<div id="BaseballNews"></div>
		<div id="BasketballNews"></div>
		<div id="VolleyballNews"></div>
		</div>
		</div>
	<script type="text/javascript">
		$(function() {
			// 인코딩
			// 100 - 200
			$.ajax({
				url : "get.soccer.news.one",
				type : "GET",
				success : function(data) {
					console.log(data)
					callbackSoccer(data);
				}
			});
			$.ajax({
				url : "get.baseball.news.one",
				type : "GET",
				success : function(data) {
					console.log(data)
					callbackBaseball(data);
				}
			});
			$.ajax({
				url : "get.basketball.news.one",
				type : "GET",
				success : function(data) {
					console.log(data)
					callbackBasketball(data);
				}
			});
			$.ajax({
				url : "get.volleyball.news.one",
				type : "GET",
				success : function(data) {
					console.log(data)
					callbackVolleyball(data);
				}
			});


		function callbackSoccer(data) {
			const element = document.getElementById('SoccerNews');
			element.innerHTML += "<div class='news'><div class='title'>"
				+ "<a href='"+ data.items[0].link + "' target='_blank'><span class='newsTitle'>"
				+ data.items[0].title
				+ "</span></a><div class='hiddenMsg'><span> </span></div>"
				+ "</div><div><span class='time'>"
				+ (data.items[0].pubDate).substring(0,
						16)
				+ "</span></div><br><span class='newsContent'>"
				+ data.items[0].description
				+ "</span><br><hr style=\"border: 0;height: 1px;background: #ccc;\"></div>";
			element.className = "SoccerNews";
								

				}
		function callbackBaseball(data) {
			const element = document.getElementById('BaseballNews');
			element.innerHTML += "<div class='news'><div class='title'>"
				+ "<a href='"+ data.items[0].link + "' target='_blank'><span class='newsTitle'>"
				+ data.items[0].title
				+ "</span></a><div class='hiddenMsg'><span> </span></div>"
				+ "</div><div><span class='time'>"
				+ (data.items[0].pubDate).substring(0,
						16)
				+ "</span></div><br><span class='newsContent'>"
				+ data.items[0].description
				+ "</span><br><hr style=\"border: 0;height: 1px;background: #ccc;\"></div>";
			element.className = "BaseballNews";
								

				}
		function callbackBasketball(data) {
			const element = document.getElementById('BasketballNews');
			element.innerHTML += "<div class='news'><div class='title'>"
				+ "<a href='"+ data.items[0].link + "' target='_blank'><span class='newsTitle'>"
				+ data.items[0].title
				+ "</span></a><div class='hiddenMsg'><span> </span></div>"
				+ "</div><div><span class='time'>"
				+ (data.items[0].pubDate).substring(0,
						16)
				+ "</span></div><br><span class='newsContent'>"
				+ data.items[0].description
				+ "</span><br><hr style=\"border: 0;height: 1px;background: #ccc;\"></div>";
			element.className = "BasketballNews";
								

				}
		function callbackVolleyball(data) {
			const element = document.getElementById('VolleyballNews');
			element.innerHTML += "<div class='news'><div class='title'>"
				+ "<a href='"+ data.items[0].link + "' target='_blank'><span class='newsTitle'>"
				+ data.items[0].title
				+ "</span></a><div class='hiddenMsg'><span> </span></div>"
				+ "</div><div><span class='time'>"
				+ (data.items[0].pubDate).substring(0,
						16)
				+ "</span></div><br><span class='newsContent'>"
				+ data.items[0].description
				+ "</span><br><hr style=\"border: 0;height: 1px;background: #ccc;\"></div>";
			element.className = "VolleyballNews";
								

				}
		});
	</script>
</body>
</html>