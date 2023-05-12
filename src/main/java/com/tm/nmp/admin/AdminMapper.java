package com.tm.nmp.admin;

import java.util.List;

import com.tm.nmp.board.BoardOption;

public interface AdminMapper {

	int calcAllClubCount(BoardOption bo);
	
	List<ClubListView> getClubViewList(BoardOption bo);
	
	int uploadImage(ClubImageDTO ci);

	int regClubInfo(ClubDTO c);

	void insertClubImages(List<ClubImageDTO> images);
	
	ClubListView getClubDetail(int id);

	List<ClubImageDTO> getClubImages(int id);
}
