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
					<li class="nav__item"><a class="nav__link" href='news.soccer.go'>축구</a></li>
						
					<li class="nav__item"> <a class="nav__link" href='news.baseball.go'>야구</a></li>
					<li class="nav__item"><a class="nav__link" href='news.basketball.go'>농구</a></li>
					<li class="nav__item"> <a class="nav__link" href='news.volleyball.go'>배구 </a></li>
				</ul>
		</div>
		<br><br>

		<div class="div_news">
		<!-- <div class="div_news_nav">
		<div id="sidebar">
		<nav class="navbar">
		 <ul class="navbar__menu">
            <li onclick="location.href='news.soccer.go'">축구</li>
            <li onclick="location.href='news.baseball.go'">야구</li>
            <li onclick="location.href='news.basketball.go'">농구</li>
            <li onclick="location.href='news.volleyball.go'">배구 </li>
          </ul>
          </nav>
           </div>
		</div> -->
		<div class="div_news_content">
		<div id="data-container"></div>
		<div id="pagination" style="margin-left: 29%;"></div>
		</div>
		</div>
	<script type="text/javascript">
		$(function() {
			// 인코딩
			// 100 - 200
			$.ajax({
				url : "get.baseball.news.all",
				type : "GET",
				success : function(data) {
					console.log(data)
					callback(data);
				}
			});

		});

		function callback(data) {
			console.log("--> 2 : " + data);
			let container = $('#pagination');
			container.pagination({
				dataSource : data.items,
				pageSize : 10,
				callback : function(data, pagination) {
					let content = "";
					$.each(
									data,
									function(index, i) {
										content += "<div class='news'><div class='title'>"
												+ "<a href='"+ i.link + "' target='_blank'><span class='newsTitle'>"
												+ i.title
												+ "</span></a><div class='hiddenMsg'><span> </span></div>"
												+ "</div><div><span class='time'>"
												+ (i.pubDate).substring(0,
														16)
												+ "</span></div><br><span class='newsContent'>"
												+ i.description
												+ "</span><br><hr style=\"border: 0;height: 1px;background: #ccc;\"></div>";
									});

					$("#data-container").html(content);
				}
			})
		}
	</script>
</body>
</html>