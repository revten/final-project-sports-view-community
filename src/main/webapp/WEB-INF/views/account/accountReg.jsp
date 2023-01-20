<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 - Enjoy Sports</title>
</head>
<body>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<h1>회원 가입</h1>
	<div id="accountReg__contrainer">
		<form action="account.reg.do" method="post" onsubmit="return regUserId()">
			<div class="accountReg__idInput-1">아이디</div>
			<div class="accountReg__idInput-2">
				<!-- user_table 아이디 인풋 창 -->
				<input id="idInput" name="user_id_name">
			</div>
			<div class="accountReg__pwInput-1">비밀번호</div>
			<div class="accountReg__pwInput-2">
				<!-- user_table 비밀번호 인풋 창 -->
				<input type="password" id="pwInput" name="user_pwd">
			</div>
			<div class="accountReg__pwInput-1">비밀번호 확인</div>
			<div class="accountReg__pwInput-2">
				<input type="password" id="pwInput2" name="user_pwdConfirm"> <font
					id="pwConfirm" size="2"></font>
			</div>
				<!--  user_table ip adress 인풋 창 -->
			<input type="hidden" id="ipv4" name="user_reg_ip" value="<%=request.getRemoteAddr()%>"><!-- value="${ipv4 }"-->
			<input type="hidden" name="user_auth_type" value="0">
			<div class="accountReg__emailInput-1">이메일</div>
			<div class="accountReg__emailInput-2">
				<!-- user_table 이메일 인풋 창 -->
				<input type="email" id="search_user_email" name="user_email">
				<br>
				<button type="button" id="user_email_check">이메일 인증</button>
				<br> 
				<input placeholder="인증번호를 입력해주세요" id="email_num"
				disabled="disabled"> <input type="hidden" id="valid">
				<span id="mail-check-warn"></span> <span id="emailcheckResult"></span>
			<p>
			</div>
			<button>가입</button>
			<br>
			<button onclick='history.back(-1)'>뒤로가기</button>
		</form>
	</div>
</body>
</html>