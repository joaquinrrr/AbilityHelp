package pe.edu.upc.abilityhelpv1.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.abilityhelpv1.dtos.ChatDTO;
import pe.edu.upc.abilityhelpv1.entities.Chat;
import pe.edu.upc.abilityhelpv1.servicesinterfaces.IChatServices;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Chat")
public class ChatController {
    @Autowired
    private IChatServices cS;
    @PostMapping("/Registro") //registrar
    public void registrar(@RequestBody ChatDTO c){
        ModelMapper m = new ModelMapper();
        Chat ch=m.map(c, Chat.class);
        cS.insert(ch);
    }

    @GetMapping //listar
    public List<ChatDTO> list(){
        return cS.list().stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y, ChatDTO.class); //expresion lambda para la transformacion
        }).collect(Collectors.toList()); //lista de tipo Shoe
    }

    @PutMapping("/{id}") // actualizar
    public void actualizar(@PathVariable("id") Integer id, @RequestBody ChatDTO c){
        ModelMapper m = new ModelMapper();
        Chat ch = m.map(c, Chat.class);
        ch.setIdChat(id); // asegurarse de que el objeto tenga el mismo ID que el proporcionado en la URL
        cS.update(ch);
    }

    @DeleteMapping("/{id}") //reconozca parametros que estamos pasando
    public void eliminar(@PathVariable("id") Integer id){
        cS.delete(id);
    }

    @GetMapping("/{id}")
    public ChatDTO listarId(@PathVariable("id") int id) {
        ModelMapper m = new ModelMapper();
        ChatDTO dto = m.map(cS.listarId(id), ChatDTO.class);
        return dto;
    }
}
