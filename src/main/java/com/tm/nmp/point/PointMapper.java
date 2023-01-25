package com.tm.nmp.point;

import java.util.List;

import com.tm.nmp.account.Calendar;

public interface PointMapper {

	List<Calendar> getCalendarList(String userId);

	int pointTable(PointVO pv);

	int updatePoint(PointVO pv);

	int insertPlusPoint(PlusPointVO ppv);

	PointVO getPoint(PointVO pv);

	List<PlusPointVO> getPlusPoint(PlusPointVO ppv);
	
	
		
	

}
