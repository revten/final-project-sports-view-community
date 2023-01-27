package com.tm.nmp.board;

import java.util.List;

public interface BoardMapper {

	int calcAllPostCount(BoardSelector bSel);

	List<PostVO> getAllPost(BoardSelector search);

	PostVO getPost(PostVO p);
	List<ReplyVO> getAllReplies(PostVO p);

	int regPost(PostVO p);

	int updatePost(PostVO p);

	int deletePost(PostVO p);

	int regReply(ReplyVO rp);

	int deleteReply(ReplyVO rp);

	int updateReply(ReplyVO rp);

	int likeCheck(LikeVO lk);

	int likeUp(LikeVO lk);

	int likeDown(LikeVO lk);


//	int getReccomed(Reccomand rec);

	int postCountUpdate(PostVO p);
	
	
	
	

}
