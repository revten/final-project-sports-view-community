<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 - Enjoy Sports</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.7.0/animate.min.css" />
</head>

<body>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	
	<div class="animated bounceInDown">
		
		<div id="accountReg__container">
			<h1 class="login_title">회원 가입</h1>
			<form action="reg.do" method="post" onsubmit="return checkReg()">
				
				<!--  아이디 입력 -->
				<div class="accountReg__idInput">
					<input class="input_id" placeholder="아이디(영어,소문자,숫자 5-12)" id="id-input" name="id" oninput="checkId()">
					<input id="id-confirm" type="hidden" value="0">
					<span class="id__good">사용가능 합니다.</span>
					<span class="id__bad">아이디 양식을 확인해 주세요</span>
				</div>
				<button type="button" onclick="checkSameId()">중복확인</button>
				
				<!-- 비밀번호 인풋 -->
				<div class="accountReg__pwdInput">
					<input class="input_pwd" placeholder="비밀번호(영어+숫자+특수문자 7-20)" type="password" id="pwd-input" name="password"  oninput="checkPwd()">
					<span class="pwd__good">사용가능 합니다.</span>
					<span class="pwd__bad">비밀번호 양식을 확인해 주세요</span>
				</div>
				<!-- 비밀번호 확인란 -->
				<div class="accountReg__pwdInput">
					<input class="input_pwd" placeholder="비밀번호 확인" type="password" id="pwd-input-confirm">
					<font id="pwd-confirm" size="2"></font>
				</div>
				
				<!-- nickname 인풋 -->
				<div>
					<input class="input_id" placeholder="닉네임(2~8자리)" id="nickname-input" name="nickname" oninput="checkNickname()">
					<span class="nickname__good">사용가능 합니다.</span>
					<span class="nickname__bad">닉네임 양식을 확인해 주세요</span>
				</div>

				<!-- 이메일 인증 -->
				<div class="accountReg__emailInput">
					<!-- 이메일 입력 -->
					<input class="input_id" id="email-input" name="email"  placeholder="이메일" type="email" >
					<button class="emailBtn2" id="email-send-btn" type="button">이메일 인증</button>
					<!-- 받은 인증번호 저장-->
					<input type="hidden" id="email-certNum">
					<!-- 인증번호 입력 -->					
					<input class="input_id"  id="email-certNum-input" placeholder="인증번호를 입력해주세요" disabled="disabled"  type="text" size="13" maxlength="6" >
					
					<button class="emailBtn2" id="email-auth-complete-btn" disabled="disabled" type="button">인증확인</button>
				</div>

				<hr>
				
				<!-- 휴대폰 인증 -->
				<div class="account_type">
					<label for="phone-input">휴대폰 인증</label>
					<!-- 휴대폰 번호 입력칸 -->
					<input class="input_id" id="phone-input" name="phone" title="전화번호 입력" oninput="autoHyphen(this)" placeholder=" '-' 입력 X" type="text" size="13" maxlength="13" />
					<button class="emailBtn2" type="button" id="phone-send-sms-btn">인증번호 전송</button>
					<!-- 인증번호 입력 -->	
					<input class="input_id" id="phone-certNum-input" placeholder="인증번호를 입력해주세요"  disabled="disabled"  type="text" size="13" maxlength="6" >
					
					<button class="emailBtn2" id="phone-auth-complete-btn" disabled="disabled" type="button" >인증확인</button>
				</div>
					
				<!-- 성별 gender -->
				<h4 >성별</h4>
				<div>
					<label for="gender_man"><b> 남자 :</b></label>
					<input id="gender_man" type="radio" name="gender" value="0">
					<label for="gender_woman"><b> 여자 :</b></label>
					<input id="gender_woman" type="radio" name="gender" value="1">
				</div>
				
				<!-- 생일 birthday -->
				<h4 >생일</h4>
				<div><input type="date" name="birthday"/></div>
				
				<!-- 관신구단 선택 -->
				<h4 >나의 관심 구단</h4>
				<h4>KBO</h4>
				<div>
					<c:forEach var='ci' items='${clubImages }'>
						<c:if test="${ci.league_id eq 101 }">
							<input type="checkbox" id="size" name="club_id" value="${ci.club_id }"/>
							<img title="${ci.club_name }" style="width: 30px; height: 30px; cursor: pointer" src="resources/files/club_images/${ci.club_id }/${ci.file_name}">
					</c:if>
					</c:forEach>
				</div>
				
				<h4>K-LEAGUE</h4>
				<div>
					<c:forEach var='ci' items='${clubImages }'>
						<c:if test="${ci.league_id eq 201 }">
							<input type="checkbox" id="size" name="club_id" value="${ci.club_id }"/>
							<img title="${ci.club_name }" style="width: 30px; height: 30px; cursor: pointer" src="resources/files/club_images/${ci.club_id }/${ci.file_name}">
					</c:if>
					</c:forEach>
				</div>
				
				<h4>K-LEAGUE</h4>
				<div>
					<c:forEach var='ci' items='${clubImages }'>
						<c:if test="${ci.league_id eq 201 }">
							<input type="checkbox" id="size" name="club_id" value="${ci.club_id }"/>
							<img title="${ci.club_name }" style="width: 30px; height: 30px; cursor: pointer" src="resources/files/club_images/${ci.club_id }/${ci.file_name}">
					</c:if>
					</c:forEach>
				</div>
				
				<h4>KBL</h4>
				<div>
					<c:forEach var='ci' items='${clubImages }'>
						<c:if test="${ci.league_id eq 301 }">
							<input type="checkbox" id="size" name="club_id" value="${ci.club_id }"/>
							<img title="${ci.club_name }" style="width: 30px; height: 30px; cursor: pointer" src="resources/files/club_images/${ci.club_id }/${ci.file_name}">
					</c:if>
					</c:forEach>
				</div>
				
				<h4>WKBL</h4>
				<div>
					<c:forEach var='ci' items='${clubImages }'>
						<c:if test="${ci.league_id eq 351 }">
							<input type="checkbox" id="size" name="club_id" value="${ci.club_id }"/>
							<img title="${ci.club_name }" style="width: 30px; height: 30px; cursor: pointer" src="resources/files/club_images/${ci.club_id }/${ci.file_name}">
					</c:if>
					</c:forEach>
				</div>
	
				<h4>KOVO(남)</h4>
				<div>
					<c:forEach var='ci' items='${clubImages }'>
						<c:if test="${ci.league_id eq 401 }">
							<input type="checkbox" id="size" name="club_id" value="${ci.club_id }"/>
							<img title="${ci.club_name }" style="width: 30px; height: 30px; cursor: pointer" src="resources/files/club_images/${ci.club_id }/${ci.file_name}">
					</c:if>
					</c:forEach>
				</div>

				<h4>KOVO(여)</h4>
				<div>
					<c:forEach var='ci' items='${clubImages }'>
						<c:if test="${ci.league_id eq 451 }">
							<input type="checkbox" id="size" name="club_id" value="${ci.club_id }"/>
							<img title="${ci.club_name }" style="width: 30px; height: 30px; cursor: pointer" src="resources/files/club_images/${ci.club_id }/${ci.file_name}">
					</c:if>
					</c:forEach>
				</div>

				<!-- 가입 타입 0:기본, 1:소셜 -->
				<input type="hidden" name="join_type" value="0">
				<button type="submit" id="reg" class="emailBtn2" style="margin-bottom: 15px;">가입</button>
			</form>
		</div>
	</div>
</body>
</html>