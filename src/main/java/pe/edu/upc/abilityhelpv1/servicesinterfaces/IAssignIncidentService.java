package pe.edu.upc.abilityhelpv1.servicesinterfaces;

import org.springframework.data.repository.query.Param;
import pe.edu.upc.abilityhelpv1.entities.AssignIncident;

import java.util.List;

public interface IAssignIncidentService {
    public void insert(AssignIncident assignIncident);
    public List<AssignIncident> list();
    public void delete(int id);
    public void update(AssignIncident assignIncident);
    public List<String[]> AssignIncidentByStudent(String name);

}
