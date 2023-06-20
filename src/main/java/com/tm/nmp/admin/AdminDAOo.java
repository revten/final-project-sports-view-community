package com.tm.nmp.admin;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tm.nmp.board.BoardOption;

@Service
public class AdminDAOo {

	@Autowired
	private SqlSessionTemplate sst;

	

	public void insertClubImages(List<ClubImageDTO> images) {

	}


	public int updateClubImage(ClubImageDTO ci) {
		return sst.insert("AdminMapper.updateClubImage", ci);
	}

	public int insert(ClubDTO c) {
		// TODO Auto-generated method stub
		return 0;
	}
}
