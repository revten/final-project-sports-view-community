<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	$(function() {
		CKEDITOR
				.replace(
						'editor',
						{
							filebrowserUploadUrl : '${pageContext.request.contextPath}/adm/fileupload.do'
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
			<label for="title">제목</label> <input type="text" class="form-control"
				id="title" name="rv_title"> <input name="rv_cat"
				value="${param.rv_cat}" type="hidden"> <input name="rv_id"
				value="${sessionScope.loginAccount.ac_id}" type="hidden"> <input
				name="rv_nick" value="${sessionScope.loginAccount.ac_nick}"
				type="hidden"> <input id="board_img_input" name="rv_img"
				value="-" type="hidden"> <input
				id="board_video_input" name="rv_video"
				value="-" type="hidden">
		</div>

		<div class="form-group">
			<label for="content"></label>
			<textarea class="form-control" rows="5" id="editor" name="rv_content"></textarea>
		</div>

		<button type="submit" id="createPostBtn" class="btn btn-primary">등록</button>
	</form>
</body>
</html>