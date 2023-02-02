package com.tm.nmp.point;

import java.util.List;

public interface PointMapper {

	int getNpoint(PointVO pv);
	 
	int pointTable(PointVO pv);

	int updatePoint(PointVO pv);

	int insertPlusPoint(PlusPointVO ppv);

	PointVO getPoint(PointVO pv);

	List<PlusPointVO> getPlusPoint(PlusPointVO ppv);

}
