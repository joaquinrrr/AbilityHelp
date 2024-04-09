package pe.edu.upc.abilityhelpv1.servicesinterfaces;

import pe.edu.upc.abilityhelpv1.entities.Incidents;

import java.util.List;

public interface IncidentServices {
    public void insert(Incidents incidents);
    public List<Incidents> list();
    public Incidents ListId(int id);
}
