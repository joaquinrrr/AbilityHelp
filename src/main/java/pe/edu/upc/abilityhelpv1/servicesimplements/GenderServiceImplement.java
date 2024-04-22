package pe.edu.upc.abilityhelpv1.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.abilityhelpv1.entities.Gender;
import pe.edu.upc.abilityhelpv1.repositories.IGenderRepository;
import pe.edu.upc.abilityhelpv1.servicesinterfaces.IGenderServices;

import java.util.List;
@Service
public class GenderServiceImplement implements IGenderServices {
    @Autowired
    private IGenderRepository sR;
    @Override
    public void insert(Gender gender) {
        sR.save(gender);
    }

    @Override
    public List<Gender> list() {
        return sR.findAll();
    }

    @Override
    public void delete(int id) {
        sR.deleteById(id);
    }

    @Override
    public void update(Gender gender) {
        sR.save(gender);
    }
}
