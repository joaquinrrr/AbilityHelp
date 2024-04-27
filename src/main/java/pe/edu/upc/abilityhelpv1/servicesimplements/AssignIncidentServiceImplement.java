package pe.edu.upc.abilityhelpv1.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.abilityhelpv1.entities.AssignIncident;
import pe.edu.upc.abilityhelpv1.repositories.IAssignIncidentRepository;
import pe.edu.upc.abilityhelpv1.servicesinterfaces.IAssignIncidentService;

import java.util.List;

@Service
public class AssignIncidentServiceImplement implements IAssignIncidentService {
    @Autowired
    private IAssignIncidentRepository aR;
    @Override
    public void insert(AssignIncident assignIncident) {
        aR.save((assignIncident));
    }

    @Override
    public List<AssignIncident> list() {
        return aR.findAll();
    }

    @Override
    public void delete(int id) {
        aR.deleteById(id);
    }

    @Override
    public void update(AssignIncident assignIncident) {
        aR.save(assignIncident);
    }
    @Override
    public List<String[]> AssignIncidentByStudent(String name) {
        return aR.AssignIncidentByStudent(name);
    }
}
