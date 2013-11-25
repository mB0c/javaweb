package com.insigma.guobo.tbk.services;

import com.insigma.guobo.tbk.exception.SendEmailException;
import com.insigma.guobo.tbk.exception.UserExistException;
import com.insigma.guobo.tbk.pojo.Users;

public interface RegisterService {
	//判断是否注册成功
	public boolean isRegister(Users user) throws UserExistException, SendEmailException ;
	
	/**
	 * 根据传进来的user对象进行数据库的更新
	 * @param user  要修改的对象  （已经修改过的）
	 * @return  返回 true 成功  false 失败
	 */
	public boolean updateUser(Users user);
}