package pe.edu.upc.abilityhelpv1.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.abilityhelpv1.dtos.InteractionDTO;
import pe.edu.upc.abilityhelpv1.dtos.InteractionWithStudentDTO;
import pe.edu.upc.abilityhelpv1.entities.Interaction;
import pe.edu.upc.abilityhelpv1.servicesinterfaces.IInteractionServices;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Interaction")
@CrossOrigin(origins = {"https://ab13-98315.web.app","http://localhost:4200"})
public class InteractionController {
    @Autowired
    private IInteractionServices iS;
    @PostMapping ("/Registro")//registrar
    @PreAuthorize("hasAnyAuthority('STUDENT') and !hasAnyAuthority('COACH', 'ADMIN')") //manejar la auth de USER
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
    @PreAuthorize("hasAnyAuthority('STUDENT') and !hasAnyAuthority('COACH', 'ADMIN')") //manejar la auth de USER
    public void actualizar(@PathVariable("id") Integer id, @RequestBody InteractionDTO i){
        ModelMapper m = new ModelMapper();
        Interaction ih = m.map(i, Interaction.class);
        ih.setId(id); // asegurarse de que el objeto tenga el mismo ID que el proporcionado en la URL
        iS.update(ih);
    }

    @GetMapping("/interactionUsers")
    @PreAuthorize("hasAnyAuthority('ADMIN') and !hasAnyAuthority('COACH','STUDENT')") //manejar la auth de USER
    public List<InteractionWithStudentDTO> interactionUsers(){
        List<String[]> filaLista = iS.interactionWithUsers();
        List<InteractionWithStudentDTO> dtoLista = new ArrayList<>();
        for(String[] columna: filaLista){
            InteractionWithStudentDTO dto = new InteractionWithStudentDTO();
            dto.setSender(columna[0]);
            dto.setReceiver(columna[1]);
            dto.setInteraction(columna[2]);
            dto.setDate(LocalDate.parse(columna[3]));
            dtoLista.add(dto);
        }
        return dtoLista;
    }

    @DeleteMapping("/{id}") //reconozca parametros que estamos pasando
    @PreAuthorize("hasAnyAuthority('STUDENT', 'ADMIN') and !hasAnyAuthority('COACH')") //manejar la auth de USER
    public void eliminar(@PathVariable("id") Integer id){
        iS.delete(id);
    }

    @GetMapping("/{id}")
    public InteractionDTO listarId(@PathVariable("id") int id) {
        ModelMapper m = new ModelMapper();
        InteractionDTO dto = m.map(iS.listarId(id), InteractionDTO.class);
        return dto;
    }
}
