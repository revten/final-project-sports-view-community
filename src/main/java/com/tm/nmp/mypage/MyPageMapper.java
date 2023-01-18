package com.tm.nmp.mypage;

import java.util.List;


public interface MyPageMapper {
	
	int getAllMPPostCount(MyPostSelector mpSel);
	
	int getAllAskCount(AskSelector askSel);

	List<MyPostDTO> getMyPostAll(MyPostSelector mpSel);

	List<AskDTO> getaskAll(AskSelector askSel);

	MyPostDTO getMyPost(MyPostDTO mp);

	AskDTO getAsk(AskDTO ask);

	int updateMyPost(MyPostDTO mp);

	int deleteMyPost(MyPostDTO mp);

	int updateAsk(AskDTO ask);

	int deleteAsk(AskDTO ask);

	int insertMyPost(MyPostDTO mp);

	int insertAsk(AskDTO ask);

	List<AskComment> getAllAskComment(AskDTO ask);

	List<MyPostComment> getAllPostComment(MyPostDTO mp);

	int writeAskComment(AskComment askC);

	int deleteAskComment(AskComment askC);

	int updateAskComment(AskComment askC);

	int writeComment(MyPostComment mpc);

	int deleteComment(MyPostComment mpc);

	int updateComment(MyPostComment mpc);


	


	
	

}
