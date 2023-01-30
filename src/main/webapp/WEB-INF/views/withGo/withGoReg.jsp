<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TRIPPLE: WithGo</title>
<script>
	$(function() {
		CKEDITOR.replace('editor', {
			filebrowserUploadUrl : 'fileupload.do',
		});
	});
</script>
</head>
<body>
	<div class="withGo__container">

		<div class="withGo__content">

			<!-- 2번줄 헤더 -->
			<div class="withGo__header">
				<!-- 왼쪽 검색바 -->
				<form action="withGo.search.do" name="boardSearchForm"
					onsubmit="return boardSearchCheck();">
					<input type="hidden" name="post_board" value="${param.post_board}">
					<div id="snsSearchArea">
						<input class="withGo__search-bar" name="search" type="search"
							maxlength="10" autocomplete="off" placeholder="검색">
					</div>
				</form>
				<div>
					<a href="withGo.board.go?post_board=11" class="nav__link">WITH
						GO</a>
				</div>

				<!-- 이동버튼 -->
				<div class="move__button-wrapper">
					<c:choose>
						<c:when test="${sessionScope.loginAccount ne null}">
							<button class="action-button"
								onclick="location.href='withGo.reg.go?post_board=11'">
								<span>새글쓰기</span>
								<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
									viewBox="0 0 24 24" fill="none" stroke="currentColor"
									stroke-width="2" stroke-linecap="round" stroke-linejoin="round"
									class="feather feather-filter">
								<polygon points="22 3 2 3 10 12.46 10 19 14 21 14 12.46 22 3" /></svg>
							</button>
						</c:when>
						<c:otherwise>
							<button class="action-button" onclick="alert('로그인하세요')">
								<span>새글쓰기</span>
								<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
									viewBox="0 0 24 24" fill="none" stroke="currentColor"
									stroke-width="2" stroke-linecap="round" stroke-linejoin="round"
									class="feather feather-filter">
								<polygon points="22 3 2 3 10 12.46 10 19 14 21 14 12.46 22 3" /></svg>
							</button>
						</c:otherwise>
					</c:choose>
				</div>
			</div>

			<div class="app-content-actions">
				<form action="withGo.reg.do" method="POST"
					onsubmit="return checkForm()" name="postRegForm"
					enctype="multipart/form-data">
					<input name="token" type="hidden" value="${token }"> <input
						name="plusPoint" value="30" type="hidden">
					<!-- 글쓰기 포인트 -->
					<input name="post_board" value="${param.post_board}" type="hidden">
					<div class="form-group">
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
							onclick="location.href='withGo.board.go?post_board=11'">목록으로</button>
						<button id="createPostBtn">등록</button>
					</div>
				</form>
			</div>

		</div>
	</div>

</body>
</html>