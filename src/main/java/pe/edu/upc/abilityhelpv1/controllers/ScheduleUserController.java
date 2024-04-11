package pe.edu.upc.abilityhelpv1.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import pe.edu.upc.abilityhelpv1.dtos.ScheduleUserDTO;
import pe.edu.upc.abilityhelpv1.entities.ScheduleUser;
import pe.edu.upc.abilityhelpv1.servicesinterfaces.IScheduleUserServices;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/ScheduleUser")
public class ScheduleUserController {
    @Autowired
    private IScheduleUserServices sS;
    @PostMapping //registrar
    public void registrar(@RequestBody ScheduleUserDTO s){
        ModelMapper m = new ModelMapper();
        ScheduleUser sh=m.map(s, ScheduleUser.class);
        sS.insert(sh);
    }

    @GetMapping //listar
    public List<ScheduleUserDTO> list(){
        return sS.list().stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y, ScheduleUserDTO.class); //expresion lambda para la transformacion
        }).collect(Collectors.toList()); //lista de tipo Shoe
    }

    @DeleteMapping("/{id}") //reconozca parametros que estamos pasando
    public void eliminar(@PathVariable("id") Integer id){
        sS.delete(id);
    }

}
