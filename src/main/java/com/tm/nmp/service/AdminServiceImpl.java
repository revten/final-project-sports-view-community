package com.tm.nmp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tm.nmp.board.BoardOption;
import com.tm.nmp.dao.AdminDAO;
import com.tm.nmp.model.ClubDTO;
import com.tm.nmp.model.ClubImageDTO;
import com.tm.nmp.model.ClubListView;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private AdminDAO adminDAO;

	// 총 게시글 수
	@Override
	public int calcAllClubCount(BoardOption boardOption) {
		return adminDAO.calcAllClubCount(boardOption);
	}
	
	@Override
	public List<ClubListView> getClubViewList(BoardOption boardOption) {
		return adminDAO.getClubViewList(boardOption);
	}
	
	// 구단 정보 조회
	@Override
	public ClubListView getClubDetail(int id) {
		return adminDAO.getClubDetail(id);
	} 
	
	@Override
	public List<ClubImageDTO> getClubImages(int id) {
		return adminDAO.getClubImages(id);
	}
	
	// 구단등록하기
	@Override
	public int insertClubInfo(ClubDTO club) {
		return adminDAO.insertClubInfo(club);
	}

	@Override
	public void insertClubImages(List<ClubImageDTO> images) {
		adminDAO.insertClubImages(images);
	}
	
	// 구단 이미지 한장 등록후 조회
	@Override
	public int insertOneClubImage(ClubImageDTO ci) {
		return adminDAO.insertOneClubImage(ci);
	}
	
	@Override
	public ClubImageDTO getRecentClubImage() {
		return adminDAO.getRecentClubImage();
	}

	// 구단 이미지 수정
	@Override
	public int updateClubImage(ClubImageDTO ci) {
		return adminDAO.updateClubImage(ci);
	}
	
}
