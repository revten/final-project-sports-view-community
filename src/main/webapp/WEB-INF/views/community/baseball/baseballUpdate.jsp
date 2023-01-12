<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<br><br><br><br><br><br>
<h1>수정 페이지</h1>
	<form action="baseballUpdate.do">
	
		<table border="1">
			<tr>
				<td>
					제목: <input name="cm_bs_title" value="${baseball.cm_bs_title}">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				 	작성날짜:<fmt:formatDate value="${baseball.cm_bs_date}" pattern="yy-MM-dd HH:mm" />
				 </td>
			</tr>
			<tr>
				<td>
					닉네임:${baseball.cm_bs_nick}
				</td>
			</tr>
			<tr>
				<td>
					글내용:<textarea name="cm_bs_content" rows="20" cols="20">${baseball.cm_bs_content}</textarea>
				</td>
			</tr>
			<tr>
				<td>
					<button name="cm_bs_no" value="${baseball.cm_bs_no}">수정완료</button>
				</td>
			</tr>
		</table>

	</form>
</body>
</html>