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
			<div>${Ask.ask_no }</div>
			<div>종목 : <input name="ask_cat" value="${Ask.ask_cat }"></div>
			<div>제목 : <input name="ask_title" value="${Ask.ask_title }"></div>
			<div>닉네임: ${Ask.ask_nick }</div>
			<div><fmt:formatDate value="${Ask.ask_date }" pattern="yyyy-MM-dd HH:mm" /></div>
			<div>조회수:${Ask.ask_count }</div>
		</div>
		<div>사진:<input type="file" name="ask_img"></div>
		<div>동영상:<input type="file" name="ask_video"></div>
		<div><textarea id="editor" maxlength="2084" name="ask_content" style="resize: none">${Ask.ask_content }</textarea></div>
		<div>
					<button onclick="history.back()">이전으로</button>
										<button onclick="location.href='ask.update.do?ask_no=${Ask.ask_no}'">수정</button>
										<button onclick="location.href='ask.delete.do?ask_no=${Ask.ask_no}'">삭제</button>
				</div>

</body>
</html>