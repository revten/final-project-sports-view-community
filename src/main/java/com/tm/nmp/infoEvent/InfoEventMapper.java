package com.tm.nmp.infoEvent;

import java.util.List;

import com.tm.nmp.mypage.MyPostDTO;

public interface InfoEventMapper {

	List<TeamEventDTO> showAllTeamEvent();

	TeamEventDTO showTeamEvent(TeamEventDTO te);

	int insertTeamEvent(TeamEventDTO te);

	int updateTeamEvent(TeamEventDTO te);

	int deleteTeamEvent(TeamEventDTO te);

	List<TeamEventDTO> showTeamEventBySearch(TeamEventDTO te);

	int getTeamEventPostCount(TeamEventDTO te);



}
