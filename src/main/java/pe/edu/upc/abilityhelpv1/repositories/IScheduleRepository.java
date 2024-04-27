package pe.edu.upc.abilityhelpv1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.abilityhelpv1.entities.Schedule;

import java.time.LocalDate;
import java.util.List;
@Repository
public interface IScheduleRepository extends JpaRepository<Schedule,Integer>  {
    public List<Schedule> findByWeekDay(LocalDate weekDay);
}
