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

		<!--==================== 상세 ====================-->
		<div class="app-container">
			<!-- 맨위의 게시판 제목 -->
			<div class="app-content">
				<div class="fanBoardDetail__main">
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
											<fmt:formatDate value="${post.post_update_date}"
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
													onclick="location.href='fan.update.go?post_id=${post.post_id}&post_member=${post.post_member}&post_board=${post.post_board }'">수정</button>
												<button class="post__bot-btn"
													onclick="deletePost(${post.post_id}, ${post.post_board});">삭제</button>
											</c:otherwise>
										</c:choose>
									</c:when>
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
	</div>


	<script> 
const srFanD = ScrollReveal({
	  origin: 'right',
	  distance: '290px',
	  duration: 2400,
	  delay: 200
	  //reset: true, // Animations repeat
	})
	srFanD.reveal(`.container-field`);
	srFanD.reveal(`.board-main`, { origin: 'right' });
	srFanD.reveal(`.app-content`, { origin: 'right' });
	srFanD.reveal(`.app-container`, { origin: 'right' });
	srFanD.reveal(`.`, { interval: 100});
	</script>

</body>
</html>