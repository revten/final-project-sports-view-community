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
	<td><button onclick="location.href='basketballInsert.go'">게시글작성</button></td>
				<th>탭</th>
				<th>제목</th>
				<th>내용</th>
				<th>등록일</th>
				<th>닉네임</th>
			</tr>
			<tr>
			<c:forEach var="bk" items="${basketball }">
			<td colspan="5"></td>
				<tr onclick="location.href='basketballBoardDetail.go?cm_bk_no=${bk.cm_bk_no}'">
					<td>${bk.cm_bk_cat}</td>
					<td>${bk.cm_bk_title}</td>
					<td>${bk.cm_bk_content}</td>
					<td><fmt:formatDate value="${bk.cm_bk_date}" pattern="yy-MM-dd HH:mm" /></td>
					<td>${bk.cm_bk_nick}</td>
				</tr>
			</c:forEach>
			</tr>
		</thead>
</table>



</body>
</html>