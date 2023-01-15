package com.tm.nmp.games;

import java.util.List;

import com.tm.nmp.admin.AnswerDTO;

public interface GamesMapper {

	List<TotoDTO> getTotoAll();

	TotoDTO getToto(TotoDTO tt);

	int updateToto(TotoDTO tt);

	int deleteToto(TotoDTO tt);

	int insertToto(TotoDTO tt);



}
