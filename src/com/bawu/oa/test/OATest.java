package com.bawu.oa.test;



import java.sql.Connection;
import java.sql.SQLException;
import java.util.Set;

import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bawu.oa.dao.AttendanceDao;
import com.bawu.oa.dao.OvertimeDao;
import com.bawu.oa.entity.Attendance;
import com.bawu.oa.entity.Role;
import com.bawu.oa.entity.User;
import com.bawu.oa.service.UserService;

class OATest {

	ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
	
	
	@Test
	void testConnection() throws SQLException {
		
		DataSource dataSource = ioc.getBean(DataSource.class);
		
		Connection con = dataSource.getConnection();
		
		System.out.println(con);
	}

	
	@Test
	void testSessionFactory() throws SQLException {
		
		SessionFactory factory = ioc.getBean(SessionFactory.class);
		Session session = factory.openSession();
		System.out.println(session);
	}
	
	
	@Test
	public void testGetUser() {
		UserService service = ioc.getBean(UserService.class);
		User user = service.getUserByAccount("admin");
		System.out.println(user);
		Set<Role> roles = user.getRoles();
		for (Role role : roles) {
			System.out.println(role);
		}
		
	}
	
	@Test
	public void testSaveOrUpdate() {
		
		AttendanceDao dao = ioc.getBean(AttendanceDao.class);
		Attendance att = new Attendance();
		att.setId("0002");
		att.setIp("192.168.0.101");
		
		dao.save(att);
	}
	
	
	@Test
	public void testCount() {
		OvertimeDao dao = ioc.getBean(OvertimeDao.class);
		User user  = new User();
		user.setId("c180081538288415584");
		
		long findCount = dao.countOvertimes(user);
		System.out.println(findCount);
		
	}
	
}
