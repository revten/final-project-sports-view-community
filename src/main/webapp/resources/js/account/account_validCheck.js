/**
 * 
 */
// <input>이 한글/특수문자/대문자 포함하면 true(=문제가 있는걸로 만들겠다), 아니면 false
// 허용하고 싶은것만
function idContain(id) {
	let ok = "1234567890qwertyuiopasdfghjklzxcvbnm";
	for (let i = 0; i < id.length; i++) {
		// return ok.indexOf(input.value[i]) == -1;
		if (ok.indexOf(id[i]) == -1) {
			return true;
		}
	}
}

// 글자 넣었을때 -> 글자수가 모자라면 true, 괜찮으면 false
function lessThan(id, length) {
	return id.length < length;
}

function moreThan(id, length) {
	return id.length > length;
}

// 비밀번호 양식 유효성 검사, 정규식 사용
function chkPwd(str) {
	let reg_pwd = /^(?=.*?[a-zA-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$ %^&*-]).{7,20}$/;

	if (!reg_pwd.test(str)) {
		return false;
	} else {
		return true;
	}
}

// 이메일 양식 체크
function checkEmail(str) {
	let reg_email = /(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))/;
	if (!reg_email.test(str)) {
		return false;
	} else {
		return true;
	}
}

function changePwd() {
	let pwd = $('#change-pw-pw').val();
	let pwdConfirm = $('#change-pw-pwConfirm').val();

	if (pwd != pwdConfirm) {
		alert('비밀번호가 다릅니다.');
		return false;
	}
	return true;
}


// ------------------------------------------------
// 유효성검사할때 사용할 라이브러리

// <input>을 넣었을때
// 비어있으면 true, 글자가 들어있으면 false
function isEmpty(input) {
	return (!input.value);
}


// <input>을 넣었을때
// 영어, 숫자이외의 것이 있으면 true, 아니면 false
function containsHS(input) {
	let txt = "1234567890qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM@_.";
	for (let i = 0; i < input.value.length; i++) {
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
	for (let i = 0; i < set.length; i++) {
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