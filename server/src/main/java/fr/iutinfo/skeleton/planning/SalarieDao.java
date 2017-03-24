
package fr.iutinfo.skeleton.planning;

import org.skife.jdbi.v2.sqlobject.*;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;

import java.util.Calendar;
import java.util.List;

public interface SalarieDao {
    @SqlUpdate("CREATE TABLE salaries(id integer primary key autoincrement, nom CHAR(20), prenom CHAR(20), nationnalite CHAR(20), dateNaissance DATE, adresse CHAR(50), departement CHAR(20), typeContrat CHAR(20), tempsContrat CHAR(20), debutContrat CHAR(20), finContrat CHAR(20), typeContrat CHAR(20), renumeration CHAR(20), numeroSecu CHAR(20);")
    void createParentTable();

    @SqlUpdate("insert into salaries(nom, prenom, nationnalite, dateNaissance, adresse, renumeration, numeroSecu) values (:nom, :prenom, :nationnalite, :dateNaissance, :adresse, :renumeration, :numeroSecu)")
    @GetGeneratedKeys
    String insert(@BindBean() Salarie salarie);
    
    @SqlUpdate("insert into salaries(nom, prenom, nationnalite, dateNaissance, adresse, dateNaissance, departement, typeContrat, tempsContrat, debutContrat, finContrat, typeContrat, renumeration, numeroSecu) values 	(:nom, :prenom,  :nationnalite, :dateNaissance, :adresse, :dateNaissance, :departement, :typeContrat, :tempsContrat, :debutContrat, :finContrat, :typeContrat, :renumeration, :numeroSecu)")
    @GetGeneratedKeys
    String insertAll(@BindBean() Salarie salarie);

    @SqlQuery("select * from salaries where nom = :nom AND prenom = :prenom")
    @RegisterMapperFactory(BeanMapperFactory.class)
    List<Salarie> search(@BindBean() int id);
   
    @SqlQuery("select * from salaries where id = :id")
    @RegisterMapperFactory(BeanMapperFactory.class)
    Salarie findById(@Bind("id") int id);
    
    @SqlQuery("select * from salaries order by nom")
    @RegisterMapperFactory(BeanMapperFactory.class)
    List<Salarie> all();
    
    @SqlUpdate("delete from salaries where id = :id")
    @RegisterMapperFactory(BeanMapperFactory.class)
    void delete(@Bind("id") int id);
    
    @SqlUpdate("delete from salaries")
    @RegisterMapperFactory(BeanMapperFactory.class)
    void deleteAll();
    
    @SqlUpdate("drop table if exists salaries;")
    void dropCreneauTable();
    
    void close();
}