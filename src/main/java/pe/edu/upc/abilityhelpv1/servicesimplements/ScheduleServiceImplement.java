package pe.edu.upc.abilityhelpv1.servicesimplements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.abilityhelpv1.entities.Schedule;
import pe.edu.upc.abilityhelpv1.repositories.IScheduleRepository;
import pe.edu.upc.abilityhelpv1.servicesinterfaces.IScheduleServices;

import java.util.List;
@Service
public class ScheduleServiceImplement implements IScheduleServices {
    @Autowired
    private IScheduleRepository sR;
    @Override
    public void insert(Schedule schedule) {
        sR.save(schedule);
    }

    @Override
    public List<Schedule> list() {
        return sR.findAll();
    }

    @Override
    public void delete(int id) {
        sR.deleteById(id);
    }

}
