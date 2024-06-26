package pe.edu.upc.abilityhelpv1.servicesinterfaces;

import pe.edu.upc.abilityhelpv1.dtos.ScheduleDTO;
import pe.edu.upc.abilityhelpv1.entities.Rol;
import pe.edu.upc.abilityhelpv1.entities.Schedule;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface IScheduleServices {

    public void insert(Schedule schedule);
    public List<Schedule> list();
    public void delete(int id);
    public List<Schedule> findByWeekDay(LocalDate weekDay);
    public void update(Schedule schedule);
    public Schedule listarId(int idSch);

}
