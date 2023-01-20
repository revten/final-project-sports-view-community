<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- 
<meta name="google-signin-client_id"
	content="567208941336-p92o44c3gigs2a282rhro3p6vni5fetb.apps.googlemembercontent.com">
-->
<title>Insert title here</title>
<script type="text/javascript"
	src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.3.js"
	charset="utf-8"></script>
<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
<script src="https://accounts.google.com/gsi/client" async defer></script>
<!-- <script src="https://apis.google.com/js/platform.js" async defer></script> -->
</head>

<body>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<div class="login_area">
		<h1>로그인</h1>

		<form class="login_form" name="loginForm" action="account.login.do"
			method="post">

			<h6>아이디</h6>
			<input name="member_id" class="input_id" id="idInput">

			<h6>비밀번호</h6>
			<input name="member_pwd" type="password" class="input_pw" id="pwInput"><br>

			<a class="find_id" type="button" href="search.id.go">아이디</a>&nbsp; <a>·</a>&nbsp;
			<a class="find_pw" type="button" href="search.pw.go">비밀번호 찾기</a><br>

			<button id="loginBtn">로그인</button>
			<div class="reg-area">

				<span>회원이 아니세요?</span>&nbsp;&nbsp;&nbsp;<a href="account.reg.go">회원가입</a>
			</div>

			<br>

			<!-- -------------------Social Login------------------- -->

			<h5>간편 로그인</h5>
			<br>
		</form>
		<div id="SNS-login-area">
			<!-- 카카오로그인 -->
			<a onclick="kakaoLogin()"> <img
				src="https://www.myro.co.kr/myro_image/kakaolink_btn.png" width="40" /></a>

			<!-- 네이버로그인 -->
			<div id="naver_id_login"></div>

			<!-- 구글로그인 -->
			<div id="g_id_onload"
				data-client_id="567208941336-p92o44c3gigs2a282rhro3p6vni5fetb.apps.googlemembercontent.com"
				data-callback="handleCredentialResponse" data-auto_prompt="false"></div>

			<div class="g_id_signin" data-type="icon" data-size="large"
				data-theme="outline" data-text="sign_in_with"
				data-shape="rectangular" data-logo_alignment="left"></div>

		</div>
	</div>

	<script>
		/* 카카오로그인 */
		function kakaoLogin() {
			Kakao.init('558a779b58860e521372474a218e5c56');
			console.log(Kakao.isInitialized());

			Kakao.Auth.login({
				success : function(authObj) {
					console.log(authObj);
					Kakao.Auth.setAccessToken(authObj.access_token);

					getInfoKakao();
				},

				fail : function(err) {
					console.log(err);
				}
			});
		}

		function getInfoKakao() {
			Kakao.API.request({
				url : '/v2/member/me',
				success : function(res) {
					console.log(res);
					var member_id_name = res.id;
					var member_auth_type = '1';
					console.log(member_id_name, member_auth_type);

					checkInfoKakao(member_id_name, member_auth_type);

				},

				fail : function(error) {
					alert('카카오 로그인에 실패했습니다. 관리자에게 문의하세요.'
							+ JSON.stringify(error));
				}
			});
		}

		function checkInfoKakao(member_id_name, member_auth_type) {
			$
					.ajax({
						url : "social.id.check",
						type : "GET",
						dataType : "text",
						data : {
							"member_id_name" : member_id_name,
							"member_auth_type" : member_auth_type
						},
						success : function(data) {
							console.log(data)
							if (data >= 1) {
								let kakaoLoginUrl = `social.login.do?member_id_name=${member_id_name}`;
								console.log(kakaoLoginUrl);
								location.replace(kakaoLoginUrl);
							} else {
								alert('회원가입을 도와드리겠습니다.');
								let kakaoJoinUrl = `social.reg.do?member_id_name=+${member_id_name}+&member_auth_type=+${member_auth_type}`;
								console.log(kakaoJoinUrl);
								location.replace(kakaoJoinUrl);
							}
						},
						error : function(request, status, error) {
							console.log("code:" + request.status + "\n"
									+ "message:" + request.responseText + "\n"
									+ "error:" + error);

						}
					});
		}
	</script>

	<script>
		/* 네이버로그인 */
		var naver_id_login = new naver_id_login("Q141vzvaIl6ZvPN2b4UJ",
				"http://localhost/nmp/social.login.go?ac_linkWhere=${ac_linkWhere}");
		var state = naver_id_login.getUniqState();
		let ac_linkWhere = "naver"
		naver_id_login.setButton("green", 1, 40);
		naver_id_login.setDomain("http://localhost/nmp/social.login.go");
		naver_id_login.setState(state);
		naver_id_login.setPopup();
		naver_id_login.init_naver_id_login();
	</script>

	<script>
		/* 구글로그인 */
		function handleCredentialResponse(response) {
			const responsePayload = parseJwt(response.credential);

			let member_id_name = responsePayload.sub;
			//let ac_name = responsePayload.name;
			//let ac_email = responsePayload.email;
			let member_auth_type = '1';

			console.log(member_id_name, member_auth_type);
			checkInfoGoogle(member_id_name, member_auth_type);
		}

		function parseJwt(token) {
			var base64Url = token.split('.')[1];
			var base64 = base64Url.replace(/-/g, '+').replace(/_/g, '/');
			var jsonPayload = decodeURIComponent(atob(base64).split('').map(
					function(c) {
						return '%'
								+ ('00' + c.charCodeAt(0).toString(16))
										.slice(-2);
					}).join(''));

			return JSON.parse(jsonPayload);
		};

		function checkInfoGoogle(member_id_name, member_auth_type) {
			$
					.ajax({
						url : "social.id.check",
						type : "GET",
						dataType : "text",
						data : {
							"member_id_name" : member_id_name,
							"member_auth_type" : member_auth_type
						},
						success : function(getData) {
							console.log(getData);
							if (getData >= 1) {
								let googleLoginUrl = `social.login.do?member_id_name=${member_id_name}`;
								console.log(googleLoginUrl);
								location.replace(googleLoginUrl);
							} else {
								alert('회원가입을 도와드리겠습니다.');
								let googleJoinUrl = `social.reg.do?member_id_name=${member_id_name}+&member_auth_type+${member_auth_type}`;
								console.log(googleJoinUrl);
								location.replace(googleJoinUrl);
							}

						},
						error : function(request, status, error) {
							console.log("code:" + request.status + "\n"
									+ "message:" + request.responseText + "\n"
									+ "error:" + error);

						}
					});
		}
	</script>

</body>
</html>