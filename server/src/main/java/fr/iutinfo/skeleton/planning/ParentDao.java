
package fr.iutinfo.skeleton.planning;

import org.skife.jdbi.v2.sqlobject.*;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;

import java.util.Calendar;
import java.util.List;

public interface ParentDao {
    @SqlUpdate("CREATE TABLE parents(id integer primary key autoincrement, nomA CHAR(20), prenomA CHAR(20), dateNaissanceA CHAR(20), adresseA CHAR(50),congesA CHAR(20), professionA CHAR(20), numeroCafA CHAR(20), categorieCafA CHAR(20),numeroA CHAR(20),nomB CHAR(20), prenomB CHAR(20), dateNaissanceB CHAR(20), adresseB CHAR(50),congesB CHAR(20), professionB CHAR(20), numeroCafB CHAR(20), categorieCafB CHAR(20),numeroB CHAR(20), dureeContrat CHAR(50), typeContrat CHAR(20), ;")
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
