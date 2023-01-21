package com.tm.nmp.board;

import java.util.List;

public interface FreeMapper {

	int calcAllPostCOunt(BoardSelector bSel);

	List<PostVO> getAllPost(BoardSelector search);

	PostVO getPost(PostVO p);
	List<ReplyVO> getAllReplies(PostVO p);

	int regPost(PostVO p);

	int deletePost(PostVO p);

	int updatePost(PostVO p);

	int regReply(ReplyVO rp);

	int deleteReply(ReplyVO rp);

	int updateReply(ReplyVO rp);
	
	
	
	
}
