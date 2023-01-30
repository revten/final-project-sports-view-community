<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TRIPPLE: WithGo</title>

</head>
<body>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<div class="withGo__container">

		<div class="app-content">

			<!-- 2번줄 헤더 -->
			<div class="withGo__header">
				<!-- 왼쪽 검색바 -->
				<div>
					<input class="search-bar" placeholder="Search..." type="text">
				</div>
				<div>
					<h3>With Go</h3>
				</div>

				<!-- 이동버튼 -->
				<div class="move__button-wrapper">
					<c:choose>
						<c:when test="${sessionScope.loginAccount ne null}">
							<button class="action-button"
								onclick="location.href='withGo.reg.go?post_board=${param.post_board}'">
								<span>리뷰쓰기</span>
								<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
									viewBox="0 0 24 24" fill="none" stroke="currentColor"
									stroke-width="2" stroke-linecap="round" stroke-linejoin="round"
									class="feather feather-filter">
								<polygon points="22 3 2 3 10 12.46 10 19 14 21 14 12.46 22 3" /></svg>
							</button>
						</c:when>
						<c:otherwise>
							<button class="action-button" onclick="alert('로그인하세요')">
								<span>새글쓰기</span>
								<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
									viewBox="0 0 24 24" fill="none" stroke="currentColor"
									stroke-width="2" stroke-linecap="round" stroke-linejoin="round"
									class="feather feather-filter">
								<polygon points="22 3 2 3 10 12.46 10 19 14 21 14 12.46 22 3" /></svg>
							</button>
						</c:otherwise>
					</c:choose>
				</div>
			</div>

					<!-- 내용넣기 -->


					<!-- 컨텐트 끝 -->
					
				</div>
			</div>

	<script>
		document.querySelector(".jsFilter").addEventListener(
				"click",
				function() {
					document.querySelector(".filter-menu").classList
							.toggle("active");
				});
	</script>
</body>
</html>