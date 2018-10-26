package com.bawu.oa.service;

import com.bawu.oa.entity.Overtime;
import com.bawu.oa.entity.User;
import com.bawu.oa.utils.Page;

public interface OvertimeService {

	Page<Overtime> findOvertimePage(User user,int pageNo,int pageSize);
}
