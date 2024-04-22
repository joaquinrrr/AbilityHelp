package pe.edu.upc.abilityhelpv1.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
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
    @PostMapping //registrar
    public void registrar(@RequestBody AssignIncidentDTO a){
        ModelMapper m = new ModelMapper();
        AssignIncident ch=m.map(a, AssignIncident.class);
        aS.insert(ch);
    }

    @GetMapping //listar
    public List<AssignIncidentDTO> list(){
        return aS.list().stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y, AssignIncidentDTO.class); //expresion lambda para la transformacion
        }).collect(Collectors.toList()); //lista de tipo Shoe
    }

    @PutMapping("/{id}") // actualizar
    public void actualizar(@PathVariable("id") Integer id, @RequestBody AssignIncidentDTO a){
        ModelMapper m = new ModelMapper();
        AssignIncident ah = m.map(a, AssignIncident.class);
        ah.setId(id); // asegurarse de que el objeto tenga el mismo ID que el proporcionado en la URL
        aS.update(ah);
    }

    @GetMapping("/incidentesPorUsuario")
    public List<AssignIncidentByUserDTO> incidentesPorUsuario(@RequestParam String name){
        List<String[]> filaLista = aS.AssignIncidentByUser(name);
        List<AssignIncidentByUserDTO> dtoLista = new ArrayList<>();
        for(String[] columna: filaLista){
            AssignIncidentByUserDTO dto = new AssignIncidentByUserDTO();
            dto.setReporter(columna[0]);
            dto.setBanned(columna[1]);
            dto.setIncident(columna[2]);
            dto.setDetail(columna[3]);
            dtoLista.add(dto);
        }
        return dtoLista;
    }

    @GetMapping("/incidentesOcurridos")
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
    public List<QuantityUserIncidentDTO> cantidadUsuarioIncidentes(){
        List<String[]> filaLista = aS.quantityUserIncidents();
        List<QuantityUserIncidentDTO> dtoLista = new ArrayList<>();
        for(String[] columna: filaLista){
            QuantityUserIncidentDTO dto = new QuantityUserIncidentDTO();
            dto.setReporter(columna[0]);
            dto.setQuantity(Integer.parseInt(columna[1]));
            dtoLista.add(dto);
        }
        return dtoLista;
    }



    @DeleteMapping("/{id}") //reconozca parametros que estamos pasando
    public void eliminar(@PathVariable("id") Integer id){
        aS.delete(id);
    }
}
