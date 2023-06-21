// 아이디 양식 유효성 검사
function checkId() {

	let id = $("#id-input").val();

	if (minLength(id, 5) || maxLength(id, 12) || idContain(id)) {
		// 위에서 하나라도 true면, 잘못된 것
		$('.id__good').css("display", "none");
		$('.id__bad').css("display", "inline-block");
	} else {
		$('.id__good').css("display", "inline-block");
		$('.id__bad').css("display", "none");
	}
}

// 아이디 중복 검사
function checkSameId() {
	let id = $('#id-input').val();

	if (minLength(id, 5) || maxLength(id, 12) || idContain(id)) {
		alert("아이디 양식 먼저 확인해주세요");
	} else {
		$.ajax({
			url : 'id.check',
			type : 'POST', // POST 방식으로 전달
			data : {
				id : id
			},
			success : function(result) { // 컨트롤러에서 넘어온 cnt값을 받는다
				if (result == 0) { // cnt가 1이 아니면 -> 사용 가능한 아이디
					alert("사용가능한 아이디입니다");
					$('#id-confirm').val('1'); // 회원 가입 버튼을 눌렀을때, 중복확인을 했는지 ->
											// 1이면 넘어가고 0이면 return false
				} else { // cnt가 1일 경우 -> 이미 존재하는 아이디
					alert("누군가 쓰고 있어요");
					$('#id-confirm').val('0');
				}
			},
			error : function() {
				alert("에러입니다");
			}
		});
	}
};

// 비밀번호 양식 유효성 검사
function checkPwd() {

	let pwd = $("#pwd-input").val();

	if (!pwdForm(pwd)) {
		// 정규식이 false면 잘못된것
		$('.pwd__good').css("display", "none");
		$('.pwd__bad').css("display", "inline-block");
	} else {
		$('.pwd__good').css("display", "inline-block");
		$('.pwd__bad').css("display", "none");
	}
}

// 비밀번호 확인란에 똑같이 입력했는지 실시간 검사
$(function() {
	$("#pwd-input")
			.keyup(
					function() {
						$("#pwd-confirm").html("");
						if (($('#pwd-input').val() != "" && ($("#pwd-input-confirm")
								.val() == ""))
								|| ($('#pwd-input').val() == "" && ($(
										"#pwd-input-confirm").val() != ""))) {
							$("#reg").attr("disabled", true);
						}
						// 두 input 값이 없을 경우 다시 사용 가능하도록
						if ($("#pwd-input").val() == ""
								&& ($("#pwd-input-confirm").val() == "")) {
							$("#reg").attr("disabled", false);
						}
					});

	$("#pwd-input-confirm").keyup(function() {
		if ($("#pwd-input").val() != $("#pwd-input-confirm").val()) {
			$("#pwd-confirm").html("비밀번호 일치하지 않음<br><br>");
			$("#pwd-confirm").css("color", "#ff0000")
			$("#reg").attr("disabled", true);
		} else {
			$("#pwd-confirm").html("비밀번호 일치함<br><br>");
			$("#pwd-confirm").css("color", "#008000");
			$("#reg").attr("disabled", false);
		}
	});
});

// 아이디 양식 유효성 검사
function checkNickname() {

	let nickname = $("#nickname-input").val();

	if (minLength(nickname, 2) || maxLength(nickname, 8)) {
		// 위에서 하나라도 true면, 잘못된 것
		$('.nickname__good').css("display", "none");
		$('.nickname__bad').css("display", "inline-block");
	} else {
		$('.nickname__good').css("display", "inline-block");
		$('.nickname__bad').css("display", "none");
	}
}

// 이메일, 휴대폰 인증
$(function() {
	
	// 이메일 인증 보내기
	$('#email-send-btn').click(function() {
		
		let email = $("#email-input").val();
		console.log(email);
		
		// 이메일 양식 우선 체크
		if(!emailForm(email)) {
			alert("이메일 양식이 잘못되었습니다");
			$("#email-input").focus();
			$("#email-input").val('');
			return false;
		} else {
			// 이메일 인증번호 보내기
			$.ajax({
				url : "email.auth.do",
				type : "GET",
				dataType : "text",
				data : {
					"email" : email
				},
				success : function(data) {
					console.log(data);
					$('#email-certNum').val(data);
					// 인증번호 입력칸, 버튼 활성화
					$('#email-certNum-input').attr('disabled', false);
					$('#email-auth-complete-btn').attr('disabled', false);
					alert('인증번호가 전송되었습니다.')
				}
			});
		}
	});
	
	// 이메일 인증 확인
	$("#email-auth-complete-btn").click(function() {
		
		let certNum = $('#email-certNum').val();
		console.log('certNum', certNum);
		let inputNum = $('#email-certNum-input').val();
		console.log('inputNum', inputNum);
		
		if (certNum == inputNum) {
			alert('성공적으로 인증되었습니다.');
			// 인증 성공시 -> 이메일 입력, 이메일 보내기 버튼, 인증번호 입력, 인증버튼 -> 비활성화
			$('#email-input').attr("disabled", "disabled");
			$('#email-send-sms-btn').attr("disabled", "disabled");
			$('#email-certNum-input').attr("disabled", "disabled");
			$('#email-auth-complete-btn').attr("disabled", "disabled");
		} else {
			alert('인증 번호가 일치하지 않습니다.');
			$('#email-certNum-input').val('');
			return false;
		}	
	});
	
});

// 휴대폰 번호 양식 자동완성
const autoHyphen = (target) => {
	 target.value = target.value
	   .replace(/[^0-9]/g, '')
	  .replace(/^(\d{0,3})(\d{0,4})(\d{0,4})$/g, "$1-$2-$3").replace(/(\-{1,2})$/g, "");
	}

