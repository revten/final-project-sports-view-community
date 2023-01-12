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
<h1>야구게시판</h1>${result}

<table border="1">
	<button onclick="location.href='baseballInsert.go'">게시글작성</button>
	<thead>
		<tr>
			<th>탭</th>
			<th>제목</th>
			<th>내용</th>
			<th>등록일</th>
			<th>닉네임</th>
		</tr>
		<tr>
			<c:forEach var="bs" items="${baseball }">
				<td colspan="5"></td>
					<tr onclick="location.href='baseballBoardDetail.go?cm_bs_no=${bs.cm_bs_no}'">
						<td>${bs.cm_bs_cat}</td>
						<td>${bs.cm_bs_title}</td>
						<td>${bs.cm_bs_content}</td>
						<td><fmt:formatDate value="${bs.cm_bs_date}" pattern="yy-MM-dd HH:mm" /></td>
						<td>${bs.cm_bs_nick}</td>
					</tr>
			</c:forEach>
		</tr>
	</thead>
</table>




</body>
</html>