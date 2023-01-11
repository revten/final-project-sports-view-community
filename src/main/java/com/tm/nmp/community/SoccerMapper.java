package com.tm.nmp.community;

import java.util.List;

public interface SoccerMapper {

	List<CM_SC_TITLE> getSoccerBoard(CM_SC_TITLE sc);

	CM_SC_TITLE getSoccer(CM_SC_TITLE sc);

	int deleteSoccer(CM_SC_TITLE sc);

	int updateSoccer(CM_SC_TITLE sc);




}
