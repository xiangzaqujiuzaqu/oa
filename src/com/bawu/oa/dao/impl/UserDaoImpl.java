package com.bawu.oa.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bawu.oa.dao.BaseDao;
import com.bawu.oa.dao.UserDao;
import com.bawu.oa.entity.User;
@Repository
public class UserDaoImpl extends BaseDao implements UserDao{

	@Override
	public User getUserByAccount(String account) {
		String hql ="from User u where u.account = ?";
		return (User)getSession().createQuery(hql).setString(0, account).uniqueResult();
	}

	
	
	
}
