package com.tm.nmp.point;

import java.util.List;

import com.tm.nmp.account.Calendar;

public interface PointMapper {

	 List<Calendar> getCalendarList(String userId);

	int pointTable(PointVo pv);	
		
	

}
