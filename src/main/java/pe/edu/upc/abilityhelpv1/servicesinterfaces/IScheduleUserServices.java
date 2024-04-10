package pe.edu.upc.abilityhelpv1.servicesinterfaces;

import java.util.List;

import pe.edu.upc.abilityhelpv1.entities.ScheduleUser;

public interface IScheduleUserServices {

    public void insert(ScheduleUser scheduleUser);
    public List<ScheduleUser> list();
    public void delete(int id);

}
