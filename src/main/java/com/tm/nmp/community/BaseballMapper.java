package com.tm.nmp.community;

import java.util.List;

public interface BaseballMapper {

	List<CM_BS_TITLE> getAllbaseball(CM_BS_TITLE bs);

	CM_BS_TITLE getBaseball(CM_BS_TITLE bs);

	int deleteBaseball(CM_BS_TITLE bs);

	int updateBaseball(CM_BS_TITLE bs);

	int insertBaseball(CM_BS_TITLE bs);

}
