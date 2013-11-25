package com.insigma.guobo.tbk.exception;

import javax.persistence.Entity;

@Entity
public class SendEmailException extends Exception {

	public SendEmailException() {
		// TODO Auto-generated constructor stub
	}

	public SendEmailException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public SendEmailException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public SendEmailException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public SendEmailException(String arg0, Throwable arg1, boolean arg2,
			boolean arg3) {
		super();
		// TODO Auto-generated constructor stub
	}

}
