
package fr.iutinfo.skeleton.planning;

import org.skife.jdbi.v2.sqlobject.*;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;

import java.util.List;

public interface EnfantDao {
    @SqlUpdate("CREATE TABLE enfants(id integer primary key autoincrement, nom CHAR(20), prenom CHAR(20), dateNaissance DATE, adresse CHAR(50),tempsAccueil char(20), horraireAccueil char(20),periodeAdaptation char(20), allergies char(100), numeroUrgence char(20), numeroMedecin char(20), photo char(30));")
    void createEnfantTable();
    
    @SqlUpdate("insert into enfants(nom, prenom,dateNaissance, adresse, tempsAccueil, horraireAccueil, periodeAdaptation, allergies, numeroUrgence, numeroMedecin, photo) values (:nom, :prenom, :dateNaissance, :adresse, :tempsAccueil, :horraireAccueil, :periodeAdaptation, :allergies, :numeroUrgence, :numeroMedecin, :photo)")
    @GetGeneratedKeys
    String insertAllInfo(@BindBean() Enfant enfant);
    
    @SqlUpdate("insert into enfants(nom, prenom,dateNaissance, adresse, horraireAccueil) values (:nom, :prenom, :dateNaissance, :adresse, :horraireAccueil)")
    @GetGeneratedKeys
    String insert(@BindBean() Enfant enfant);
    
    @SqlQuery("select * from enfants where nom = :nom AND prenom = :prenom")
    @RegisterMapperFactory(BeanMapperFactory.class)
    List<Enfant> search(@BindBean() int id);
   
    @SqlQuery("select * from enfants where id = :id")
    @RegisterMapperFactory(BeanMapperFactory.class)
    Enfant findById(@Bind("id") int id);
    
    @SqlQuery("select * from enfants order by nom")
    @RegisterMapperFactory(BeanMapperFactory.class)
    List<Enfant> all();
    
    @SqlUpdate("delete from enfants where id = :id")
    @RegisterMapperFactory(BeanMapperFactory.class)
    void delete(@Bind("id") int id);
    
    @SqlUpdate("delete from enfants")
    @RegisterMapperFactory(BeanMapperFactory.class)
    void deleteAll();
    
    @SqlUpdate("drop table if exists enfants;")
    void dropCreneauTable();
    
    void close();
}