package pe.edu.upc.abilityhelpv1.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.abilityhelpv1.entities.Incidents;
import pe.edu.upc.abilityhelpv1.entities.Interaction;
import pe.edu.upc.abilityhelpv1.repositories.IInteractionRepository;
import pe.edu.upc.abilityhelpv1.servicesinterfaces.IInteractionServices;

import java.util.List;
@Service
public class InteractionServiceImplement implements IInteractionServices {
    @Autowired
    private IInteractionRepository iR;
    @Override
    public void insert(Interaction interaction) {
        iR.save(interaction);
    }

    @Override
    public List<Interaction> list() {
        return iR.findAll();
    }

    @Override
    public void delete(int id) {
        iR.deleteById(id);
    }

    @Override
    public void update(Interaction interaction) {
        iR.save(interaction);
    }

    @Override
    public List<String[]> interactionWithUsers() {
        return iR.interactionWithUsers();
    }

    @Override
    public Interaction listarId(int idInteraction) {
        return iR.findById(idInteraction).orElse(new Interaction());
    }
}
