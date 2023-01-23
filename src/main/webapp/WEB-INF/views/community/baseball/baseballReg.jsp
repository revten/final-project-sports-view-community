<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	<h3>야구게시판</h3>
	<form action="baseball.reg.do" method="POST"
		enctype="multipart/form-data">

		<input name="post_board" value="21" type="hidden">

		<div class="form-group">
			<label for="title">제목</label> <input type="text" class="form-control"
				id="title" name="post_title">
		</div>
		<div class="form-group">
			<label for="content"></label>
			<textarea class="form-control" rows="5" id="editor"
				name="post_content"></textarea>
			<input type="hidden" name="post_image" value="${bottomSplit }">
			<input type="hidden" name="post_file" value="-">
		</div>
		<button type="submit" id="createPostBtn" class="btn btn-primary">
			등록</button>
	</form>
</body>
</html>