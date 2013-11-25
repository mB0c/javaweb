package com.insigma.guobo.tbk.services;

import com.insigma.guobo.tbk.dao.UserDao;
import com.insigma.guobo.tbk.dao.UserDaoImpl;
import com.insigma.guobo.tbk.log.LogStyle;
import com.insigma.guobo.tbk.pojo.Users;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class LoginServiceImpl implements LoginService {
	
	@ManyToOne
	private UserDao userDAO = new UserDaoImpl();

	public boolean isValidUser(String userName, String password) {
		//从数据库获取该账户名
		Users user = userDAO.findUserByNickOrEmail(userName);
		//这里还要判断加密的密码 TODO
		if(null != user && user.getPassword().equals(password)){
			String message = "用户： " + user.getNick() + " 登录了！";
			String level = "info";
			LogStyle.serviceLog(LoginServiceImpl.class, message, level);
			return true;
		}
		return false;
	}

	public boolean isValidEmail(String email) {
		
		boolean isValidEmail = false;
		//从数据库中校验
		Users user = userDAO.findUserByEmail(email);
		if(user == null){
			isValidEmail = true;
		}
		return isValidEmail;
	}

}
