package pe.edu.upc.abilityhelpv1.servicesinterfaces;

import pe.edu.upc.abilityhelpv1.entities.Rol;
import pe.edu.upc.abilityhelpv1.entities.Users;

import java.util.List;

public interface IRolServices {
    public void insert(Rol rol);
    public List<Rol> list();
    public void delete(int id);
    public void update(Rol rol);
}
