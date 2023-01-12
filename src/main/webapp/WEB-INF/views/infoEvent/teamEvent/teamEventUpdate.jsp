<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
.thead{
 	display: inline-block;
    width: 100px;
    text-align: center;
}
.theadTitle{
	display: inline-block;
    width: 300px;
    text-align: center;
}
.theadDate{
	display: inline-block;
    width: 200px;
    text-align: center;
}
.tableContent{
	width:70%;
	align:center;
	text-align: left;
	border:1px solid
}
.tableUD{
	width:70%;
	align:center;
	text-align: right;
}
</style>
<title>Insert title here</title>
</head>
<body>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
		<div style="border:1px solid;width:70%;align:center;">
			<div class="thead">${teamEvent.ie_te_no }</div>
			<div class="thead"><input name="ie_te_team" value="${teamEvent.ie_te_team }"></div>
			<div class="theadTitle"><input name="ie_te_title" value="${teamEvent.ie_te_title }"></div>
			<div class="thead">${teamEvent.ie_te_nick }</div>
			<div class="theadDate"><fmt:formatDate value="${teamEvent.ie_te_regdate }" pattern="yyyy-MM-dd HH:mm" /></div>
			<div class="thead">조회수:${teamEvent.ie_te_views }</div>
		</div>
		<div class="tableContent"><input type="file" value="${teamEvent.ie_te_img }"></div>
		<div class="tableContent"><textarea maxlength="2084" name="ie_te_content" style="resize: none">${teamEvent.ie_te_content }</textarea></div>
		<div class="tableUD">
					<button onclick="history.back()">이전으로</button>
										<button onclick="location.href='teamEvent.update.do?ie_te_no=${teamEvent.ie_te_no}'">수정</button>
										<button onclick="location.href='teamEvent.delete.do?ie_te_no=${teamEvent.ie_te_no}'">삭제</button>
				</div>
				
				
</body>
</html>