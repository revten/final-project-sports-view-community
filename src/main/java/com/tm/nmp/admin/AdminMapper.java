package com.tm.nmp.admin;

import java.util.List;

import com.tm.nmp.board.BoardOption;

public interface AdminMapper {

	int regClubInfo(ClubDTO c);

	List<ClubListView> getClubViewList(BoardOption bo);

	int calcAllClubCount(BoardOption bo);

}
