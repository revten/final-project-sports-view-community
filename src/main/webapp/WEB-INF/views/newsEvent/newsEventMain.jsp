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
	<div class="nav__menu" id="nav-menu" style="width:55%;align:center;">
				<ul class="nav__list">
					<li class="nav__item"><a href="newsEvent.main.go"
						class="nav__link">뉴스</a>
					</li>
						
					<!-- <li class="nav__item"><a href="news.sports.go"
						class="nav__link">스포츠</a></li> -->
						
					<li class="nav__item"><a href="clubEvent.board.go"
						class="nav__link">구단공식이벤트</a></li>
						

				</ul>
		</div>
		<br><br>
		
		<div class="div_news">
		<div style="float:left; width: 200px;">
		<div class="div_news_go"><a href="news.soccer.go" class="news_go">축구</a></div>
		<div class="div_news_go"><a href="news.baseball.go" class="news_go">야구</a></div>
		<div class="div_news_go"><a href="news.basketball.go" class="news_go">농구</a></div>
		<div class="div_news_go"><a href="news.volleyball.go" class="news_go">배구</a></div>
		</div>
		<div class="div_news_content">
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
				+ "<a href='"+ data.items[0].link + "'><span class='newsTitle'>"
				+ data.items[0].title
				+ "</span></a><div class='hiddenMsg'><span> </span></div>"
				+ "</div><div><span class='time'>"
				+ (data.items[0].pubDate).substring(0,
						16)
				+ "</span></div><br><span class='newsContent'>"
				+ data.items[0].description
				+ "</span></div><br><hr style=\"border: 0;height: 1px;background: #ccc;\">";
			element.className = "SoccerNews";
								

				}
		function callbackBaseball(data) {
			const element = document.getElementById('BaseballNews');
			element.innerHTML += "<div class='news'><div class='title'>"
				+ "<a href='"+ data.items[0].link + "'><span class='newsTitle'>"
				+ data.items[0].title
				+ "</span></a><div class='hiddenMsg'><span> </span></div>"
				+ "</div><div><span class='time'>"
				+ (data.items[0].pubDate).substring(0,
						16)
				+ "</span></div><br><span class='newsContent'>"
				+ data.items[0].description
				+ "</span></div><br><hr style=\"border: 0;height: 1px;background: #ccc;\">";
			element.className = "BaseballNews";
								

				}
		function callbackBasketball(data) {
			const element = document.getElementById('BasketballNews');
			element.innerHTML += "<div class='news'><div class='title'>"
				+ "<a href='"+ data.items[0].link + "'><span class='newsTitle'>"
				+ data.items[0].title
				+ "</span></a><div class='hiddenMsg'><span> </span></div>"
				+ "</div><div><span class='time'>"
				+ (data.items[0].pubDate).substring(0,
						16)
				+ "</span></div><br><span class='newsContent'>"
				+ data.items[0].description
				+ "</span></div><br><hr style=\"border: 0;height: 1px;background: #ccc;\">";
			element.className = "BasketballNews";
								

				}
		function callbackVolleyball(data) {
			const element = document.getElementById('VolleyballNews');
			element.innerHTML += "<div class='news'><div class='title'>"
				+ "<a href='"+ data.items[0].link + "'><span class='newsTitle'>"
				+ data.items[0].title
				+ "</span></a><div class='hiddenMsg'><span> </span></div>"
				+ "</div><div><span class='time'>"
				+ (data.items[0].pubDate).substring(0,
						16)
				+ "</span></div><br><span class='newsContent'>"
				+ data.items[0].description
				+ "</span></div><br><hr style=\"border: 0;height: 1px;background: #ccc;\">";
			element.className = "VolleyballNews";
								

				}
		});
	</script>
</body>
</html>