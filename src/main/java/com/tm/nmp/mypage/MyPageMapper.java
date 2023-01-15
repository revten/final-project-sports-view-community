package com.tm.nmp.mypage;

import java.util.List;

public interface MyPageMapper {

	List<MyPostDTO> getMyPostAll();

	List<AskDTO> getAskAll();

	MyPostDTO getMyPost(MyPostDTO mp);

	AskDTO getAsk(AskDTO ask);

	int updateMyPost(MyPostDTO mp);

	int deleteMyPost(MyPostDTO mp);

	int updateAsk(AskDTO ask);

	int deleteAsk(AskDTO ask);
	
	

}
