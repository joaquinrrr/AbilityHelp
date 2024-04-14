package pe.edu.upc.abilityhelpv1.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "rol", uniqueConstraints = {@UniqueConstraint(columnNames = {"user_id","rol"})})
public class Rol implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_rol;
    private String rol;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Users user;
    public Rol() {
    }

    public int getId_rol() {
        return id_rol;
    }

    public String getRol() {
        return rol;
    }

    public void setId_rol(int id_rol) {
        this.id_rol = id_rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}
