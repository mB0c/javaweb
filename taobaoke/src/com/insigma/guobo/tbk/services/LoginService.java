package com.insigma.guobo.tbk.services;

public interface LoginService {
	
	public boolean isValidUser(String userName,String password);
	public boolean isValidEmail(String email);
}
