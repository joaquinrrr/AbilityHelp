package pe.edu.upc.abilityhelpv1.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.abilityhelpv1.dtos.PersonalitiesDTO;
import pe.edu.upc.abilityhelpv1.dtos.RolDTO;
import pe.edu.upc.abilityhelpv1.entities.Personalities;
import pe.edu.upc.abilityhelpv1.entities.Rol;
import pe.edu.upc.abilityhelpv1.servicesinterfaces.IRolServices;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Rol")
public class RolController {
    @Autowired
    private IRolServices sS;
    @PostMapping("/Registro") //registrar
    public void registrar(@RequestBody RolDTO s){
        ModelMapper m = new ModelMapper();
        Rol sh=m.map(s, Rol.class);
        sS.insert(sh);
    }

    @GetMapping //listar
    public List<RolDTO> list(){
        return sS.list().stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y, RolDTO.class); //expresion lambda para la transformacion
        }).collect(Collectors.toList()); //lista de tipo Shoe
    }

    @PutMapping("/{id}") // actualizar
    public void actualizar(@PathVariable("id") Long id, @RequestBody RolDTO re){
        ModelMapper m = new ModelMapper();
        Rol rh = m.map(re, Rol.class);
        rh.setIdRol(id); // asegurarse de que el objeto tenga el mismo ID que el proporcionado en la URL
        sS.update(rh);
    }

    @DeleteMapping("/{id}") //reconozca parametros que estamos pasando
    public void eliminar(@PathVariable("id") Integer id){
        sS.delete(id);
    }
    @GetMapping("/{id}")
    public RolDTO listarId(@PathVariable("id") int id) {
        ModelMapper m = new ModelMapper();
        RolDTO dto = m.map(sS.listarId(id), RolDTO.class);
        return dto;
    }
}
