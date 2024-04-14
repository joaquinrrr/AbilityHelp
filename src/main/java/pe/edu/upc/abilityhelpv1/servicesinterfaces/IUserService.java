package pe.edu.upc.abilityhelpv1.servicesinterfaces;

import org.apache.catalina.User;
import pe.edu.upc.abilityhelpv1.entities.Users;

import java.util.List;

public interface IUserService {
    public void insert(Users usuario);
    public List<Users>list();
    public void delete(Long idUsuario);
    public Users listarId(Long idUsuario);
}
