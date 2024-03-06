package com.kodnest.tunehub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kodnest.tunehub.entity.User;
import com.kodnest.tunehub.serviceimpl.UserServiceImpl;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	@Autowired
	UserServiceImpl serviceimpl;

	@PostMapping("/register")
	public String addUser(@ModelAttribute User user) {

		//email taken from the registration form
		String email = user.getEmail();

		//checking  if email  as entered in registration 
		//is present in  Database or not
		boolean status = serviceimpl.emailExists(email);

		if(status == false) {
			serviceimpl.addUser(user);
			System.out.println("User added");
		}else {
			System.out.println("User already exists");
		}
		return "home";		
	}

	@PostMapping("/validate")
	public  String validate(@RequestParam("email")String email,
			@RequestParam("password")String password,HttpSession session) {

		if(serviceimpl.validateUser(email ,password) == true){
			String role=serviceimpl.getRole(email);

			session.setAttribute("email",email);
			if(role.equals("admin")) {
				return "adminhome";
			}else {
				return "customerhome";
			}			
		}
		else {
			return "login";
		}

	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "login";
	}
}
