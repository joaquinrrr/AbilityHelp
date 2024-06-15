package pe.edu.upc.abilityhelpv1.controllers;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.abilityhelpv1.dtos.RolDTO;
import pe.edu.upc.abilityhelpv1.dtos.ScheduleDTO;
import pe.edu.upc.abilityhelpv1.entities.Rol;
import pe.edu.upc.abilityhelpv1.entities.Schedule;
import pe.edu.upc.abilityhelpv1.servicesinterfaces.IScheduleServices;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Schedule")
public class    ScheduleController {
    @Autowired
    private IScheduleServices sS;
    @PostMapping("/Registro") //registrar
    @PreAuthorize("hasAnyAuthority('COACH') and !hasAnyAuthority('ADMIN', 'STUDENT')") //manejar la auth de USER
    public void registrar(@RequestBody ScheduleDTO s){
        ModelMapper m = new ModelMapper();
        Schedule sh=m.map(s, Schedule.class);
        sS.insert(sh);
    }

    @GetMapping//listar
    public List<ScheduleDTO> list(){
        return sS.list().stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y, ScheduleDTO.class); //expresion lambda para la transformacion
        }).collect(Collectors.toList()); //lista de tipo Shoe
    }

    @PutMapping("/{id}") // actualizar
    @PreAuthorize("hasAnyAuthority('COACH', 'ADMIN') and !hasAnyAuthority('STUDENT')") //manejar la auth de USER
    public void actualizar(@PathVariable("id") Integer id, @RequestBody ScheduleDTO se){
        ModelMapper m = new ModelMapper();
        Schedule sh = m.map(se, Schedule.class);
        sh.setIdSchedule(id); // asegurarse de que el objeto tenga el mismo ID que el proporcionado en la URL
        sS.update(sh);
    }

    @DeleteMapping("/{id}") //reconozca parametros que estamos pasando
    @PreAuthorize("hasAnyAuthority('COACH', 'ADMIN') and !hasAnyAuthority('STUDENT')") //manejar la auth de USER
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

    @GetMapping("/{id}")
    public ScheduleDTO listarId(@PathVariable("id") int id) {
        ModelMapper m = new ModelMapper();
        ScheduleDTO dto = m.map(sS.listarId(id), ScheduleDTO.class);
        return dto;
    }
}
