package pe.edu.upc.abilityhelpv1.servicesinterfaces;


import pe.edu.upc.abilityhelpv1.entities.Schedule;
import pe.edu.upc.abilityhelpv1.entities.TypeInteraction;
import pe.edu.upc.abilityhelpv1.entities.User;

import java.util.List;

public interface ITypeInteractionServices {
    public void insert(TypeInteraction typeInteraction);
    public List<TypeInteraction> list();
    public void delete(int id);
    public void update(TypeInteraction typeInteraction);
    public TypeInteraction listarId(int idType);

}
