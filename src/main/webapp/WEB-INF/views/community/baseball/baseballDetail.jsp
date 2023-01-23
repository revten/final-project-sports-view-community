<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	$(function() {
		CKEDITOR.replace('editor', {
			filebrowserUploadUrl : 'fileupload.do',
		});
	});
</script>
</head>
<body>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<h1>야구게시판</h1>
	<div>
		<!-- 상세창 -->
		<div class="freeDetail">
			<div class="freeDetail__1st-line">
				<div class="freeDetail_title">탭:${post.post_category}&nbsp;제목:${post.post_title}</div>
				<div class="freeDetail_date">
					<c:choose>
						<c:when test="${post.post_update_date eq null }">
						작성날짜:<fmt:formatDate value="${post.post_reg_date}"
								pattern="yy-MM-dd HH:mm" />
						</c:when>
						<c:otherwise>
						수정날짜:<fmt:formatDate value="${post.post_update_date}"
								pattern="yy-MM-dd HH:mm" />
						</c:otherwise>
					</c:choose>
				</div>
			</div>

			<div class="freeDetail_2nd_line">
				<div class="freeDetail_element">닉네임:${post.member_nick}</div>
				<div class="bbsDetail_element">NO.:${post.post_id }&nbsp;조회수:${post.post_hit_count }&nbsp;
					추천수:${post.post_like_count}&nbsp;스크랩수:${post.post_scrap_count}</div>
			</div>

			<div class="freeDetail_detail">${post.post_content}</div>
			<%-- 			<div class="freeDetail_img">
				<c:if test="${post.post_img ne null }">
					<td colspan="3"><img src="resources/ckeditor/fileUpload/${post.post_img }">
				</c:if>
			</div>
			<div class="freeDetail_file">
				<c:if test="${post.post_file ne null }">
					<td colspan="3"><img src="resources/ckeditor/fileUpload/${post.post_file }">
				</c:if> --%>
		</div>

		<div class="freeDetail_bot">
			<button class="freebt" onclick="history.back()">이전으로</button>
			<c:choose>
				<c:when
					test="${sessionScope.loginAccount.member_id eq post.post_member}">
					<c:choose>
						<c:when test="${sessionScope.loginAccount eq null}">
							<button onclick="alert('로그인하세요')">수정</button>
							<button onclick="alert('로그인하세요')">삭제</button>
						</c:when>
						<c:otherwise>
							<button class="freebt"
								onclick="location.href='baseball.update.go?post_id=${post.post_id}&post_member=${post.post_member}'">수정</button>
							<button class="bbsbt"
								onclick="location.href='baseball.delete.do?post_id=${post.post_id}'">삭제</button>
						</c:otherwise>
					</c:choose>
				</c:when>
			</c:choose>
		</div>
	</div>
</body>
</html>