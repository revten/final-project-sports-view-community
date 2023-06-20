<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.3.js" charset="utf-8"></script>
</head>
<body>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
<script>
var naver_id_login = new naver_id_login("Q141vzvaIl6ZvPN2b4UJ", "http://localhost/nmp/account/reg.go");
//alert(naver_id_login.oauthParams.access_token);
naver_id_login.get_naver_userprofile("naverSignInCallback()");

function naverSignInCallback() { 
	let member_email = naver_id_login.getProfileData('email');
  	let member_id = member_email.split('@');
  	member_id =	member_id[0];
 	let member_reg_type = '2';
  	
 	$.ajax({
		url:"social.id.check",
		type:"GET",
		dataType :"text",
		data:{"member_id":member_id,
			"member_reg_type":member_reg_type
			},
		success: function(getData) {
			console.log(getData);
			if (getData >=1) {
				window.close();
				window.opener.location.href="http://localhost/nmp/social.login.do?member_id="+member_id;
		}else {
				alert('회원가입을 도와드리겠습니다.');
				window.close();
				window.opener.location.href="http://localhost/nmp/social.reg.do?member_id="
					+ member_id + "&member_reg_type="
					+ member_reg_type;
			}
			
		},
		error : function(request,status,error) {
			console.log("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
			
		}
	});
  }
</script>
</body>
</html>