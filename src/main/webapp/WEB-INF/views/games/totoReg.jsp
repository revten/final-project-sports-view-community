<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<form action="toto.insert.do" enctype="multipart/form-data" method="post">
		<div style="border:1px solid;width:70%;align:center;">
			<div>종목: 
			<select name="toto_cat">
				<option value="축구">축구</option>
				<option value="야구">야구</option>
				<option value="농구">농구</option>
				<option value="배구">배구</option>
			</select></div>
			<div>제목 : <input name="toto_title"></div>
		</div>
		<input id="board_img_input" type="file" name="toto_img" value="${bottomSplit }" type="hidden">
		<input id="board_video_input" type="file" name="toto_video" value="-" type="hidden">
		<div style="width: 80%"><textarea id="editor" maxlength="2084" name="toto_content" style="resize: none"></textarea></div>
		<div>
					<button type="button" onclick="history.back()">이전으로</button>
										<button>등록</button>
				</div>
			</form>	

</body>
</html>