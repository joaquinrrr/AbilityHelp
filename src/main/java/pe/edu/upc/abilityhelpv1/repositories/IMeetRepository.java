package pe.edu.upc.abilityhelpv1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.edu.upc.abilityhelpv1.entities.Meeting;
//import pe.edu.upc.abilityhelpv1.servicesinterfaces.IMeetServices;

import java.time.LocalDate;
import java.util.List;

public interface IMeetRepository extends JpaRepository<Meeting, Integer> {
    @Query(value = "select us.username as Coach, s.week_day as Date , count(*) as Quantity_Meetings from meeting as me \n" +
            "inner join schedule as s ON s.id_schedule = me.id_schedule \n" +
            "inner join user_table as us ON us.id_user = s.coach_id \n" +
            "where us.username=:name \n" +
            "group by us.username, s.week_day", nativeQuery = true)
    public List<String[]> QuantityMeetPerCoach(@Param("name") String name);

    @Query(value = "select us.username as Name, sc.week_day as Date , sc.start_hour, sc.finish_hour  from meeting as me \n" +
            "inner join user_table as us ON us.id_user = me.user_id \n" +
            "inner join schedule as sc ON sc.id_schedule = me.id_schedule \n" +
            "where sc.week_day =:date \n" +
            "group by us.username, sc.week_day, sc.start_hour, sc.finish_hour", nativeQuery = true)
    public List<String[]> meetingPerUserDate(@Param("date") LocalDate date);

    @Query(value = "SELECT to_char(s.week_day, 'Month') AS mes,\n" +
            "COUNT(*) AS cantidad_reuniones\n" +
            "FROM Meeting m\n" +
            "INNER JOIN Schedule s ON m.id_schedule = s.id_schedule\n" +
            "WHERE date_part('year', s.week_day) =:year \n" +
            "GROUP BY mes", nativeQuery = true)
    public List<String[]> quantityMeetsPerMonth(@Param("year") int year);

    @Query(value = "SELECT u.username, AVG(num_reuniones) AS promedio_reuniones \n" +
            "FROM ( \n" +
            "    SELECT u.id_user, COUNT(*) AS num_reuniones\n" +
            "    FROM meeting AS m \n" +
            "    INNER JOIN user_table AS u ON u.id_user = m.student_id \n" +
            "    GROUP BY u.id_user \n" +
            ") AS reuniones_por_usuario \n" +
            "JOIN user_table AS u ON reuniones_por_usuario.id_user = u.id_user \n" +
            "GROUP BY u.username ", nativeQuery = true)
    public List<String[]> averageMeetUser();


}
