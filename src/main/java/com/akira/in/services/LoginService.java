package com.akira.in.services;

import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.akira.in.model.User;
import com.akira.in.repository.UserRepository;

@Service
@Transactional
public class LoginService {

	@Resource
	UserRepository userRepo;

	public boolean loginAllowed(String userName, String password) {
		Set<User> usersList = userRepo.findByUnameAndPassword(userName,
				password);
		if (usersList.size() == 1)
			return true;
		else
			return false;
	}

}
