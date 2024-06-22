package pe.edu.upc.abilityhelpv1.servicesinterfaces;

import pe.edu.upc.abilityhelpv1.entities.AssignIncident;
import pe.edu.upc.abilityhelpv1.entities.Chat;

import java.util.List;

public interface IChatServices {
    public void insert(Chat chat);
    public List<Chat> list();
    public void delete(int id);
    public void update(Chat chat);
    public Chat listarId(int idChat);
}
