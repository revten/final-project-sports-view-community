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
	<div class="container">
		<form action="reviewUpdate.do" method="POST">

			<div class="form-group">
				<label for="title">제목</label> <input type="text"
					class="form-control" id="title" name="rv_title"
					value="${p.rv_title}"> <input name="rv_cat"
					value="${param.rv_cat}" type="hidden"> <input name="rv_no"
					value="${param.rv_no}" type="hidden"> <input
					id="board_img_input" name="rv_img" value="-" type="hidden">
				<input id="board_video_input" name="rv_video" value="-"
					type="hidden">
				<!--  <input id="board_img_input" name="rv_img" value="${p.rv_img}" type="hidden"> -->
			</div>

			<div class="form-group">
				<label for="content"></label>
				<textarea class="form-control" rows="5" id="editor"
					name="rv_content">${p.rv_content}</textarea>
			</div>
			<button onclick="history.back(-1)">뒤로가기</button>
			<button type="submit" class="btn btn-primary">수정</button>
		</form>
	</div>
</body>
</html>