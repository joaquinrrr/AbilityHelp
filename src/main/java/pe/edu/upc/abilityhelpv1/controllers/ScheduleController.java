package pe.edu.upc.abilityhelpv1.controllers;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.abilityhelpv1.dtos.ScheduleDTO;
import pe.edu.upc.abilityhelpv1.entities.Schedule;
import pe.edu.upc.abilityhelpv1.servicesinterfaces.IScheduleServices;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@Api(tags = "Schedule Management")
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

    /*@GetMapping("/busqueda")
    @ApiOperation(value = "Get schedules by week day", notes = "Returns a list of schedules for the specified week day")
    public List<Schedule> buscarFecha(@RequestParam LocalDate weekDay) {
        return sS.findByWeekDay(weekDay);
    } */
}
