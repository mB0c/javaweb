package com.insigma.guobo.tbk.services.mail;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.persistence.Entity;

@Entity
public class MyAuthenticator extends Authenticator {
	//身份验证:用户�?密码
	String userName=null;  
    String password=null;  
       
    public MyAuthenticator(){  
    }  
    public MyAuthenticator(String username, String password) {   
        this.userName = username;   
        this.password = password;   
    }   
    protected PasswordAuthentication getPasswordAuthentication(){  
        return new PasswordAuthentication(userName, password);  
    }  

}
