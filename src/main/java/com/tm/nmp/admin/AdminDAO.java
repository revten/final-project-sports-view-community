package com.tm.nmp.admin;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tm.nmp.board.BoardOption;

@Service
public class AdminDAO {

	@Autowired
	private SqlSessionTemplate sst;

	public int calcAllClubCount(BoardOption bo) {
		return sst.selectOne("AdminMapper.calcAllClubCount", bo);
	}

	public List<ClubListView> getClubViewList(BoardOption bo) {
		return sst.selectList("AdminMapper.getClubViewList", bo);
	}

	public void regClubInfo(ClubDTO c) {
		sst.insert("AdminMapper.regClubInfo", c);
	}

	public void insertClubImages(List<ClubImageDTO> images) {
		sst.insert("AdminMapper.insertClubImages", images);
	}

	public ClubListView getClubDetail(int id) {
		return sst.selectOne("AdminMapper.getClubDetail", id);
	}

	public List<ClubImageDTO> getClubImages(int id) {
		return sst.selectList("AdminMapper.getClubImages", id);
	}

	public int insertOneClubImage(ClubImageDTO ci) {
		return sst.insert("AdminMapper.insertOneClubImage", ci);
	}

	public int updateClubImage(ClubImageDTO ci) {
		return sst.insert("AdminMapper.updateClubImage", ci);
	}
}
