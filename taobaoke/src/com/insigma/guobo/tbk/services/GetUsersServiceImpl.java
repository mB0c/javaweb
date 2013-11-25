package com.insigma.guobo.tbk.services;

import java.util.ArrayList;
import java.util.List;

import com.insigma.guobo.tbk.dao.UserDao;
import com.insigma.guobo.tbk.dao.UserDaoImpl;
import com.insigma.guobo.tbk.pojo.Users;

public class GetUsersServiceImpl implements GetUsersService {

	UserDao userDAO = new UserDaoImpl();
	
	/**
	 * 获取所有的用户消息
	 */
	public List<Users> getAllUsers() {
		
		List<Users> list = userDAO.getAllUsers();		
		return list;
	}
	
	/**
	 * 批量删除用户
	 */
	public boolean delUsers(int[] ids) {
		
		boolean isSuccess = false;
		//
		isSuccess = userDAO.delUsersByids(ids);
		
		return isSuccess;
	}

	public String[] getLikeNames(String name) {
		
		String[] userNames = userDAO.findUserNames(name);
		
		
		
		return userNames;
	}

}
