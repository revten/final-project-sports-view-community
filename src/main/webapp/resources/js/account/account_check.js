// javaScript
function searchIdForm() {
	let nameInput = document.searchIdForm.ac_name;
	let emailInput = documnet.searchIdForm.ac_email;

	if (isEmpty(nameInput)) {
		alert("이름을 입력해주세요.");
		nameInput.focus();
		nameInput.value = "";
		return false;
	}
	if (isEmpty(emailInput)) {
		alert('이메일을 입력해주세요.');
		emailInput.focus();
		emailInput.value = "";
		return false;
	}
	return true;
}

function regUserId(){
	let email = $('#search_user_email').val();
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
}

function searchPw(){
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
}

// jQuery

//일반 회원 이메일 인증 절차
$(function() {
	$('#user_email_check').click(function() {
		let email = $('#search_user_email').val();
		console.log(email);
		let checkNum = $('#email_num');

		$.ajax({
			url : "user.email.check.do",
			type : "GET",
			dataType : "text",
			data : {
				"user_email" : email
			},
			success : function(data) {
				checkNum.attr('disabled', false);
				$('#valid').val(data);
				alert('인증번호가 전송되었습니다.')
			}
		});
	});
});

$(function() {
	$('#email_check').click(function() {
		let email = $('#search_ac_email').val();
		console.log(email);
		let checkNum = $('#email_num');

		$.ajax({
			url : "email.check.do",
			type : "GET",
			dataType : "text",
			data : {
				"ac_email" : email
			},
			success : function(data) {
				checkNum.attr('disabled', false);
				$('#valid').val(data);
				alert('인증번호가 전송되었습니다.')
			}
		});
	});
});

function changePw() {
	let pw = $('#change-pw-pw').val();
	let pwConfirm = $('#change-pw-pwConfirm').val();

	if (pw != pwConfirm) {
		alert('비밀번호가 다릅니다.');
		return false;
	}
	return true;
}

//------------------------------------------------
//유효성검사할때 사용할 라이브러리

//<input>을 넣었을때
//비어있으면 true, 글자가 들어있으면 false
function isEmpty(input) {
	return (!input.value);
}

//<input>, 글자수를 넣었을때
//글자수가 모자라면 true, 괜찮으면 false
function lessThan(input, len) {
	return (input.value.length < len);
}

//<input>을 넣었을때
//영어, 숫자이외의 것이 있으면 true, 아니면 false
function containsHS(input) {
	var txt = "1234567890qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM@_.";
	for (var i = 0; i < input.value.length; i++) {
		if (txt.indexOf(input.value[i]) == -1) {
			return true;
		}
	}
	return false;
}

//<input> 두 개 넣었을때
//두 개 내용이 다르면 true, 같으면 false
function notEquals(input1, input2) {
	return (input1.value != input2.value);
}

//<input>, 문자열세트를 넣었을때
//문자열세트에 포함된게 없으면 true, 있으면 false
function notContains(input, set) {
	for (var i = 0; i < set.length; i++) {
		if (input.value.indexOf(set[i]) != -1) {
			return false;
		}
	}
	return true;
}

//<input>을 넣으면
//거기에 숫자 아닌거 있으면 true, 숫자만 있으면 false
function isNotNumber(input) {
	return isNaN(input.value);
}

//<input>, 확장자를 넣으면
//그 파일이 아니면 true, 맞으면 false
function isNotType(input, type){
	type = "." + type;
	return (input.value.indexOf(type) == -1);
}
