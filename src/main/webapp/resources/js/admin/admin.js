// 이미지 미리보기
function setThumbnail(event) {
	// 이벤트 대상자의 부모
	let uploadWrap = event.target.parentNode;

	let reader = new FileReader();
	reader.onload = function(event) {
		console.log(uploadWrap.files);
		let newImg = document.createElement("img");
		uploadWrap.appendChild(newImg);
		newImg.setAttribute("src", event.target.result);
		newImg.setAttribute("width", 200);
		newImg.setAttribute("class", "pre_img");
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
		url : "adminClub.uploadImage.do",
		type : "POST",
		enctype : 'multipart/form-data',
		data : formData,
		processData : false, // 프로세스 데이터 설정 : false 값을 해야 form data로 인식
		contentType : false
	}).done(function(response) {
		console.log("response : ", response);
		$("#image-file").val('');
		$(".pre_img").empty();		
		alert('업로드 완료');
	}).fail(function(data) {
		if (data.responseCode)
			console.log(data.responseCode);
	});
}
