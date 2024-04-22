package pe.edu.upc.abilityhelpv1.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.abilityhelpv1.dtos.MeetingDTO;
import pe.edu.upc.abilityhelpv1.dtos.PersonalitiesDTO;
import pe.edu.upc.abilityhelpv1.dtos.PersonalityPerUserDTO;
import pe.edu.upc.abilityhelpv1.dtos.RolDTO;
import pe.edu.upc.abilityhelpv1.entities.Meeting;
import pe.edu.upc.abilityhelpv1.entities.Personalities;
import pe.edu.upc.abilityhelpv1.entities.Rol;
import pe.edu.upc.abilityhelpv1.servicesinterfaces.IPersonalityServices;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Personalities")
public class PersonalitiesController {
    @Autowired
    private IPersonalityServices sS;
    @PostMapping //registrar
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
    public void actualizar(@PathVariable("id") Integer id, @RequestBody PersonalitiesDTO pe){
        ModelMapper m = new ModelMapper();
        Personalities ph = m.map(pe, Personalities.class);
        ph.setIdPersonality(id); // asegurarse de que el objeto tenga el mismo ID que el proporcionado en la URL
        sS.update(ph);
    }

    @GetMapping("/cantidad")
    public List<PersonalityPerUserDTO> cantidadUserPorPersonalidad(@RequestParam String name){
        List<String[]> filaLista = sS.quantityUserPerPersonality(name);
        List<PersonalityPerUserDTO> dtoLista = new ArrayList<>();
        for(String[] columna: filaLista){
            PersonalityPerUserDTO dto = new PersonalityPerUserDTO();
            dto.setNameP(columna[0]);
            dto.setQuantity(Integer.parseInt(columna[1]));
            dtoLista.add(dto);
        }
        return dtoLista;
    }

    @DeleteMapping("/{id}") //reconozca parametros que estamos pasando
    public void eliminar(@PathVariable("id") Integer id){
        sS.delete(id);
    }

}
