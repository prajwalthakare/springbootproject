package com.java.test;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class passwordBcrypt {

	public static void main(String[] args) {
		
		BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
		String rawPassword="1234";
		String encodedpassword=encoder.encode(rawPassword);
		System.out.println(encodedpassword);
	}

}
