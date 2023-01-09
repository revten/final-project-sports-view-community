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
	<h3>글 등록하기</h3>
	<form action="">
		<select>
			<option>직관 후기 게시판</option>
			<option value="withGo">같이 직관/경기 게시판</option>
			<option>야구 게시판</option>
			<option>축구 게시판</option>
			<option>농구 게시판</option>
			<option>배구 게시판</option>
			<option>기타 게시판</option>
		</select>
		<textarea name="text" id="editor"></textarea>
		<p>
			<input type="submit" value="전송">
		</p>
	</form>
</body>
</html>