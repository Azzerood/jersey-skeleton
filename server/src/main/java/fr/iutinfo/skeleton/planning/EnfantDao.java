
package fr.iutinfo.skeleton.api;

import org.skife.jdbi.v2.sqlobject.*;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;

import java.util.List;

public interface EnfantDao {
    @SqlUpdate("CREATE TABLE enfants(nom CHAR(20), prenom CHAR(20));")
    void createCreneauTable();
    
    @SqlUpdate("insert into enfants(nom, prenom) values (:nom, :prenom)")
    @GetGeneratedKeys
    String insert(@BindBean() Enfant enfant);
    
    @SqlQuery("select * from enfants where nom = :nom AND prenom = :prenom")
    @RegisterMapperFactory(BeanMapperFactory.class)
    List<Enfant> search(@BindBean() Enfant enfant);
    
    @SqlQuery("select * from enfants order by nom")
    @RegisterMapperFactory(BeanMapperFactory.class)
    List<Enfant> all();
    
    @SqlUpdate("drop table if exists enfants;")
    void dropCreneauTable();
    
    void close();
}