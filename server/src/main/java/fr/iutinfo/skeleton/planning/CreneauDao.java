
package fr.iutinfo.skeleton.planning;

import org.skife.jdbi.v2.sqlobject.*;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;

import fr.iutinfo.skeleton.api.User;

import java.util.Date;
import java.util.List;

public interface CreneauDao {
    @SqlUpdate("CREATE TABLE creneaux(id integer primary key autoincrement, status char(20),date DATE, heureDebut INT, heureFin INT, listEnfant char(200); ")
    void createCreneauTable();
    
    @SqlUpdate("insert into creneaux(status,date, heureDebut, heureFin, listEnfant) values (:status, :date, :heureDebut, :heureFin, :listEnfant)")
    @GetGeneratedKeys
    String insert(@BindBean() Creneau creneau);
    
    @SqlQuery("select * from creneaux where search like :id")
    @RegisterMapperFactory(BeanMapperFactory.class)
    List<Creneau> search(@Bind("id") int id);
    
    @SqlQuery("select * from creneaux order by date")
    @RegisterMapperFactory(BeanMapperFactory.class)
    List<Creneau> all();
    
    @SqlQuery("select * from creneaux where id = :id")
    @RegisterMapperFactory(BeanMapperFactory.class)
    Creneau findById(@Bind("id") int id); 

    @SqlUpdate("delete from creneaux where id = :id")
    void delete(@Bind("id") int id);
    
    @SqlUpdate("drop table if exists creneaux;")
    void dropCreneauTable();
    
    void close();
}