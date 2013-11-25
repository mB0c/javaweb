package com.insigma.guobo.tbk.services.mail;

import javax.persistence.Entity;



@Entity
public class MailTest {

	/**
	 * @param 发送邮件
	 */
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		 //这个类主要是设置邮件  
        MailSenderInfo mailInfo = new MailSenderInfo();
        mailInfo.setMailServerHost("smtp.163.com");
//        System.out.println("设置SMTP!");
        mailInfo.setMailServerPort("25");
//        System.out.println("设置端口!");
        mailInfo.setValidate(true); 
//        System.out.println("服务器校验正确!");
        mailInfo.setUserName("testweiboabc@163.com"); 
//        System.out.println("获得用户名!");
        mailInfo.setPassword("abc123");//您的邮箱密码   
//        System.out.println("请设置您的密码!");
        mailInfo.setFromAddress("testweiboabc@163.com"); 
//        System.out.println("获取发件人邮箱地址!");
        mailInfo.setToAddress("zhouchangzai@insigma.com.cn");
//        System.out.println("获取收件人地址!");
        mailInfo.setSubject("您有新邮件!");
//        System.out.println("设置邮件主题!");
        mailInfo.setContent("文本邮件");
//        System.out.println("写入邮件内容...");
           //这个类主要来发送邮件  
        SimpleMailSender sms = new SimpleMailSender();
        boolean flag1 , flag2 = false;  
        flag1 = sms.sendTextMail(mailInfo);//发送文体格式      
        if(flag1){  
        	System.out.println("发送文本格式mail 成功！");  
        }else{
        	System.out.println("发送文本格式mail 失败！");
        }
        mailInfo.setContent("abc<br/><a href='http://px.insigmaedu.com'>javamail的一封测试邮件!</a>");
        flag2 = sms.sendHtmlMail(mailInfo);//发送html格式    
        if(flag2){  
          System.out.println("发送html格式mail 成功！");  
        }else{
          System.out.println("发送html格式mail 失败！");  
        }
	}

}
