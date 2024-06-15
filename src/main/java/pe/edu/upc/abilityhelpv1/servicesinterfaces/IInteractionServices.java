package pe.edu.upc.abilityhelpv1.servicesinterfaces;

import pe.edu.upc.abilityhelpv1.entities.Incidents;
import pe.edu.upc.abilityhelpv1.entities.Interaction;

import java.util.List;

public interface IInteractionServices {
    public void insert(Interaction interaction);
    public List<Interaction> list();
    public void delete(int id);
    public void update(Interaction interaction);
    public List<String[]> interactionWithUsers();
    public Interaction listarId(int idInteraction);

}
