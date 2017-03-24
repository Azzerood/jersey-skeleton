
package fr.iutinfo.skeleton.planning;

import java.util.Calendar;
import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;

public interface CreneauDao {
    @SqlUpdate("CREATE TABLE creneaux(id integer primary key autoincrement, status char(20),date char(20), heureDebut integer, heureFin integer, listEnfant char(200));")
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
    
    @SqlQuery("select * from creneaux where status = :status order by date")
    @RegisterMapperFactory(BeanMapperFactory.class)
    List<Creneau> selectByStatus(@Bind("status") String status);
    
    @SqlQuery("select * from creneaux where date BETWEEN :date1 AND :date2 order by date")
    @RegisterMapperFactory(BeanMapperFactory.class)
    List<Creneau> selectByDate(@Bind("date")Calendar date1, Calendar date2 );
    
    @SqlQuery("select * from creneaux where id = :id")
    @RegisterMapperFactory(BeanMapperFactory.class)
    Creneau findById(@Bind("id") int id); 

    @SqlUpdate("delete from creneaux where id = :id")
    @RegisterMapperFactory(BeanMapperFactory.class)
    void delete(@Bind("id") int id);
    
    @SqlUpdate("delete from creneaux")
    @RegisterMapperFactory(BeanMapperFactory.class)
    void deleteAll();
    
    @SqlUpdate("drop table if exists creneaux;")
    void dropCreneauTable();
    
    void close();
}