package com.insigma.guobo.tbk.services;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import com.insigma.guobo.tbk.dao.UserDao;
import com.insigma.guobo.tbk.dao.UserDaoImpl;
import com.insigma.guobo.tbk.exception.SendEmailException;
import com.insigma.guobo.tbk.exception.UserExistException;
import com.insigma.guobo.tbk.pojo.Users;
import com.insigma.guobo.tbk.services.mail.MailSenderInfo;
import com.insigma.guobo.tbk.services.mail.SimpleMailSender;
import com.insigma.guobo.tbk.utils.Configuration;
import javax.persistence.Entity;



@Entity
public class RegisterServiceImpl implements RegisterService {
	
	
	private UserDao userDAO = new UserDaoImpl();
	
	public boolean isRegister(Users user) throws UserExistException, SendEmailException {
		
		boolean isSuccess = false;
		//判断用户是否存在
		Users userByEmail = userDAO.findUserByEmail(user.getEmail());
		
		
		
		if(null == userByEmail){
			//说明用户不存在  进行保存
			isSuccess = userDAO.isRisterSuccess(user);
		}
		else{//抛 用户也已经存在异常
			isSuccess = false;
			throw new UserExistException("用户已经存在！！！");
		}
		//发送邮件  激活
		isSuccess = sendActiveMail(user);
		if(!isSuccess){
			throw new SendEmailException("邮件发送失败！！！");
		}
		
		return isSuccess;
	}
	
	private boolean sendActiveMail(Users user){
		boolean isSendSuccess = false;
		 //这个类主要是设置邮件  
        MailSenderInfo mailInfo = new MailSenderInfo();
        mailInfo.setMailServerHost(Configuration.getMailServer());
//        System.out.println("设置SMTP!");
        mailInfo.setMailServerPort(Configuration.getMailPort());
//        System.out.println("设置端口!");
        mailInfo.setValidate(true); 
//        System.out.println("服务器校验正确!");
        mailInfo.setUserName(Configuration.getMailUser()); 
//        System.out.println("获得用户名!");
        mailInfo.setPassword(Configuration.getMailPassword());//您的邮箱密码   
//        System.out.println("请设置您的密码!");
        mailInfo.setFromAddress(Configuration.getMailFrom()); 
//        System.out.println("获取发件人邮箱地址!");
        mailInfo.setToAddress(user.getEmail());
//        System.out.println("获取收件人地址!");
        mailInfo.setSubject("感谢您注册淘宝客网站，请激活您的用户!");
//        System.out.println("设置邮件主题!");
           //这个类主要来发送邮件  
        String url = "";
		try {
			url = "http://" + Configuration.getTaobaokeServerName() + ":" + Configuration.getTaobaokeServerPort() + "/taobaoke/servlet/ActiveUserServlet?activeCode=" + URLEncoder.encode(user.getActiveCode(), "utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        mailInfo.setContent("感谢您注册淘宝客网站，请点击以下链接来激活您的用户:\n<br/><a href='" + url + "'>点击激活用户</a>");
        isSendSuccess = SimpleMailSender.sendHtmlMail(mailInfo);//发送html格式    
        
        return isSendSuccess;
	}

	public boolean updateUser(Users user) {
		boolean isSuccess = false;
		
		isSuccess = userDAO.updateUser(user);
		
		return isSuccess;
	}
	

}
