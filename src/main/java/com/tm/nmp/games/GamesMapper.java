package com.tm.nmp.games;

import java.util.List;



public interface GamesMapper {

	int getAllTTPostCount(TotoSelector ttSel);

	public abstract List<TotoDTO> getTotoAll(TotoSelector ttSel);

	int updateToto(TotoDTO tt);

	int deleteToto(TotoDTO tt);

	int insertToto(TotoDTO tt);

	// 댓글
	
	TotoDTO getToto(TotoDTO tt);

	List<TotoComment> getAllcomment(TotoDTO tt);

	int writeComment(TotoComment ttc);

	int deleteComment(TotoComment ttc);

	int updateComment(TotoComment ttc);



}
