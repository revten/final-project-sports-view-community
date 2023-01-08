
function modi(){
	let ok = confirm("정말 수정 하시겠습니까?");
	if (ok) {
		location.href = "account.modify.do"
	}
}


function bye() {
	var ok = confirm("정말 탈퇴 하시겠습니까?");
	if (ok) {
		location.href = "account.delete.go";
	}
}

