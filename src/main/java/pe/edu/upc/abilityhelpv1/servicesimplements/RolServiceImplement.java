package pe.edu.upc.abilityhelpv1.servicesimplements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.abilityhelpv1.entities.Rol;
import pe.edu.upc.abilityhelpv1.entities.User;
import pe.edu.upc.abilityhelpv1.repositories.IRolRepository;
import pe.edu.upc.abilityhelpv1.repositories.IUserRepository;
import pe.edu.upc.abilityhelpv1.servicesinterfaces.IRolServices;

import java.util.List;
import java.util.Optional;

@Service
public class RolServiceImplement implements IRolServices {
    @Autowired
    private IRolRepository sR;
    @Autowired
    private IUserRepository uR;

    @Override
    public void insert(Rol rol) {
        sR.save(rol);
    }

    @Override
    public List<Rol> list() {
        return sR.findAll();
    }

    @Override
    public void delete(Long id) {

        Optional<Rol> roleOptional = sR.findById(id);
        if (roleOptional.isPresent()) {
            Rol role = roleOptional.get();
            User user = role.getUser();
            if (user != null) {
                user.getRol().remove(role);
                uR.save(user);
            }
            sR.delete(role);
        }
    }

    @Override
    public Rol listarId(Long idRol) {
        return sR.findById(idRol).orElse(new Rol());
    }

    @Override
    public void update(Rol rol) {
        sR.save(rol);
    }

    @Override
    public List<String[]> quantityUserPerRol() {
        return sR.quantityUserPerRol();
    }
}
