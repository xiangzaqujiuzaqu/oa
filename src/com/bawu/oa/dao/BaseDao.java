package com.bawu.oa.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.SessionAttributes;

public class BaseDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	public Session getSession(){
		return sessionFactory.openSession();
		//return sessionFactory.getCurrentSession();
	}

}
