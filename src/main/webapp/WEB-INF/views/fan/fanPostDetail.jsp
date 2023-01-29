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

	<h1>${post.post_board }게시판</h1>


	<!--==================== 상세 ====================-->
	<div class="fanBoardDetail__main">
		<br>
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
								<button class="post__bot-btn"
									onclick="location.href='fan.update.go?post_id=${post.post_id}&post_member=${post.post_member}'">수정</button>
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
								<button id="LikeBtn"
									onclick="likeCheck(${likeCheck}, ${post.post_id}, ${sessionScope.loginAccount.member_id})">추천</button>
							</c:otherwise>
						</c:choose>
					</c:otherwise>
				</c:choose>
			</div>
		</section>


		<!--==================== 댓글 ====================-->
		<section class="reply section">
		
			<!-- 댓글 등록 -->
			<div class="reply_reg_form">
				<!-- 로그인x면 댓글 쓸수 없다 -->
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

					<button class="reply__reg-btn">쓰기</button>
				</c:if>
			</div>

			<!-- 댓글 리스트 -->
			<div class="reply__list">
				<c:forEach var="reply" items="${post.replies}">
					<div class="reply__div">
						<input class="reply__id" type="hidden" name="reply_id" value="${reply.reply_id}">
							
						<span class="reply_writterNick">${reply.member_nick }</span>
							
						<span class="reply__date">
							<fmt:formatDate value="${reply.reply_reg_date }" type="both" dateStyle="short" timeStyle="short" />
						</span>
						
						<span class="reply__content">${reply.reply_content}</span>
								
						<span class="reply__btn">
							<c:if test="${reply.reply_member == sessionScope.loginAccount.member_id }">
								<button class="reply__update-btn">수정</button>
								<button class="reply__delete-btn">삭제</button>
							</c:if><br>
						</span>
					</div>
				</c:forEach>
			</div>
			
		</section>
	</div>
</body>
</html>