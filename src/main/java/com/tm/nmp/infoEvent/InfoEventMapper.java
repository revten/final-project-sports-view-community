package com.tm.nmp.infoEvent;

import java.util.List;



public interface InfoEventMapper {
	
	int getAllPostCount(TeamEventSelector ttSel);

	List<TeamEventDTO> showAllTeamEvent();

	TeamEventDTO showTeamEvent(TeamEventDTO te);

	int insertTeamEvent(TeamEventDTO te);

	int updateTeamEvent(TeamEventDTO te);

	int deleteTeamEvent(TeamEventDTO te);

	List<TeamEventDTO> showTeamEventBySearch(TeamEventDTO te);


	List<TeamEventComment> getAllcomment(TeamEventDTO te);





}
