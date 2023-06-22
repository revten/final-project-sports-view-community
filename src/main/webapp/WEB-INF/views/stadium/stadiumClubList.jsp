<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
	<div id="stadium__container">
		<!-- 검색 -->
		<div>검색 영역</div>
		<form action="getClubList.go" class="" onsubmit="return searchClub()">
			<div id="">
				<div id="">
					<input id="search-club-input" placeholder="검색어 입력"
						name="searchValue" />
					<button class="btn">검색</button>
				</div>
				<div id="city">
					<select name="sports_id" id="sports"></select>
					<select name="league_id" id="league"></select>
				</div>
			</div>
		</form>

		<div id="stadium-club-list">
			<c:forEach var='ci' items='${clubImages }'>
				<div id="stadium__img">

					<input type="hidden" id="stadium-login-id-${ci.club_id }" value="${sessionScope.loginAccount.id }">
					<input type="hidden" id="stadium-club-id-${ci.club_id }" value="${ci.club_id }">
					
					<a style="cursor: pointer" onclick="location.href='stadium.detail.go?club_id=${ci.club_id}'">
						<img style="width: 100px; height: 100px; cursor: pointer" src="/resources/files/club_images/${ci.club_id }/${ci.file_name}">
					</a>
					
					<span>
						<c:choose>
							<c:when test="${ci.favored == 1 }">
								<img onclick="heartClick('${ci.club_id }')" class="club-fav-img club-fav-img-${ci.club_id }" alt="" src="/resources/files/icons/fav.png">
							</c:when>
							<c:otherwise>
								<img onclick="heartClick('${ci.club_id }')" class="club-fav-img club-fav-img-${ci.club_id }" alt="" src="/resources/files/icons/fav_not.png">
							</c:otherwise>
						</c:choose>
					</span>
				</div>
			</c:forEach>
		</div>
		
	</div>
</body>
</html>
