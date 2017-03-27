
package fr.iutinfo.skeleton.planning;

import org.skife.jdbi.v2.sqlobject.*;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;

import fr.iutinfo.skeleton.common.dto.ParentDto;

import java.util.Calendar;
import java.util.List;

public interface ParentDao {
    @SqlUpdate("CREATE TABLE parents(id integer primary key autoincrement,nomEnfant CHAR(20),prenomEnfant CHAR(20), nomA CHAR(20), prenomA CHAR(20), dateNaissanceA CHAR(20), adresseA CHAR(50),congesA CHAR(20), professionA CHAR(20), numeroCafA CHAR(20), categorieCafA CHAR(20),numeroA CHAR(20),nomB CHAR(20), prenomB CHAR(20), dateNaissanceB CHAR(20), adresseB CHAR(50),congesB CHAR(20), professionB CHAR(20), numeroCafB CHAR(20), categorieCafB CHAR(20),numeroB CHAR(20), dureeContrat CHAR(50), typeContrat CHAR(20) )")
    void createParentTable();

    @SqlUpdate("insert into parents(nomEnfant,prenomEnfant , nomA , prenomA, dateNaissanceA, adresseA,congesA , professionA , numeroCafA , categorieCafA ,numeroA ,nomB , prenomB, dateNaissanceB , adresseB ,congesB, professionB, numeroCafB , categorieCafB ,numeroB , dureeContrat, typeContrat) values (:nomEnfant,:prenomEnfant , :nomA , :prenomA, :dateNaissanceA, :adresseA,:congesA , :professionA , :numeroCafA , :categorieCafA ,:numeroA ,:nomB , :prenomB, :dateNaissanceB , :adresseB ,:congesB, :professionB, :numeroCafB , :categorieCafB ,:numeroB , :dureeContrat, :typeContrat)")
    @GetGeneratedKeys
    String insert(@BindBean() Parent parent);
    
    
    @SqlQuery("select * from parents where nom = :nom AND prenom = :prenom")
    @RegisterMapperFactory(BeanMapperFactory.class)
    List<Parent> search(@BindBean() int id);
   
    @SqlQuery("select * from parents where id = :id")
    @RegisterMapperFactory(BeanMapperFactory.class)
    Parent findById(@Bind("id") int id);
    
    @SqlQuery("select * from parents order by id")
    @RegisterMapperFactory(BeanMapperFactory.class)
    List<Parent> all();

    @SqlUpdate("update parents SET nomEnfant = :nomEnfant AND prenomEnfant = :prenomEnfant AND nomA = :nomA AND prenomA = :prenomA AND dateNaissanceA = :dateNaissanceA AND adresseA = :adresseA AND congesA = :congesA AND professionA = :professionA AND numeroCafA = :numeroCafA AND categorieCafA = :categorieCafA AND nomB = :nomB AND prenomB = :prenomB AND dateNaissanceB = :dateNaissanceB AND adresseB = :adresseB AND congesB = :congesB AND professionB = :professionB AND numeroCafB = :numeroCafB AND categorieCafB = :categorieCafB AND dureeContrat =:dureeContrat AND typeContrat =:typeContrat WHERE id = :id")
    @RegisterMapperFactory(BeanMapperFactory.class)
    void update(@BindBean()ParentDto parent);
    
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
