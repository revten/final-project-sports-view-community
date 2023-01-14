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
<br><br><br><br><br><br>
<h1>상세페이지</h1>
	<table border="1">
			<tr>
				<td>제목:${baseball.cm_bs_title}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					작성날짜:<fmt:formatDate value="${baseball.cm_bs_date}" pattern="yy-MM-dd HH:mm" />
				</td>
			</tr>
			<tr>
				<td>닉네임:${baseball.cm_bs_nick}</td>
			</tr>
			<tr>
				<td>글내용:${baseball.cm_bs_content}</td>
			</tr>
			<tr>
				<td>
					<button onclick="location.href='baseballUpdate.go?cm_bs_no=${baseball.cm_bs_no}'">수정</button>
					<button onclick="location.href='baseballDelete.do?cm_bs_no=${baseball.cm_bs_no}'">삭제</button>
				</td>
			</tr>
	</table>



</body>
</html>