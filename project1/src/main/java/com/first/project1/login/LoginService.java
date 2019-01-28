package com.first.project1.login;

import org.springframework.stereotype.Service;

@Service
public class LoginService {
	public boolean validate(String n,String  p){
		return n.equals("")&&p.equals("");
	}

}
