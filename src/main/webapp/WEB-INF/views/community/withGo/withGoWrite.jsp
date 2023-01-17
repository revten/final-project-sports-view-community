<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%-- <script>
	$(function() {
		ClassicEditor.create(document.querySelector('#editor'), {
			language : "ko"
		});
	});
</script>--%>
<script>
$(function () {
	CKEDITOR.replace('editor', {
		filebrowserUploadUrl : 'fileupload.do',
	});
}); // ck에디터 적용: 하기 내용 그대로 복붙하고 연결점(form action만 textarea의 name을 DB테이블의 컬럼에 맞춰서 수정해주면 됨
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
	<form action="withGo.upload.do" method="POST">
		<div class="form-group">
			<label for="title">제목</label>
			<input type="text" class="form-control"
				id="title" name="wg_title">
		</div>
		<div class="form-group">
			<label for="content"></label>
			<textarea class="form-control" rows="5" id="editor" name="wg_content"></textarea>
			<input type="hidden" name="wg_img" value="${bottomSplit }">
			<input type="hidden" name="wg_video" value="-">
		</div>
		<button type="submit" id="createPostBtn" class="btn btn-primary" name="wg_cat" value="withGo"> 등록</button>
	</form>
</body>
</html>