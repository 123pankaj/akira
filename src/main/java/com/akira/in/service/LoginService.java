package com.akira.in.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LoginService {

	public boolean loginAllowed(String userName,String email){
		return true;
	}
	
}
