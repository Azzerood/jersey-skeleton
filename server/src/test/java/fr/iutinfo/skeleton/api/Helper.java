package fr.iutinfo.skeleton.api;

import fr.iutinfo.skeleton.common.dto.UserDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.core.GenericType;
import java.util.List;

public class Helper {
    private final static Logger logger = LoggerFactory.getLogger(Helper.class);
    private static final UserDao dao = BDDFactory.getDbi().open(UserDao.class);
    static GenericType<List<UserDto>> listUserResponseType = new GenericType<List<UserDto>>() {
    };

    public static void initDb() {
        dao.dropUserTable();
        dao.createUserTable();
    }

    static User createUserWithName(String name) {
        User user = new User(name, "mdpTemporaire");
        return createUser(user);
    }

    public static User createUserWithPassword(String name, String password) {
        User user = new User(name, password);
        return createUser(user);
    }

 

  

    private static User createUser(User user) {
        String login = dao.insert(user);
        user.setLogin(login);
        return user;
    }


    private static User createFullUSer(String name,String password,String role) {
        User user = new User(name,password,role);
        
        String id = dao.insert(user);
        return user;
    }

    static void createRms() {
        createFullUSer("Richard Stallman", "RMS", "parent");
    }

    static User createRob() {
        return createFullUSer("Robert Capillo", "rob", "parent");
    }

    static User createLinus() {
        return createFullUSer("Linus Torvalds", "linus", "admin");
    }

    static User createIan() {
        return createFullUSer("Ian Murdock", "debian", "salarie");
    }
}
