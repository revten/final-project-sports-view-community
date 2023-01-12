<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<h1>등록페이지</h1>

	<div>
		<h3>축구게시판</h3>
		<form action="soccerInsert.do" method="post"
			enctype="multipart/form-data">
			<table border="1">
				<tr>
				<tr>
					<td>탭선택하기 :<select name="cm_sc_cat">
							<option value="cat">잡담</option>
							<option value="q">질문</option>
							<option value="img">사진/영상</option>
							<option value="story">소식정보</option>
					</select> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 제목입력: <input
						name="cm_sc_title">
					</td>
				</tr>
				<tr>
					<td><input type="hidden" name="cm_sc_id"
						value="${sessionScope.loginAccount.ac_id}"> <input
						type="hidden" name="cm_sc_nick"
						value="${sessionScope.loginAccount.ac_nick}"></td>
				</tr>
				<tr>
					<td>글내용:<textarea name="cm_sc_content" rows="20" cols="20"></textarea>
					</td>
				</tr>
				<tr>
					<td>사진<input name="cm_sc_img" type="file"> 동영상<input
						name="cm_sc_video" type="file">
						<button type="button" onclick="location.href='soccerBoard.go'">목록으로</button>
					</td>
				</tr>
				<tr>
					<td>
						<button>등록</button>
					</td>
				</tr>
				<tr>
			</table>
		</form>
	</div>



</body>
</html>