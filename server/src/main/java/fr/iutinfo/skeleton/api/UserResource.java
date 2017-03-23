package fr.iutinfo.skeleton.api;

import fr.iutinfo.skeleton.common.dto.UserDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

import static fr.iutinfo.skeleton.api.BDDFactory.getDbi;
import static fr.iutinfo.skeleton.api.BDDFactory.tableExist;

@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {
    final static Logger logger = LoggerFactory.getLogger(UserResource.class);
    private static UserDao dao = getDbi().open(UserDao.class);

    public UserResource() throws SQLException {
        if (!tableExist("users")) {
            logger.debug("Create table users");
            dao.createUserTable();
            dao.insert(new User( "toto", "toto","parent"));
            dao.insert(new User("admin","admin","parent"));
        }
    }

    @POST
    public UserDto createUser(UserDto dto) {
        User user = new User(dto.getLogin(),"");
        user.initFromDto(dto);
        String login = dao.insert(user);
        dto.setLogin(login);
        return dto;
    }

    @GET
    @Path("/{name}")
    public UserDto getUser(@PathParam("login") String login) {
        User user = dao.findByName(login);
        if (user == null) {
            throw new WebApplicationException(404);
        }
        return user.convertToDto();
    }

    @GET
    public List<UserDto> getAllUsers(@QueryParam("q") String query) {
        List<User> users;
        if (query == null) {
            users = dao.all();
        } else {
            logger.debug("Search users with query: " + query);
            users = dao.search("%" + query + "%");
        }
        return users.stream().map(User::convertToDto).collect(Collectors.toList());
    }

    @DELETE
    @Path("/{login}")
    public void deleteUser(@PathParam("login") String login) {
        dao.delete(login);
    }

}