// 휴대폰 인증
$(function() {
	
	// 휴대폰 인증 번호 보내기
	$("#phone-send-sms-btn").click(function() {

		let phoneNumber = $("#phone-input").val();
		let phoneInput = $("#phone-input");
		
		// 휴대폰 번호 입력 여부 우선 체크
		if (isEmpty(phoneNumber)) {
			alert("휴대폰 번호를 입력해주세요.");
			phoneInput.focus();
			return false;
		} else {
			// 휴대폰 인증번호 보내기
			$.ajax({
				url : "sendSms.do",
				type: 'GET',
				data : {
					"num" : phoneNumber
				},
				success: function(data) {
					alert("인증번호가 전송되었습니다.");
					// 인증번호 입력칸, 버튼 활성화
					$('#phone-inputNum').attr("disabled", false);
					$('#phone-auth-complete-btn').attr('disabled', false);
					const certNum = data;
					console.log("certNum", certNum);
					
					// 휴대폰 인증하기
					$("#phone-auth-complete-btn").click(function() {
						const inputNum = $("#phone-inputNum").val();
						
						if(certNum == inputNum) {
							alert("인증 성공");
							// 인증 성공시 -> 폰번호 입력, sms보내기 버튼, 인증번호 입력, 인증버튼 ->
							// 비활성화
							$('#phone-input').attr("disabled", "disabled");
							$('#phone-send-sms-btn').attr("disabled", "disabled");
							$('#phone-certNum-input').attr("disabled", "disabled");
							$('#phone-auth-complete-btn').attr("disabled", "disabled");
							
						} else {
							alert('인증 번호가 일치하지 않습니다.');
							$('#phone-certNum-input').val('');
							return false;
						}
					});
				}
			});
		}
	});
	
});


// 회원가입 버튼 눌렀을때, 전체적으로 다시 한번 검사 -> 최종 유효성 검사
// 닉네임 양식 + 이메일 인증 여부 + 아이디 중복 여부 확인
function checkReg() {
	
	// 관심구단 목록
	$("select[name=club_id]").change(function() {
		console.log($(this).val()); // value값 가져오기
		console.log($("select[name=club_id] option:selected").text()); // text값
		// 가져오기
	});
	
	// 이메일 입력값 disabled 풀기
	$('#email-input').attr("disabled", false);
	
	// 닉네임 입력 여부
	let nick_input = $("#nickname-input");
	let nick = $("#nickname-input").val();
	if (nick == '' || nick == undefined || nick == null || nick == 'null') {
		alert("닉네임을 입력해주세요");
		nick_input.focus();
		return false;
	}

	// 이메일 인증 여부
	let emailInputNum = $('#email-certNum-input').val();
	if (emailInputNum == '' || nick == undefined || nick == null || nick == 'null') {
		alert("이메일 인증을 완료해주세요");
		return false;
	}

	// 아이디 중복 확인 여부
	if ($("#id-confirm").val() == 1) {
		return true;
	} else {
		alert("아이디 중복여부를 확인해주세요");
		id.focus();
		return false;
	}
	return true;
};


// ID 찾기
function searchId() {
	let searchId_nickname = $('#searchId-nickname').val();
	let searchId_email = $('#searchId-email').val();

	$.ajax({
		url : "search.id.do",
		type: "POST",
		data : {
			"nickname" : searchId_nickname,
			"email" : searchId_email
		}
	}).done(function(res) {
		console.log("result", res);
		if (res != 0) {
			$("#success-modal").fadeIn(300);
			$(".success-modal").fadeIn(300);
			$('#idFind-auth-hidden').val(res);
			$('.findId_span').text(res);
		} else {
			$("#fail-modal").fadeIn(300);
			$(".fail-modal").fadeIn(300);
			$('#idFind-auth-hidden').val(res);fail-modal
			$('.findId_span').text(res);			
		}
	});
}

// 비밀번호 찾기 유효성 검사
function searchPw() {
	
	// submit이 안되도록
	let resultFlag = false;
	
	// 이메일 입력값 disabled 풀기
	$('#email-input').attr("disabled", false);
	
	// 이메일 인증 여부
	let emailInputNum = $('#email-certNum-input').val();
	if (emailInputNum == '') {
		alert("이메일 인증을 완료해주세요");
		return resultFlag;
	}
	
	let id = $('#id-input').val();
	console.log('id', id);
	
	$.ajax({
		url : 'id.check',
		type : 'POST', // POST 방식으로 전달
		async: false,
		data : {
			id : id
		},
		success : function(result) { // 컨트롤러에서 넘어온 cnt값을 받는다
			console.log("idCheck", result);
			if (result == 0) { // cnt가 1이 아니면 -> 사용 가능한 아이디
				alert("없는 아이디 입니다");
				resultFlag = false;
			} else { // cnt가 1일 경우 -> 이미 존재하는 아이디
				alert("비밀번호 재설정 페이지로 이동합니다");
				resultFlag = true;
			}
		},
		error : function() {
			alert("에러입니다");
		}
	});
	return 	resultFlag;
};

// 비밀번호 변경 -> 비밀번호 양식 체크
function changePw() {
	let pwd_input = $("#pwdInput");
	let pwd = $("#pwdInput").val();

	if (!chkPwd(pwd)) {
		alert("비밀번호 양식을 확인해주세요");
		pwd_input.focus();
		pwd_input.value = "";
		return false;
	}
};


// login area
function logout() {
	let ok = confirm("로그아웃 하시겠습니까?")
	if(ok){
		location.href='/account/logout.do';
	}
}

function goMyPage() {
		location.href='myPage.main.go';
}
