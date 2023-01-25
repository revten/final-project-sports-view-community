function checkProfile() {
	
	let pw_input = $("#pwInput");
	let pw = $("#pwInput").val();
	let nick_input = $("#member_nick");
	let nick = $("#member_nick").val();
	
	let club = $("select[name=club_id] option:selected").text(); // text값
	let club_val = $("select[name=club_id] option:selected").val(); // 가져오기
	console.log(club);
	console.log(club_val);
	
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

	if (club_val == 0) {
		alert("좋아하는 구단을 선택해주세요");
		return false;
	}
	
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

function chkPW(str) {
	let reg_pw = /^(?=.*?[a-zA-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$ %^&*-]).{7,12}$/;

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