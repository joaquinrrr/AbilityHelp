package pe.edu.upc.abilityhelpv1.servicesinterfaces;

import pe.edu.upc.abilityhelpv1.entities.Meeting;

import java.util.List;

public interface IMeetServices {

    public void insert(Meeting meeting);
    public List<Meeting> list();
    public void delete(int id);
}
