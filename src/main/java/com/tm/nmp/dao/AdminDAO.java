package com.tm.nmp.dao;

import java.util.List;

import com.tm.nmp.board.BoardOption;
import com.tm.nmp.model.ClubDTO;
import com.tm.nmp.model.ClubImageDTO;
import com.tm.nmp.model.ClubListView;

public interface AdminDAO {

	// 총 게시글 수
	int calcAllClubCount(BoardOption boardOption);
	
	List<ClubListView> getClubViewList(BoardOption boardOption);
	
	// 구단 정보 조회
	ClubListView getClubDetail(int id);
	
	List<ClubImageDTO> getClubImages(int id);
	
	// 구단등록하기
	int insertClubInfo(ClubDTO club);

	void insertClubImages(List<ClubImageDTO> images);
	
	// 구단 이미지 한장 등록후 조회
	int insertOneClubImage(ClubImageDTO ci);

	ClubImageDTO getRecentClubImage();
	
	// 구단 이미지 수정
	int updateClubImage(ClubImageDTO ci);
}
