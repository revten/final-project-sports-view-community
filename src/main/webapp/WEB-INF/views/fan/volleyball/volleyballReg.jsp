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
	<h3>배구게시판</h3>


	<!--==================== 등록 ====================-->
	<main class="boardReg__Main">
	<form action="volleyball.reg.do" method="POST"
		enctype="multipart/form-data" onsubmit="return checkForm();"
		name="regForm">

		<input name="post_board" value="24" type="hidden">

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
	</main>


	<!--==================== JS ====================-->
	<script>
		function checkForm() {
			let titleInput = document.regForm.post_title;
			let contentInput = document.regForm.post_content;

			if (isEmpty(titleInput) || isEmpty(contentInput)) {
				alert("내용을 입력해주세요");
				return false;
			}
			return true;
		}
	</script>
</body>
</html>