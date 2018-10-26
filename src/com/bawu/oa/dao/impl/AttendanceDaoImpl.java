package com.bawu.oa.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;
import org.springframework.stereotype.Repository;

import com.bawu.oa.dao.AttendanceDao;
import com.bawu.oa.dao.BaseDao;
import com.bawu.oa.entity.Attendance;
import com.bawu.oa.entity.User;

@Repository
public class AttendanceDaoImpl extends BaseDao implements AttendanceDao {

	
	@Override
	public long findCount(String userId) {
		
		String hql ="select count(*) from Attendance a where a.userId=?";
		return (long)getSession().createQuery(hql).setString(0, userId).uniqueResult();
	}
	
	
	@Override
	public List<Attendance> findAttendanceByUserId(String userId,int offset,int pageSize) {
		
		String hql ="from Attendance a where a.userId = ?";
		
		return getSession().createQuery(hql).setString(0, userId).setFirstResult(offset).setMaxResults(pageSize).list();
	}

	@Override
	public List<Attendance> findSignIn(Date beginDate, Date endDate,String userId,int offset,int pageSize) {
		
		//QBC
		Criteria criteria = getSession().createCriteria(Attendance.class);
		SimpleExpression eq = Restrictions.eq("userId", userId);
		SimpleExpression ge = Restrictions.ge("signIn", beginDate);
		SimpleExpression le = Restrictions.le("signIn", endDate);
		criteria = criteria.add(eq).add(ge).add(le);
		if(pageSize!=0) {
			criteria = criteria.setFirstResult(offset).setMaxResults(pageSize);
		}
		
		return  (List<Attendance>)criteria.list();
	}

	@Override
	public void save(Attendance attendance) {
		
		//单元测试的代码
		/*Session session = getSession();
		Transaction beginTransaction = session.beginTransaction();
		
		session.saveOrUpdate(attendance);
		beginTransaction.commit();*/
		getSession().saveOrUpdate(attendance);
	}

}
