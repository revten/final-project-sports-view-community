<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>추가 정보 입력 - Enjoy Sports</title>
</head>
<body>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<h1>추가 정보 입력</h1>
	<div id="profileReg__contrainer">
		<form action="profile.reg.do">
			<!-- <div class="profileReg__idInput-1">아이디</div>
			<div class="profileReg__idInput-2"></div>
				 profile id 히든 창 -->
			<input type="hidden" name="profile_id"
				value="${sessionScope.loginAccount.user_id }">
			<div class="profileReg__pwInput-1">닉네임</div>
			<div class="profileReg__pwInput-2">
				<!-- profile 닉네임 인풋 창 -->
				<input id="nickInput" name="profile_nick">
			</div>
			<!--  profile intro 인풋 창 -->
			<div class="profileReg__introInput-1">자기소개</div>
			<div class="profileReg_introInput-2">
				<textarea name="profile_intro" cols="50" rows="10"></textarea>
			</div>
			<div>
				<div>
					<input type="checkbox" name="profile_subs" checked value="1"> 
					<label for="profile_subs">수신 동의</label>
				</div>
				<div>
					<input type="checkbox" name="profile_subs" value="0"> 
					<label for="profile_subs">수신 거부</label>
				</div>
			</div>
			<!-- <div class="profileReg__nameInput-1">이름</div>
			<div class="profileReg__nameInput-2">
				<input id="nameInput" name="ac_name">
			</div> 

			<div class="profileReg__addrInput">주소</div>
			<div>
				<input id="addrInput" name="ac_addr">
			</div> -->
			<input type="hidden" id="ipv4" name="user_reg_ip"
				value="<%=request.getRemoteAddr()%>">
			<!-- value="${ipv4 }"-->
			<input type="hidden" name="user_auth_type" value="0">
			<div class="profileReg__emailInput-1">이메일</div>
			<div class="profileReg__emailInput-2">
				<!-- user_table 이메일 인풋 창 -->
				<input type="email" id="search_user_email" name="user_email">
				<br>
				<button type="button" id="user_email_check">이메일 인증</button>
				<br> <input placeholder="인증번호를 입력해주세요" id="email_num"
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