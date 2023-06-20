<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 찾기</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.7.0/animate.min.css" />
<style>
#success-modal, #fail-modal {
	display: none;
	position: fixed;
	width: 100%;
	height: 100%;
	top: 0;
	left: 0;
	background: rgba(0, 0, 0, 0.3);
}

.modal-con {
	display: none;
	position: fixed;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
	max-width: 60%;
	min-height: 30%;
	background: #fff;
}

.modal-con .title {
	font-size: 20px;
	padding: 20px;
	background: #f3f6fd;
	text-align: center;
}

.modal-con .con {
	font-size: 15px;
	line-height: 1.3;
	padding: 30px;
}

.modal-con .close {
	display: block;
	position: absolute;
	width: 30px;
	height: 30px;
	border-radius: 50%;
	border: 3px solid #000;
	text-align: center;
	line-height: 30px;
	text-decoration: none;
	color: #000;
	font-size: 20px;
	font-weight: bold;
	right: 10px;
	top: 20px;
}
</style>
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
		<div class="login_area">

			<h1 class="login_title">아이디 찾기</h1>

			<div>
				<input class="input_id" id="searchId-nickname" name="nickname" placeholder="닉네임을 입력해주세요" required>
			</div>
			<div>
				<input class="input_id" id="searchId-email" name="email" placeholder="이메일을 입력해주세요" required>
			</div>
			<div>
				<button class="loginBtn" onclick="searchId();">아이디 찾기</button>
			</div>

			<br>
			<div>
				이미 회원이신가요?&nbsp;&nbsp;&nbsp; <a href="login.go">로그인</a>
			</div>
			<div>
				아직 회원이 아니신가요?&nbsp;&nbsp;&nbsp;<a href="reg.go">회원가입</a>
			</div>
		</div>

		<!-- 모달 -->
		<div>
			<div id="success-modal"></div>
			<input type="hidden" id="idFind-auth-hidden">
			<div class="modal-con success-modal">
				<a href="javascript:;" class="close">X</a>
				<p class="title">찾았습니다!!</p>
				<div class="con">
					회원님 아이디는 <span class="findId_span"></span>입니다
				</div>
			</div>
		</div>
		
		<div>
			<div id="fail-modal"></div>
			<input type="hidden" id="idFind-auth-hidden">
			<div class="modal-con fail-modal">
				<a href="javascript:;" class="close">X</a>
				<p class="title">일치하는 아이디가 없습니다</p>
			</div>
		</div>
		
	</div>
	
</body>
	<script type="text/javascript">
		$("#success-modal, #fail-modal, .close").on('click', function() {
			$("#success-modal, #fail-modal").fadeOut(300);
			$(".modal-con").fadeOut(300);
		});
	</script>
</html>