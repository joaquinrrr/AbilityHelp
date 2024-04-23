package pe.edu.upc.abilityhelpv1.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.abilityhelpv1.dtos.AssignIncidentCountDTO;
import pe.edu.upc.abilityhelpv1.dtos.InteractionDTO;
import pe.edu.upc.abilityhelpv1.dtos.InteractionWithUserDTO;
import pe.edu.upc.abilityhelpv1.entities.Interaction;
import pe.edu.upc.abilityhelpv1.servicesinterfaces.IInteractionServices;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Interaction")
public class InteractionController {
    @Autowired
    private IInteractionServices iS;
    @PostMapping ("/Registro")//registrar
    public void registrar(@RequestBody InteractionDTO inteDTO){
        ModelMapper m = new ModelMapper();
        Interaction us=m.map(inteDTO, Interaction.class);
        iS.insert(us);
    }

    @GetMapping //listar
    public List<InteractionDTO> list(){
        return iS.list().stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y, InteractionDTO.class); //expresion lambda para la transformacion
        }).collect(Collectors.toList()); //lista de tipo Shoe
    }
    @PutMapping("/{id}") // actualizar
    public void actualizar(@PathVariable("id") Integer id, @RequestBody InteractionDTO i){
        ModelMapper m = new ModelMapper();
        Interaction ih = m.map(i, Interaction.class);
        ih.setId(id); // asegurarse de que el objeto tenga el mismo ID que el proporcionado en la URL
        iS.update(ih);
    }

    @GetMapping("/interactionUsers")
    public List<InteractionWithUserDTO> interactionUsers(){
        List<String[]> filaLista = iS.interactionWithUsers();
        List<InteractionWithUserDTO> dtoLista = new ArrayList<>();
        for(String[] columna: filaLista){
            InteractionWithUserDTO dto = new InteractionWithUserDTO();
            dto.setSender(columna[0]);
            dto.setReceiver(columna[1]);
            dto.setInteraction(columna[2]);
            dto.setDate(LocalDate.parse(columna[3]));
            dtoLista.add(dto);
        }
        return dtoLista;
    }

    @DeleteMapping("/{id}") //reconozca parametros que estamos pasando
    public void eliminar(@PathVariable("id") Integer id){
        iS.delete(id);
    }
}
