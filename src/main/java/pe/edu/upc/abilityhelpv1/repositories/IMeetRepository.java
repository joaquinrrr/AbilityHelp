package pe.edu.upc.abilityhelpv1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.edu.upc.abilityhelpv1.entities.Meeting;
import pe.edu.upc.abilityhelpv1.servicesinterfaces.IMeetServices;

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
            "where us.username =:name and sc.week_day =:date \n" +
            "group by us.username, sc.week_day, sc.start_hour, sc.finish_hour", nativeQuery = true)
    public List<String[]> meetingPerUserDate(@Param("name") String name, @Param("date") LocalDate date);
}
