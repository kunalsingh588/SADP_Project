package com.sapient.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;

@Entity
@Table(name = "UserDetails")
@Scope("session")
public class BrokerLogin {

	@Id
	private String userName;
	private String userPassword;
		

	public BrokerLogin() {
	}

	public BrokerLogin(String userName, String userPassword) {
		this.userName = userName;
		this.userPassword = userPassword;
	
	
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

    

	@Override
	public String toString() {
		return "User [userName=" + userName + ", userPassword=" + userPassword + "]";
	}


}
