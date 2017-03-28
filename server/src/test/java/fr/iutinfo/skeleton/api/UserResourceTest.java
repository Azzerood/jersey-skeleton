package fr.iutinfo.skeleton.api;

import fr.iutinfo.skeleton.common.dto.UserDto;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import static fr.iutinfo.skeleton.api.Helper.*;
import static org.junit.Assert.assertEquals;

public class UserResourceTest extends JerseyTest {
    private static final String PATH = "/user";
    private UserDao dao = BDDFactory.getDbi().open(UserDao.class);

    @Override
    protected Application configure() {
        return new Api();
    }

    @Before
    public void init() {
        Helper.initDb();
    }
    
    @Test
    public void list_should_return_all_users() {
        createUserWithName("foo");
        createUserWithName("bar");
        List<UserDto> users = target(PATH + "/").request().get(listUserResponseType);
        assertEquals(2, users.size());
    }
   
}