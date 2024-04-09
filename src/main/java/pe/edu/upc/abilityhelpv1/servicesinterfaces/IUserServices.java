package pe.edu.upc.abilityhelpv1.servicesinterfaces;

import pe.edu.upc.abilityhelpv1.entities.User;

import java.time.LocalDate;
import java.util.List;

public interface IUserServices {
    public void insert(User user);
    public List<User> list();
    public void delete(int id);
}
