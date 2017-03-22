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
        return name.equals(user.name) && alias.equals(user.alias) && email.equals(user.email) && passwdHash.equals(user.getPasswdHash()) && salt.equals((user.getSalt()));
    }

    @Override
    public String toString() {
        return id + ": " + alias + ", " + name + " <" + email + ">";
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getSalt() {
        if (salt == null) {
            salt = generateSalt();
        }
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    private String generateSalt() {
        SecureRandom random = new SecureRandom();
        Hasher hasher = Hashing.sha256().newHasher();
        hasher.putLong(random.nextLong());
        return hasher.hash().toString();
    }

    public void resetPasswordHash() {
        if (password != null && !password.isEmpty()) {
            setPassword(getPassword());
        }
    }

    public boolean isInUserGroup() {
        return !(id == anonymous.getId());
    }

    public boolean isAnonymous() {
        return this.getId() == getAnonymousUser().getId();
    }

    public String getSearch() {
        search = name + " " + alias + " " + email;
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public void initFromDto(UserDto dto) {
        this.setAlias(dto.getAlias());
        this.setEmail(dto.getEmail());
        this.setId(dto.getId());
        this.setName(dto.getName());
        this.setPassword(dto.getPassword());
    }

    public UserDto convertToDto() {
        UserDto dto = new UserDto();
        dto.setAlias(this.getAlias());
        dto.setEmail(this.getEmail());
        dto.setId(this.getId());
        dto.setName(this.getName());
        dto.setPassword(this.getPassword());
        return dto;
    }
}
