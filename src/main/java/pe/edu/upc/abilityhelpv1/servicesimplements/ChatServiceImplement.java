package pe.edu.upc.abilityhelpv1.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.abilityhelpv1.entities.Chat;
import pe.edu.upc.abilityhelpv1.repositories.IChatRepository;
import pe.edu.upc.abilityhelpv1.servicesinterfaces.IChatService;

import java.util.List;

@Service
public class ChatServiceImplement implements IChatService {
    @Autowired
    private IChatRepository cR;

    @Override
    public void insert(Chat chat) {
        cR.save(chat);
    }

    @Override
    public List<Chat> list() {
        return cR.findAll();
    }

    @Override
    public void delete(int id) {
        cR.deleteById(id);
    }

    @Override
    public void update(Chat chat) {
        cR.save(chat);
    }
}
