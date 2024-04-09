package pe.edu.upc.abilityhelpv1.servicesinterfaces;

import pe.edu.upc.abilityhelpv1.entities.Rol;
import pe.edu.upc.abilityhelpv1.entities.Type_Interaction;

import java.util.List;

public interface IType_InteractionServices {

    public void insert(Type_Interaction type_Interaction);
    public List<Type_Interaction> list();


}
