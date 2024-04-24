package pe.edu.upc.abilityhelpv1.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.abilityhelpv1.dtos.MeetingDTO;
import pe.edu.upc.abilityhelpv1.dtos.MeetingPerCoachDTO;
import pe.edu.upc.abilityhelpv1.dtos.MeetingPerStudentDateDTO;
import pe.edu.upc.abilityhelpv1.dtos.QuantityMeetsPerMonthDTO;
import pe.edu.upc.abilityhelpv1.entities.Meeting;
import pe.edu.upc.abilityhelpv1.servicesinterfaces.IMeetServices;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/meeting")
public class MeetingController {
    @Autowired
    private IMeetServices mS;
    @PostMapping ("/Registro")//registrar
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
    public void actualizar(@PathVariable("id") Integer id, @RequestBody MeetingDTO me){
        ModelMapper m = new ModelMapper();
        Meeting mh = m.map(me, Meeting.class);
        mh.setIdMeet(id); // asegurarse de que el objeto tenga el mismo ID que el proporcionado en la URL
        mS.update(mh);
    }

    @GetMapping("/cantidadMeetPorCoach")
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
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        for(String[] columna: filaLista){
            MeetingPerStudentDateDTO dto = new MeetingPerStudentDateDTO();
            dto.setNameU(columna[0]);
            dto.setDate(LocalDate.parse(columna[1]));
            dto.setStarthour(LocalDateTime.parse(columna[2], formatter));
            dto.setFinishhour(LocalDateTime.parse(columna[3], formatter));
            dtoLista.add(dto);
        }
        return dtoLista;
    }

    @GetMapping("/cantidadReunionesPorMes")
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

    @DeleteMapping("/{id}") //reconozca parametros que estamos pasando
    public void eliminar(@PathVariable("id") Integer id){
        mS.delete(id);
    }
}
