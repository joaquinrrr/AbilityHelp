package pe.edu.upc.abilityhelpv1.servicesimplements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.abilityhelpv1.entities.Incidents;
import pe.edu.upc.abilityhelpv1.repositories.IncidentRepository;
import pe.edu.upc.abilityhelpv1.servicesinterfaces.IncidentServices;

import java.util.List;
@Service
public class IncidentsServiceImplement implements IncidentServices{
    @Autowired
    private IncidentRepository sR;
    @Override
    public void insert(Incidents incidents) {
        sR.save(incidents);
    }
    @Override
    public List<Incidents> list() {
        return sR.findAll();
    }
    @Override
    public Incidents listId(int id) {return sR.findById(id).orElse(new Incidents());}

    @Override
    public void delete(int id) {sR.deleteById(id);    }

    @Override
    public List<Incidents> findByIncident(String Type) {
        return null;
    }

}
