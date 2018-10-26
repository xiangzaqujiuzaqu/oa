package com.bawu.oa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bawu.oa.dao.UserDao;
import com.bawu.oa.entity.User;
import com.bawu.oa.service.UserService;
@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Override
	public User getUserByAccount(String account) {
		return  userDao.getUserByAccount(account);
	}

}
