package pe.edu.upc.abilityhelpv1.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.abilityhelpv1.dtos.*;
import pe.edu.upc.abilityhelpv1.entities.AssignIncident;
import pe.edu.upc.abilityhelpv1.servicesinterfaces.IAssignIncidentServices;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/AssignIncident")
public class AssignIncidentController {
    @Autowired
    private IAssignIncidentServices aS;

    @PostMapping("/Registro") //registrar
    public void registrar(@RequestBody AssignIncidentDTO a) {
        ModelMapper m = new ModelMapper();
        AssignIncident ch = m.map(a, AssignIncident.class);
        aS.insert(ch);
    }

    @GetMapping //listar
    public List<AssignIncidentDTO> list() {
        return aS.list().stream().map(y -> {
            ModelMapper m = new ModelMapper();
            return m.map(y, AssignIncidentDTO.class); //expresion lambda para la transformacion
        }).collect(Collectors.toList()); //lista de tipo Shoe
    }

    @PutMapping("/{id}") // actualizar
    public void actualizar(@PathVariable("id") Integer id, @RequestBody AssignIncidentDTO a) {
        ModelMapper m = new ModelMapper();
        AssignIncident ah = m.map(a, AssignIncident.class);
        ah.setId(id); // asegurarse de que el objeto tenga el mismo ID que el proporcionado en la URL
        aS.update(ah);
    }

    @GetMapping("/incidentesPorUsuario")
    @PreAuthorize("hasAnyAuthority('ADMIN') and !hasAnyAuthority('COACH','STUDENT')") //manejar la auth de USER
    public List<AssignIncidentByStudentDTO> incidentesPorEstudiante(@RequestParam String name){
        List<String[]> filaLista = aS.AssignIncidentByStudent(name);
        List<AssignIncidentByStudentDTO> dtoLista = new ArrayList<>();
        for(String[] columna: filaLista){
            AssignIncidentByStudentDTO dto = new AssignIncidentByStudentDTO();
            dto.setReporter(columna[0]);
            dto.setBanned(columna[1]);
            dto.setIncident(columna[2]);
            dto.setDetail(columna[3]);
            dtoLista.add(dto);
        }
        return dtoLista;
    }

    @GetMapping("/incidentesOcurridos")
    @PreAuthorize("hasAnyAuthority('COACH','ADMIN') and !hasAnyAuthority('STUDENT')") //manejar la auth de USER
    public List<AssignIncidentCountDTO> cantidadIncidentesOcurridos(){
        List<String[]> filaLista = aS.AssignIncidentsCount();
        List<AssignIncidentCountDTO> dtoLista = new ArrayList<>();
        for(String[] columna: filaLista){
            AssignIncidentCountDTO dto = new AssignIncidentCountDTO();
            dto.setTypeInci(columna[0]);
            dto.setQuantity(Integer.parseInt(columna[1]));
            dtoLista.add(dto);
        }
        return dtoLista;
    }

    @GetMapping("/cantidadUsuarioIncidentes")
    @PreAuthorize("hasAnyAuthority('COACH','STUDENT') and !hasAnyAuthority('ADMIN')") //manejar la auth de USER
    public List<QuantityStudentIncidentDTO> cantidadEstudianteIncidentes(){
        List<String[]> filaLista = aS.quantityStudentIncidents();
        List<QuantityStudentIncidentDTO> dtoLista = new ArrayList<>();
        for(String[] columna: filaLista){
            QuantityStudentIncidentDTO dto = new QuantityStudentIncidentDTO();
            dto.setBanned(columna[0]);
            dto.setQuantity(Integer.parseInt(columna[1]));
            dtoLista.add(dto);
        }
        return dtoLista;
    }

    @GetMapping("/cantidadIncidentesPorMes")
    @PreAuthorize("hasAnyAuthority('ADMIN') and !hasAnyAuthority('COACH','STUDENT')") //manejar la auth de USER
    public List<QuantityIncidentsPerMonthDTO> cantidadIncidentesPorMes(@RequestParam int year){
        List<String[]> filaLista = aS.quantityIncidentsPerMonth(year);
        List<QuantityIncidentsPerMonthDTO> dtoLista = new ArrayList<>();
        for(String[] columna: filaLista){
            QuantityIncidentsPerMonthDTO dto = new QuantityIncidentsPerMonthDTO();
            dto.setMonth(columna[0]);
            dto.setQuantity(Integer.parseInt(columna[1]));
            dtoLista.add(dto);
        }
        return dtoLista;
    }

    @GetMapping("/cantidadIncidentesPorEstado")
    public List<QuantityIncidentPerStatusDTO> cantidadIncidentesPorEstado(){
        List<String[]> filaLista = aS.quantityIncidentsPerStatus();
        List<QuantityIncidentPerStatusDTO> dtoLista = new ArrayList<>();
        for(String[] columna: filaLista){
            QuantityIncidentPerStatusDTO dto = new QuantityIncidentPerStatusDTO();
            dto.setNameIncident(columna[0]);
            dto.setStatus(columna[1]);
            dto.setQuantity(Integer.parseInt(columna[2]));
            dtoLista.add(dto);
        }
        return dtoLista;
    }



    @DeleteMapping("/{id}") //reconozca parametros que estamos pasando
    public void eliminar(@PathVariable("id") Integer id){
        aS.delete(id);
    }

    @GetMapping("/{id}")
    public AssignIncidentDTO listarId(@PathVariable("id") int id) {
        ModelMapper m = new ModelMapper();
        AssignIncidentDTO dto = m.map(aS.listarId(id), AssignIncidentDTO.class);
        return dto;
    }
}
