package pe.edu.upc.abilityhelpv1.controllers;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.abilityhelpv1.dtos.RolDTO;
import pe.edu.upc.abilityhelpv1.dtos.Type_InteractionDTO;
import pe.edu.upc.abilityhelpv1.entities.Rol;
import pe.edu.upc.abilityhelpv1.entities.Type_Interaction;
import pe.edu.upc.abilityhelpv1.servicesinterfaces.IType_InteractionServices;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Type_Interaction")
public class Type_InteractionController {

    @Autowired
    private IType_InteractionServices Is;
    @PostMapping //registrar
    public void registrar(@RequestBody Type_InteractionDTO s){
        ModelMapper m = new ModelMapper();
        Type_Interaction sh=m.map(s, Type_Interaction.class);
        Is.insert(sh);
    }

    @GetMapping //listar
    public List<Type_InteractionDTO> list(){
        return Is.list().stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y, Type_InteractionDTO.class); //expresion lambda para la transformacion
        }).collect(Collectors.toList()); //lista de tipo Shoe
    }





}
