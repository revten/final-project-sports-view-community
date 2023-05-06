function setThumbnail(event) {
	var uploadWrap = event.target.parentNode;
	// 이벤트 대상자의 부모
	var reader = new FileReader();

	reader.onload = function(event) {
		console.log(uploadWrap);
		var newImg = document.createElement("img");
		uploadWrap.appendChild(newImg);
		newImg.setAttribute("src", event.target.result);
		newImg.setAttribute("width", 200);
		newImg.setAttribute("class", "pre_img");
	};
	reader.readAsDataURL(event.target.files[0]);
}

function uploadClubImg(){
	
	let club_id = $(".admin__clubCode").name();
	console.log(club_id);
	let sort = 
	console.log(sort);
	$.ajax({
		url: ,
		data: {
			"club_id" = club_id,
			"sort" = club_id
		},
		type: ""
	}).done(function(res) {
		
		
	})
	return false;
	
	
}

