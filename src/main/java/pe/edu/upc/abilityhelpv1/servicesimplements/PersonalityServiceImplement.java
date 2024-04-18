package pe.edu.upc.abilityhelpv1.servicesimplements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.abilityhelpv1.entities.Incidents;
import pe.edu.upc.abilityhelpv1.entities.Personalities;
import pe.edu.upc.abilityhelpv1.repositories.IPersonalityRepository;
import pe.edu.upc.abilityhelpv1.servicesinterfaces.IPersonalityServices;

import java.util.List;
@Service
public class PersonalityServiceImplement implements IPersonalityServices {
    @Autowired
    private IPersonalityRepository sR;
    @Override
    public void insert(Personalities personalities) {
        sR.save(personalities);
    }
    @Override
    public List<Personalities> list() {
        return sR.findAll();
    }

    @Override
    public Personalities listId(int id) {return sR.findById(id).orElse(new Personalities());}

    public Personalities ListId(int id){return sR.findById(id).orElse(new Personalities());}
}