<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
	<table>
		<tr>
			<td>${teamEvent.ie_te_no }</td>
			<td>${teamEvent.ie_te_team }</td>
			<td>${teamEvent.ie_te_title }</td>
			<td>${teamEvent.ie_te_nick }</td>
			<td>${teamEvent.ie_te_regdate }</td>
			<td>조회수:${teamEvent.ie_te_views }</td>
		</tr>
		<tr>
			<td>${teamEvent.ie_te_content }</td>
		</tr>
	</table>
	

</body>
</html>