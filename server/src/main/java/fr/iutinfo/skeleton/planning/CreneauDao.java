
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
    @SqlUpdate("CREATE TABLE creneaux(id integer primary key autoincrement, status char(20),date char(10), heureDebut integer, heureFin integer, listEnfant char(200));")
    void createCreneauTable();
    
    @SqlUpdate("insert into creneaux(status,date, heureDebut, heureFin, listEnfant) values (:status, :date, :heureDebut, :heureFin, :listEnfant)")
    @GetGeneratedKeys
    int insert(@BindBean() Creneau creneau);
    
    @SqlQuery("select * from creneaux where search like :id")
    @RegisterMapperFactory(BeanMapperFactory.class)
    List<Creneau> search(@Bind("id") int id);
    
    @SqlQuery("select * from creneaux order by date")
    @RegisterMapperFactory(BeanMapperFactory.class)
    List<Creneau> all();
    
    @SqlQuery("select * from creneaux where status = :status order by date")
    @RegisterMapperFactory(BeanMapperFactory.class)
    List<Creneau> selectByStatus(@Bind("status") String status);
    
    @SqlQuery("select * from creneaux where date = :date1 order by date")
    @RegisterMapperFactory(BeanMapperFactory.class)
    List<Creneau> selectByDate(@Bind("date")String date1 );
    
    @SqlQuery("select * from creneaux where status = :status AND date = :date")
    @RegisterMapperFactory(BeanMapperFactory.class)
    List<Creneau> selectByStatusAndDate(@Bind("status") String status, @Bind("date")String date );
    
    @SqlQuery("select * from creneaux where id = :id")
    @RegisterMapperFactory(BeanMapperFactory.class)
    Creneau findById(@Bind("id") int id); 

    @SqlUpdate("delete from creneaux where id = :id")
    @RegisterMapperFactory(BeanMapperFactory.class)
    void delete(@Bind("id") int id);
    
    @SqlUpdate("UPDATE creneaux SET listEnfant = :enfants WHERE id = :id;")
    @RegisterMapperFactory(BeanMapperFactory.class)
    void updateCreneau(@Bind("id") int id, @Bind("enfants") String enfants);
    
    @SqlUpdate("delete from creneaux")
    @RegisterMapperFactory(BeanMapperFactory.class)
    void deleteAll();
    
    @SqlUpdate("drop table if exists creneaux;")
    void dropCreneauTable();
    
    void close();
}
