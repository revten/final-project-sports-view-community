<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>


	<!--==================== Nav바 ====================-->
	<div class="nav__menu" id="nav-menu" style="width: 55%; align: center;">
		<ul class="nav__list">
			<li class="nav__item"><a href="newsEvent.main.go" class="nav__link">뉴스</a></li>
			<li class="nav__item"><a href="clubEvent.board.go"
				class="nav__link">구단공식이벤트</a></li>
			
		</ul>

		<!-- close button -->
		<div class="nav__close" id="nav-close">
			<i class="ri-close-line"></i>
		</div>
	</div>
	<br><br>
	
	<div id="content_area">
		<ul class="bxslider">
			<!-- <li><img src="resources/files/slider/aa.jpg" /></li> -->
			<li><img
				src="http://ticketimage.interpark.com/TCMS3.0/SPORT/BIGBN/2301/230104022322_20230104022322.gif" /></li>
			<li><img
				src="http://ticketimage.interpark.com/TCMS3.0/SPORT/BIGBN/2212/221228102015_20221228102015.gif" /></li>
		</ul>
	</div>
	
	
	<!--==================== 게시판 ====================-->

	<div class="board__container">
		<div class="board__top">
			<c:choose>
				<c:when test="${sessionScope.loginAccount ne null}">
					<a href=clubEvent.reg.go> 새글쓰기</a>
				</c:when>
				<c:otherwise>
					<a href="clubEvent.reg.go" onclick="alert('로그인하세요')">새글쓰기</a>
				</c:otherwise>
			</c:choose>
		</div>


		<table class="board__table">
			<thead>
				<tr>
					<th style="width: 80px;">게시판넘버</th>
					<th style="width: 70px;">글번호</th>
					<th style="width: 50px;">탭</th>
					<th style="width: 510px;">제목</th>
					<th style="width: 150px;">등록일</th>
					<th style="width: 100px;">닉네임</th>
					<th style="width: 70px;">조회수</th>
					<th style="width: 70px;">추천수</th>
				</tr>
				<c:forEach var="p" items="${posts }">
					<tr>
						<td>${p.post_board}</td>
						<td>${p.post_id}</td>
						<td>${p.post_category}</td>
						<td><a
							href="clubEvent.detail.go?post_id=${p.post_id }&post_member=${p.post_member}">${p.post_title }
								[${p.post_like_count}]</a></td>
						<td><c:choose>
								<c:when test="${p.post_update_date eq null }">
									<fmt:formatDate value="${p.post_reg_date}"
										pattern="yy-MM-dd HH:mm" />
								</c:when>
								<c:otherwise>
									<fmt:formatDate value="${p.post_update_date}"
										pattern="yy-MM-dd HH:mm" />
								</c:otherwise>
							</c:choose></td>
						<td>${p.member_nick}</td>
						<td>${p.post_hit_count}</td>
						<td>${p.post_like_count}</td>
					</tr>
				</c:forEach>
			</thead>
		</table>


		<div class="board__bot">
			<div class="board__bot-search">
				<form action="clubEvent.search.do" name="boardSearchForm"
					onsubmit="return boardSearchCheck();">
					<table id="snsSearchArea">
						<tr>
							<td id="ssaTd1"><input id="search" name="search" maxlength="10"
								autocomplete="off" placeholder="검색어를 입력해주세요."></td>
							<td id="ssaTd2"><button class="btn btn-dark">검색</button></td>
						</tr>
					</table>
				</form>
			</div>

			<div class="board__bot-paging">
				<c:if test="${curPage != 1}">
					<span><a href="clubEvent.page.change?pg=1">[맨처음]</a></span>
					<span><a href="clubEvent.page.change?pg=${curPage - 1}">
							◀이전 </a></span>
				</c:if>
				<c:forEach var="i" begin="1" end="${pageCount}">
					<a href="clubEvent.page.change?pg=${i}"> [${i}] </a>
				</c:forEach>
				<c:if test="${curPage != pageCount}">
					<span> <a href="clubEvent.page.change?pg=${curPage + 1}">
							다음▶ </a></span>
					<span><a href="clubEvent.page.change?pg=${pageCount}">[맨끝]</a></span>
				</c:if>
			</div>
		</div>

	</div>
	</main>
	<script>
		function boardSearchCheck() {
			let searchInput = document.boardSearchForm.search;

			if (isEmpty(searchInput)) {
				alert("?");
				searchInput.focus();
				return false;
			}
			return true;
		}
	</script>
</body>
</html>