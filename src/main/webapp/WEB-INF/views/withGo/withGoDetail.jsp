<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TRIPPLE: WithGo</title>

</head>
<body>
	<div style="float: left; position: absolute; top: 800px; left: -9%;">
		<img src="resources/files/backgroundImg/with1.png">
	</div>
	<div style="float: right; position: absolute; top: -10px; left: 77%;">
		<img src="resources/files/backgroundImg/with2.png">
	</div>
	<div class="withGo__container">

		<div class="withGo__content">

			<!-- 2번줄 헤더 -->
			<div class="withGo__header">
				<!-- 왼쪽 검색바 -->
				<form action="withGo.search.do" name="boardSearchForm"
					onsubmit="return boardSearchCheck();">
					<input type="hidden" name="post_board" value="11">
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

			<div class="fanBoardDetail__main" style="margin-top: -60px">
				<section class="post section">
					<div class="post__container">
						<hr>
						<div class="post__1st-line">
							<div class="post__title">${post.post_title}</div>
							<div class="post__date">
								<c:choose>
									<c:when test="${post.post_update_date eq null }">
										<fmt:formatDate value="${post.post_reg_date}"
											pattern="yy-MM-dd HH:mm" />
									</c:when>
									<c:otherwise>
						수정 <fmt:formatDate value="${post.post_update_date}"
											pattern="yy-MM-dd HH:mm" />
									</c:otherwise>
								</c:choose>
							</div>
						</div>
						<hr>
						<div class="post__2nd-line">
							<div class="post__nick">${post.member_nick}</div>
							<div class="post__element">
								조회수 <b>${post.post_hit_count }</b> 추천수 <b>${post.post_like_count}</b>
								스크랩수 <b>${post.post_scrap_count}</b>
							</div>
						</div>
						<hr>
						<div class="post__content">${post.post_content}</div>


						<div class="post__bot">
							<button class="post__bot-btn" onclick="history.back()">이전으로</button>

							<!-- 로그인하고 자신이 쓴글이면 수정/삭제버튼 나오도록 / 도중 세션만료시 로그인 / 로그인해야 추천할수 있음 -->
							<c:choose>
								<c:when
									test="${sessionScope.loginAccount.member_id eq post.post_member}">
									<c:choose>
										<c:when test="${sessionScope.loginAccount eq null}">
											<button onclick="alert('로그인하세요')">수정</button>
											<button onclick="alert('로그인하세요')">삭제</button>
										</c:when>
										<c:otherwise>
											<button class="post__bot-btn"
												onclick="location.href='withGo.update.go?post_id=${post.post_id}&post_member=${post.post_member}'">수정</button>
											<button class="post__bot-btn"
												onclick="location.href='withGo.delete.do?post_id=${post.post_id}&post_board=${post.post_board}'">
												삭제</button>
										</c:otherwise>
									</c:choose>
								</c:when>
								<c:otherwise>
									<c:choose>
										<c:when test="${sessionScope.loginAccount eq null}">
											<button id="LikeBtn" onclick="alert('로그인하세요')">추천</button>
										</c:when>
										<c:otherwise>
											<button id="LikeBtn"
												onclick="likeCheck(${likeCheck}, ${post.post_id}, ${sessionScope.loginAccount.member_id})">추천</button>
										</c:otherwise>
									</c:choose>
								</c:otherwise>
							</c:choose>
						</div>
					</div>
				</section>


				<!--==================== 댓글 ====================-->
				<div class="reply__section">
					<!-- 댓글 리스트 -->
					<hr>
					<div style="font-size: 15px">댓글 리스트</div>
					<div class="reply__list">
						<c:forEach var="reply" items="${post.replies}">
							<div class="reply__div">
								<p>
								<hr>
								<input class="reply__id" type="hidden" name="reply_id"
									value="${reply.reply_id}">
								<div class="sortInfo">
									<div class="reply_writterNick">
										<b>${reply.member_nick }</b>
									</div>
									<div class="reply__date">
										<fmt:formatDate value="${reply.reply_reg_date }" type="both"
											dateStyle="short" timeStyle="short" />
										<c:if
											test="${reply.reply_member == sessionScope.loginAccount.member_id }">
											<button class="reply__update-btn">수정</button>
											<button class="reply__delete-btn">삭제</button>
										</c:if>
										<br>
									</div>
								</div>
								<div class="reply__content">${reply.reply_content}</div>
							</div>
						</c:forEach>
					</div>
					<hr>
					<!-- 댓글 등록 -->
					<div class="reply_reg_form">
						<!-- 로그인x면 댓글 쓸수 없다 -->
						<span>댓글 쓰기</span>
						<c:if test="${sessionScope.loginAccount != null }">
							<!-- 토큰으로 새로고침시 자동입력을 방지 -->
							<input class="reply__token" type="hidden" name="token"
								value="${token }">
							<!-- 등록후 등록한 사람의 닉네임을 보여줘야 되니까 담아서 js에 보내준다 -->
							<input type="hidden" id="reply_writterNick"
								value="${sessionScope.loginAccount.member_nick}">
							<!-- 리플을 DB에 등록할때 게시판의 id도 필요하니 담아서 js에 보내준다 -->
							<input type="hidden" id="reply_board" value="${post.post_board}">
							<!-- 리플을 DB에 등록할때 게시글의 id도 필요하니 담아서 js에 보내준다 -->
							<input type="hidden" id="reply_post" value=" ${post.post_id}">

							<!-- 댓글 입력내용 당연히 보내야겠지 -->
							<input class="reply__content-reg" name="reply__content"
								maxlength="80" autocomplete="off" required>
							<button class="reply__reg-btn">등록</button>
						</c:if>
					</div>
				</div>
			</div>

		</div>
	</div>

</body>
</html>