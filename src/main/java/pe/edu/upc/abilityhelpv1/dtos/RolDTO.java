package pe.edu.upc.abilityhelpv1.dtos;
import pe.edu.upc.abilityhelpv1.entities.User;


public class RolDTO {
    private int idRol;
    private String rol;
    private User user;

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
