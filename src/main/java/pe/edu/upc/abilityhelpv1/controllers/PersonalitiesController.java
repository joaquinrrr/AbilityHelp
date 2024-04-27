package pe.edu.upc.abilityhelpv1.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.abilityhelpv1.dtos.PersonalitiesDTO;
import pe.edu.upc.abilityhelpv1.dtos.RolDTO;
import pe.edu.upc.abilityhelpv1.entities.Personalities;
import pe.edu.upc.abilityhelpv1.entities.Rol;
import pe.edu.upc.abilityhelpv1.servicesinterfaces.IPersonalityServices;

import java.util.List;
import java.util.stream.Collectors;
@RestController
@RequestMapping("/personalities")
public class PersonalitiesController {
    @Autowired
    private IPersonalityServices pS;
    @PostMapping
    public void registrar(@RequestBody PersonalitiesDTO p){
        ModelMapper m=new ModelMapper();
        Personalities pe=m.map(p, Personalities.class);
        pS.insert(pe);
    }
    @PutMapping("/{id}") // actualizar
    @PreAuthorize("hasAnyAuthority('COACH', 'ADMIN')")
    public void actualizar(@PathVariable("id") int id, @RequestBody PersonalitiesDTO p){
        ModelMapper m = new ModelMapper();
        Personalities ph = m.map(p, Personalities.class);
        ph.setId_personality(id);
    }

    @GetMapping("/listar")
    @PreAuthorize("hasAnyAuthority('COACH', 'ADMIN')")
    public List<PersonalitiesDTO> list(){
        return pS.list().stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y, PersonalitiesDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}") //reconozca parametros que estamos pasando
    public void eliminar(@PathVariable("id") Integer id){
        pS.delete(id);
    }
}
