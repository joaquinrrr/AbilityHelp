package pe.edu.upc.abilityhelpv1.servicesinterfaces;

import pe.edu.upc.abilityhelpv1.entities.Gender;
import java.util.List;

public interface IGenderService {
    public void insert(Gender gender);
    public List<Gender> list();
    public void delete(int id);
    public void update(Gender gender);
}
