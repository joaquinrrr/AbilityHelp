package pe.edu.upc.abilityhelpv1.servicesinterfaces;
import pe.edu.upc.abilityhelpv1.entities.Admin;
import java.util.List;
public interface IAdminServices {
    public void insert(Admin admin);
    public List<Admin> list();

}
