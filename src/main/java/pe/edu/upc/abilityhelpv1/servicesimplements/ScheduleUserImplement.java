package pe.edu.upc.abilityhelpv1.servicesimplements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.abilityhelpv1.entities.ScheduleUser;
import pe.edu.upc.abilityhelpv1.repositories.IScheduleUserRepository;
import pe.edu.upc.abilityhelpv1.servicesinterfaces.IScheduleUserServices;
import java.util.List;

@Service
public class ScheduleUserImplement implements IScheduleUserServices {

    @Autowired
    private IScheduleUserRepository sR;

    @Override
    public void insert(ScheduleUser scheduleuser) {
        sR.save(scheduleuser);
    }

    @Override
    public List<ScheduleUser> list() {
        return sR.findAll();
    }

    @Override
    public void delete(int id) {
        sR.deleteById(id);
    }

}
