package com.tm.nmp.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tm.nmp.board.BoardOption;
import com.tm.nmp.model.ClubDTO;
import com.tm.nmp.model.ClubImageDTO;
import com.tm.nmp.model.ClubListView;

@Repository //AdminDAO 객체 생성
public class AdminDAOImpl implements AdminDAO {
	
	@Autowired // MyBatis 연결
	private SqlSessionTemplate sst;
	
	// 총 게시글 수
	@Override
	public int calcAllClubCount(BoardOption boardOption) {
		return sst.selectOne("AdminMapper.calcAllClubCount", boardOption);
	}
	
	@Override
	public List<ClubListView> getClubViewList(BoardOption boardOption) {
		return sst.selectList("AdminMapper.getClubViewList", boardOption);
	}
	
	// 구단 정보 조회
	@Override
	public ClubListView getClubDetail(int id) {
		return sst.selectOne("AdminMapper.getClubDetail", id);
	}
	
	@Override
	public List<ClubImageDTO> getClubImages(int id) {
		return sst.selectList("AdminMapper.getClubImages", id);
	}
	
	// 구단등록하기
	@Override
	public int insertClubInfo(ClubDTO club) {
		return sst.insert("AdminMapper.insertClubInfo", club);
	}

	@Override
	public void insertClubImages(List<ClubImageDTO> images) {
		sst.insert("AdminMapper.insertClubImages", images);
	}
	
	// 구단 이미지 한장 등록후 조회
	@Override
	public int insertOneClubImage(ClubImageDTO ci) {
		return sst.insert("AdminMapper.insertOneClubImage", ci);
	}
	
	@Override
	public ClubImageDTO getRecentClubImage() {
		return sst.selectOne("AdminMapper.getRecentClubImage");
	}

	// 구단 이미지 수정
	@Override
	public int updateClubImage(ClubImageDTO ci) {
		return sst.insert("AdminMapper.updateClubImage", ci);
	}

}
