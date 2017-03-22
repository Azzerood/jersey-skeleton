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
    private static User anonymous = new User("Anonymous", "anonym","p");
    String login;
    String password;
    char role;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
        this.role = 'p';
    }
    public User(String login, String password, char role){
    	this.login = login;
    	this.password = password;
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

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    
    public boolean isGoodPassword(String password) {
        if (isAnonymous()) {
            return false;
        }
        String hash = buildHash(password, getSalt());
        return hash.equals(getPasswdHash());
    }

    public String getPasswdHash() {
        return passwdHash;
    }

    public void setPasswdHash(String passwdHash) {
        this.passwdHash = passwdHash;
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
        this.setPassword(dto.getPassword());
        this.role(dto.getRole());
    }

    public UserDto convertToDto() {
        UserDto dto = new UserDto();
        dto.setLogin(dto.getLogin());
        dto.setName(dto.getLogin());
        dto.setRole(dto.getRole());
        return dto;
    }
}
