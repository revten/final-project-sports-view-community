/*function searchPw() {
 let email = $('#search_ac_email').val();
 let inputNum = $(this).val();
 if (inputNum == $('#valid').val()) {
 alert('인증 번호가 성공적으로 인증되었습니다.');
 let id = $('#search_ac_id').val();
 console.log(email);
 console.log(inputNum);
 console.log(id);
 return true;
 } else {
 alert('인증 번호가 일치하지 않습니다.');
 return false;
 }

 }*/

// 아이디 양식 유효성 검사
function checkId() {
	
	let id = $("#idInput").val();
		
	if (lessThan(id, 5) || moreThan(id, 12) || idContain(id)) { 
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
	let id = $('#idInput').val(); // id값이 "idInput"인 입력란의 값을 저장
	
	if (lessThan(id, 5) || moreThan(id, 12) || idContain(id)) { 
		alert("아이디 양식 먼저 확인해주세요");
	} else {
		$.ajax({
			url : 'account.id.check', // Controller에서 요청 받을 주소
			type : 'POST', // POST 방식으로 전달
			data : {
				id : id
			},
			success : function(result) { // 컨트롤러에서 넘어온 cnt값을 받는다
				if (result == 0) { // cnt가 1이 아니면 -> 사용 가능한 아이디
					alert("사용가능한 아이디입니다");
					$('#idConfirm').val('1'); // 회원 가입 버튼을 눌렀을때, 중복확인을 했는지 -> 1이면 넘어가고 0이면 return false
				} else { // cnt가 1일 경우 -> 이미 존재하는 아이디
					alert("누군가 쓰고 있어요");
					$('#idConfirm').val('0');
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
	
	let pwd = $("#pwdInput").val();
		
	if (!chkPwd(pwd)) { 
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
	$("#pwdInput")
			.keyup(
					function() {
						$("#pwdConfirm").html("");
						if (($('#pwdInput').val() != "" && ($("#pwdInput2").val() == ""))
								|| ($('#pwdInput').val() == "" && ($("#pwdInput2")
										.val() != ""))) {
							$("#reg").attr("disabled", true);
						}
						// 두 input 값이 없을 경우 다시 사용 가능하도록
						if ($("#pwdInput").val() == ""
								&& ($("#pwdInput2").val() == "")) {
							$("#reg").attr("disabled", false);
						}
					});

	$("#pwdInput2").keyup(function() {
		if ($("#pwdInput").val() != $("#pwdInput2").val()) {
			$("#pwdConfirm").html("비밀번호 일치하지 않음<br><br>");
			$("#pwdConfirm").css("color", "#ff0000")
			$("#reg").attr("disabled", true);
		} else {
			$("#pwdConfirm").html("비밀번호 일치함<br><br>");
			$("#pwdConfirm").css("color", "#008000");
			$("#reg").attr("disabled", false);
		}
	});
});

// 이메일 인증
$(function() {
	$('#email_auth').click(function() {
		let email = $('#search_member_email').val();
		console.log(email);
		let checkNum = $('#checkNum');

		$.ajax({
			url : "email.auth.do",
			type : "GET",
			dataType : "text",
			data : {
				"email" : email
			},
			success : function(data) {
				console.log(data);
				checkNum.attr('disabled', false);
				$('#valid').val(data);
				alert('인증번호가 전송되었습니다.')
			}
		});
	});
});

// 닉네임 양식 + 이메일 양식 + 이메일 인증 여부 + 좋아하는 구단 선택 여부 + 아이디 중복 여부 확인
// 회원가입 버튼 눌렀을때, 전체적으로 다시 한번 검사
function checkReg() {
	$("select[name=club_id]").change(function() {
		console.log($(this).val()); // value값 가져오기
		console.log($("select[name=club_id] option:selected").text()); // text값
		// 가져오기
	});
	
	let id_input = $("#idInput");
	let id = $("#idInput").val;
	let pwd_input = $("#pwdInput");
	let pwd = $("#pwdInput").val();
	let nick_input = $("#member_nick");
	let nick = $("#member_nick").val();
	let email_input = $("#search_member_email");
	let email = $("#search_member_email").val();
	
	if (lessThan(id, 5) || moreThan(id, 13) || idContain(id)) { 
		alert("아이디 양식을 확인해주세요");
		id_input.focus();
		id_input.value = "";
		return false;
	}

	if (!chkPwd(pwd)) {
		alert("비밀번호 양식을 확인해주세요");
		pwd_input.focus();
		pwd_input.value = "";
		return false;
	}
	
	// 닉네임 양식
	if(nick == '' || nick == undefined || nick == null || nick == 'null' ){
		alert("닉네임을 입력해주세요");
		nick_input.focus();
		return false;
	}
	
	// 이메일 양식
	if (!checkEmail(email)) {
		alert("이메일 양식이 잘못되었습니다");
		email_input.focus();
		email_input.value = "";
		return false;
	}
	
	// 이메일 인증 여부
	let inputNum = $('#checkNum').val();
	if (inputNum == '' || nick == undefined || nick == null || nick == 'null' ) {
		alert("이메일 인증을 완료해주세요");
		return false;
	}
	
	// 이메일 인증번호
	if (inputNum == $('#valid').val()) {
		alert('성공적으로 인증되었습니다.');
	} else {
		alert('인증 번호가 일치하지 않습니다.');
		return false;
	}

	// 아이디 중복 여부 확인
	if ($("#idConfirm").val() == 1) {
		return true;
	} else {
		alert("아이디 중복여부를 확인해주세요");
		id.focus();
		return false;
	}
	return true;
};