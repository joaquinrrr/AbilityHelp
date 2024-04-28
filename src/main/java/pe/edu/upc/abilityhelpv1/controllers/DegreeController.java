package pe.edu.upc.abilityhelpv1.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.abilityhelpv1.dtos.DegreeDTO;
import pe.edu.upc.abilityhelpv1.dtos.InteractionWithStudentDTO;
import pe.edu.upc.abilityhelpv1.dtos.QuantityDegreePersonalityUserDTO;
import pe.edu.upc.abilityhelpv1.entities.Degree;
import pe.edu.upc.abilityhelpv1.servicesinterfaces.IDegreeServices;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Degree")
public class DegreeController {
    @Autowired
    private IDegreeServices sS;
    @PostMapping ("/Registro")//registrar
    public void registrar(@RequestBody DegreeDTO d){
        ModelMapper m = new ModelMapper();
        Degree de=m.map(d, Degree.class);
        sS.insert(de);
    }

    @GetMapping //listar
    public List<DegreeDTO> list(){
        return sS.list().stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y, DegreeDTO.class); //expresion lambda para la transformacion
        }).collect(Collectors.toList()); //lista de tipo Shoe
    }
    @PutMapping("/{id}") // actualizar
    public void actualizar(@PathVariable("id") Integer id, @RequestBody DegreeDTO d){
        ModelMapper m = new ModelMapper();
        Degree dh = m.map(d, Degree.class);
        dh.setIdCarrera(id); // asegurarse de que el objeto tenga el mismo ID que el proporcionado en la URL
        sS.update(dh);
    }

    @DeleteMapping("/{id}") //reconozca parametros que estamos pasando
    public void eliminar(@PathVariable("id") Integer id){
        sS.delete(id);
    }

    @GetMapping("/cantidadPersonalidadyCarreraEstudiante")
    @PreAuthorize("hasAnyAuthority('ADMIN') and !hasAnyAuthority('COACH','STUDENT')") //manejar la auth de USER
    public List<QuantityDegreePersonalityUserDTO> cantidadPersonalidadyCarreraEstudiante(){
        List<String[]> filaLista = sS.quantityPersonalityDegreeUser();
        List<QuantityDegreePersonalityUserDTO> dtoLista = new ArrayList<>();
        for(String[] columna: filaLista){
            QuantityDegreePersonalityUserDTO dto = new QuantityDegreePersonalityUserDTO();
            dto.setQuantity(Integer.parseInt(columna[0]));
            dto.setPersonaltity(columna[1]);
            dto.setDegree(columna[2]);
            dtoLista.add(dto);
        }
        return dtoLista;
    }

}