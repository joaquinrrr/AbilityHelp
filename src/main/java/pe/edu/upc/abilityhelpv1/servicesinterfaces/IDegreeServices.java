package pe.edu.upc.abilityhelpv1.servicesinterfaces;

import pe.edu.upc.abilityhelpv1.entities.Degree;

import java.util.List;

public interface IDegreeServices {
    public void insert(Degree degree);
    public List<Degree> list();
    public void delete(int id);
}
