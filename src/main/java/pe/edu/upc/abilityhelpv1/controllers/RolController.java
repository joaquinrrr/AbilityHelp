package pe.edu.upc.abilityhelpv1.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.abilityhelpv1.dtos.QuantityUserPerRolDTO;
import pe.edu.upc.abilityhelpv1.dtos.RolDTO;
import pe.edu.upc.abilityhelpv1.entities.Rol;
import pe.edu.upc.abilityhelpv1.servicesinterfaces.IRolServices;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Rol")
@CrossOrigin(origins = {"https://ab13-98315.web.app","http://localhost:4200"})
public class RolController {
    @Autowired
    private IRolServices sS;
    @PostMapping("/Registro") //registrar
    public void registrar(@RequestBody RolDTO s){
        ModelMapper m = new ModelMapper();
        Rol sh=m.map(s, Rol.class);
        sS.insert(sh);
    }

    @GetMapping //listar
    public List<RolDTO> list(){
        return sS.list().stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y, RolDTO.class); //expresion lambda para la transformacion
        }).collect(Collectors.toList()); //lista de tipo Shoe
    }

    @PutMapping("/{id}") // actualizar
    @PreAuthorize("hasAnyAuthority('ADMIN') and !hasAnyAuthority('COACH', 'STUDENT')") //manejar la auth de USER
    public void actualizar(@PathVariable("id") Long id, @RequestBody RolDTO re){
        ModelMapper m = new ModelMapper();
        Rol rh = m.map(re, Rol.class);
        rh.setIdRol(id); // asegurarse de que el objeto tenga el mismo ID que el proporcionado en la URL
        sS.update(rh);
    }

    @DeleteMapping("/{id}") //reconozca parametros que estamos pasando
    @PreAuthorize("hasAnyAuthority('ADMIN') and !hasAnyAuthority('COACH', 'STUDENT')") //manejar la auth de USER
    public void eliminar(@PathVariable("id") Long id){
        sS.delete(id);
    }
    @GetMapping("/{id}")
    public RolDTO listarId(@PathVariable("id") Long id) {
        ModelMapper m = new ModelMapper();
        RolDTO dto = m.map(sS.listarId(id), RolDTO.class);
        return dto;
    }

    @GetMapping("/cantidadUsuariosPorRol")
    @PreAuthorize("hasAnyAuthority('ADMIN') and !hasAnyAuthority('COACH', 'STUDENT')") //manejar la auth de USER
    public List<QuantityUserPerRolDTO> cantidadUsuariosPorRol(){
        List<String[]> filaLista = sS.quantityUserPerRol();
        List<QuantityUserPerRolDTO> dtoLista = new ArrayList<>();
        for(String[] columna: filaLista){
            QuantityUserPerRolDTO dto = new QuantityUserPerRolDTO();
            dto.setNameR(columna[0]);
            dto.setQuantity(Integer.parseInt(columna[1]));
            dtoLista.add(dto);
        }
        return dtoLista;
    }
}
