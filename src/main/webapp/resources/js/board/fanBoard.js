function likeCheck(likeCheck, like_post, member_id) {
	let likeCheck = likeCheck;
	let like_post = like_post;
	let like_member = member_id;

	if (likeCheck > 0) {
		console.log(likeCheck + "좋아요 누름");
		$('#LikeBtn').html("좋아요 취소");
		$('#LikeBtn').click(function() {
			$.ajax({
				type : 'post',
				url : "like.down.do",
				contentType : 'application/json',
				data : JSON.stringify({
					"like_post" : like_post,
					"like_member" : like_member
				}),
				success : function(data) {
					alert('취소 성공');
				}
			})// 아작스 끝
		})

	} else {
		console.log(likeCheck + "좋아요 안누름")
		console.log(like_post);
		console.log(like_member);
		$('#LikeBtn').click(function() {
			$.ajax({
				type : 'post',
				url : "like.up.do",
				contentType : 'application/json',
				data : JSON.stringify({
					"like_post" : like_post,
					"like_member" : like_member
				}),
				success : function(data) {
					alert('성공염');
				}
			})// 아작스 끝

		})
	}
}

function deletePost(n) {
	let ok = confirm("복구는 불가능합니다. 정말 삭제하시겠습니까?");
		if (ok) {
			location.href = "post.delete.do?post_id=" + n;
	}
}
