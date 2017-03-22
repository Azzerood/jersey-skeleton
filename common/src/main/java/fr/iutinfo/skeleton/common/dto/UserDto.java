package fr.iutinfo.skeleton.common.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.Principal;

public class UserDto implements Principal {
    final static Logger logger = LoggerFactory.getLogger(UserDto.class);
    private String login;
    private char role;

    public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public char getRole() {
		return role;
	}

	public void setRole(char role) {
		this.role = role;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return login;
	}
	

}
