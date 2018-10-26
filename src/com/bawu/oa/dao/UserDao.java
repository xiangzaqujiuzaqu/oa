package com.bawu.oa.dao;

import com.bawu.oa.entity.User;

public interface UserDao{

	User getUserByAccount(String account);
	
}
