<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
	<br>
	<br>
	<br>
	<br>
	<br>
	<nav>
		<div id="community_area">
			<ul id="community_list">
				<li><a style="cursor: pointer"
					href="fan.board.go?post_board=21">야구 게시판</a></li>
				<li><a style="cursor: pointer"
					href="fan.board.go?post_board=22">축구 게시판</a></li>
				<li><a style="cursor: pointer"
					href="fan.board.go?post_board=23">농구 게시판</a></li>
				<li><a style="cursor: pointer"
					href="fan.board.go?post_board=24">배구 게시판</a></li>
				<li><a style="cursor: pointer"
					href="fan.board.go?post_board=41">분석 게시판</a></li>
			</ul>
		</div>
	</nav>

	<h1>${post.post_board }게시판</h1>


	<!--==================== 상세 ====================-->
	<main class="boardDetail__main"> <br>
	<section class="post section">
		<div class="post__container">
			<div class="post__1st-line">
				<div class="post__title">탭:${post.post_category}&nbsp;제목:${post.post_title}</div>
				<!-- 글등록후엔 등록날짜가, 수정후엔 수정날짜가 나오도록-->
				<div class="post__date">
					<c:choose>
						<c:when test="${post.post_update_date eq null }">
						작성날짜:<fmt:formatDate value="${post.post_reg_date}"
								pattern="yy-MM-dd HH:mm" />
						</c:when>
						<c:otherwise>
						수정날짜:<fmt:formatDate value="${post.post_update_date}"
								pattern="yy-MM-dd HH:mm" />
						</c:otherwise>
					</c:choose>
				</div>
			</div>

			<div class="post__2nd-line">
				<div class="post__element">닉네임:${post.member_nick}</div>
				<div class="post__element">NO.:${post.post_id }&nbsp;조회수:${post.post_hit_count }&nbsp;
					추천수:${post.post_like_count}&nbsp;스크랩수:${post.post_scrap_count}</div>
			</div>

			<div class="post__content">${post.post_content}</div>
		</div>


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
							<button class="post__bot-btn" onclick="location.href='fan.update.go?post_id=${post.post_id}&post_member=${post.post_member}'">수정</button>
							<button class="post__bot-btn"
								onclick="deletePost(${post.post_id}, ${post.post_board});">삭제</button>
						</c:otherwise>
					</c:choose>
				</c:when>
				<c:otherwise>
					<c:choose>
						<c:when test="${sessionScope.loginAccount eq null}">
							<button id="LikeBtn" onclick="alert('로그인하세요')">추천</button>
						</c:when>
						<c:otherwise>
							<button id="LikeBtn" onclick="likeCheck(${likeCheck}, ${post.post_id}, ${sessionScope.loginAccount.member_id})">추천</button>
						</c:otherwise>
					</c:choose>
				</c:otherwise>
			</c:choose>
		</div>
	</section>


	<!--==================== 댓글 ====================-->
	<section class="reply section">
		<table class="reply__table">
			<tr>
				<td>
					<c:forEach var="rp" items="${post.replies }">
						<span>${post.member_nick }</span>-&nbsp;${rp.reply_content }&nbsp;
	
							<c:if test="${rp.reply_update_date eq null }">
							<span>(<fmt:formatDate value="${rp.reply_reg_date }"
									type="both" dateStyle="short" timeStyle="short" />)
							</span>
						</c:if>

						<c:if test="${rp.reply_member == sessionScope.loginAccount.member_id }">
							<button onclick="updateReply(${rp.reply_id},${post.post_id},'${post.post_member}');">수정-ajax처리하기</button>
							<button onclick="deleteReply(${rp.reply_id},${post.post_id},'${post.post_member}');">삭제-ajax처리하기</button>
						</c:if>
						<br>
					</c:forEach>
					
					<c:if test="${sessionScope.loginAccount != null }">
						<form action="fanReply.reg.do" onsubmit="return checkReplyReg(this);">
							<span> ${sessionScope.loginAccount.member_nick } </span>
							<input type="hidden" name="token" value="${token }">
							<input type="hidden" name="reply_post" value="${post.post_id}">
							<input type="hidden" name="reply_board" value="${post.post_board}">
							<input type="hidden" name="post_member" value="${post.post_member}">
							<input type="hidden" name="post_id" value="${post.post_id}">
							<input type="hidden" name="pg" value="${curPage }">
							
							<input name="reply_content" maxlength="80" autocomplete="off" required>
							<button>쓰기-ajax처리</button>
						</form>
					</c:if>
				</td>
			</tr>
		</table>
	</section>
	</main>
</body>
</html>