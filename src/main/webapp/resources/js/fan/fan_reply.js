$(function() {
	

	
// 댓글 등록
$('.reply__reg-btn').click(function() {
		// DAO를 고치지 않고 하려고 했으나, DAO고쳐서 조회까지 해오기 때문에 이건 이제 필요없음. 참고용으로 남겨둠.
		// 등록하려면 token, reply_board, reply_post, reply_content는 필요하니 있어야함
// let reply_writterNick= $("#reply_writterNick").val();
		let token = $('.reply__token').val();
		let reply_board = $('#reply_board').val();
		let reply_post = $('#reply_post').val();
		let reply_content = $('.reply__content-reg').val();
// let d = new Date();
// let regDate = d.toLocaleString();
		
// console.log(reply_writterNick);
// console.log(regDate);
		console.log(token);		
		console.log(reply_post);		
		console.log(reply_board);		
		console.log(reply_content);
		
		$.ajax({
			url : "fanReply.reg.do",
			// 리플을 등록할때 DAO에 받아오려고 하는것
				// 토큰의 새정보, 성공여부(0 혹은 1), ReplyVO를 담은 ResultVO이다
			type : 'post',
			dataType : 'json',
			data : {
				"token" : token,
				"reply_board" : reply_board,
				"reply_post" : reply_post,
				"reply_content" : reply_content
			},

			success : function(data) {
				console.log('통신 성공');
				console.log(data);
				console.log(JSON.stringify(data)); // 받아온 데이터 찍어보기
				
				// 새로 받아온 토큰으로 교체해준다
				$('.reply__token').val(data.token); 
				
				// 성공시 result는 1
				let result = (data.result)*1;
				
				// 받아온 resultVO=data의 replyVO를 담아준다
				let reply = data.replyVO;
				console.log(JSON.stringify(reply)); 
//				<fmt:formatDate value="${reply.reply_reg_date }" type="both" dateStyle="short" timeStyle="short" />
				if(result > 0) {
					let replyContent = `
					<div class="reply__div">
						<p>
						<hr>
						<input class="reply__id" type="hidden" name="reply_id" value="${reply.reply_id}" >
						<div class="sortInfo">
							<div class="reply_writterNick"><b>${reply.member_nick}</b></div>
							<div class="reply__date">
								<fmt:formatDate value="${reply.reply_reg_date}" type="both" dateStyle="short" timeStyle="short" />						
								<button class="reply__update-btn">수정</button>
								<button class="reply__delete-btn">삭제</button>
								<br>
							</div>						
						</div>						
						<div class="reply__content">${reply.reply_content}</div>
					</div>`;
					
				$('.reply__list').prepend(replyContent);

				} else {
					console.log('댓글 등록 실패');
				}
				$('.reply__content').val('');
			},
			error : function(){
			alert('통신 실패');
			}
		});
	});

// ---------------------------------------------------------

// 댓글 삭제
$(document).on('click', '.reply__delete-btn', function() {
	
	let reply__div = $(this).parent().parent().parent();
	
	
	let reply_id = 	$(reply__div).find('.reply__id').val();
	alert(reply_id);
	
	console.log(reply_id);	
	
	$.ajax({
		url : "fanReply.delete.do",
		type : 'get',
		dataType : 'json',
		data : {
			"reply_id" : reply_id
		},

		success : function(data) {
			console.log('통신 성공');
			console.log(data);
			if(data > 0) {
				reply__div.remove();
			} else {
				console.log('댓글 삭제 실패');
			}
		},
		error : function(){
		alert('통신 실패');
		}
	});
});

$(document).on('click', '.reply__update-btn', function() {
	
	let reply__div = $(this).parent().parent();
	let reply_id = 	$(reply__div).find('.reply__id').val();
	alert(reply_id);
	let reply_content = $(reply__div).find('.reply__content');
	alert(reply_content);
	
	$(reply_content).html(`<input class="reply__content-reg" name="reply__content" maxlength="80" autocomplete="off" required>`);
	// 
	
});


});