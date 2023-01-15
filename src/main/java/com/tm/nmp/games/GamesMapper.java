package com.tm.nmp.games;

import java.util.List;

public interface GamesMapper {

	List<TotoDTO> getTotoAll();

	TotoDTO getToto(TotoDTO tt);

	int updateToto(TotoDTO tt);

	int deleteToto(TotoDTO tt);


}
