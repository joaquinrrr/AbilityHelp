package pe.edu.upc.abilityhelpv1.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Rol")
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_rol;
    @Column(name = "rol_name", nullable = false, length = 35)
    private String name;

    public Rol() {

    }

    public Rol(int id_rol, String name) {
        this.id_rol = id_rol;
        this.name = name;
    }

    public int getId_rol() {
        return id_rol;
    }

    public String getName() {
        return name;
    }

    public void setId_rol(int id_rol) {
        this.id_rol = id_rol;
    }

    public void setName(String name) {
        this.name = name;
    }
}
