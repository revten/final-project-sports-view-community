package com.tm.nmp.admin;

import java.util.List;

import com.tm.nmp.board.BoardOption;

public interface AdminMapper {

	int uploadImage(ClubImageDTO ci);

	int regClubInfo(ClubDTO c);

	void insertClubImages(List<ClubImageDTO> images);

	List<ClubListView> getClubViewList(BoardOption bo);

	int calcAllClubCount(BoardOption bo);


}
