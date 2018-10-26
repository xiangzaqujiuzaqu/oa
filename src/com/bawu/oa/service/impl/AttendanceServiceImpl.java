package com.bawu.oa.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bawu.oa.dao.AttendanceDao;
import com.bawu.oa.dao.UserDao;
import com.bawu.oa.entity.Attendance;
import com.bawu.oa.service.AttendanceService;

@Service
@Transactional
public class AttendanceServiceImpl implements AttendanceService{


	@Autowired
	private AttendanceDao attendanceDao;
	
	@Override
	public List<Attendance> findAttendanceByUserId(String userId,int offset,int pageSize) {
		return attendanceDao.findAttendanceByUserId(userId,offset,pageSize);
	}

	@Override
	public long findCount(String userId) {
		return attendanceDao.findCount(userId);
	}
	
	@Override
	public List<Attendance> findSignIn(Date beginDate, Date endDate,String userId,int offset,int pageSize) {
		// TODO Auto-generated method stub
		return attendanceDao.findSignIn(beginDate,endDate,userId,offset,pageSize);
	}

	@Override
	public void save(Attendance attendance) {
		
		attendanceDao.save(attendance);
	}

	
	
	
	
}
