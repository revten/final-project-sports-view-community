<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
	<div id="community_area">
		<ul id="community_list">
			<li><a style="cursor: pointer"
				href='reviewList.go?rv_cat=review'>직관 후기 게시판</a></li>
			<li><a style="cursor: pointer"
				href='withGoList.go?wg_cat=withGo'>같이 직관/경기 게시판</a></li>
			<li><a style="cursor: pointer" href="baseballBoard.go">야구
					게시판</a></li>
			<li><a style="cursor: pointer" href="soccerBoard.go">축구 게시판</a></li>
			<li><a style="cursor: pointer" onclick="">농구 게시판</a></li>
			<li><a style="cursor: pointer" onclick="">배구 게시판</a></li>
			<li><a style="cursor: pointer" onclick="">기타 게시판</a></li>
		</ul>
	</div>
	<div id="community_main">
	<div id="review_board">
		<a>경기장 직관 후기 베스트</a>
		<div id="review_list_cat">
	</div>
	<div id="review_list">
	<c:forEach var="b" items="${posts}">
					<a><img style="width: 100px; height: 100px"
						src="resources/ckeditor/fileUpload/${b.wg_img }"></a><br>
					<div onclick="location.href='withGoDetail.go?wg_no=${b.wg_no}'">
					  <a>${b.wg_id}</a>
					<a><fmt:formatDate value="${b.wg_date}"
							pattern="yy-MM-dd HH:mm" /></a>
					<a style="width: 40%;">${b.wg_title}</a>
				</div>
			</c:forEach>
	</div>
	</div>
	<div id="best_board">
		<a>인기글</a>
	<div id="best_list_cat">
		<a>탭</a>
		<a>제목</a>
		<a>내용</a>
		<a>등록일</a>
		<a>닉네임</a>
	</div>
	<div id="best_list">
		<c:forEach var="sc" items="${soccer }">
			<div onclick="location.href='soccerBoardDetail.go?cm_sc_no=${sc.cm_sc_no}'">
				<a>${sc.cm_sc_cat}</a>
				<a>${sc.cm_sc_title}</a>
				<a>${sc.cm_sc_content}</a>
				<a><fmt:formatDate value="${sc.cm_sc_date}"
						pattern="yy-MM-dd HH:mm" /></a>
				<a>${sc.cm_sc_nick}</a>
			</div>
		</c:forEach>
	</div>
	</div>
	</div>
</body>
</html>