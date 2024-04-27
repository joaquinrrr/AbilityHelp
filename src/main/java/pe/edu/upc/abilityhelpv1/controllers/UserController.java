package pe.edu.upc.abilityhelpv1.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.abilityhelpv1.dtos.UserDTO;
import pe.edu.upc.abilityhelpv1.entities.Users;
import pe.edu.upc.abilityhelpv1.servicesinterfaces.IUserService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
public class UserController {
    @Autowired
    private IUserService uS;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @PostMapping
    public void registrar(@RequestBody UserDTO dto){
        ModelMapper m= new ModelMapper();
        Users u= m.map(dto, Users.class);
        String encodedPassword = passwordEncoder.encode(u.getPassword());
        u.setPassword(encodedPassword);
        uS.insert(u);
    }
    @PutMapping("/{id}") // actualizar
    @PreAuthorize("hasAnyAuthority('COACH', 'ADMIN')")
    public void actualizar(@PathVariable("id") Long id, @RequestBody UserDTO u){
        ModelMapper m = new ModelMapper();
        Users uh = m.map(u, Users.class);
        uh.setIdUser(id);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Long id) {
        uS.delete(id);
    }


    @GetMapping("/listar")
    @PreAuthorize("hasAnyAuthority('COACH', 'ADMIN')")
    public List<UserDTO> listar() {
        return uS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, UserDTO.class);
        }).collect(Collectors.toList());
    }
}
