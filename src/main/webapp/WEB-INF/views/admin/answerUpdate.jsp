<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
$(function() {
	CKEDITOR
			.replace(
					'editor',
					{
						filebrowserUploadUrl : '${pageContext.request.contextPath}/adm/fileupload.do'
					});
});
</script>
</head>
<body>
<br><br><br><br><br>

<div style="border:1px solid;width:70%;align:center;">
			<div>${answer.answer_no }</div>
			<div>종목 : <input name="answer_cat" value="${answer.answer_cat }"></div>
			<div>제목 : <input name="answer_title" value="${answer.answer_title }"></div>
			<div>닉네임: ${answer.answer_nick }</div>
			<div><fmt:formatDate value="${answer.answer_date }" pattern="yyyy-MM-dd HH:mm" /></div>
			<div>조회수:${answer.answer_count }</div>
		</div>
		<div>사진:<input type="file" name="answer_img"></div>
		<div>동영상:<input type="file" name="answer_video"></div>
		<div><textarea id="editor" maxlength="2084" name="answer_content" style="resize: none">${answer.answer_content }</textarea></div>
		<div>
					<button onclick="history.back()">이전으로</button>
										<button onclick="location.href='answer.update.do?answer_no=${answer.answer_no}'">수정</button>
										<button onclick="location.href='answer.delete.do?answer_no=${answer.answer_no}'">삭제</button>
				</div>

</body>
</html>