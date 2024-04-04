package pe.edu.upc.abilityhelpv1.servicesimplements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.abilityhelpv1.entities.Auth;
import pe.edu.upc.abilityhelpv1.repositories.IAuthRepository;
import pe.edu.upc.abilityhelpv1.servicesinterfaces.IAuthServices;


import java.util.List;
@Service
public class AuthServiceImplement implements IAuthServices {
    @Autowired
    private IAuthRepository sR;
    @Override
    public void insert(Auth auth) {
        sR.save(auth);
    }

    @Override
    public List<Auth> list() {
        return sR.findAll();
    }
    @Override
    public void delete(int id) {
        sR.deleteById(id);
    }
}
