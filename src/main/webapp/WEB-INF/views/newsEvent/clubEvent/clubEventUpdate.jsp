<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
.thead{
 	display: inline-block;
    width: 120px;
    text-align: center;
}
.theadTitle{
	display: inline-block;
    width: 200px;
    text-align: center;
}
.theadDate{
	display: inline-block;
    width: 200px;
    text-align: center;
}
.tableContent{
	width:70%;
	align:center;
	text-align: left;
	border:1px solid
}
.tableUD{
	width:70%;
	align:center;
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
			
			
	<!--==================== 상세-수정 ====================-->
	<main class="boardUpdate__main"> <br>
	<section class="post section">
		<form action="clubEvent.update.do" method="POST"
			enctype="multipart/form-data" onsubmit="return checkForm();"
			name="regForm">
			<div class="post__container">
				<div class="post__1st-line">
					<div class="post__option">
						탭: <input name="post_category" value="${post.post_category}">
						게시글번호: <input name="post_id" value="${post.post_id}">
					</div>

					<div class="post__title">
						제목: <input type="text" name="post_title"
							value="${post.post_title}">
					</div>
				</div>


				<div class="post__2nd-line">
					<div class="post__element">닉네임:${post.member_nick}</div>
					<div class="post__element">NO.:${post.post_id }&nbsp;조회수:${post.post_hit_count }&nbsp;
						추천수:${post.post_like_count}&nbsp;스크랩수:${post.post_scrap_count}</div>
				</div>

				<div class="post__content">
					<textarea rows="5" id="editor" name="post_content">${post.post_content}</textarea>
					<input id="board_image_input" name="post_img"
						value="${bottomSplit }" type="hidden"> <input
						id="board_file_input" name="post_file" value="-" type="hidden">
				</div>

				<div class="post__bot">
					<button class="post__bot-btn" onclick="history.back()">이전으로</button>
					<button type="submit" id="createPostBtn" class="btn btn-primary">수정</button>
				</div>
			</div>
		</form>
	</section>
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