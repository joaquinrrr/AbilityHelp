package pe.edu.upc.abilityhelpv1.servicesimplements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.abilityhelpv1.entities.Rol;
import pe.edu.upc.abilityhelpv1.repositories.IRolRepository;
import pe.edu.upc.abilityhelpv1.servicesinterfaces.IRolServices;

import java.util.List;
@Service
public class RolServiceImplement implements IRolServices {
    @Autowired
    private IRolRepository sR;
    @Override
    public void insert(Rol rol) {
        sR.save(rol);
    }

    @Override
    public List<Rol> list() {
        return sR.findAll();
    }

    @Override
    public void delete(int id) {
        sR.deleteById(id);
    }
}


