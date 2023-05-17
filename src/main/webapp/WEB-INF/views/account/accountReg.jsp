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
<script src="resources/js/account/account_check.js"></script>
<script>
function pick(e){
	
	let baseball = [
		{text:"SSG 랜더스", value:"1001"},
		{text:"키움 히어로즈", value:"1002"},
		{text:"LG트윈스", value:"1003"},
		{text:"kt wiz", value:"1004"},
		{text:"KIA 타이거즈", value:"1005"},
		{text:"NC 다이노스", value:"1006"},
		{text:"삼성 라이온즈", value:"1007"},
		{text:"롯데 자이언츠", value:"1008"},
		{text:"두산 베어스", value:"1009"},
		{text:"한화 이글스", value:"1010"}
	];
	
	let soccer = [
		{text:"강원 FC", value:"2001"},
		{text:"광주 FC", value:"2002"},
		{text:"대구 FC", value:"2003"},
		{text:"대전 하나 시티즌", value:"2004"},
		{text:"FC 서울", value:"2005"},
		{text:"수원 삼성 블루윙즈", value:"2006"},
		{text:"수원 FC", value:"2007"},
		{text:"울산 현대", value:"2008"},
		{text:"인천 유나이티드", value:"2009"},
		{text:"전북 현대 모터스", value:"2010"},
		{text:"제주 유나이티드", value:"2011"},
		{text:"포항 스틸러스", value:"2012"}
	];
	
	let basketball = [
		{text:"고양 캐롯 점퍼스", value:"3001"},
		{text:"대구 한국가스공사 페가수스", value:"3002"},
		{text:"수원 kt 소닉붐", value:"3003"},
		{text:"서울 삼성 썬더스", value:"3004"},
		{text:"서울 SK 나이츠", value:"3005"},
		{text:"안양 KGC인삼공사", value:"3006"},
		{text:"울산 현대모비스 피버스", value:"3007"},
		{text:"원주 DB 프로미", value:"3008"},
		{text:"전주 KCC 이지스", value:"3009"},
		{text:"창원 LG 세이커스", value:"3010"}
	];
	
	let wBasketball = [
		{text:"부산 BNK 썸", value:"3501"},
		{text:"부천 하나원큐", value:"3502"},
		{text:"아산 우리은행 우리WON", value:"3503"},
		{text:"용인 삼성생명 블루밍스", value:"3504"},
		{text:"인천 신한은행 에스버드", value:"3505"},
		{text:"청주 KB 스타즈", value:"3506"}
	];
	
	let volleyball = [
		{text:"인천 대한항공 점보스", value:"4001"},
		{text:"의정부 KB손해보험 스타즈", value:"4002"},
		{text:"수원 한국전력 빅스롬", value:"4003"},
		{text:"서울 우리카드 우리WON", value:"4004"},
		{text:"안산 OK금융그룹 웃맨", value:"4005"},
		{text:"대전 삼성화재 블루팡스", value:"4006"},
		{text:"천안 현대캐피탈 스카이워커스", value:"4007"}
	];
	
	let wVolleyball = [
		{text:"수원 현대건설 힐스테이트", value:"4501"},
		{text:"김천 한국도로공사 하이패스", value:"4502"},
		{text:"GS칼텍스 서울 KIXX", value:"4503"},
		{text:"대전 KGC인삼공사", value:"4504"},
		{text:"화성 IBK기업은행 알토스", value:"4505"},
		{text:"인천 흥국생명 핑크스파이더스", value:"4506"},
		{text:"광주 페퍼저축은행 AI 페퍼스", value:"4507"}
	];
	
	let target = document.getElementById("club_id");
	
	if(e.value == "KBO") let d = baseball;
	else if(e.value == "K-LEAGUE") let d = soccer;
	else if(e.value == "KBL") let d = basketball;
	else if(e.value == "WKBL") let d = wBasketball;
	else if(e.value == "V-LEAGUE(M)") let d = volleyball;
	else if(e.value == "V-LEAGUE(W)") let d = wVolleyball;

	target.options.length = 0;
	
	for(x in d){
		let opt = document.createElement("option");
		opt.value = d[x].value;
		opt.innerText = d[x].text;
		target.appendChild(opt);
	}
}
</script>

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
			<form action="account.reg.do" method="post" onsubmit="return checkReg()">
				
				<!--  아이디 입력 -->
				<div class="accountReg__idInput">
					<input class="input_id" placeholder="아이디(영어,소문자,숫자 5-12)" id="idInput" name="id" oninput="checkId()">
					<input id="idConfirm" type="hidden" value="0">
					<span class="id__good">사용가능 합니다.</span>
					<span class="id__bad">아이디 양식을 확인해 주세요</span>
				</div>
				<button type="button" onclick="checkSameId()">중복확인</button>
				
				<!-- 비밀번호 인풋 -->
				<div class="accountReg__pwdInput">
					<input class="input_pwd" placeholder="비밀번호(영어+숫자+특수문자 7-20)" type="password" id="pwdInput" name="password"  oninput="checkPwd()">
					<span class="pwd__good">사용가능 합니다.</span>
					<span class="pwd__bad">비밀번호 양식을 확인해 주세요</span>
				</div>
				<!-- 비밀번호 확인란 -->
				<div class="accountReg__pwdInput">
					<input class="input_pwd" placeholder="비밀번호 확인" type="password" id="pwdInput2">
					<font id="pwdConfirm" size="2"></font>
				</div>
				
				<!-- nickname 인풋 -->
				<input class="input_id" placeholder="닉네임" id="member_nick" name="nickname">

				<!-- 이메일 인증 인풋 -->
				<div class="accountReg__emailInput">
					<input class="input_id" placeholder="이메일" type="email" id="search_member_email" name="email">
					<button class="emailBtn2" type="button" id="email_auth">이메일 인증</button>
					
					<input class="input_id" placeholder="인증번호를 입력해주세요" id="checkNum" disabled="disabled">
					<input type="hidden" id="valid">
					<span id="mail-check-warn"></span>
					<span id="emailcheckResult"></span>
				</div>
				
				<div> 추가 정보 (선택)</div>
				<!-- 휴대폰 cellphone -->
				<div>휴대폰</div>
				<!-- 성별 gender -->
				<div >성별</div>
				<!-- 생일 birthday -->
				<div >생일</div>

				<!-- 관신구단 선택 -->
				<div>
					<label>좋아하는 리그 선택</label>
					<select onchange="pick(this)">
						<option>리그를 선택해주세요</option>
						<option value="KBO" id="league">야구</option>
						<option value="K-LEAGUE" id="league">축구</option>
						<option value="KBL" id="league">남자 농구</option>
						<option value="WKBL" id="league">여자 농구</option>
						<option value="V-LEAGUE(M)" id="league">남자 배구</option>
						<option value="V-LEAGUE(W)" id="league">여자 배구</option>
					</select>
				</div>

				<div>
					<label>좋아하는 구단 선택</label>
					<select name="club_id" id="club_id">
						<option value="0">구단을 선택해주세요</option>
					</select>
				</div>

				<!-- 가입 타입 0:기본, 1:소셜 -->
				<input type="hidden" name="join_type" value="0">
				
				<button type="submit" id="reg" class="emailBtn2" style="margin-bottom: 15px;">가입</button>
			</form>
		</div>
	</div>
</body>
</html>