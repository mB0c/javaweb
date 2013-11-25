package com.insigma.guobo.tbk.dao;

import java.util.List;

import com.insigma.guobo.tbk.pojo.Users;

public interface UserDao {
	
	public Users findUserByNickOrEmail(String nickOrEmail);
	public Users findUserByEmail(String email);
	
	//注册
	public boolean isRisterSuccess(Users user);
	//根据activeCode找user
	public Users findUserByCode(String activeCode);
	//更新用户的激活状态
	
	/**
	 * 
	 * @param user 根据传入的用户进行匹配激活
	 * @return
	 */
	public boolean updateUser(Users user);
	//获取全部用户
	
	/**
	 * 获取全部用户信息
	 * @return  返回list<Users>类型
	 */
	public List<Users> getAllUsers();
	//批量删除用户
	/**
	 *  根据id值 批量删除用户
	 * @param ids 传入id的数组
	 * @return  如果删除成功为 true 否则 false
	 */
	public boolean delUsersByids(int[] idInts);
	/**
	 * dao层模糊查询用户的姓名
	 * @param name  关键字
	 * @return    返回姓名数组
	 */
	public String[] findUserNames(String name);
}
