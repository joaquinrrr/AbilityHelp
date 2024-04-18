package pe.edu.upc.abilityhelpv1.controllers;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.abilityhelpv1.dtos.ScheduleDTO;
import pe.edu.upc.abilityhelpv1.entities.Schedule;
import pe.edu.upc.abilityhelpv1.servicesinterfaces.IScheduleServices;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Schedule")
public class ScheduleController {
    @Autowired
    private IScheduleServices sS;
    @PostMapping //registrar
    public void registrar(@RequestBody ScheduleDTO s){
        ModelMapper m = new ModelMapper();
        Schedule sh=m.map(s, Schedule.class);
        sS.insert(sh);
    }

    @GetMapping //listar
    @PreAuthorize("hasAnyAuthority('COACH', 'ADMIN') and !hasAuthority('USER')") //manejar la auth de USER
    public List<ScheduleDTO> list(){
        return sS.list().stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y, ScheduleDTO.class); //expresion lambda para la transformacion
        }).collect(Collectors.toList()); //lista de tipo Shoe
    }

    @DeleteMapping("/{id}") //reconozca parametros que estamos pasando
    public void eliminar(@PathVariable("id") Integer id){
        sS.delete(id);
    }

    @GetMapping("/busqueda") //listar
    public List<ScheduleDTO> buscarmoedlo(@RequestParam LocalDate weekDay){
        return sS.findByWeekDay(weekDay).stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y, ScheduleDTO.class); //expresion lambda para la transformacion
        }).collect(Collectors.toList()); //lista de tipo Shoe
    }
}
