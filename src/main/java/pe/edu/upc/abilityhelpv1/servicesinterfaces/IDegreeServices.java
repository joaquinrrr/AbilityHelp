package pe.edu.upc.abilityhelpv1.servicesinterfaces;

import pe.edu.upc.abilityhelpv1.entities.Chat;
import pe.edu.upc.abilityhelpv1.entities.Degree;

import java.util.List;

public interface IDegreeServices {
    public void insert(Degree degree);
    public List<Degree> list();
    public void delete(int id);
    public void update(Degree degree);
    public List<String[]> quantityPersonalityDegreeUser();

    public Degree listarId(int idDegree);

}
