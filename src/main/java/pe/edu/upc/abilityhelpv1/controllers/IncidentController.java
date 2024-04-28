package pe.edu.upc.abilityhelpv1.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.abilityhelpv1.dtos.IncidentsDTO;
import pe.edu.upc.abilityhelpv1.entities.Incidents;
import pe.edu.upc.abilityhelpv1.servicesinterfaces.IncidentServices;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("Incident")
public class IncidentController {
    @Autowired
    private IncidentServices sS;
    @PostMapping
    public void Registrar(@RequestBody IncidentsDTO s){
        ModelMapper I=new ModelMapper();
        Incidents Ih=I.map(s,Incidents.class);
        sS.insert(Ih);
    }
    @GetMapping
    public List<IncidentsDTO> list() {
        return sS.list().stream().map(y -> {
            ModelMapper m = new ModelMapper();
            return m.map(y, IncidentsDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id){
        sS.delete(id);
    }
    @GetMapping("/{id}")
    public IncidentsDTO listarId(@PathVariable("id") Integer id){
        ModelMapper m= new ModelMapper();
        IncidentsDTO dto=m.map(sS.listId(id),IncidentsDTO.class);
        return dto;
    }

}
