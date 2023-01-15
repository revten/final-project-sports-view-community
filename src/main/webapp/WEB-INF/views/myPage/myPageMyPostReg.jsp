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
<form action="mypost.insert.do" enctype="multipart/form-data" method="post">
		<div style="border:1px solid;width:70%;align:center;">
			<div>종목: 
			<select name="mypost_cat">
				<option value="축구">축구</option>
				<option value="야구">야구</option>
				<option value="농구">농구</option>
				<option value="배구">배구</option>
			</select></div>
			<div>제목 : <input name="mypost_title"></div>
		</div>
		<div>사진<input type="file" name="mypost_img"></div>
		<div>동영상<input type="file" name="mypost_video"></div>
		<div><textarea id="editor" maxlength="2084" name="mypost_content" style="resize: none"></textarea></div>
		<div>
					<button type="button" onclick="history.back()">이전으로</button>
										<button>등록</button>
				</div>
			</form>	

</body>
</html>