package pe.edu.upc.abilityhelpv1.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "UserTable")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUser;
    @Column(name = "username", nullable = false, length = 35)
    private String username;
    @Column(name = "email", nullable = false, length = 35)
    private String emailUser;
    @Column(name = "password", nullable = false, length = 200)
    private String password;
    @Column(name = "age", nullable = false, length = 2)
    private int ageUser;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="rolid")
    private List<Rol> rol;
    private Boolean enabled;

    public User() {
    }

    public User(int idUser, String username, String emailUser, String password, int ageUser, List<Rol> rol, Boolean enabled) {
        this.idUser = idUser;
        this.username = username;
        this.emailUser = emailUser;
        this.password = password;
        this.ageUser = ageUser;
        this.rol = rol;
        this.enabled = enabled;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmailUser() {
        return emailUser;
    }

    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAgeUser() {
        return ageUser;
    }

    public void setAgeUser(int ageUser) {
        this.ageUser = ageUser;
    }

    public List<Rol> getRol() {
        return rol;
    }

    public void setRol(List<Rol> rol) {
        this.rol = rol;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
}
