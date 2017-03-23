package fr.iutinfo.skeleton.common.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.Principal;

public class UserDto implements Principal {
    final static Logger logger = LoggerFactory.getLogger(UserDto.class);
    private String login;
    private String password;
    private String role;

    public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
