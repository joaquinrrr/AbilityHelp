package pe.edu.upc.abilityhelpv1.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.abilityhelpv1.entities.Meeting;
import pe.edu.upc.abilityhelpv1.repositories.IMeetRepository;
import pe.edu.upc.abilityhelpv1.servicesinterfaces.IMeetServices;

import java.time.LocalDate;
import java.util.List;
@Service
public class MeetingServiceImplement implements IMeetServices {
    @Autowired
    private IMeetRepository sR;
    @Override
    public void insert(Meeting meeting) {
        sR.save(meeting);
    }

    @Override
    public List<Meeting> list() {
        return sR.findAll();
    }

    @Override
    public void delete(int id) {
        sR.deleteById(id);
    }

    @Override
    public void update(Meeting meeting) {
        sR.save(meeting);
    }

    @Override
    public List<String[]> QuantityMeetPerCoach(String name) {
        return sR.QuantityMeetPerCoach(name);
    }

    @Override
    public List<String[]> meetingPerUserDate(LocalDate date) {
        return sR.meetingPerUserDate(date);
    }

    @Override
    public List<String[]> quantityMeetsPerMonth(int year) {
        return sR.quantityMeetsPerMonth(year);
    }
}
