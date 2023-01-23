<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	<h1>야구게시판 수정페이지</h1>
	<form action="baseball.update.do" method="POST">
		<div class="freeDetail">
			<div class="freeDetail__1st-line">
				<div class="freeDetail_title">
					탭: <input name="post_category" value="${post.post_category}">
					탭: <input name="post_id" value="${post.post_id}">
				</div>
				<div class="freeDetail_title">
					제목: <input type="text" name="post_title" value="${post.post_title}">
				</div>
			</div>
		</div>

		<div class="freeDetail_2nd_line">
			<div class="freeDetail_element">닉네임:${post.member_nick}</div>
			<div class="bbsDetail_element">NO.:${post.post_id }&nbsp;조회수:${post.post_hit_count }&nbsp;
				추천수:${post.post_like_count}&nbsp;스크랩수:${post.post_scrap_count}</div>
		</div>
		<div class="freeDetail_detail">
			<textarea class="form-control" rows="5" id="editor" name="post_content">${post.post_content}</textarea>
			<input id="board_image_input" name="post_img" value="${bottomSplit }"
				type="hidden"> <input id="board_file_input" name="post_file"
				value="-" type="hidden">
		</div>

		<div class="freeDetail_bot">
			<button class="freebt" onclick="history.back()">이전으로</button>
			<button type="submit" id="createPostBtn" class="btn btn-primary">수정</button>
		</div>
	</form>
</body>
</html>