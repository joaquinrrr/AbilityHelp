package pe.edu.upc.abilityhelpv1.controllers;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.abilityhelpv1.dtos.IncidentsDTO;
import pe.edu.upc.abilityhelpv1.dtos.PersonalitiesDTO;
import pe.edu.upc.abilityhelpv1.entities.Personalities;
import pe.edu.upc.abilityhelpv1.servicesimplements.PersonalityServiceImplement;
import pe.edu.upc.abilityhelpv1.servicesinterfaces.IPersonalityServices;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("Personality")
public class PersonalitiesController {
    @Autowired
    private IPersonalityServices sS;
    @PostMapping
    public void Registrar(@RequestBody PersonalitiesDTO p){
        ModelMapper P=new ModelMapper();
        Personalities Ph=P.map(p,Personalities.class);
        sS.insert(Ph);
    }
    @GetMapping
    public List<PersonalitiesDTO> list() {
        return sS.list().stream().map(y -> {
            ModelMapper m = new ModelMapper();
            return m.map(y,PersonalitiesDTO.class);
        }).collect(Collectors.toList());
    }
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id){
        sS.delete(id);
    }
    @GetMapping("/{id}")
    public PersonalitiesDTO listarId(@PathVariable("id") Integer id){
        ModelMapper m= new ModelMapper();
        PersonalitiesDTO dto=m.map(sS.listId(id),PersonalitiesDTO.class);
        return dto;
    }
}
