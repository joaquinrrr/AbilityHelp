package pe.edu.upc.abilityhelpv1.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.abilityhelpv1.dtos.GenderDTO;
import pe.edu.upc.abilityhelpv1.entities.Gender;
import pe.edu.upc.abilityhelpv1.servicesinterfaces.IGenderServices;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/gender")
@CrossOrigin(origins = {"https://ab13-98315.web.app","http://localhost:4200"})
public class GenderController {
    @Autowired
    private IGenderServices sS;
    @PostMapping("/Registro") //registrar
    @PreAuthorize("hasAnyAuthority('ADMIN') and !hasAnyAuthority('COACH', 'STUDENT')") //manejar la auth de USER
    public void registrar(@RequestBody GenderDTO g){
        ModelMapper m = new ModelMapper();
        Gender ge=m.map(g, Gender.class);
        sS.insert(ge);
    }

    @GetMapping //listar
    public List<GenderDTO> list(){
        return sS.list().stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y, GenderDTO.class); //expresion lambda para la transformacion
        }).collect(Collectors.toList()); //lista de tipo Shoe
    }
    @PutMapping("/{id}") // actualizar
    @PreAuthorize("hasAnyAuthority('ADMIN') and !hasAnyAuthority('COACH', 'STUDENT')") //manejar la auth de USER
    public void actualizar(@PathVariable("id") Integer id, @RequestBody GenderDTO g){
        ModelMapper m = new ModelMapper();
        Gender gh = m.map(g, Gender.class);
        gh.setIdGender(id); // asegurarse de que el objeto tenga el mismo ID que el proporcionado en la URL
        sS.update(gh);
    }

    @DeleteMapping("/{id}") //reconozca parametros que estamos pasando
    @PreAuthorize("hasAnyAuthority('ADMIN') and !hasAnyAuthority('COACH', 'STUDENT')") //manejar la auth de USER
    public void eliminar(@PathVariable("id") Integer id){
        sS.delete(id);
    }

    @GetMapping("/{id}")
    public GenderDTO listarId(@PathVariable("id") int id) {
        ModelMapper m = new ModelMapper();
        GenderDTO dto = m.map(sS.listarId(id), GenderDTO.class);
        return dto;
    }
}
