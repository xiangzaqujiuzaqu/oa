package com.bawu.oa.dao;

import java.util.Date;
import java.util.List;

import com.bawu.oa.entity.Attendance;

public interface AttendanceDao{

	List<Attendance> findAttendanceByUserId(String userId,int offset,int pageSize);
	
	List<Attendance> findSignIn(Date beginDate,Date endDate,String userId,int offset,int pageSize);
	
	 void save(Attendance attendance);
	 
	 long findCount(String userId);
}
