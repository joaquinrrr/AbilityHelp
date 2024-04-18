package pe.edu.upc.abilityhelpv1.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Rol")
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRol;
    @Column(name = "rolName", nullable = false, length = 35)
    private String name;

    //agregar el one to many para saber que rol esta asignado a cada usuario
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Rol(){

    }

    public Rol(int idRol, String name, User user) {
        this.idRol = idRol;
        this.name = name;
        this.user = user;
    }

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
