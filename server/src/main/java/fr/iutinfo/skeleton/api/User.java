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
    private static User anonymous = new User("Anonymous", "anonym",'p');
    String login;
    private String password;
    private char role;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
        this.role = 'p';
    }
    public User(String login, String password, char role){
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


    public char getRole(){
    	return role;
    }
    public void setRole(char r){
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


    public void initFromDto(UserDto dto) {
        this.setLogin(dto.getName());
        //this.setPassword(dto.getPassword());
        this.setRole(dto.getRole());
    }

    public UserDto convertToDto() {
        UserDto dto = new UserDto();
        dto.setLogin(dto.getLogin());
        dto.setName(dto.getLogin());
        dto.setRole(dto.getRole());
        return dto;
    }
}
