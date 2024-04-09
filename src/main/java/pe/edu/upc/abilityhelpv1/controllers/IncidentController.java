package pe.edu.upc.abilityhelpv1.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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

}
