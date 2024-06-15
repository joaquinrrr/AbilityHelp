package pe.edu.upc.abilityhelpv1.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.abilityhelpv1.dtos.PersonalitiesDTO;
import pe.edu.upc.abilityhelpv1.entities.Personalities;
import pe.edu.upc.abilityhelpv1.servicesinterfaces.IPersonalityServices;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Personalities")
public class PersonalitiesController {
    @Autowired
    private IPersonalityServices sS;
    @PostMapping ("/Registro")//registrar
    @PreAuthorize("hasAnyAuthority('ADMIN') and !hasAnyAuthority('COACH', 'STUDENT')") //manejar la auth de USER
    public void registrar(@RequestBody PersonalitiesDTO p){
        ModelMapper m = new ModelMapper();
        Personalities ps=m.map(p, Personalities.class);
        sS.insert(ps);
    }

    @GetMapping //listar
    public List<PersonalitiesDTO> list(){
        return sS.list().stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y, PersonalitiesDTO.class); //expresion lambda para la transformacion
        }).collect(Collectors.toList()); //lista de tipo Shoe
    }

    @PutMapping("/{id}") // actualizar
    @PreAuthorize("hasAnyAuthority('ADMIN') and !hasAnyAuthority('COACH', 'STUDENT')") //manejar la auth de USER
    public void actualizar(@PathVariable("id") Integer id, @RequestBody PersonalitiesDTO pe){
        ModelMapper m = new ModelMapper();
        Personalities ph = m.map(pe, Personalities.class);
        ph.setIdPersonality(id); // asegurarse de que el objeto tenga el mismo ID que el proporcionado en la URL
        sS.update(ph);
    }


    @DeleteMapping("/{id}") //reconozca parametros que estamos pasando
    @PreAuthorize("hasAnyAuthority('ADMIN') and !hasAnyAuthority('COACH', 'STUDENT')") //manejar la auth de USER
    public void eliminar(@PathVariable("id") Integer id){
        sS.delete(id);
    }


    @GetMapping("/{id}")
    public PersonalitiesDTO listarId(@PathVariable("id") int id) {
        ModelMapper m = new ModelMapper();
        PersonalitiesDTO dto = m.map(sS.listarId(id), PersonalitiesDTO.class);
        return dto;
    }
}
