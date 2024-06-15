package pe.edu.upc.abilityhelpv1.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.abilityhelpv1.dtos.UserDTO;
import pe.edu.upc.abilityhelpv1.entities.Gender;
import pe.edu.upc.abilityhelpv1.entities.Personalities;
import pe.edu.upc.abilityhelpv1.entities.Rol;
import pe.edu.upc.abilityhelpv1.entities.User;
import pe.edu.upc.abilityhelpv1.repositories.IGenderRepository;
import pe.edu.upc.abilityhelpv1.repositories.IRolRepository;
import pe.edu.upc.abilityhelpv1.repositories.IUserRepository;
import pe.edu.upc.abilityhelpv1.servicesinterfaces.IPersonalityServices;
import pe.edu.upc.abilityhelpv1.servicesinterfaces.IUserServices;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImplement implements IUserServices {
    @Autowired
    private IUserRepository sR;
    @Override
    public User insert(User user) {
        return sR.save(user); // Devuelve el usuario creado
    }
    @Override
    public List<User> list() {
        return sR.findAll();
    }
    @Override
    public void delete(Long id) {
        sR.deleteById(id);
    }
    @Override
    public User listarId(Long idUsuario) {
        return sR.findById(idUsuario).orElse(new User());
    }
    @Override
    public void update(User user) {
        sR.save(user);
    }
    @Override
    public List<User> listByRole(String roleName) {
        return sR.findByRoleName(roleName);
    }


}
