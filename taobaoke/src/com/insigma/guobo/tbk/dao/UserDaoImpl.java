package com.insigma.guobo.tbk.dao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Entity;
import org.hibernate.Criteria;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;


import com.insigma.guobo.tbk.pojo.HibernateSessionFactory;
import com.insigma.guobo.tbk.pojo.Users;


@Entity
public class UserDaoImpl implements UserDao {

	public Users findUserByNickOrEmail(String nickOrEmail) {
		
		Session s = HibernateSessionFactory.getSession();
		Criteria c = s.createCriteria(Users.class);
		//通过nick 或者 email 获取  用户
		c.add(Restrictions.or(Restrictions.eq("nick", nickOrEmail), Restrictions.eq("email", nickOrEmail)));
		Users user = (Users) c.uniqueResult();
		
		return user;		
		
	}

	public Users findUserByEmail(String email) {
		Session s = HibernateSessionFactory.getSession();
		Criteria c = s.createCriteria(Users.class);
		//通过nick 或者 email 获取  用户
		c.add(Restrictions.eq("email", email));
		Users user = (Users) c.uniqueResult();
		
		return user;

	}


	public boolean isRisterSuccess(Users user) {

		Session s = HibernateSessionFactory.getSession();
		boolean isSuccess = false;
		try{
			s.beginTransaction();
			s.save(user);
			s.flush();
			s.getTransaction().commit();
			isSuccess = true;
		}catch(Exception e){
			s.getTransaction().rollback();
		}
		
		return isSuccess;
	}

	public Users findUserByCode(String activeCode) {
		
		Session s = HibernateSessionFactory.getSession();
		Criteria c = s.createCriteria(Users.class);
		c.add(Restrictions.eq("activeCode", activeCode));
		//user对象 或者为null
		Users user = (Users) c.uniqueResult();  //ROEX Fj/GeMGBoQQLKN8ZA==   ROEX+Fj/GeMGBoQQLKN8ZA==
		
		return user;
	}


	public boolean updateUser(Users user) {
		boolean isSuccess = false;
		try{
			Session s = HibernateSessionFactory.getSession();
			
			s.clear();
			
			s.beginTransaction();
			s.update(user);
			s.flush();
			s.getTransaction().commit();
			isSuccess = true;
		}catch (Exception e){
			
			isSuccess = false;
			e.printStackTrace();
		}
		return isSuccess;
	}
	
	
	public List<Users> getAllUsers() {
		
		StringBuilder HQL = new StringBuilder("from Users");
		List<Users> list = new ArrayList<Users>();
		Session s = HibernateSessionFactory.getSession();
		Query query = s.createQuery(HQL.toString());
		list = query.list();
		
		return list;
	}


	public boolean delUsersByids(int[] idInts) {
		
		boolean isSuccess = false;
		
		try{
			Session s = HibernateSessionFactory.getSession();
			
			StringBuilder HQL = new StringBuilder("delete from Users where id in (");
			for (int i : idInts) {
				HQL.append(i + ",");
			}
			String hql = HQL.toString();
			hql = hql.substring(0, hql.lastIndexOf(',')) + ")";
			//HQL = (StringBuilder) hql.subSequence(0, hql.length()-1);
			//HQL.append(")");
			
			System.out.println(hql);
			
			Transaction tra = s.beginTransaction();
			
			//注意下面的   UserTest不是表名   是hibernate中与表对应的bean对象
			s.createQuery(hql).executeUpdate();
			
			s.flush();
			tra.commit();
			isSuccess = true;
		}catch(Exception e){
			e.printStackTrace();
			HibernateSessionFactory.closeSession();
		}

		return isSuccess;
	}

	public String[] findUserNames(String name) {
		// 
		
		String[] userNames = {""};
		
		Session s = HibernateSessionFactory.getSession();
		
		List<Users> list = s.createQuery("from Users where nick like '%"+ name +"%'").list();
		userNames = new String[list.size()];
		if(null != list && list.size() != 0){
			for (int i = 0;i<list.size();i++) {
				userNames[i] = list.get(i).getNick();
			}
		}
		
		
		return userNames;
	}

}
