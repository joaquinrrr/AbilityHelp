package pe.edu.upc.abilityhelpv1.servicesinterfaces;

import org.springframework.data.repository.query.Param;
import pe.edu.upc.abilityhelpv1.entities.Meeting;

import java.time.LocalDate;
import java.util.List;

public interface IMeetServices {

    public void insert(Meeting meeting);

    public List<Meeting> list();

    public void delete(int id);

    public void update(Meeting meeting);

    public List<String[]> QuantityMeetPerCoach(String name);

    public List<String[]> meetingPerUserDate(LocalDate date);

    public List<String[]> quantityMeetsPerMonth(int year);

    public List<String[]> averageMeetUser();


}