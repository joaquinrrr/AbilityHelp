package pe.edu.upc.abilityhelpv1.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.abilityhelpv1.dtos.ScheduleDTO;
import pe.edu.upc.abilityhelpv1.dtos.TypeInteractionDTO;
import pe.edu.upc.abilityhelpv1.entities.Schedule;
import pe.edu.upc.abilityhelpv1.entities.TypeInteraction;
import pe.edu.upc.abilityhelpv1.servicesinterfaces.ITypeInteractionServices;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/TypeInteraction")
public class TypeInteractionController {
    @Autowired
    private ITypeInteractionServices tS;
    @PostMapping //registrar
    public void registrar(@RequestBody TypeInteractionDTO typeDTO){
        ModelMapper m = new ModelMapper();
        TypeInteraction us=m.map(typeDTO, TypeInteraction.class);
        tS.insert(us);
    }

    @GetMapping //listar
    public List<TypeInteractionDTO> list(){
        return tS.list().stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y, TypeInteractionDTO.class); //expresion lambda para la transformacion
        }).collect(Collectors.toList()); //lista de tipo Shoe
    }

    @PutMapping("/{id}") // actualizar
    public void actualizar(@PathVariable("id") Integer id, @RequestBody TypeInteractionDTO ti){
        ModelMapper m = new ModelMapper();
        TypeInteraction th = m.map(ti, TypeInteraction.class);
        th.setId(id); // asegurarse de que el objeto tenga el mismo ID que el proporcionado en la URL
        tS.update(th);
    }

    @DeleteMapping("/{id}") //reconozca parametros que estamos pasando
    public void eliminar(@PathVariable("id") Integer id){
        tS.delete(id);
    }
}
