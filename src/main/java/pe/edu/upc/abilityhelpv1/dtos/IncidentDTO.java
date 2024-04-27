package pe.edu.upc.abilityhelpv1.dtos;

import jakarta.persistence.Column;

import java.time.LocalDate;

public class IncidentDTO {
    private int id;
    private String typeIncident;
    private String description;

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
