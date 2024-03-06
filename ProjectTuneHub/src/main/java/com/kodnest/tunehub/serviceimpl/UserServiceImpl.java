package com.kodnest.tunehub.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodnest.tunehub.entity.User;
import com.kodnest.tunehub.repository.UserRepistory;
import com.kodnest.tunehub.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepistory userRepistory;

	public String addUser(User user) {
		userRepistory.save(user);
		return "User added successfully";
	}

	// To check the duplicate entries
	public boolean emailExists(String email) {
		if(userRepistory.findByEmail(email)!=null) {
			return true;
		}else {
			return false;
		}
	}

	public boolean validateUser(String email, String password) {
		User user = userRepistory.findByEmail(email);

		String dbpwd = user.getPassword();
		if(password.equals(dbpwd)) {
			return true;
		}
		return false;
	}

	public String getRole(String email) {
		User user=userRepistory.findByEmail(email);
		return user.getRole();
	}

	@Override
	public User getUser(String email) {
		return userRepistory.findByEmail(email);
	}

	@Override
	public void updateUser(User user) {
		userRepistory.save(user);
	}

}
