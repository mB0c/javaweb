package com.insigma.guobo.tbk.test;

import org.hibernate.Session;

import com.insigma.guobo.tbk.pojo.HibernateSessionFactory;
import com.insigma.guobo.tbk.pojo.Users;

public class TestAddUser {
	public static void main(String[] args){
		Session s = HibernateSessionFactory.getSession();
		s.beginTransaction();
		for(int i =0 ;i < 30;i++){
			Users user = new Users();
			user.setNick("nick"+i);
			user.setEmail(i+"00@qq.com");
			user.setPassword("123456");
			user.setRole(i%2);
			user.setActiveCode("h23kskendki883298ksf");
			user.setStatus(""+i%2);
			s.save(user);
		}
		s.getTransaction().commit();
		s.close();
	}

}
