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
	<td><button onclick="location.href='volleyballInsert.go'">게시글작성</button></td>
				<th>탭</th>
				<th>제목</th>
				<th>내용</th>
				<th>등록일</th>
				<th>닉네임</th>
			</tr>
			<tr>
			<c:forEach var="vl" items="${volleyball }">
			<td colspan="5"></td>
				<tr onclick="location.href='volleyballBoardDetail.go?cm_vl_no=${vl.cm_vl_no}'">
					<td>${vl.cm_vl_cat}</td>
					<td>${vl.cm_vl_title}</td>
					<td>${vl.cm_vl_content}</td>
					<td><fmt:formatDate value="${vl.cm_vl_date}" pattern="yy-MM-dd HH:mm" /></td>
					<td>${vl.cm_vl_nick}</td>
				</tr>
			</c:forEach>
			</tr>
		</thead>
</table>



</body>
</html>