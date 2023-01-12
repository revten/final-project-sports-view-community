package com.tm.nmp.community;

import java.util.List;

public interface ReviewMapper {
	
	int getReviewPostCount(CM_RV_TITLE rv);

	List<CM_RV_TITLE> getReviewPostList(CM_RV_TITLE rv);

	CM_RV_TITLE reviewPostDetail(CM_RV_TITLE rv);

	int writeReviewPost(CM_RV_TITLE rv);

	int getReviewPostNum(CM_RV_TITLE rv);

	int deleteReviewPost(CM_RV_TITLE rv);

	int updateReviewPost(CM_RV_TITLE rv);
}
