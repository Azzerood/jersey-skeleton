package fr.iutinfo.skeleton.api;

import com.google.common.base.Charsets;
import com.google.common.hash.Hasher;
import com.google.common.hash.Hashing;
import fr.iutinfo.skeleton.common.dto.UserDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.Principal;
import java.security.SecureRandom;

public class User implements Principal {
    final static Logger logger = LoggerFactory.getLogger(User.class);
    private static User anonymous = new User("Anonymous", "anonym","parent");
    private String login;
    private String password;
    private String role;
    
    public User() {
		// TODO Auto-generated constructor stub
	}

    public User(String login, String password) {
        this.login = login;
        this.password = password;
        this.role = "parent";
    }
    public User(String login, String password, String role){
    	this(login,password);
    	this.role = role;
    }

    public static User getAnonymousUser() {
        return anonymous;
    }


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }


    public String getRole(){
    	return role;
    }
    public void setRole(String r){
    	this.role = r;
    }

    @Override
    public String getName(){
    	return login;
    }
    
    @Override
    public boolean equals(Object arg) {
        if (getClass() != arg.getClass())
            return false;
        User user = (User) arg;
        return login.equals(user.login);
    }

    @Override
    public String toString() {
        return "<"+role+">"+login;
    }
    
    public boolean isGoodPassword(String password) {
        return password.equals(this.password);
    }

    public void initFromDto(UserDto dto) {
        this.setLogin(dto.getLogin());
        this.setPassword(dto.getPassword());
        this.setRole(dto.getRole());
    }

    public UserDto convertToDto() {
        UserDto dto = new UserDto();
        dto.setLogin(getLogin());
        dto.setPassword(getPassword());
        dto.setRole(getRole());
        return dto;
    }
	public boolean isInUserGroup(String s) {
		return getRole().equals(s);
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
