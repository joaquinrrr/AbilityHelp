package pe.edu.upc.abilityhelpv1.entities;
import jakarta.persistence.*;

@Entity
@Table(name = "Admin")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idadmin;
    @Column(name = "name_admin", nullable = false, length = 35)
    private String nombre;
    @Column(name = "email_admin", nullable = false, length = 35)
    private String correo;
    @Column(name = "password_admin", nullable = false, length = 12)
    private String password;

    public Admin(int idadmin, String nombre, String correo, String password) {
        this.idadmin = idadmin;
        this.nombre = nombre;
        this.correo = correo;
        this.password = password;
    }

    public int getIdadmin() {
        return idadmin;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public String getPassword() {
        return password;
    }

    public void setIdadmin(int idadmin) {
        this.idadmin = idadmin;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
