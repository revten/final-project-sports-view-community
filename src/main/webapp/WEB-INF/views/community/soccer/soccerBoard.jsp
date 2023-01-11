<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<br><br><br><br><br><br>
<h1>축구게시판</h1>${result }

<table border="1" >
		<thead>
			<tr>
				<th>탭</th>
				<th>제목</th>
				<th>내용</th>
				<th>등록일</th>
				<th>닉네임</th>
			</tr>
			<tr>
			<c:forEach var="sc" items="${soccer }">
			<td colspan="5"></td>
				<tr onclick="location.href='soccerBoardDetail.go?cm_sc_no=${sc.cm_sc_no}'">
					<td>${sc.cm_sc_cat}</td>
					<td>${sc.cm_sc_title}</td>
					<td>${sc.cm_sc_content}</td>
					<td><fmt:formatDate value="${sc.cm_sc_date}" pattern="yy-MM-dd HH:mm" /></td>
					<td>${sc.cm_sc_nick}</td>
				</tr>
			</c:forEach>
			</tr>
		</thead>
</table>



</body>
</html>