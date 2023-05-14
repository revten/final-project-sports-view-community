package com.tm.nmp.stadium;

import java.util.List;

import com.tm.nmp.admin.ClubImageDTO;

public interface StadiumMapper {
	
//	int calcAllClubCount(BoardOption bo);

//	List<ClubListView> getClubViewList(BoardOption bo);

//	ClubListView getClubDetail(int id);

	List<ClubImageDTO> getLogoBySports(int league_id);
	
//	ClubImageDTO getRecentClubImage(int id);

}
