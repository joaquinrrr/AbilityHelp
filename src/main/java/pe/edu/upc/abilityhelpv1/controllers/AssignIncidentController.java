package pe.edu.upc.abilityhelpv1.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.abilityhelpv1.dtos.AssignIncidentDTO;
import pe.edu.upc.abilityhelpv1.entities.AssignIncident;
import pe.edu.upc.abilityhelpv1.servicesinterfaces.IAssignIncidentService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/assignIncident")
public class AssignIncidentController {
    @Autowired
    private IAssignIncidentService aS;
    @PostMapping("/Registro") //registrar
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
    @DeleteMapping("/{id}") //reconozca parametros que estamos pasando
    public void eliminar(@PathVariable("id") Integer id){
        aS.delete(id);
    }
}
