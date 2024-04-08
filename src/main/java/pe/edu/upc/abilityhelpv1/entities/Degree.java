package pe.edu.upc.abilityhelpv1.entities;

import jakarta.persistence.*;

@Entity
@Table (name = "Carrera")
public class Degree {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_carrera;
    @Column(name = "carrera_name", nullable = false, length = 35)
    private String nombre_carrera;

    public Degree(){}

    public Degree(int id_carrera, String nombre_carrera) {
        this.id_carrera = id_carrera;
        this.nombre_carrera = nombre_carrera;
    }

    public int getId_carrera() {
        return id_carrera;
    }

    public String getNombre_carrera() {
        return nombre_carrera;
    }

    public void setId_carrera(int id_rol) {
        this.id_carrera = id_carrera;
    }

    public void setNombre_carrera(String nombre_carrera) {
        this.nombre_carrera = nombre_carrera;
    }
}
