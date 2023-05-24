<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
	<div id="stadium__container">
		<div id="stadium__area">
			<c:forEach var='ci' items='${clubImages }'>
				<div id="stadium__img">
					<a style="cursor: pointer" onclick="location.href='stadium.detail.go?club_id=${ci.club_id}'">
						<img style="width: 100px; height: 100px; cursor: pointer" src="resources/files/club_images/${ci.club_id }/${ci.file_name}">
					</a>
				</div>
			</c:forEach>
		</div>
	</div>
</body>
</html>
