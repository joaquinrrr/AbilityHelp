package pe.edu.upc.abilityhelpv1.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.abilityhelpv1.entities.Incidents;
import pe.edu.upc.abilityhelpv1.repositories.IIncidentsRepository;
import pe.edu.upc.abilityhelpv1.servicesinterfaces.IIncidentServices;

import java.util.List;
@Service
public class IncidentServiceImplement implements IIncidentServices {
    @Autowired
    private IIncidentsRepository iR;

    @Override
    public void insert(Incidents incidents) {
        iR.save(incidents);
    }

    @Override
    public List<Incidents> list() {
        return iR.findAll();
    }

    @Override
    public void delete(int id) {
        iR.deleteById(id);
    }

    @Override
    public void update(Incidents incidents) {
        iR.save(incidents);
    }
}
