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
		<form action="withGoUpdate.do" method="POST">

			<div class="form-group">
				<label for="title">제목</label> <input type="text"
					class="form-control" id="title" name="wg_title"
					value="${p.wg_title}"> <input name="wg_cat"
					value="${param.wg_cat}" type="hidden"> <input name="wg_no"
					value="${param.wg_no}" type="hidden"> <input
					id="board_img_input" name="wg_img" value="-" type="hidden">
				<input id="board_video_input" name="wg_video" value="-"
					type="hidden">
				<!--  <input id="board_img_input" name="wg_img" value="${p.wg_img}" type="hidden"> -->
			</div>

			<div class="form-group">
				<label for="content"></label>
				<textarea class="form-control" rows="5" id="editor"
					name="wg_content">${p.wg_content}</textarea>
			</div>
			<button onclick="history.back(-1)">뒤로가기</button>
			<button type="submit" class="btn btn-primary">수정 완료</button>
		</form>
	</div>
</body>
</html>