package com.springproject.service;

import com.springproject.model.User;

public interface UserService {

	void userSignUp(User user);

	User userLogIn(String email, String pass);
}
