package com.springproject.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.springproject.model.User;
import com.springproject.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	private static final Logger log= LoggerFactory.getLogger(UserController.class);
	
	
	@Autowired
	private UserService us;

	@GetMapping({ "/", "/login" })
	public String getLogin() {
		return "LoginForm";

	}

	@PostMapping("/login")
	public String postLogin(@ModelAttribute User user, Model model, HttpSession session) {

		user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
		User usr = us.userLogIn(user.getEmail(), user.getPassword());

		if (usr != null) {
			
			log.info("---------------------user login success------------------");

			session.setAttribute("activeuser", usr);
			session.setMaxInactiveInterval(120);
//			model.addAttribute("uname", usr.getFname());
			return "Home";
		}

		
		model.addAttribute("msg", "user not found !!!");
		return "LoginForm";
	}

	@GetMapping("/signup")
	public String getSignUp() {
		return "SignUpForm";
	}

	@PostMapping("/signup")
	public String postSignUp(@ModelAttribute User user) {
		user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
		us.userSignUp(user);
		return "LoginForm";
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		
		log.info("-------------user logout success--------------");
		session.invalidate(); // session kill
		return "LoginForm";
	}
	
	@GetMapping("/profile")
	public String profile() {
		return "Profile";
	}

}
