package pe.edu.upc.abilityhelpv1.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.abilityhelpv1.dtos.*;
import pe.edu.upc.abilityhelpv1.entities.Meeting;
import pe.edu.upc.abilityhelpv1.servicesinterfaces.IMeetServices;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/meeting")
public class MeetingController {
    @Autowired
    private IMeetServices mS;
    @PostMapping ("/Registro")//registrar
    @PreAuthorize("hasAnyAuthority('STUDENT') and !hasAnyAuthority('COACH','ADMIN')") //manejar la auth de USER
    public void registrar(@RequestBody MeetingDTO mt){
        ModelMapper m = new ModelMapper();
        Meeting me=m.map(mt, Meeting.class);
        mS.insert(me);
    }

    @GetMapping //listar
    //@PreAuthorize("hasAuthority('USER')") //manejar la auth de USER
    public List<MeetingDTO> list(){
        return mS.list().stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y, MeetingDTO.class); //expresion lambda para la transformacion
        }).collect(Collectors.toList()); //lista de tipo Shoe
    }

    @PutMapping("/{id}") // actualizar
    @PreAuthorize("hasAnyAuthority('STUDENT') and !hasAnyAuthority('COACH','ADMIN')") //manejar la auth de USER
    public void actualizar(@PathVariable("id") Integer id, @RequestBody MeetingDTO me){
        ModelMapper m = new ModelMapper();
        Meeting mh = m.map(me, Meeting.class);
        mh.setIdMeet(id); // asegurarse de que el objeto tenga el mismo ID que el proporcionado en la URL
        mS.update(mh);
    }

    @GetMapping("/cantidadMeetPorCoach")
    @PreAuthorize("hasAnyAuthority('COACH','ADMIN') and !hasAnyAuthority('STUDENT')") //manejar la auth de USER
    public List<MeetingPerCoachDTO> cantidadMeetPorCoach(@RequestParam String name){
        List<String[]> filaLista = mS.QuantityMeetPerCoach(name);
        List<MeetingPerCoachDTO> dtoLista = new ArrayList<>();
        for(String[] columna: filaLista){
            MeetingPerCoachDTO dto = new MeetingPerCoachDTO();
            dto.setCoach(columna[0]);
            dto.setDate(LocalDate.parse(columna[1]));
            dto.setQuantity(Integer.parseInt(columna[2]));
            dtoLista.add(dto);
        }
        return dtoLista;
    }
    @GetMapping("/reunionporUsuarioyFecha")
    public List<MeetingPerStudentDateDTO> reunionporUsuarioyFecha(@RequestParam LocalDate date){
        List<String[]> filaLista = mS.meetingPerUserDate(date);
        List<MeetingPerStudentDateDTO> dtoLista = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
        for (String[] columna : filaLista) {
            MeetingPerStudentDateDTO dto = new MeetingPerStudentDateDTO();
            dto.setNameU(columna[0]);
            dto.setDate(LocalDate.parse(columna[1]));
            dto.setStarthour(LocalDateTime.parse(columna[2],formatter2));  // assuming time not available
            dto.setFinishhour(LocalDateTime.parse(columna[3],formatter2));  // assuming time not available
            dtoLista.add(dto);
        }
        return dtoLista;
    }

    @GetMapping("/cantidadReunionesPorMes")
    @PreAuthorize("hasAnyAuthority('ADMIN','COACH') and !hasAnyAuthority('STUDENT')") //manejar la auth de USER
    public List<QuantityMeetsPerMonthDTO> cantidadReunionesPorMes(@RequestParam int year){
        List<String[]> filaLista = mS.quantityMeetsPerMonth(year);
        List<QuantityMeetsPerMonthDTO> dtoLista = new ArrayList<>();
        for(String[] columna: filaLista){
            QuantityMeetsPerMonthDTO dto = new QuantityMeetsPerMonthDTO();
            dto.setMonth(columna[0]);
            dto.setQuantity(Integer.parseInt(columna[1]));
            dtoLista.add(dto);
        }
        return dtoLista;
    }

    @GetMapping("/promedioReunionUsuario")
    public List<AverageMeetUserDTO> promedioReunionUsuario(){
        List<String[]> filaLista = mS.averageMeetUser();
        List<AverageMeetUserDTO> dtoLista = new ArrayList<>();
        for(String[] columna: filaLista){
            AverageMeetUserDTO dto = new AverageMeetUserDTO();
            dto.setStudent(columna[0]);
            dto.setQuantity(Float.parseFloat(columna[1]));
            dtoLista.add(dto);
        }
        return dtoLista;
    }

    @DeleteMapping("/{id}") //reconozca parametros que estamos pasando
    @PreAuthorize("hasAnyAuthority('STUDENT') and !hasAnyAuthority('COACH','ADMIN')") //manejar la auth de USER
    public void eliminar(@PathVariable("id") Integer id){
        mS.delete(id);
    }
}
