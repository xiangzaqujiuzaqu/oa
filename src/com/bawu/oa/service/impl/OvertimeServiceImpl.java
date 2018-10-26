package com.bawu.oa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bawu.oa.dao.OvertimeDao;
import com.bawu.oa.entity.Overtime;
import com.bawu.oa.entity.User;
import com.bawu.oa.service.OvertimeService;
import com.bawu.oa.utils.Page;

@Service
@Transactional
public class OvertimeServiceImpl implements OvertimeService {

	@Autowired
	private OvertimeDao overtimeDao;
	
	
	@Override
	public Page<Overtime> findOvertimePage(User user, int pageNo,int pageSize) {
		
		Page<Overtime> page = new Page<Overtime>();
	
		int offset = page.countOffset(pageNo, pageSize);
		
		long totalRecords = overtimeDao.countOvertimes(user);
		
		List<Overtime> list = overtimeDao.findOvertimePage(user,offset,pageSize);
		
		page.setPageNo(pageNo);
		page.setPageSize(pageSize);
		page.setTotalRecords((int)totalRecords);
		page.setList(list);
		
		return page;
	}

}
