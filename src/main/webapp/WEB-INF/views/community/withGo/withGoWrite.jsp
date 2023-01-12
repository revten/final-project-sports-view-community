<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	$(function() {
		ClassicEditor.create(document.querySelector('#editor'), {
			language : "ko"
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
	<h3>같이 보러 가기</h3>
	<form action="withGoWrite.do" method="POST">
		<div class="form-group">
			<label for="title">제목</label> <input type="text" class="form-control"
				id="title" name="wg_title"> <input name="wg_cat"
				value="${param.wg_cat}" type="hidden"> <input name="wg_id"
				value="${sessionScope.loginAccount.ac_id}" type="hidden"> <input
				name="wg_nick" value="${sessionScope.loginAccount.ac_nick}"
				type="hidden"> <input id="board_img_input" name="wg_img"
				value="-" type="hidden"> <input id="board_video_input"
				name="wg_video" value="-" type="hidden">
		</div>

		<div class="form-group">
			<label for="content"></label>
			<textarea class="form-control" rows="5" id="editor" name="wg_content"></textarea>
		</div>

		<button type="submit" id="createPostBtn" class="btn btn-primary">등록</button>
	</form>
</body>
</html>