package com.tm.nmp.community;

import java.util.List;

public interface VolleyballMapper {

	List<CM_VL_TITLE> getAllVolleyball(CM_VL_TITLE vL);

	CM_VL_TITLE getVolleyball(CM_VL_TITLE vL);

	int deleteVolleyball(CM_VL_TITLE vL);

	int updateVolleyball(CM_VL_TITLE vL);

	int insertVolleyball(CM_VL_TITLE vL);

}
