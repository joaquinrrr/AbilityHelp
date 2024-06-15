package pe.edu.upc.abilityhelpv1.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.abilityhelpv1.entities.Schedule;
import pe.edu.upc.abilityhelpv1.entities.TypeInteraction;
import pe.edu.upc.abilityhelpv1.repositories.ITypeInteractionRepository;
import pe.edu.upc.abilityhelpv1.servicesinterfaces.ITypeInteractionServices;

import java.util.List;
@Service
public class TypeInteractionServiceImplement implements ITypeInteractionServices {
    @Autowired
    private ITypeInteractionRepository tR;
    @Override
    public void insert(TypeInteraction typeInteraction) {
        tR.save(typeInteraction);
    }

    @Override
    public List<TypeInteraction> list() {
        return tR.findAll();
    }

    @Override
    public void delete(int id) {
        tR.deleteById(id);
    }

    @Override
    public void update(TypeInteraction typeInteraction) {
        tR.save(typeInteraction);
    }

    @Override
    public TypeInteraction listarId(int idType) {
        return tR.findById(idType).orElse(new TypeInteraction());
    }
}
