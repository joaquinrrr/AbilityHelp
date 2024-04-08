package pe.edu.upc.abilityhelpv1.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.abilityhelpv1.entities.Gender;
import pe.edu.upc.abilityhelpv1.repositories.IGenderRepository;
import pe.edu.upc.abilityhelpv1.servicesinterfaces.IGenderService;


import java.util.List;
@Service
public class GenderServiceImplement implements IGenderService{
    @Autowired
    private IGenderRepository gR;
    @Override
    public void insert(Gender gender) {
        gR.save(gender);
    }

    @Override
    public List<Gender> list() {
        return gR.findAll();
    }

    @Override
    public void delete(int id) {
        gR.deleteById(id);
    }
}
