package com.gpg.hibernate.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.gpg.hibernate.entity.User;

public class MyTest {
	@Test
	public void test01() {
		// 1. 读取配置文件
		Configuration conf = new Configuration().configure();
		// 2.获取数据库操作对象SessionFactory
		@SuppressWarnings("deprecation")
		SessionFactory sessionFactory = conf.buildSessionFactory();
		// 3 通过获得操作数据库的session对象
		Session session = sessionFactory.openSession();
		System.out.println(session);
		 // 4 操作数据库
		 User u = new User();
		 u.setName("gpg");
		 session.save(u);
		 session.beginTransaction().commit();// 提交
		 // 5 关闭资源
		 session.close();
		 sessionFactory.close();

	}
}
