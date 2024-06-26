package pe.edu.upc.abilityhelpv1.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
@CrossOrigin(origins = {"https://ab13-98315.web.app","http://localhost:4200"})
public class TypeInteractionController {
    @Autowired
    private ITypeInteractionServices tS;
    @PostMapping ("/Registro")//registrar
    @PreAuthorize("hasAnyAuthority('ADMIN') and !hasAnyAuthority('STUDENT','COACH')") //manejar la auth de USER
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
    @PreAuthorize("hasAnyAuthority('ADMIN') and !hasAnyAuthority('STUDENT','COACH')") //manejar la auth de USER
    public void actualizar(@PathVariable("id") Integer id, @RequestBody TypeInteractionDTO ti){
        ModelMapper m = new ModelMapper();
        TypeInteraction th = m.map(ti, TypeInteraction.class);
        th.setId(id); // asegurarse de que el objeto tenga el mismo ID que el proporcionado en la URL
        tS.update(th);
    }

    @DeleteMapping("/{id}") //reconozca parametros que estamos pasando
    @PreAuthorize("hasAnyAuthority('ADMIN') and !hasAnyAuthority('STUDENT','COACH')") //manejar la auth de USER
    public void eliminar(@PathVariable("id") Integer id){
        tS.delete(id);
    }

    @GetMapping("/{id}")
    public TypeInteractionDTO listarId(@PathVariable("id") int id) {
        ModelMapper m = new ModelMapper();
        TypeInteractionDTO dto = m.map(tS.listarId(id), TypeInteractionDTO.class);
        return dto;
    }
}
