package pe.edu.upc.abilityhelpv1.servicesimplements;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.abilityhelpv1.entities.Type_Interaction;

import pe.edu.upc.abilityhelpv1.repositories.IType_InteractionRepository;
import pe.edu.upc.abilityhelpv1.servicesinterfaces.IType_InteractionServices;

import java.util.List;


@Service
public class Type_InteractionImplement implements IType_InteractionServices {
    @Autowired
    private IType_InteractionRepository sR;


    @Override
    public void insert(Type_Interaction type_Interaction) {
        sR.save(type_Interaction);
    }

    @Override
    public List<Type_Interaction> list() {
       return sR.findAll();
    }
}
