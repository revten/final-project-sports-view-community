package com.tm.nmp.community;

import java.util.List;

public interface BasketballMapper {

	List<CM_BK_TITLE> getAllBasketball(CM_BK_TITLE bK);

	CM_BK_TITLE getBasketball(CM_BK_TITLE bK);

	int deleteBasketball(CM_BK_TITLE bK);

	int updateBasketball(CM_BK_TITLE bK);

	int insertBasketball(CM_BK_TITLE bK);

}
