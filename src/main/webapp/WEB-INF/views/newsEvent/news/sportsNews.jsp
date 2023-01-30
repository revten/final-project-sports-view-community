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
	<br>
	<div class="nav__menu" id="nav-menu" style="width:70%;align:center;">
				<ul class="nav__list">
					<li class="nav__item"><a href="news.soccer.go"
						class="nav__link">축구</a>
					</li>

					<li class="nav__item"><a href="news.baseball.go" class="nav__link">야구</a></li>

					<li><a href="news.basketball.go" class="nav__link">농구</a></li>

					<li class="nav__item"><a href="news.volleyball.go"
						class="nav__link">배구</a></li>
						
					<li class="nav__item"><a href="news.sports.go"
						class="nav__link">스포츠</a></li>
						
					<li class="nav__item"><a href="team.event.main.go"
						class="nav__link">구단공식이벤트</a></li>
						
					<li class="nav__item"><a href="sports.info.main.go"
						class="nav__link">생활체육정보</a></li>

				</ul>

				<!-- close button -->
				<div class="nav__close" id="nav-close">
					<i class="ri-close-line"></i>
				</div>
			</div>
	


	<section>
		<div id="data-container"></div>
		<div id="pagination" class='paginationjs-theme-blue paginationjs-smallen'></div>
	</section>
	<script type="text/javascript">
		$(function() {
			// 인코딩
			// 100 - 200
			$.ajax({
				url : "get.sports.news.all",
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
												+ "<a href='"+ i.link + "'target='_blank'><span class='newsTitle'>"
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