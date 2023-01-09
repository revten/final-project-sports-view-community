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


	<section>
		<div id="data-container"></div>
		<div id="pagination"></div>
	</section>
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