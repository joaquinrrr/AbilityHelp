package pe.edu.upc.abilityhelpv1.servicesinterfaces;


import pe.edu.upc.abilityhelpv1.entities.Gender;
import pe.edu.upc.abilityhelpv1.entities.Incidents;

import java.util.List;

public interface IIncidentServices {
    public void insert(Incidents incidents);
    public List<Incidents> list();
    public void delete(int id);
    public void update(Incidents incidents);
    public Incidents listarId(int idIncident);

}
