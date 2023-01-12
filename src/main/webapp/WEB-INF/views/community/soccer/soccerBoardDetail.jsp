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
	<br>
	<h1>상세페이지</h1>
	<table border="1">
		<tr>
			<td>제목:${soccer.cm_sc_title}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				작성날짜:<fmt:formatDate value="${soccer.cm_sc_date}"
					pattern="yy-MM-dd HH:mm" />
			</td>
		</tr>
		<tr>
			<td>닉네임:${soccer.cm_sc_nick}</td>
		</tr>
		<tr>
			<td>글내용:${soccer.cm_sc_content}</td>
		</tr>
		<tr>
		</tr>
	</table>
</body>
</html>