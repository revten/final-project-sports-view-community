package com.tm.nmp.admin;

import java.util.List;

import com.tm.nmp.board.BoardOption;

public interface AdminMapper {

	int regClubInfo(ClubDTO c);

	int calcAllClubCount(String field, String search);

	List<ClubView> getClubViewList(BoardOption bo);

}
