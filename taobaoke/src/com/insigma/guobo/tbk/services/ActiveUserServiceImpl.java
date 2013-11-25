package com.insigma.guobo.tbk.services;

import com.insigma.guobo.tbk.dao.UserDao;
import com.insigma.guobo.tbk.dao.UserDaoImpl;
import com.insigma.guobo.tbk.log.LogStyle;
import com.insigma.guobo.tbk.pojo.Users;
import com.insigma.guobo.tbk.utils.Constants;

public class ActiveUserServiceImpl implements ActiveUserService {
	UserDao userDAO = new UserDaoImpl();
	public Users activeUser(String activeCode) {
		//获取user
		Users user = userDAO.findUserByCode(activeCode);
		//判断user是否存在
		if(null != user){
			//存在  则进行激活操作
			//设置激活状态
			user.setStatus(Constants.USER_ACTIVE_YES);
			//保存激活的用户状态  返回boolean类型
			boolean isSuccess = userDAO.updateUser(user);
			//如果激活失败  则置user为空
			if(!isSuccess){
				return null;
			}
			LogStyle.serviceLog(ActiveUserServiceImpl.class, "用户"+user.getNick() + "激活了", "info");
		}
		return user;
	}

}
