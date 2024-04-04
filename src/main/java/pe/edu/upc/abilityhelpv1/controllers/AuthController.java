package pe.edu.upc.abilityhelpv1.controllers;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.abilityhelpv1.dtos.AuthDTO;
import pe.edu.upc.abilityhelpv1.entities.Auth;
import pe.edu.upc.abilityhelpv1.servicesinterfaces.IAuthServices;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Auth")
public class AuthController {
    @Autowired
    private IAuthServices sS;
    @PostMapping //registrar
    public void registrar(@RequestBody AuthDTO s){
        ModelMapper m = new ModelMapper();
        Auth sh=m.map(s, Auth.class);
        sS.insert(sh);
    }

    @GetMapping //listar
    public List<AuthDTO> list(){
        return sS.list().stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y, AuthDTO.class); //expresion lambda para la transformacion
        }).collect(Collectors.toList()); //lista de tipo Shoe
    }

    @DeleteMapping("/{id}") //reconozca parametros que estamos pasando
    public void eliminar(@PathVariable("id") Integer id){
        sS.delete(id);
    }
}
