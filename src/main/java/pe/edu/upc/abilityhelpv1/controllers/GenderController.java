package pe.edu.upc.abilityhelpv1.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.abilityhelpv1.dtos.GenderDTO;
import pe.edu.upc.abilityhelpv1.entities.Gender;
import pe.edu.upc.abilityhelpv1.servicesinterfaces.IGenderService;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Gender")
public class GenderController {
    @Autowired
    private IGenderService gS;
    @PostMapping //registrar
    public void registrar(@RequestBody GenderDTO s){
        ModelMapper m = new ModelMapper();
        Gender sh=m.map(s, Gender.class);
        gS.insert(sh);
    }

    @GetMapping ("/listar")//listar
    public List<GenderDTO> list(){
        return gS.list().stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y, GenderDTO.class); //expresion lambda para la transformacion
        }).collect(Collectors.toList()); //lista de tipo Shoe
    }

    @DeleteMapping("/{id}") //reconozca parametros que estamos pasando
    public void eliminar(@PathVariable("id") Integer id){
        gS.delete(id);
    }
}
