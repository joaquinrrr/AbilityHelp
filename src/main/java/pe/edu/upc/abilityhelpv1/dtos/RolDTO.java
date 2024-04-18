package pe.edu.upc.abilityhelpv1.dtos;
import pe.edu.upc.abilityhelpv1.entities.User;


public class RolDTO {
    private int idRol;
    private String name;
    private User user;

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
