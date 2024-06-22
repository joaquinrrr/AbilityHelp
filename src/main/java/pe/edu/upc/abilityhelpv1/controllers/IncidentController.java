package pe.edu.upc.abilityhelpv1.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.abilityhelpv1.dtos.IncidentDTO;
import pe.edu.upc.abilityhelpv1.entities.Incidents;
import pe.edu.upc.abilityhelpv1.servicesinterfaces.IIncidentServices;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Incident")
@CrossOrigin(origins = "https://ab13-98315.web.app")
public class IncidentController {
    @Autowired
    private IIncidentServices iS;
    @PostMapping ("/Registro")//registrar
    @PreAuthorize("hasAnyAuthority('ADMIN') and !hasAnyAuthority('COACH','STUDENT')") //manejar la auth de USER
    public void registrar(@RequestBody IncidentDTO inciDTO){
        ModelMapper m = new ModelMapper();
        Incidents in =m.map(inciDTO, Incidents.class);
        iS.insert(in);
    }

    @GetMapping //listar
    public List<IncidentDTO> list(){
        return iS.list().stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y, IncidentDTO.class); //expresion lambda para la transformacion
        }).collect(Collectors.toList()); //lista de tipo Shoe
    }
    @PutMapping("/{id}") // actualizar
    @PreAuthorize("hasAnyAuthority('ADMIN') and !hasAnyAuthority('COACH','STUDENT')") //manejar la auth de USER
    public void actualizar(@PathVariable("id") Integer id, @RequestBody IncidentDTO i){
        ModelMapper m = new ModelMapper();
        Incidents ih = m.map(i, Incidents.class);
        ih.setId(id); // asegurarse de que el objeto tenga el mismo ID que el proporcionado en la URL
        iS.update(ih);
    }

    @DeleteMapping("/{id}") //reconozca parametros que estamos pasando
    @PreAuthorize("hasAnyAuthority('ADMIN') and !hasAnyAuthority('COACH','STUDENT')") //manejar la auth de USER
    public void eliminar(@PathVariable("id") Integer id){
        iS.delete(id);
    }

    @GetMapping("/{id}")
    public IncidentDTO listarId(@PathVariable("id") int id) {
        ModelMapper m = new ModelMapper();
        IncidentDTO dto = m.map(iS.listarId(id), IncidentDTO.class);
        return dto;
    }
}
