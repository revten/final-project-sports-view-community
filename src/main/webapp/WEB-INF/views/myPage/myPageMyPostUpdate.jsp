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
<br><br><br><br><br>

<div style="border:1px solid;width:70%;align:center;">
			<div>${MyPost.mypost_no }</div>
			<div>종목 : <input name="mypost_cat" value="${MyPost.mypost_cat }"></div>
			<div>제목 : <input name="mypost_title" value="${MyPost.mypost_title }"></div>
			<div>닉네임: ${MyPost.mypost_nick }</div>
			<div><fmt:formatDate value="${MyPost.mypost_date }" pattern="yyyy-MM-dd HH:mm" /></div>
			<div>조회수:${MyPost.mypost_count }</div>
		</div>
		<div>사진:<input type="file" name="mypost_img"></div>
		<div>동영상:<input type="file" name="mypost_video"></div>
		<div><textarea id="editor" maxlength="2084" name="mypost_content" style="resize: none">${MyPost.mypost_content }</textarea></div>
		<div>
					<button onclick="history.back()">이전으로</button>
										<button onclick="location.href='mypost.update.do?mypost_no=${MyPost.mypost_no}'">수정</button>
										<button onclick="location.href='mypost.delete.do?mypost_no=${MyPost.mypost_no}'">삭제</button>
				</div>

</body>
</html>