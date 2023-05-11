// 이미지 미리보기
function imagePreview(event) {

	// 이벤트 대상자의 부모를 기준으로 움직이도록
	let uploadImage = event.target.parentNode;

	// 이미지 변경할때 이미지 계속 늘어나지 않도록 기존 이미지 삭제
	// 버튼 계속 늘어나지 않도록 기존 버튼 삭제
	let pre_img = $(uploadImage).find('img'); // find().val()로 하지 않는 것에 유의
	let pre_del = $(uploadImage).find('button'); 
	if ($(pre_img).length) {
		$(pre_img).remove();
		$(pre_del).remove();
	}

	let reader = new FileReader();
	reader.onload = function(event) {
		console.log(uploadImage);
		// <img> 만들어주기
		let newImg = document.createElement("img");
		uploadImage.appendChild(newImg);
		newImg.setAttribute("src", event.target.result);
		newImg.setAttribute("width", 200);
		newImg.setAttribute("class", "pre_img");

		// 미리보기 삭제 버튼 만들어주기 -> 버튼 클릭시 이미지, 파일명, 버튼도 다시 삭제됨
		let delImg = document.createElement("button")
		delImg.type = 'button';
		delImg.innerHTML = '미리보기 삭제';
		delImg.className = 'pre_del';
		delImg.onclick = function() {
			let img = $(this).parent().find('img');
			console.log("img", img);
			let input = $(this).parent().find('input');
			console.log("input", input);

			$(img).remove();
			$(input).val('');
			$(this).remove();
		};
		uploadImage.appendChild(delImg);
	};
	reader.readAsDataURL(event.target.files[0]);
}

// 이미지 업로드
function uploadClubImg(a) {

	let formData = new FormData(); // FormData 객체 생성

	const imageInput = $("#image-file")[0];
	console.log("imageInput: ", imageInput.files)
	formData.append("file_name", imageInput.files[0]);

	console.log("club_id : ", $(".admin__clubCode").val());
	formData.append("club_id", $(".admin__clubCode").val());

	console.log("sort : ", a);
	formData.append("sort", a);

	$.ajax({
		url : 'adminClub.uploadImage.do',
		type : 'POST',
		data : formData,
		// processData,contentType은 반드시 false여야 전송됨
		// processData 설정 : false 값을 해야 form data로 인식
		enctype : 'multipart/form-data',
		processData : false,
		contentType : false,
	}).done(function(response) {
		console.log("response : ", JSON.stringify(response));
		$("#image-file").val('');
		$(".pre_img").empty();
		alert('업로드 완료');
	}).fail(function(data) {
		if (data.responseCode)
			console.log(data.responseCode);
	});
}
