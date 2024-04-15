package pe.edu.upc.abilityhelpv1.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Rol")
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRol;
    @Column(name = "rolName", nullable = false, length = 35)
    private String name;

    public Rol() {
    }

    public Rol(int idRol, String name) {
        this.idRol = idRol;
        this.name = name;
    }

    public int getIDRol() {
        return idRol;
    }

    public String getName() {
        return name;
    }

    public void setIDRol(int IDRol) {
        this.idRol = idRol;
    }

    public void setName(String name) {
        this.name = name;
    }
}
