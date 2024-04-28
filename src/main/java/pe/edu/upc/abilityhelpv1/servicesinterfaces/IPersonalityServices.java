package pe.edu.upc.abilityhelpv1.servicesinterfaces;

import pe.edu.upc.abilityhelpv1.entities.Incidents;
import pe.edu.upc.abilityhelpv1.entities.Personalities;
import java.util.List;

public interface IPersonalityServices {
    public void insert(Personalities personalities);
    public List<Personalities> list();
    public Personalities listId(int id);
    public void delete(int id);
}
