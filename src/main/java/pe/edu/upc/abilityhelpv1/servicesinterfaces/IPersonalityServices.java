package pe.edu.upc.abilityhelpv1.servicesinterfaces;

import pe.edu.upc.abilityhelpv1.entities.Meeting;
import pe.edu.upc.abilityhelpv1.entities.Personalities;
import java.util.List;

public interface IPersonalityServices {
    public void insert(Personalities personalities);
    public List<Personalities> list();
    public void delete(int id);
    public void update(Personalities personalities);
    public List<String[]> quantityUserPerPersonality(String name);

}
