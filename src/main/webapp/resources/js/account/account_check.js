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

function checkId() {
	var id = $('#idInput').val(); // id값이 "idInput"인 입력란의 값을 저장
	$.ajax({
		url : 'account.id.check', // Controller에서 요청 받을 주소
		type : 'POST', // POST 방식으로 전달
		data : {
			member_id : id
		},
		success : function(cnt) { // 컨트롤러에서 넘어온 cnt값을 받는다
			if (cnt == 0) { // cnt가 1이 아니면(=0일 경우) -> 사용 가능한 아이디
				$('.id_ok').css("display", "inline-block");
				$('.id_already').css("display", "none");
				$('#idConfirm').val('1');
			} else { // cnt가 1일 경우 -> 이미 존재하는 아이디
				$('.id_already').css("display", "inline-block");
				$('.id_ok').css("display", "none");
				$('#idConfirm').val('0');
			}
		},
		error : function() {
			alert("에러입니다");
		}
	});
};

function checkReg() {
	$("select[name=club_id]").change(function() {
		console.log($(this).val()); // value값 가져오기
		console.log($("select[name=club_id] option:selected").text()); // text값
		// 가져오기
	});

	let id_input = $("#idInput");
	let id = $("#idInput").val();
	let pw_input = $("#pwInput");
	let pw = $("#pwInput").val();
	let nick_input = $("#member_nick");
	let nick = $("#member_nick").val();
	let email_input = $("#search_member_email");
	let email = $("#search_member_email").val();

	let club = $("select[name=club_id] option:selected").text(); // text값
	let club_val = $("select[name=club_id] option:selected").val(); // 가져오기
	console.log(club);
	console.log(club_val);

	if (!chkID(id)) {
		alert("아이디 형식을 확인해주세요");
		id_input.focus();
		id_input.value = "";
		return false;
	}

	if (!chkPW(pw)) {
		alert("비밀번호 형식을 확인해주세요");
		pw_input.focus();
		pw_input.value = "";
		return false;
	}

	if(nick == '' || nick == undefined || nick == null || nick == 'null' ){
		alert("닉네임을 입력해주세요");
		nick_input.focus();
		return false;
	}
	
	if (!checkEmail(email)) {
		alert("이메일 형식이 잘못되었습니다");
		email_input.focus();
		email_input.value = "";
		return false;
	}
	
	let inputNum = $('#email_num').val();
	
	if (inputNum == '' || nick == undefined || nick == null || nick == 'null' ) {
		alert("이메일 인증을 완료해주세요");
		return false;
	}
	
	if (inputNum == $('#valid').val()) {
		alert('인증 번호가 성공적으로 인증되었습니다.');
	} else {
		alert('인증 번호가 일치하지 않습니다.');
		return false;
	}
	
	if (club_val == 0) {
		alert("좋아하는 구단을 선택해주세요");
		return false;
	}


	/*if ($("#idConfirm").val() == 1) {
		return true;
	} else {
		alert("아이디 중복여부를 확인해주세요");
		id.focus();
		return false;
	}*/
	
	return true;

};

$(function() {
	$("#pwInput")
			.keyup(
					function() {
						$("#pwConfirm").html("");

						if (($('#pwInput').val() != "" && ($("#pwInput2").val() == ""))
								|| ($('#pwInput').val() == "" && ($("#pwInput2")
										.val() != ""))) {
							$("#reg").attr("disabled", true);
						}

						// 두 input 값이 없을 경우 다시 사용 가능하도록
						if ($("#pwInput").val() == ""
								&& ($("#pwInput2").val() == "")) {
							$("#reg").attr("disabled", false);
						}

					});

	$("#pwInput2").keyup(function() {
		if ($("#pwInput").val() != $("#pwInput2").val()) {
			$("#pwConfirm").html("비밀번호 일치하지 않음<br><br>");
			$("#pwConfirm").css("color", "#6A82FB")
			$("#reg").attr("disabled", true);
		} else {
			$("#pwConfirm").html("비밀번호 일치함<br><br>");
			$("#pwConfirm").css("color", "#008000");
			$("#reg").attr("disabled", false);
		}
	});
});

$(function() {
	$('#member_email_check').click(function() {
		let email = $('#search_member_email').val();
		console.log(email);
		let checkNum = $('#email_num');

		$.ajax({
			url : "member.email.check.do",
			type : "GET",
			dataType : "text",
			data : {
				"member_email" : email
			},
			success : function(data) {
				checkNum.attr('disabled', false);
				$('#valid').val(data);
				alert('인증번호가 전송되었습니다.')
			}
		});
	});
});

/*
 * $(function() { $('#email_check').click(function() { let email =
 * $('#search_ac_email').val(); console.log(email); let checkNum =
 * $('#email_num');
 * 
 * $.ajax({ url : "email.check.do", type : "GET", dataType : "text", data : {
 * "ac_email" : email }, success : function(data) { checkNum.attr('disabled',
 * false); $('#valid').val(data); alert('인증번호가 전송되었습니다.') } }); }); });
 */

function changePw() {
	let pw = $('#change-pw-pw').val();
	let pwConfirm = $('#change-pw-pwConfirm').val();

	if (pw != pwConfirm) {
		alert('비밀번호가 다릅니다.');
		return false;
	}
	return true;
}

function checkEmail(str) {
	let reg_email = /(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))/;
	if (!reg_email.test(str)) {
		return false;
	} else {
		return true;
	}
}

function chkID(str) {
	let reg_id = /^(?=.*[a-zA-Z])(?=.*[0-9]).{5,12}$/;

	if (!reg_id.test(str)) {
		return false;
	} else {
		return true;
	}
}

function chkPW(str) {
	let reg_pw = /^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$ %^&*-]).{7,12}$/;

	if (!reg_pw.test(str)) {
		return false;
	} else {
		return true;
	}
}

// ------------------------------------------------
// 유효성검사할때 사용할 라이브러리

// <input>을 넣었을때
// 비어있으면 true, 글자가 들어있으면 false
function isEmpty(input) {
	return (!input.value);
}

// <input>, 글자수를 넣었을때
// 글자수가 모자라면 true, 괜찮으면 false
function lessThan(input, len) {
	return (input.value.length < len);
}

// <input>을 넣었을때
// 영어, 숫자이외의 것이 있으면 true, 아니면 false
function containsHS(input) {
	var txt = "1234567890qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM@_.";
	for (var i = 0; i < input.value.length; i++) {
		if (txt.indexOf(input.value[i]) == -1) {
			return true;
		}
	}
	return false;
}

// <input> 두 개 넣었을때
// 두 개 내용이 다르면 true, 같으면 false
function notEquals(input1, input2) {
	return (input1.value != input2.value);
}

// <input>, 문자열세트를 넣었을때
// 문자열세트에 포함된게 없으면 true, 있으면 false
function notContains(input, set) {
	for (var i = 0; i < set.length; i++) {
		if (input.value.indexOf(set[i]) != -1) {
			return false;
		}
	}
	return true;
}

// <input>을 넣으면
// 거기에 숫자 아닌거 있으면 true, 숫자만 있으면 false
function isNotNumber(input) {
	return isNaN(input.value);
}

// <input>, 확장자를 넣으면
// 그 파일이 아니면 true, 맞으면 false
function isNotType(input, type) {
	type = "." + type;
	return (input.value.indexOf(type) == -1);
}
