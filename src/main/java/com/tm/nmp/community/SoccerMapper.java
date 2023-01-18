package com.tm.nmp.community;

import java.util.List;

public interface SoccerMapper {
	
	int getAllSCPostCount(SoccerSelector scSel);

	public abstract List<CM_SC_TITLE> getSoccerBoard(SoccerSelector scSel);

	CM_SC_TITLE getSoccer(CM_SC_TITLE sc);

	int deleteSoccer(CM_SC_TITLE sc);

	int updateSoccer(CM_SC_TITLE sc);

	int insertSoccer(CM_SC_TITLE sc);

	List<CM_SC_CommentDTO> getAllcomment(CM_SC_TITLE sc);
	
	int writeComment(CM_SC_CommentDTO scc);

	int deleteComment(CM_SC_CommentDTO scc);

	int updateComment(CM_SC_CommentDTO scc);






}
