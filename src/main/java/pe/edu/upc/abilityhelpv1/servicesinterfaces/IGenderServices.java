package pe.edu.upc.abilityhelpv1.servicesinterfaces;

import pe.edu.upc.abilityhelpv1.entities.Degree;
import pe.edu.upc.abilityhelpv1.entities.Gender;
import pe.edu.upc.abilityhelpv1.entities.User;

import java.util.List;

public interface IGenderServices {
    public void insert(Gender gender);
    public List<Gender> list();
    public void delete(int id);
    public void update(Gender gender);
    public Gender listarId(int idGender);


}
