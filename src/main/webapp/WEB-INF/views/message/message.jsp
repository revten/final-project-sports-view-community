<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<br><br><br><br><br><br>

<h1>메세지 페이지 </h1>
<c:if test="${sessionScope.loginAccount != null}">
	<table id="messageMemberArea" style="bottom: -500px;">
		<tr>
			<td align="center">
				<span id="messageMemberSummoner">
					<img src="resources/files/message_img/sns.png" style="background-color: #000000BF; border-radius: 10px; padding: 5px; ">
				</span>
			</td>
		</tr>
		<tr>
			<td align="center">
				<div id="messageMemberArea2">
					<c:forEach var="m" items="${members }">
						<table class="aMember" onclick="sendMessage('${m.member_id}');">
							<tr>
								<td class="aMemberID">${m.member_id }
									
								</td>
							</tr>
							<tr>
								<td align="right" class="aMemberNick">${m.member_nick }&nbsp;</td>
							</tr>
						</table>
					</c:forEach>
				</div>
			</td>
		</tr>
	</table>
</c:if>
<div id="messageArea">
	<c:forEach var="m" items="${msgs }">
		<table class="aCMsg">
			<tr>
				<td align="right"><span style="font-size: 8pt; cursor: pointer;"
					onclick="deleteMessage(${m.message_id});">X</span></td>
			</tr>
			<tr>
				<td class="aCMsgFrom" onclick="sendMessage('${m.message_from}');">&nbsp;${m.message_from }</td>
			</tr>
			<tr>
				<td align="right" class="aCMsgDate">
					<fmt:formatDate value="${m.message_when }" type="both" dateStyle="short" timeStyle="short"/>
					<br>
				<hr></td>
			</tr>
			<tr>
				<td class="aCMsgTxt">${m.message_txt }</td>
			</tr>
		</table>
	</c:forEach>
</div>


<body>
</body>
</html>