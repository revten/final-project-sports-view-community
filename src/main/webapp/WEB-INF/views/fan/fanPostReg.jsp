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
<link rel="stylesheet" href="resources/css/fan/fan.css" />
<script src="resources/js/fan/fanPost.js"></script>
</head>
<body>
	<br>
	<br>
	<br>
	<br>
	<br>


	<%-- 	<h1>${param.post_board }게시판"${post_board}</h1> --%>
	<div class="board_container">
	<div class="board__name">
	<h1>${board_name } 게시판</h1>
	</div>
	<!--==================== 등록 ====================-->
	<div class="fanBoardReg__Main">
		<form action="fan.reg.do" method="POST" onsubmit="return checkForm()"
			name="postRegForm" enctype="multipart/form-data">
			<input name="token" type="hidden" value="${token }"> <input
				name="plusPoint" value="30" type="hidden">
			<!-- 글쓰기 포인트 -->
			<input name="post_board" value="${param.post_board}" type="hidden">
			<div class="form-group">
				<input type="text" class="form-control" name="post_title" id="post_title"
					placeholder="제목을 입력해주세요">
			</div>
			<!-- 카테고리 설정 -->
			<div>
				<select name="post_category" id="post_category">
					<option value="4">카테고리를 선택해주세요</option>
					<option value="0">잡담</option>
					<option value="1">질문</option>
					<option value="2">정보</option>
					<option value="3">분석</option>
				</select>
			</div>
			<div class="form-group">
				<textarea class="form-control" rows="5" id="editor"
					name="post_content" id="post_content"></textarea>
				<input type="hidden" name="post_image" value="${bottomSplit}">
				<input type="hidden" name="post_file" value="-">
			</div>
			
			<button id="goBoardBtn" type="button" onclick="location.href='fan.board.go?post_board=21'">목록으로</button>
			<button id="createPostBtn">등록</button>
		</form>
	</div>
	</div>
</body>
</html>