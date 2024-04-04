package pe.edu.upc.abilityhelpv1.servicesinterfaces;

import pe.edu.upc.abilityhelpv1.entities.Rol;

import java.util.List;

public interface IRolServices {
    public void insert(Rol rol);
    public List<Rol> list();
    public void delete(int id);

}
