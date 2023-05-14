package com.tm.nmp.admin;

import java.util.List;

import com.tm.nmp.board.BoardOption;

public interface AdminMapper {

	int calcAllClubCount(BoardOption bo);

	List<ClubListView> getClubViewList(BoardOption bo);

	ClubListView getClubDetail(int id);

	List<ClubImageDTO> getClubImages(int club_id);
	
	ClubImageDTO getRecentClubImage(int id);

	int insertClubInfo(ClubDTO c);

	void insertClubImages(List<ClubImageDTO> images);

	int insertOneClubImage(ClubImageDTO ci);

	int updateClubImage(ClubImageDTO ci);

}
