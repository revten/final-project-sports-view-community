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
			<div>${toto.toto_no }</div>
			<div>종목 : <input name="toto_cat" value="${toto.toto_cat }"></div>
			<div>제목 : <input name="toto_title" value="${toto.toto_title }"></div>
			<div>닉네임: ${toto.toto_nick }</div>
			<div><fmt:formatDate value="${toto.toto_date }" pattern="yyyy-MM-dd HH:mm" /></div>
			<div>조회수:${toto.toto_count }</div>
		</div>
		<div>사진:<input id="board_img_input" type="file" name="toto_img"></div>
		<div>동영상:<input type="file" name="toto_video"></div>
		<div><textarea id="editor" maxlength="2084" name="toto_content" style="resize: none">${toto.toto_content }</textarea></div>
		<div>
					<button onclick="history.back()">이전으로</button>
										<button onclick="location.href='toto.update.do?toto_no=${toto.toto_no}'">수정</button>
										<button onclick="location.href='toto.delete.do?toto_no=${toto.toto_no}'">삭제</button>
				</div>

</body>
</html>