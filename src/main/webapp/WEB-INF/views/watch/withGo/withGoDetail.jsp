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
<body
	onload="likeCheck(${p.wg_no},'${sessionScope.loginAccount.ac_id}')">
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<input id="ac_id" type="hidden"
		value="${sessionScope.loginAccount.ac_id}">
	<input id="wg_no" type="hidden" value="${p.wg_no}">
	<div class="container" style="margin-top: 50px">
		<div class="row">
			<div class="col">
				<span style="font-size: 30px;">${p.wg_title}</span>
				<p class="text-right">
					<fmt:formatDate value="${p.wg_date}" pattern="yyyy-MM-dd HH:mm" />
					&nbsp;&nbsp; 조회수:${p.wg_count}
				</p>
				<hr>
			</div>

			<div class="col">
				${p.wg_content} <br>
				<button
					onclick="getWithGoLike(${p.wg_no},'${sessionScope.loginAccount.ac_id }')"
					id="like_btn" type="button"
					class="btn btn-default btn-sm center-block">${p.wg_like}
					좋아요</button>
				<hr>

				<div id="withGoDeleteUpdateBtn">
					<button class="btn btn-warning modBtn"
						onclick="location.href='withGoUpdate.go?wg_no=${p.wg_no}&wg_cat=${p.wg_cat}'">
						<i class="fa fa-edit"></i>수정
					</button>

					<button class="btn btn-danger delBtn"
						onclick="location.href='withGoDelete.do?wg_no=${p.wg_no}&wg_cat=${p.wg_cat}'">
						<i class="fa fa-trash"></i>삭제
					</button>
				</div>
			</div>
		</div>
	</div>
</body>
</html>