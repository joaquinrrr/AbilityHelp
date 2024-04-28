package pe.edu.upc.abilityhelpv1.servicesinterfaces;
import pe.edu.upc.abilityhelpv1.entities.Incidents;
import java.util.List;

public interface IncidentServices {
    public void insert(Incidents incidents);
    public List<Incidents> list();
    public Incidents listId(int id);
    public void delete(int id);
    public List<Incidents> findByIncident(String Type);
}
