package com.bawu.oa.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bawu.oa.dao.BaseDao;
import com.bawu.oa.dao.OvertimeDao;
import com.bawu.oa.entity.Overtime;
import com.bawu.oa.entity.User;
@Repository
public class OvertimeDaoImpl extends BaseDao implements OvertimeDao {

	
	@Override
	public List<Overtime> findOvertimePage(User user, int offset, int pageSize) {
		
		String hql = "from Overtime o where o.user=?";
		return getSession().createQuery(hql).setEntity(0, user).setFirstResult(offset).setMaxResults(pageSize).list();
	}

	@Override
	public long countOvertimes(User user) {
		String hql = "select count(*) from Overtime o where o.user=?";
		return (long)getSession().createQuery(hql).setEntity(0, user).uniqueResult();
	}

}
