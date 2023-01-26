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

		<div>
		<div style="float:left; width: 200px;">
		<div class="div_news_go"><a href="news.soccer.go" class="news_go">축구</a></div>
		<div class="div_news_go"><a href="news.baseball.go" class="news_go">야구</a></div>
		<div class="div_news_go"><a href="news.basketball.go" class="news_go">농구</a></div>
		<div class="div_news_go"><a href="news.volleyball.go" class="news_go">배구</a></div>
		</div>
		<div style="margin-left: 200px;">
		<div id="data-container"></div>
		<div id="pagination" style="margin-left: 30%;"></div>
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
										content += "<div class='news'><span class='time'>"
												+ (i.pubDate).substring(0,
														16)
												+ "</span><div class='title'>"
												+ "<a href='"+ i.link + "'><span class='newsTitle'>"
												+ i.title
												+ "</span></a><div class='hiddenMsg'><span>⬅ </span></div>"
												+ "</div><span class='newsContent'>"
												+ i.description
												+ "</span></div>";
									});

					$("#data-container").html(content);
				}
			})
		}
	</script>
</body>
</html>