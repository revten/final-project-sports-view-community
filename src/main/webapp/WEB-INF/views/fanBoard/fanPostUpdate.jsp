<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
	<div class="container-field">
		<div class="board-main">
			<!--==================== fan__best 부분 - 종목별 베스트 (각 게시판별로 CRUD별로 존재해야)  ====================-->
			<div class="card-list">
				<!-- 맨위에 fan__best 부분 - 상위글 보여주는 부분 -->
				<div class="card blue" style="cursor: pointer"
					onclick="location.href='fan.board.go?post_board=21'">
					<div class="title">
						<span>야구 게시판</span>
					</div>
					<i class="zmdi zmdi-upload"></i>
					<div class="value">KBO</div>
					<div class="stat">It ain't over till it's over.</div>
				</div>
				<div class="card green" style="cursor: pointer"
					onclick="location.href='fan.board.go?post_board=22'">
					<div class="title">
						<span>축구 게시판</span>
					</div>
					<i class="zmdi zmdi-upload"></i>
					<div class="value">KFA</div>
					<div class="stat">No sweat, no sweet!</div>
				</div>
				<div class="card orange" style="cursor: pointer"
					onclick="location.href='fan.board.go?post_board=23'">
					<div class="title">
						<span>농구 게시판</span>
					</div>
					<i class="zmdi zmdi-download"></i>
					<div class="value">KBL</div>
					<div class="stat">make each day</div>
				</div>
				<div class="card red" style="cursor: pointer"
					onclick="location.href='fan.board.go?post_board=24'">
					<div class="title">
						<span>배구 게시판</span>
					</div>
					<i class="zmdi zmdi-download"></i>
					<div class="value">KOVO</div>
					<div class="stat">Nothing Better</div>
				</div>
			</div>
		</div>
		
		<!--==================== 상세-수정 ====================-->
		<div class="app-container">
			<!-- 맨위의 게시판 제목 -->
			<div class="app-content">
				<div class="fanBoardUpdate__main">
					<br>
					<div class="app-content-actions">
						<form action="fan.update.do" method="POST"
							onsubmit="return checkForm2()" enctype="multipart/form-data"
							name="postRegForm">
							<input type="hidden" name="post_category"
								value="${post.post_category}"> <input type="hidden"
								name="post_id" value="${post.post_id}">
							<div class="form-group">
								<select name="post_category" id="post_category">
									<option value="4">카테고리</option>
									<option value="0">잡담</option>
									<option value="1">질문</option>
									<option value="2">정보</option>
									<option value="3">분석</option>
								</select>
								<!-- 카테고리 설정 -->
								<div>
									<input type="text" class="form-control" name="post_title"
										id="post_title" value="${post.post_title}">
								</div>
							</div>
							<input type="hidden" value="${post.member_nick}"> <input
								type="hidden" value="${post.post_id }"> <input
								type="hidden" value="${post.post_hit_count }"> <input
								type="hidden" value="${post.post_like_count}"> <input
								type="hidden" value="${post.post_scrap_count}">

							<textarea rows="5" id="editor" name="post_content">${post.post_content}</textarea>
							<input id="board_image_input" name="post_img"
								value="${bottomSplit }" type="hidden"> <input
								id="board_file_input" name="post_file" value="-" type="hidden">
							<div id="buttonArea">
								<button id="goBoardBtn" onclick="history.back()">이전으로</button>
								<button type="submit" id="createPostBtn" class="btn btn-primary"
									name="post_member" value="${post.post_member }">수정</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
				<script> 
const srFanU = ScrollReveal({
	  origin: 'right',
	  distance: '290px',
	  duration: 2400,
	  delay: 200
	  //reset: true, // Animations repeat
	})
	srFanU.reveal(`.container-field`);
	srFanU.reveal(`.board-main`, { origin: 'right' });
	srFanU.reveal(`.app-content`, { origin: 'right' });
	srFanU.reveal(`.app-container`, { origin: 'right' });
	srFanU.reveal(`.`, { interval: 100 });
	</script>
</body>
</html>