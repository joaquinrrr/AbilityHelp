package pe.edu.upc.abilityhelpv1.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.abilityhelpv1.dtos.IncidentsDTO;
import pe.edu.upc.abilityhelpv1.entities.Incidents;
import pe.edu.upc.abilityhelpv1.servicesinterfaces.IncidentServices;

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
    @GetMapping("{Id}")
    public IncidentsDTO listarId(@PathVariable("id")Integer id){
        ModelMapper I=new ModelMapper();
        IncidentsDTO dto=I.map(sS.listId(id),IncidentsDTO.class);
        return dto;
    }

}