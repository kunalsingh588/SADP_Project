package com.sapient.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.sapient.entity.BrokerLogin;

@Component
public class LoginDAO {

	@PersistenceContext
	private EntityManager entityManager;

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public boolean validateUsername(String userName) {
		BrokerLogin foundUsername = entityManager.find(BrokerLogin.class, userName);
		if (foundUsername == null) {
			return false;
		} else {
			return true;
		}
	}

	public boolean validateUser(String userName, String userPassword) {
		BrokerLogin foundUser = entityManager.find(BrokerLogin.class, userName);
		if (foundUser != null) {
			if (foundUser.getUserPassword().equals(userPassword)) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	@Transactional
	public boolean checkPassword(String name, String password, String cPassword) {
		if (password.equals(cPassword)) {
			BrokerLogin user = entityManager.find(BrokerLogin.class, name);
			user.setUserPassword(cPassword);
			return true;
		} else {
			return false;
		}
	}
}
