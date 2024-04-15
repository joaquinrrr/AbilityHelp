package pe.edu.upc.abilityhelpv1.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.abilityhelpv1.dtos.UserDTO;
import pe.edu.upc.abilityhelpv1.entities.User;
import pe.edu.upc.abilityhelpv1.servicesinterfaces.IUserServices;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/User")
public class UserController {
    @Autowired
    private IUserServices sS;

    @PostMapping //registrar
    public void registrar(@RequestBody UserDTO userDTO) {
        ModelMapper m = new ModelMapper();
        User us = m.map(userDTO, User.class);
        sS.insert(us);
    }

    @GetMapping //listar
    public List<UserDTO> list() {
        return sS.list().stream().map(y -> {
            ModelMapper m = new ModelMapper();
            return m.map(y, UserDTO.class); //expresion lambda para la transformacion
        }).collect(Collectors.toList()); //lista de tipo Shoe
    }

    @DeleteMapping("/{id}") //reconozca parametros que estamos pasando
    public void eliminar(@PathVariable("id") Integer id) {
        sS.delete(id);
    }
}
