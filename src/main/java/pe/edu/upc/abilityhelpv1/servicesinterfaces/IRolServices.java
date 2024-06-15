package pe.edu.upc.abilityhelpv1.servicesinterfaces;

import pe.edu.upc.abilityhelpv1.entities.Personalities;
import pe.edu.upc.abilityhelpv1.entities.Rol;

import java.util.List;

public interface IRolServices {
    public void insert(Rol rol);
    public List<Rol> list();
    public void delete(Long id);
    public Rol listarId(Long idRol);
    public void update(Rol rol);
    public List<String[]> quantityUserPerRol();
}
