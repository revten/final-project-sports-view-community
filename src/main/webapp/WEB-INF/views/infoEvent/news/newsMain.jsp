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
    <script src="https://code.jquery.com/jquery-3.6.3.min.js"
	integrity="sha256-pvPw+upLPUjgMXY0G+8O0xUf+/Im1MZjXxxgOcBQBXU="
	crossorigin="anonymous"></script>
</head>
<body>
	<br>
	<br>
	<br>
	<br>
	<br>
	
	<div class="nav__menu" id="nav-menu">
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

				</ul>

				<!-- close button -->
				<div class="nav__close" id="nav-close">
					<i class="ri-close-line"></i>
				</div>
			</div>
			
			<div align="center"><jsp:include page="${newsPage }"></jsp:include></div>


	
</body>
</html>