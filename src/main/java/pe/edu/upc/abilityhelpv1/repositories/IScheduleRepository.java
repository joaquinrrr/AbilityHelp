package pe.edu.upc.abilityhelpv1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.abilityhelpv1.entities.Schedule;

public interface IScheduleRepository extends JpaRepository<Schedule,Integer>  {

}
