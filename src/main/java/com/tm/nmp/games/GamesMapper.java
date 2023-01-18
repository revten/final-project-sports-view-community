package com.tm.nmp.games;

import java.util.List;



public interface GamesMapper {

	int getAllTotoPostCount(TotoSelector ttSel);

	public abstract List<TotoDTO> getTotoAll(TotoSelector ttSel);

	int updateToto(TotoDTO tt);

	int deleteToto(TotoDTO tt);

	int insertToto(TotoDTO tt);

	// 댓글
	
	TotoDTO getToto(TotoDTO tt);

	List<TotoComment> getAllTotocomment(TotoDTO tt);

	int writeTotoComment(TotoComment ttc);

	int deleteTotoComment(TotoComment ttc);

	int updateTotoComment(TotoComment ttc);



}
