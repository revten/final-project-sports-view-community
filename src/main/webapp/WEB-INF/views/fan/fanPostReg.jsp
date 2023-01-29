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
	
	
<%-- 	<h1>${param.post_board }게시판"${post_board}</h1> --%>
	<h1>${param.post_board }게시판</h1>

	<!--==================== 등록 ====================-->
	<div class="fanBoardReg__Main">
	<form action="fan.reg.do" method="POST" onsubmit="return checkForm();" name="postRegForm" enctype="multipart/form-data" >
			<input name="token" type="hidden" value="${token }">
			<input name="plusPoint" value="30" type="hidden"> <!-- 글쓰기 포인트 -->
			<input name="post_board" value="${param.post_board}" type="hidden" >
		<div class="form-group">
			<input type="text" class="form-control" name="post_title" placeholder="제목을 입력해주세요">

		</div>
		
		<div class="form-group">
			<textarea class="form-control" rows="5" id="editor"
				name="post_content"></textarea>
			<input type="hidden" name="post_image" value="${bottomSplit}">
			<input type="hidden" name="post_file" value="-">
		</div>
		
		<button type="submit" id="createPostBtn" class="btn btn-primary">등록</button>
	</form>
	</div>
</body>
</html>