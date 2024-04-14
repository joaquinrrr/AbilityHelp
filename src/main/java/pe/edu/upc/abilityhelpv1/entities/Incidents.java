package pe.edu.upc.abilityhelpv1.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Incidents")
public class Incidents {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_incident;
    @Column(name = "type_incident", nullable = false, length = 35)
    private String type;
    @Column(name = "description", nullable = false, length = 35)
    private String description;
    @Column(name = "date_incident", nullable = false)
    private Date date_incident;

    public Incidents(int id_incident, String type, String description, Date date_incident) {
        this.id_incident = id_incident;
        this.type = type;
        this.description = description;
        this.date_incident = date_incident;
    }

    public Incidents() {

    }

    public int getId_incident() {
        return id_incident;
    }

    public void setId_incident(int id_incident) {
        this.id_incident = id_incident;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate_incident() {
        return date_incident;
    }

    public void setDate_incident(Date date_incident) {
        this.date_incident = date_incident;
    }
}
