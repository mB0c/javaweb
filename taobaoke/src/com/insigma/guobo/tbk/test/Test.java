package com.insigma.guobo.tbk.test;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import javax.persistence.Entity;

@Entity
public class Test {

	public static void main(String[] args) {
		try {
			System.out.println(URLDecoder.decode("%BC%F2%BC%F2%B5%A5%B5%A5%B9%FD1%CA%C0", "gb2312"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
