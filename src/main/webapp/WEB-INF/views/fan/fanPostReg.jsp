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
		<!--==================== 게시판 ====================-->
		<div class="app-container">
			<!-- 맨위의 게시판 제목 -->
			<div class="app-content">
				<!-- 1번줄 헤더 -->
				<div class="app-content-header">
					<!-- 왼쪽게시판 제목 -->
					<h1 class="app-content-headerText">${board_name }게시판</h1>
				</div>
				<!-- 2번줄 헤더 -->
				<div class="app-content-actions">
					<form action="fan.reg.do" method="POST"
						onsubmit="return checkForm()" name="postRegForm"
						enctype="multipart/form-data">
						<input name="token" type="hidden" value="${token }"> <input
							name="plusPoint" value="30" type="hidden">
						<!-- 글쓰기 포인트 -->
						<input name="post_board" value="${param.post_board}" type="hidden">
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
								id="post_title" placeholder="제목">
						</div>
						</div>
						<div class="form-group">
							<textarea class="form-control" rows="5" id="editor"
								name="post_content" id="post_content"></textarea>
							<input type="hidden" name="post_image" value="${bottomSplit}">
							<input type="hidden" name="post_file" value="-">
						</div>
						
						<div id="buttonArea">
						<button id="goBoardBtn" type="button"
							onclick="location.href='fan.board.go?post_board=21'">목록으로</button>
						<button id="createPostBtn">등록</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>