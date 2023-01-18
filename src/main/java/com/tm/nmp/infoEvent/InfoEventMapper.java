package com.tm.nmp.infoEvent;

import java.util.List;



public interface InfoEventMapper {
	
	int getAllTEPostCount(ClubEventSelector ttSel);

	List<ClubEventDTO> showAllClubEvent();

	ClubEventDTO showClubEvent(ClubEventDTO te);

	int insertClubEvent(ClubEventDTO te);

	int updateClubEvent(ClubEventDTO te);

	int deleteClubEvent(ClubEventDTO te);

	List<ClubEventDTO> showClubEventBySearch(ClubEventDTO te);


	List<ClubEventComment> getAllcomment(ClubEventDTO te);

	int writeClubEventComment(ClubEventComment tec);

	int deleteClubEventComment(ClubEventComment tec);

	int updateClubEventComment(ClubEventComment tec);





}
