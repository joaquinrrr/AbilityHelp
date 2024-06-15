package pe.edu.upc.abilityhelpv1.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.abilityhelpv1.entities.Chat;
import pe.edu.upc.abilityhelpv1.entities.Degree;
import pe.edu.upc.abilityhelpv1.repositories.IDegreeRepository;
import pe.edu.upc.abilityhelpv1.servicesinterfaces.IDegreeServices;

import java.util.List;

@Service
public class DegreeServiceImplement implements IDegreeServices {
    @Autowired
    private IDegreeRepository sR;

    @Override
    public void insert(Degree degree) {
        sR.save(degree);
    }

    @Override
    public List<Degree> list() {
        return sR.findAll();
    }

    @Override
    public void delete(int id) {
        sR.deleteById(id);
    }

    @Override
    public void update(Degree degree) {
        sR.save(degree);
    }

    @Override
    public List<String[]> quantityPersonalityDegreeUser() {
        return sR.quantityPersonalityDegreeUser();
    }

    @Override
    public Degree listarId(int idDegree) {
        return sR.findById(idDegree).orElse(new Degree());
    }

}
