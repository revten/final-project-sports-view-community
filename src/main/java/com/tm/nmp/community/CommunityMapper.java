package com.tm.nmp.community;

import java.util.List;

public interface CommunityMapper {

	int getAllpostCount(CommunityDTO co);

	List<CommunityDTO> getPostList(CommunityDTO co);

	int writePost(CommunityDTO co);

	int getPostNum(CommunityDTO co);

}
