function sendMessage(to) {
	var t = prompt("내용을 입력하세요",t);
	if (t != null && t.length > 0 && t.length < 180) {
		location.href = "message.send?message_to=" + to + "&message_txt=" + t;
	}
}

function deleteMessage(n) {
	var ok = confirm("삭제 하겠습니까?");
	if (ok) {
		location.href = "message.delete?message_id=" + n;
	}
}


