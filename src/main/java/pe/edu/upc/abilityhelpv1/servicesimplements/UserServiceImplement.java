package pe.edu.upc.abilityhelpv1.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.abilityhelpv1.entities.User;
import pe.edu.upc.abilityhelpv1.repositories.IUserRepository;
import pe.edu.upc.abilityhelpv1.servicesinterfaces.IUserServices;

import java.util.List;

@Service
public class UserServiceImplement implements IUserServices {
    @Autowired
    private IUserRepository sR;
    @Override
    public void insert(User user) {
        sR.save(user);
    }

    @Override
    public List<User> list() {
        return sR.findAll();
    }
    @Override
    public void delete(int id) {
        sR.deleteById(id);
    }
    @Override
    public User listarId(int idUsuario) {
        return sR.findById(idUsuario).orElse(new User());
    }
    @Override
    public void update(User user) {
        sR.save(user);
    }

    @Override
    public List<String[]> quantityPersonalityPerCarrer() {
        return sR.quantityPersonalityPerCarrer();
    }
}
