package pe.edu.upc.abilityhelpv1.servicesinterfaces;
import pe.edu.upc.abilityhelpv1.entities.Auth;
import java.util.List;
public interface IAuthServices {
    public void insert(Auth auth);
    public List<Auth> list();
    public void delete(int id);

}
