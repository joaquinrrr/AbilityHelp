package pe.edu.upc.abilityhelpv1.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.abilityhelpv1.dtos.RolDTO;
import pe.edu.upc.abilityhelpv1.entities.Rol;
import pe.edu.upc.abilityhelpv1.servicesinterfaces.IRolServices;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Rol")
public class RolController {
    @Autowired
    private IRolServices sS;
    @PostMapping //registrar
    public void registrar(@RequestBody RolDTO s){
        ModelMapper m = new ModelMapper();
        Rol sh=m.map(s, Rol.class);
        sS.insert(sh);
    }

    @GetMapping ("/listar")
    public List<RolDTO> list(){
        return sS.list().stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y, RolDTO.class); //expresion lambda para la transformacion
        }).collect(Collectors.toList()); //lista de tipo Shoe
    }

    @DeleteMapping("/{id}") //reconozca parametros que estamos pasando
    public void eliminar(@PathVariable("id") Integer id){
        sS.delete(id);
    }
}
