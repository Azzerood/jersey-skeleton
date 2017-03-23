package fr.iutinfo.skeleton.api;

import org.skife.jdbi.v2.sqlobject.*;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;

import java.util.List;

public interface UserDao {
    @SqlUpdate("CREATE TABLE users (login CHAR (20) PRIMARY KEY, password CHAR (20) NOT NULL, role CHAR(20) NOT NULL);")
    void createUserTable();

    @SqlUpdate("insert into users (login,password,role) values (:login, :password, :role)")
    @GetGeneratedKeys
    String insert(@BindBean() User user);

    @SqlQuery("select * from users where login = :login")
    @RegisterMapperFactory(BeanMapperFactory.class)
    User findByName(@Bind("login") String login);

    @SqlQuery("select * from users where search like :login")
    @RegisterMapperFactory(BeanMapperFactory.class)
    List<User> search(@Bind("login") String login);

    @SqlUpdate("drop table if exists users")
    void dropUserTable();

    @SqlUpdate("delete from users where login = :login")
    void delete(@Bind("login") String login);

    @SqlQuery("select * from users order by login")
    @RegisterMapperFactory(BeanMapperFactory.class)
    List<User> all();

    @SqlQuery("select * from users where login = :login")
    @RegisterMapperFactory(BeanMapperFactory.class)
    User findById(@Bind("login") String login);

    void close();
}
