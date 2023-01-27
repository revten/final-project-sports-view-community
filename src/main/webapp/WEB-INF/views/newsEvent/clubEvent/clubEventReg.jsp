<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
.thead {
	display: inline-block;
	width: 250px;
	text-align: left;
}

.theadTitle {
	display: inline-block;
	width: 400px;
	text-align: center;
}

.theadDate {
	display: inline-block;
	width: 200px;
	text-align: center;
}

.tableContent {
	width: 70%;
	align: center;
	text-align: left;
	border: 1px solid
}

.tableUD {
	width: 70%;
	align: center;
	text-align: right;
}
</style>
<script>
	$(function() {
		CKEDITOR.replace('editor', {
			filebrowserUploadUrl : 'fileupload.do',
		});
	});
</script>
<title>Insert title here</title>
</head>
<body>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>


	<!--==================== Nav바 ====================-->
	<div class="nav__menu" id="nav-menu" style="width: 55%; align: center;">
		<ul class="nav__list">
			<li class="nav__item"><a href="newsEvent.main.go" class="nav__link">뉴스</a></li>
			<li class="nav__item"><a href="clubEvent.board.go"
				class="nav__link">구단공식이벤트</a></li>
			
		</ul>

		<!-- close button -->
		<div class="nav__close" id="nav-close">
			<i class="ri-close-line"></i>
		</div>
	</div>
	<br><br>


	<!--==================== 글등록칸 ====================-->
	<main class="boardReg__Main">
	<form action="clubEvent.reg.do" method="POST"
		enctype="multipart/form-data" onsubmit="return checkForm();"
		name="regForm">

		<input name="post_board" value="31" type="hidden">

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