package com.tm.nmp.mypage;

import java.util.List;

public interface MyPageMapper {

	List<MyPostDTO> getMyPostAll();

	List<AskDTO> getAskAll();

	MyPostDTO getMyPost(MyPostDTO mp);
	
	

}
