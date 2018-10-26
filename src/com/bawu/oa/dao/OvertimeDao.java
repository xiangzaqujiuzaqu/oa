package com.bawu.oa.dao;

import java.util.List;

import com.bawu.oa.entity.Overtime;
import com.bawu.oa.entity.User;

public interface OvertimeDao {

	List<Overtime> findOvertimePage(User user,int offset,int pageSize);
	long countOvertimes(User user);
	
}
