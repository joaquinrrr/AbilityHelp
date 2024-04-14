package pe.edu.upc.abilityhelpv1.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.abilityhelpv1.dtos.DegreeDTO;
import pe.edu.upc.abilityhelpv1.entities.Degree;
import pe.edu.upc.abilityhelpv1.servicesinterfaces.IDegreeServices;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Carrera")

public class DegreeController {
    @Autowired
    private IDegreeServices sS;

    @PostMapping //registrar
    public void registrar(@RequestBody DegreeDTO s) {
        ModelMapper m = new ModelMapper();
        Degree sh = m.map(s, Degree.class);
        sS.insert(sh);
    }

    @GetMapping //listar
    public List<DegreeDTO> list() {
        return sS.list().stream().map(y -> {
            ModelMapper m = new ModelMapper();
            return m.map(y, DegreeDTO.class); //expresion lambda para la transformacion
        }).collect(Collectors.toList()); //lista de tipo Degree
    }

    @DeleteMapping("/{id}") //reconozca parametros que estamos pasando
    public void eliminar(@PathVariable("id") Integer id) {
        sS.delete(id);
    }
}
