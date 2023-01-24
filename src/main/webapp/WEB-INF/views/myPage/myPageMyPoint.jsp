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
<br><br><br><br><br>
<div>현재 포인트 : ${point.point }</div>
<div>등급 : ${point.point_grade }</div>

<div>적립내역</div>
<table border="1">
		<thead>
			<tr>
				<th>포인트</th>
				<th>시간</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="ppt" items="${plusPoint }">
				<tr>
					<td>${ppt.plusPoint }</td>
					<td><fmt:formatDate value="${ppt.plusPoint_date }" pattern="yyyy-MM-dd HH:mm" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>