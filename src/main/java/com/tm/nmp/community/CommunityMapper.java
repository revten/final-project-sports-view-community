package com.tm.nmp.community;

import java.util.List;

public interface CommunityMapper {

	int getAllPostCount(CommunityDTO co);

	List<CommunityDTO> getPostList(CommunityDTO co);

	int writePost(CommunityDTO co);

	int getPostNum(CommunityDTO co);

	CommunityDTO postDetail(CommunityDTO co);

	int deletePost(CommunityDTO co);

	int updatePost(CommunityDTO co);

}
