package pe.edu.upc.abilityhelpv1.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upc.abilityhelpv1.dtos.PersonalitiesDTO;
import pe.edu.upc.abilityhelpv1.entities.Personalities;
import pe.edu.upc.abilityhelpv1.servicesimplements.PersonalityServiceImplement;
import pe.edu.upc.abilityhelpv1.servicesinterfaces.IPersonalityServices;

@RestController
@RequestMapping("Personality")
public class PersonalitiesController {
    @Autowired
    private IPersonalityServices sS;
    @PostMapping
    public void Registrar(@RequestBody PersonalitiesDTO p){
        ModelMapper P=new ModelMapper();
        Personalities Ph=P.map(p,Personalities.class);
        sS.insert(Ph);
    }
}
