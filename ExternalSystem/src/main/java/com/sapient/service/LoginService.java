package com.sapient.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sapient.dao.LoginDAO;

@Service
public class LoginService {

	@Autowired
	private LoginDAO loginDAO;

	public boolean validateUserName(String userName) {
		return loginDAO.validateUsername(userName);
	}

	public boolean validateUser(String userName, String userPassword) {
		return loginDAO.validateUser(userName, userPassword);
	}

	public boolean checkPassword(String name, String password, String cPassword) {

		return loginDAO.checkPassword(name, password, cPassword);
	}
}
