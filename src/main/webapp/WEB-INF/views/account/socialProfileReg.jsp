<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 - Enjoy Sports</title>
<style>
.id_ok {
	color: #008000;
	display: none;
}

.id_already {
	color: #6A82FB;
	display: none;
}
</style>
<script src="resources/js/account/account_check.js"></script>
<script>
function pick(e){
	
	var baseball = [
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
	
	var soccer = [
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
	
	var basketball = [
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
	
	var wBasketball = [
		{text:"부산 BNK 썸", value:"3501"},
		{text:"부천 하나원큐", value:"3502"},
		{text:"아산 우리은행 우리WON", value:"3503"},
		{text:"용인 삼성생명 블루밍스", value:"3504"},
		{text:"인천 신한은행 에스버드", value:"3505"},
		{text:"청주 KB 스타즈", value:"3506"}
	];
	
	var volleyball = [
		{text:"인천 대한항공 점보스", value:"4001"},
		{text:"의정부 KB손해보험 스타즈", value:"4002"},
		{text:"수원 한국전력 빅스롬", value:"4003"},
		{text:"서울 우리카드 우리WON", value:"4004"},
		{text:"안산 OK금융그룹 웃맨", value:"4005"},
		{text:"대전 삼성화재 블루팡스", value:"4006"},
		{text:"천안 현대캐피탈 스카이워커스", value:"4007"}
	];
	
	var wVolleyball = [
		{text:"수원 현대건설 힐스테이트", value:"4501"},
		{text:"김천 한국도로공사 하이패스", value:"4502"},
		{text:"GS칼텍스 서울 KIXX", value:"4503"},
		{text:"대전 KGC인삼공사", value:"4504"},
		{text:"화성 IBK기업은행 알토스", value:"4505"},
		{text:"인천 흥국생명 핑크스파이더스", value:"4506"},
		{text:"광주 페퍼저축은행 AI 페퍼스", value:"4507"}
	];
	
	var target = document.getElementById("club_id");
	
	if(e.value == "KBO") var d = baseball;
	else if(e.value == "K-LEAGUE") var d = soccer;
	else if(e.value == "KBL") var d = basketball;
	else if(e.value == "WKBL") var d = wBasketball;
	else if(e.value == "V-LEAGUE(M)") var d = volleyball;
	else if(e.value == "V-LEAGUE(W)") var d = wVolleyball;

	target.options.length = 0;
	
	for(x in d){
		let opt = document.createElement("option");
		opt.value = d[x].value;
		opt.innerText = d[x].text;
		target.appendChild(opt);
	}
	
}
</script>
<script>
function checkOne(element) {
	  
	  const checkboxes 
	      = document.getElementsByName("member_subs");
	  
	  checkboxes.forEach((cb) => {
	    cb.checked = false;
	  })
	  
	  element.checked = true;
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
	<h1>회원 가입</h1>
	<div id="accountReg__contrainer">
		<form action="profile.reg.do" method="post"
			onsubmit="return checkReg()">
			<div class="accountReg__pwInput-1">비밀번호</div>
			<div class="accountReg__pwInput-2">
				<!-- member 비밀번호 인풋 창 -->
				<input type="password" id="pwInput" name="member_pwd"> <img id="questionMark2"
					src="data:image/png;base64,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">
			<span id="accountCondition2" style="display:none">영어와 숫자, 특수문자 조합 7-12자</span>
			</div>
			<div class="accountReg__pwInput-1">비밀번호 확인</div>
			<div class="accountReg__pwInput-2">
				<input type="password" id="pwInput2" name="member_pwdConfirm">
				<br> <font id="pwConfirm" size="2"></font>
			</div>
			<!-- member nick 인풋 창 -->
			<div>닉네임</div>
			<input id="member_nick" name="member_nick">
			<!--  member ip adress 히든 창 -->
			<input type="hidden" name="member_auth_type" value="0"> <input
				type="hidden" name="member_reg_type" value="0"> <input
				type="hidden" id="ipv4" name="member_reg_ip"
				value="<%=request.getRemoteAddr()%>">
			<!-- value="${ipv4 }"-->
			<!-- member intro 인풋 창-->
			<div class="profileReg__introInput-1">자기소개</div>
			<textarea name="member_intro" cols="50" rows="10"></textarea>
			<!-- member club 선택 창 -->
			<div>
				<label>좋아하는 리그 선택</label> <select onchange="pick(this)">
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
				<label>좋아하는 구단 선택</label> <select name="club_id" id="club_id">
					<option value="0">구단을 선택해주세요</option>
				</select>
			</div>
			<!-- profile subs 동의 인풋 창 -->
			<div>
				<input type="checkbox" name="member_subs" checked value="1"
					onclick="checkOne(this)"> <label for="profile_subs">
					이메일 수신 동의</label>
			</div>
			<div>
				<input type="checkbox" name="member_subs" value="0"
					onclick="checkOne(this)"> <label for="profile_subs">
					이메일 수신 거부</label>
			</div>
			<input type="hidden" name="member_admin" value="0"> <br>
			<button id="reg">가입</button>
		</form>
	</div>
</body>
</html>