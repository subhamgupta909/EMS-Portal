package com.ems.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncryption {
 public static void main(String[] args) {
	BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
	String rawPassword="admin";
	String hashPassword=encoder.encode(rawPassword);
	System.out.println(hashPassword);
	System.out.println(encoder.matches(rawPassword, hashPassword));
	
}
}
