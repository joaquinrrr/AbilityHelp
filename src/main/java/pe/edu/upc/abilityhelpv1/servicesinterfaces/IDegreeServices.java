package pe.edu.upc.abilityhelpv1.servicesinterfaces;

import pe.edu.upc.abilityhelpv1.entities.Degree;
import pe.edu.upc.abilityhelpv1.entities.Rol;

import java.util.List;

public interface IDegreeServices {

    public void insert(Degree degree);

    public default List<Degree> list() {
        return null;
    }

    public void delete(int id);
}
