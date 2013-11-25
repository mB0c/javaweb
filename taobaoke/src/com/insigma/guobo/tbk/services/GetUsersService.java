package com.insigma.guobo.tbk.services;

import java.util.List;

import com.insigma.guobo.tbk.pojo.Users;

public interface GetUsersService {
	
	//获取全部用户
	public List<Users> getAllUsers();
	//删除用户

	public boolean delUsers(int[] ids);
	
	/**
	 * 根据关键字模糊查询  返回用户的姓名 数组
	 * @param name  关键字
	 * @return    用户名数组
	 */
	public String[] getLikeNames(String name);
}
