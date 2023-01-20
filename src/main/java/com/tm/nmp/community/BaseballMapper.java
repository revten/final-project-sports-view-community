package com.tm.nmp.community;

import java.util.List;

public interface BaseballMapper {

	int getAllBaseballPostCount(BaseballSelector bsSel);
	
	List<CM_BS_TITLE> getAllbaseball(BaseballSelector bsSel);

	CM_BS_TITLE getBaseball(CM_BS_TITLE bs);

	int deleteBaseball(CM_BS_TITLE bs);

	int updateBaseball(CM_BS_TITLE bs);

	int insertBaseball(CM_BS_TITLE bs);



}
