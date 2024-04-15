package pe.edu.upc.abilityhelpv1.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.abilityhelpv1.dtos.DegreeDTO;
import pe.edu.upc.abilityhelpv1.dtos.MeetingDTO;
import pe.edu.upc.abilityhelpv1.entities.Degree;
import pe.edu.upc.abilityhelpv1.entities.Meeting;
import pe.edu.upc.abilityhelpv1.servicesinterfaces.IMeetServices;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/meeting")
public class MeetingController {
    @Autowired
    private IMeetServices mS;
    @PostMapping //registrar
    public void registrar(@RequestBody MeetingDTO mt){
        ModelMapper m = new ModelMapper();
        Meeting me=m.map(mt, Meeting.class);
        mS.insert(me);
    }

    @GetMapping //listar
    public List<MeetingDTO> list(){
        return mS.list().stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y, MeetingDTO.class); //expresion lambda para la transformacion
        }).collect(Collectors.toList()); //lista de tipo Shoe
    }

    @DeleteMapping("/{id}") //reconozca parametros que estamos pasando
    public void eliminar(@PathVariable("id") Integer id){
        mS.delete(id);
    }
}
