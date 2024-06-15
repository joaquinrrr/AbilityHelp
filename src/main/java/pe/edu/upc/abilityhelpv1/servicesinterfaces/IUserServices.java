package pe.edu.upc.abilityhelpv1.servicesinterfaces;

import org.springframework.web.bind.annotation.RequestParam;
import pe.edu.upc.abilityhelpv1.entities.TypeInteraction;
import pe.edu.upc.abilityhelpv1.entities.User;

import java.util.List;

public interface IUserServices {
    User insert(User user);
    public List<User> list();
    public void delete(Long id);
    public User listarId(Long idUsuario);
    public void update(User user);
    public List<User> listByRole(String roleName);
}
