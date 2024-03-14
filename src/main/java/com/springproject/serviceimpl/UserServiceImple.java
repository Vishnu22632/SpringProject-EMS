package com.springproject.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springproject.model.User;
import com.springproject.repository.UserRepository;
import com.springproject.service.UserService;

@Service // here we write all business logics of the system
public class UserServiceImple implements UserService {
	
	@Autowired
	private UserRepository userRepo;

	@Override
	public void userSignUp(User user) {
		userRepo.save(user);
		
	}

	@Override
	public User userLogIn(String email, String pass) {
		
		return userRepo.findByEmailAndPassword(email, pass);
	}

}
