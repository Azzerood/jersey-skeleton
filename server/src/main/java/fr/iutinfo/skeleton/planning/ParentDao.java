
package fr.iutinfo.skeleton.planning;

import org.skife.jdbi.v2.sqlobject.*;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;

import java.util.Calendar;
import java.util.List;

public interface ParentDao {
    @SqlUpdate("CREATE TABLE parents(id integer primary key autoincrement, nom CHAR(20), prenom CHAR(20), dateNaissance DATE, adresse CHAR(50),conge CHAR(20), profession CHAR(20), numeroCaf CHAR(20), categorieCaf CHAR(20), debutContrat CHAR(20), finContrat CHAR(20), typeContrat CHAR(20), numero CHAR(20);")
    void createParentTable();

    @SqlUpdate("insert into parents(nom, prenom,dateNaissance, adresse, numero) values (:nom, :prenom, :dateNaissance, :adresse, :numero)")
    @GetGeneratedKeys
    String insert(@BindBean() Parent parent);
    
    @SqlUpdate("insert into parents(nom, prenom, dateNaissance, adresse, dateNaissance, conge, profession, numeroCaf, categorieCaf, debutContrat, finContrat, typeContrat, numero) values (:nom, :prenom, :dateNaissance, :adresse, :dateNaissance, :conge, :profession, :numeroCaf, :categorieCaf, :debutContrat, :finContrat, :typeContrat, :numero)")
    @GetGeneratedKeys
    String insertAll(@BindBean() Parent parent);

    @SqlQuery("select * from parents where nom = :nom AND prenom = :prenom")
    @RegisterMapperFactory(BeanMapperFactory.class)
    List<Parent> search(@BindBean() int id);
   
    @SqlQuery("select * from parents where id = :id")
    @RegisterMapperFactory(BeanMapperFactory.class)
    Parent findById(@Bind("id") int id);
    
    @SqlQuery("select * from parents order by nom")
    @RegisterMapperFactory(BeanMapperFactory.class)
    List<Parent> all();
    
    @SqlUpdate("delete from parents where id = :id")
    @RegisterMapperFactory(BeanMapperFactory.class)
    void delete(@Bind("id") int id);
    
    @SqlUpdate("delete from parents")
    @RegisterMapperFactory(BeanMapperFactory.class)
    void deleteAll();
    
    @SqlUpdate("drop table if exists parents;")
    void dropCreneauTable();
    
    void close();
}