<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
$(function () {
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
	<h3>직관 후기 작성</h3>
		<form action="reviewWrite.do" method="POST">
		<div class="form-group">
			<label for="title">제목</label>
			<input type="text" class="form-control"
				id="title" name="rv_title">
		</div>
		<div class="form-group">
			<label for="content"></label>
			<textarea class="form-control" rows="5" id="editor" name="rv_content"></textarea>
			<input type="hidden" name="rv_img" value="${bottomSplit }">
			<input type="hidden" name="rv_video" value="-">
		</div>
		<button type="submit" id="createPostBtn" class="btn btn-primary" name="rv_cat" value="review"> 등록</button>
	</form>
</body>
</html>