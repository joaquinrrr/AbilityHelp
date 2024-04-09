package pe.edu.upc.abilityhelpv1.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Incidents")
public class Incidents {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "typeIncident", nullable = false)
    private String typeIncident;
    @Column(name = "description", nullable = false)
    private String description;


    public Incidents() {
    }

    public Incidents(int id, String typeIncident, String description) {
        this.id = id;
        this.typeIncident = typeIncident;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypeIncident() {
        return typeIncident;
    }

    public void setTypeIncident(String typeIncident) {
        this.typeIncident = typeIncident;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
