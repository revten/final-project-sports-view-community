package com.tm.nmp.mapper;

import java.util.List;

import com.tm.nmp.board.BoardOption;
import com.tm.nmp.model.ClubDTO;
import com.tm.nmp.model.ClubImageDTO;
import com.tm.nmp.model.ClubListView;

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
