package pe.edu.upc.abilityhelpv1.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.abilityhelpv1.dtos.IncidentsDTO;
import pe.edu.upc.abilityhelpv1.dtos.RolDTO;
import pe.edu.upc.abilityhelpv1.entities.Incidents;
import pe.edu.upc.abilityhelpv1.entities.Rol;
import pe.edu.upc.abilityhelpv1.servicesinterfaces.IRolServices;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Incident")
public class IncidentsController {
    @Autowired
    private IRolServices sS;
    @PostMapping //registrar
    public void registrar(@RequestBody RolDTO s){
        ModelMapper m = new ModelMapper();
        Rol sh=m.map(s, Rol.class);
        sS.insert(sh);
    }
    @PutMapping("/{id}") // actualizar
    @PreAuthorize("hasAnyAuthority('COACH', 'ADMIN')")
    public void actualizar(@PathVariable("id") int id, @RequestBody IncidentsDTO i){
        ModelMapper m = new ModelMapper();
        Incidents ih = m.map(i, Incidents.class);
        ih.setId_incident(id);
    }
    @GetMapping("/listar")
    public List<RolDTO> list(){
        return sS.list().stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y, RolDTO.class); //expresion lambda para la transformacion
        }).collect(Collectors.toList()); //lista de tipo Shoe
    }

    @DeleteMapping("/{id}") //reconozca parametros que estamos pasando
    public void eliminar(@PathVariable("id") Integer id){
        sS.delete(id);
    }
}
