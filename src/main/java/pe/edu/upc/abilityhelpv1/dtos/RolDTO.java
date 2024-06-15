package pe.edu.upc.abilityhelpv1.dtos;
import pe.edu.upc.abilityhelpv1.entities.User;


public class RolDTO {
    private Long idRol;
    private String rol;
    private User user;

    public Long getIdRol() {
        return idRol;
    }

    public void setIdRol(Long idRol) {
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
