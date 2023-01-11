package com.tm.nmp.community;

import java.util.List;

public interface WithGoMapper {
	int getWithGoPostCount(CM_WG_TITLE wg);

	List<CM_WG_TITLE> getWithGoPostList(CM_WG_TITLE wg);

	int writeWithGoPost(CM_WG_TITLE wg);

	int getWithGoPostNum(CM_WG_TITLE wg);

	CM_WG_TITLE WithGoPostDetail(CM_WG_TITLE wg);

	int deleteWithGoPost(CM_WG_TITLE wg);

	int updateWithGoPost(CM_WG_TITLE wg);
}
