
package fr.iutinfo.skeleton.planning;

import org.skife.jdbi.v2.sqlobject.*;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;

import java.util.Date;
import java.util.List;

public interface CreneauDao {
    @SqlUpdate("CREATE TABLE creneaux(date DATE, heureDebut INT, heureFin INT);")
    void createCreneauTable();
    
    @SqlUpdate("insert into creneaux(date, heureDebut, heureFin) values (:date, :heureDebut, :heureFin)")
    @GetGeneratedKeys
    String insert(@BindBean() Creneau creneau);
    
    @SqlQuery("select * from creneaux where date = :date")
    @RegisterMapperFactory(BeanMapperFactory.class)
    List<Creneau> search(@Bind("date") Date date);
    
    @SqlQuery("select * from creneaux order by date")
    @RegisterMapperFactory(BeanMapperFactory.class)
    List<Creneau> all();
    
    @SqlUpdate("drop table if exists creneaux;")
    void dropCreneauTable();
    
    void close();
}