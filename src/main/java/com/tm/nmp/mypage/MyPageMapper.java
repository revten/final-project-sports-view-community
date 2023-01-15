package com.tm.nmp.mypage;

import java.util.List;

import com.tm.nmp.games.TotoDTO;

public interface MyPageMapper {

	List<MyPostDTO> getMyPostAll();

	List<AskDTO> getAskAll();

	MyPostDTO getMyPost(MyPostDTO mp);

	AskDTO getAsk(AskDTO ask);

	int updateMyPost(MyPostDTO mp);

	int deleteMyPost(MyPostDTO mp);

	int updateAsk(AskDTO ask);

	int deleteAsk(AskDTO ask);

	int insertMyPost(MyPostDTO mp);

	int insertAsk(AskDTO ask);

	
	

}
